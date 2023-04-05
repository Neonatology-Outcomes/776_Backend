package com.neonatal.backend.services;

import com.neonatal.backend.entities.*;
import com.neonatal.backend.models.*;
import com.neonatal.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class that defines service operations for rules Design.  This is the class that connects the rules controller to
 * the rules data within the neonatal database's rules table.  The rules controller calls a method within this class,
 * which then queries rules table within the database, runs logic on the retrived data (if needed) then returns the
 * information back to the controller.
 */
@Service
@Transactional
public class RulesService {

    @Autowired
    private RulesRepository rulesRepository;
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



    /* Example of a get by id call
    public Rule findById(Long id){
        Optional<Rule> rules = rulesRepository.findById(id);
        if (rules.isPresent()){
            return rules.get();
        }else {
            return null;
        }
    }
     */

    /**
     * Get all the rules, and return them as a list of type Rule
     * @return List of Rule objects
     */
    // TODO: Implement Optional<Object> or if then in case find all or queries are returned null or empty
    public ArrayList<RuleObject> getAll(){

        ArrayList<RuleObject> ruleObject = new ArrayList<>();

        try {

            List<Sub_Bundle> subBundleList = subBundleRepository.findAll();

            // Get the list of all sub_bundles id and put them in an array
            long [] subBundleIds = new long[subBundleList.size()];
            for (int i = 0; i < subBundleIds.length; i ++){
                subBundleIds[i] = subBundleList.get(i).getSub_bundle_id();
            }

            for (int m = 0; m < subBundleIds.length; m++) {

                long subBundleId = subBundleIds[0];
                String ruleName = subBundleList.get(m).getPurpose();

                // Get a list of all criteria with the associated sub bundle id
                List<Criteria_Bundles> critBundBySubBundId = criteriaBundlesRepository.getBySub_bundle_id(subBundleId);
                long criteria_id = critBundBySubBundId.get(0).getCriteria_bundles_id();

                // Get a list of all criteria with the associated sub bundle id
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

                ruleObject.add(new RuleObject(ruleName, condition.toString(), action.toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ruleObject;
    }

    /**
     * Add a rules to the database
     * @param parentBundle JSON parent Bundle object to be parsed.
     * @return Rule type that was added
     */
    public String addRules(ParentBundle parentBundle){

        List<SubBundle> subBundles = parentBundle.getSubBundles();

        // Save to the parent bundle table, and create the parent bundle object so we can retrieve the ID number
        Parent_Bundle parent_bundle = parentBundleRepository.save(new Parent_Bundle(parentBundle.getParentBundle(),
                parentBundle.getParentPurpose(), "", "yes", ""));
        long parentBundleId = parent_bundle.getParent_bundle_id();
        System.out.println("Parent Bundle ID: " + parentBundleId);

        // There can be multiple sub bundles therefore they must be looped through and processed individually
        for (int i = 0; i < subBundles.size(); i++){
            SubBundle objSubBundle = subBundles.get(i);
            Sub_Bundle subBundle = subBundleRepository.save(new Sub_Bundle(objSubBundle.getBundle(),
                    objSubBundle.getPurpose(), parentBundleId));

            // Save to the Criteria Bundles table, create an object to extract its ID, we need it
            Criteria_Bundles criteria_bundles = criteriaBundlesRepository.save(new Criteria_Bundles(objSubBundle.getCriteriasName().get(i),
                    parentBundleId, subBundle.getSub_bundle_id()));
            long criteriaBundleID = criteria_bundles.getCriteria_bundles_id();
            System.out.println("Criteria Bundle ID: " + criteriaBundleID);

            // Save to the Recommendation Bundle, create that object to extract its id as well
            Recommendation_Bundle recommendation_bundle = recommendBundleRepository.save(new Recommendation_Bundle(subBundle.getSub_bundle_id(),
                    parentBundleId, criteriaBundleID));
            long recommendationBundleID = recommendation_bundle.getRecommendation_bundle_id();
            System.out.println("Recommendation Bundle ID: " + recommendationBundleID);

            List<List<CriteriaObject>> criteriaObjectList = objSubBundle.getCriteriaObjectList();
            List<List<RecommendationObject>> recomendObjectList = objSubBundle.getRecommendationObjectList();

            // Iterate through the criteriaOBjectList, convert them to Criteria_Object entity lists, and write them
            for (List<CriteriaObject> objList: criteriaObjectList){
                List<Criteria_Object> entityObject = mapCriteriaObjectToEntity(objList, criteriaBundleID);
                criteriaObjectRepository.saveAll(entityObject);
            }
            // Iterate through the recomendOBjectLIst, convert them to Recommend_Object entity lists, and write them
            for (List<RecommendationObject> objList: recomendObjectList){
                List<Recommendation_Object> entityObject = mapRecomOBjectToEntity(objList, recommendationBundleID);
                recommendObjectRepository.saveAll(entityObject);
            }

        }

    return "success";
    }

    private List<Criteria_Object> mapCriteriaObjectToEntity(List<CriteriaObject> criteriaObjects, long bundleID){
        List<Criteria_Object> criteria_objectList = new ArrayList<>();
        for (CriteriaObject criteriaObject: criteriaObjects){
            Criteria_Object entityObject = new Criteria_Object(bundleID, criteriaObject.getField_name(),
                    criteriaObject.getType(), criteriaObject.getFrom_value(), criteriaObject.getTime());
            criteria_objectList.add(entityObject);
        }
        return criteria_objectList;
    }

    private List<Recommendation_Object> mapRecomOBjectToEntity(List<RecommendationObject> recomendObjects, long bundleID){
        List<Recommendation_Object> recomend_objectList = new ArrayList<>();
        for (RecommendationObject recomendObject: recomendObjects){
            Recommendation_Object entityObject = new Recommendation_Object(bundleID, recomendObject.getCategory_name(),
                    recomendObject.getField_name(), recomendObject.getType(), recomendObject.getFrom_value(),
                    recomendObject.getTime());
            recomend_objectList.add(entityObject);
        }
        return recomend_objectList;
    }
}
