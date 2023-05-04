package com.neonatal.backend.services;

import com.neonatal.backend.entities.*;
import com.neonatal.backend.models.*;
import com.neonatal.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines service operations for the saveBundle and getBundle endpoints.  
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api")
@Service
@Transactional
public class RulesService {

    @Autowired
    private SubBundle_Repository subBundleRepository;
    @Autowired
    private CriteriaBundlesRepository criteriaBundlesRepository;
    @Autowired
    private RecommendationBundleRepository recommendBundleRepository;
    @Autowired
    private CriteriaObjectRepository criteriaObjectRepository;
    @Autowired
    private RecommendationObjectRepository recommendObjectRepository;
    @Autowired
    private ParentBundleRepository parentBundleRepository;
    @Autowired 
    private BirthDetailsRepository birthDetailsRepository;

    /**
     * Gets the list of all Rule Names and their associated Conditions and Actions and returns them
     * for the GET endpoint /getBundles
     *
     * @return List of RuleObjectPOJO
     */
    // TODO: The rule name is derived from the sub bundle table, this may need updating
    public ArrayList<RuleObjectPOJO> getAll(){

        ArrayList<RuleObjectPOJO> ruleObject = new ArrayList<>();

        try {

            List<Sub_Bundle> subBundleList = subBundleRepository.findAll();

            // Get the list of all sub_bundles id and put them in an array
            long [] subBundleIds = new long[subBundleList.size()];
            for (int i = 0; i < subBundleIds.length; i ++){
                subBundleIds[i] = subBundleList.get(i).getSub_bundle_id();
            }

            for (int m = 0; m < subBundleIds.length; m++) {

                // Get the subBundleID and the Rule Name from the array
                long subBundleId = subBundleIds[0];
                String ruleName = subBundleList.get(m).getPurpose();

                // Get a list of all criteria objects with the associated sub bundle id
                List<Criteria_Bundles> critBundBySubBundId = criteriaBundlesRepository.getBySub_bundle_id(subBundleId);
                long criteria_id = critBundBySubBundId.get(0).getCriteria_bundles_id();

                // Get a list of all recommendation objects with the associated sub bundle id
                List<Recommendation_Bundle> recBundBySubBundId = recommendBundleRepository.getBySub_bundle_id(subBundleId);
                long recom_id = recBundBySubBundId.get(0).getRecommendation_bundle_id();

                // Get a list of all the Criteria_Objects with the specified criteria_id, so we can extract
                // their information and build the string for the condition field of the JSON
                List<Criteria_Object> criteriaObjects = criteriaObjectRepository.getByCriteria_bundles_id(criteria_id);
                StringBuilder condition = new StringBuilder();
                // TODO: If criteriaObjects.size >= 1...
                for (int i = 0; i < criteriaObjects.size(); i++) {
                    Criteria_Object criteriaObject = criteriaObjects.get(i);
                    condition.append("If ");
                    condition.append(criteriaObject.getField_name() + " ");
                    condition.append(criteriaObject.getType() + " ");
                    condition.append(criteriaObject.getFrom_value() + " ");
                    condition.append(criteriaObject.getTime() + " ");
                    // TODO: Medicine, vent, or_condition, bin?
                    if (criteriaObjects.size() > 1 && i != criteriaObjects.size() - 1)
                        condition.append("AND ");
                }

                // Get a list of all the Recommendation_Objects with the specified criteria_id, so we can extract
                // their information and build the string for the action field of the JSON
                List<Recommendation_Object> recommendObjects = recommendObjectRepository.getByRecommendation_object_id(recom_id);
                StringBuilder action = new StringBuilder();
                // TODO: If recommendObjects.size() >= 1
                for (int i = 0; i < recommendObjects.size(); i++) {
                    Recommendation_Object recomendObject = recommendObjects.get(i);
                    action.append(recomendObject.getCategory_name() + " ");
                    action.append(recomendObject.getField_name() + " ");
                    action.append(recomendObject.getType() + " ");
                    action.append(recomendObject.getFrom_value() + " ");
                    action.append(recomendObject.getTime() + " ");
                    // TODO: Repeat time and Repeat Unit ?
                }

                ruleObject.add(new RuleObjectPOJO(ruleName, condition.toString(), action.toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ruleObject;
    }

    /**
     * Takes as input a ParentBUndlePOJO object (from the JSON passed to the body parameter) of the POST request and
     * parses the objects, and enters the information into the parent_bundle, sub_bundle, criteria_bundle,
     * criteria_object, reccommendation_bundle, recommendation_object tables.
     * @param parentBundle ParentBundlePOJO representing the JSON string that was passed to the POST request
     * @return "Success" if successful // TODO: Modify return value?
     */
    public String addRules(ParentBundlePOJO parentBundle){

        try {

            System.out.println("Adding Bundle to Database Neonatal");

            List<SubBundlePOJO> subBundles = parentBundle.getSubBundles();

            // Save to the parent bundle table, and create the parent bundle object so we can retrieve the ID number
            Parent_Bundle parent_bundle = parentBundleRepository.save(new Parent_Bundle(parentBundle.getParentBundle(),
                    parentBundle.getParentPurpose(), "", "yes", ""));
            long parentBundleId = parent_bundle.getParent_bundle_id();
            System.out.println("Parent Bundle ID: " + parentBundleId);

            // There can be multiple sub bundles therefore they must be looped through and processed individually
            for (int i = 0; i < subBundles.size(); i++) {
                SubBundlePOJO objSubBundle = subBundles.get(i);
                Sub_Bundle subBundle = subBundleRepository.save(new Sub_Bundle(objSubBundle.getBundle(),
                        objSubBundle.getPurpose(), parentBundleId));
                
                // Loop by size of CriteriasName field
                for(int j = 0; j < objSubBundle.getCriteriasName().size(); j++) {
                    
                    // Save to the Criteria Bundles table, create an object to extract its ID, we need it
                	Criteria_Bundles criteria_bundles = criteriaBundlesRepository.save(new Criteria_Bundles(objSubBundle.getCriteriasName().get(j),
                        parentBundleId, subBundle.getSub_bundle_id()));
                	long criteriaBundleID = criteria_bundles.getCriteria_bundles_id();
                	System.out.println("Criteria Bundle ID: " + criteriaBundleID);

                    // Save to the Recommendation Bundle, create that object to extract its id as well
                	Recommendation_Bundle recommendation_bundle = recommendBundleRepository.save(new Recommendation_Bundle(subBundle.getSub_bundle_id(),
                        parentBundleId, criteriaBundleID));
                	long recommendationBundleID = recommendation_bundle.getRecommendation_bundle_id();
                	System.out.println("Recommendation Bundle ID: " + recommendationBundleID);

                    // Here we extract all the criteria and recommendation objects as a list of lists for row submission
                	List<List<Criteria_Object>> criteriaObjectList = objSubBundle.getCriteriaObjectList();
                	List<List<Recommendation_Object>> recomendObjectList = objSubBundle.getRecommendationObjectList();

                    // Iterate through the criteriaOBjectList, convert them to Criteria_Object entity lists, and write them
                	for (List<Criteria_Object> objList : criteriaObjectList) {
                    List<Criteria_Object> entityObject = mapCriteriaObjectToEntity(objList, criteriaBundleID);
                    criteriaObjectRepository.saveAll(entityObject);
                }
                // Iterate through the recomendOBjectLIst, convert them to Recommend_Object entity lists, and write them
                for (List<Recommendation_Object> objList : recomendObjectList) {
                    List<Recommendation_Object> entityObject = mapRecomObjectToEntity(objList, recommendationBundleID);
                    recommendObjectRepository.saveAll(entityObject);
                	}
             
           
                    // Iterate through the recomendOBjectLIst, convert them to Recommend_Object entity lists, and write them
                    for (List<Recommendation_Object> objList : recomendObjectList) {
                        List<Recommendation_Object> entityObject = mapRecomObjectToEntity(objList, recommendationBundleID);
                        recommendObjectRepository.saveAll(entityObject);
                    }
                }
            }
        }          
        catch (Exception e) {
            e.printStackTrace();
        }

    return "success";
    }


    /**
     * Converts a list of CriteriaObjectPOJO from the JSON passed to the POST request to a list of
     * Criteria_Object Entities
     *
     * @param criteriaObjects a List of CriteriaObjectPOJO objects that are to be converted
     * @param bundleID the criteria_bundle_id that is associated with the Criteria_Object entity that needs to
     *                 be entered into the criteria_bundles_id field for each entry.
     * @return List of Criteria_Object entities
     */
    private List<Criteria_Object> mapCriteriaObjectToEntity(List<Criteria_Object> criteriaObjects, long bundleID){
        List<Criteria_Object> criteria_objectList = new ArrayList<>();
        for (Criteria_Object criteriaObject: criteriaObjects){
            Criteria_Object entityObject = new Criteria_Object(bundleID, criteriaObject.getField_name(),
                    criteriaObject.getType(), criteriaObject.getFrom_value(), criteriaObject.getTime());
            criteria_objectList.add(entityObject);
        }
        return criteria_objectList;
    }

    /**
     * Converts a list of RecommendationOBjectPOJO from the JSON passed to the POST request to a list
     * of Recommendation_Object entities.
     *
     * @param recomendObjects a List of RecommendationOBjectPOJO objects that are to be converted
     * @param bundleID the recommendation_bundle_id that is associated with the Recommendation_Object entity that needs
     *                 to be entered into the recommendation_bundle_id for each entry.
     * @return
     */
    private List<Recommendation_Object> mapRecomObjectToEntity(List<Recommendation_Object> recomendObjects, long bundleID){
        List<Recommendation_Object> recomend_objectList = new ArrayList<>();
        for (Recommendation_Object recomendObject: recomendObjects){
            Recommendation_Object entityObject = new Recommendation_Object(bundleID, recomendObject.getCategory_name(),
                    recomendObject.getField_name(), recomendObject.getType(), recomendObject.getFrom_value(),
                    recomendObject.getTime());
            recomend_objectList.add(entityObject);
        }
        return recomend_objectList;
    }
  
    
    public List<NurseTasks> getNurseTasks() {		
		List<NurseTasks> returnList = new ArrayList<>();
		try {
			List<Birth_Details> babyList = birthDetailsRepository.getBirthDetails();
			List<Recommendation_Object> recommendations = recommendObjectRepository.getAllRecommendations();

			List<String> recommendationStr = new ArrayList<>();
			for(Recommendation_Object obj : recommendations) {
				StringBuilder str = new StringBuilder();
				if(obj.getField_name() != null) {
					str.append(obj.getField_name());
					if(obj.getType() != null) str.append(" " + obj.getType());
					if(obj.getFrom_value() != null) str.append(" " + obj.getFrom_value());
					if(obj.getTime() != null) str.append(" " + obj.getTime());
					if(obj.getUnit() != null) str.append(" " + obj.getUnit());
					if(obj.getRepeat_time() != null && obj.getRepeat_time() > 0) {
						if(obj.getRepeat_time() == 1) {
							str.append(" once");
						}else {
							str.append(" " + obj.getRepeat_time());
							str.append(" times");
						}
					}
					if(obj.getRepeat_unit() != null) {
						str.append(" in a" + obj.getRepeat_unit());
					}
					recommendationStr.add(str.toString());
				}
				
			}
			for (Birth_Details babyObj : babyList) {
				NurseTasks nurseObj = new NurseTasks();
				nurseObj.setUhid(babyObj.getUhid());
				nurseObj.setBirth_weight(babyObj.getBirth_weight());
				nurseObj.setDateofbirth(babyObj.getDateofbirth());
				nurseObj.setTasks(recommendationStr);
				returnList.add(nurseObj);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return returnList;
	}
}
