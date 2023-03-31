package com.neonatal.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neonatal.backend.entities.Criteria_Bundles;
import com.neonatal.backend.entities.Criteria_Object;
import com.neonatal.backend.entities.Parent_Bundle;
import com.neonatal.backend.entities.Recommendation_Bundle;
import com.neonatal.backend.entities.Recommendation_Object;
import com.neonatal.backend.entities.Rule;
import com.neonatal.backend.entities.Sub_Bundle;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.SubBundlesPOJO;
import com.neonatal.backend.repositories.CriteriaBundlesRepository;
import com.neonatal.backend.repositories.CriteriaObjectRepository;
import com.neonatal.backend.repositories.ParentBundleRepository;
import com.neonatal.backend.repositories.RecommendationBundleRepository;
import com.neonatal.backend.repositories.RecommendationObjectRepository;
import com.neonatal.backend.repositories.RulesRepository;
import com.neonatal.backend.repositories.SubBundle_Repository;

/**
 * Class that defines service operations for rules Design. This is the class
 * that connects the rules controller to the rules data within the neonatal
 * database's rules table. The rules controller calls a method within this
 * class, which then queries rules table within the database, runs logic on the
 * retrived data (if needed) then returns the information back to the
 * controller.
 */
@Service
public class RulesService {

	@Autowired
	private RulesRepository rulesRepository;

	@Autowired
	private ParentBundleRepository parentBundleRepository;

	@Autowired
	private SubBundle_Repository subBundleRepository;

	@Autowired
	private CriteriaBundlesRepository criteriaBundlesRepository;

	@Autowired
	private CriteriaObjectRepository criteriaObjectRepository;

	@Autowired
	private RecommendationBundleRepository recommendationBundleRepository;

	@Autowired
	private RecommendationObjectRepository recommendationObjectRepository;

	public RulesService() {
		System.out.println("Rule Service Layer");
	}

	@SuppressWarnings("unchecked")
	public ParentBundlePOJO saveBundle(ParentBundlePOJO parentBundlePOJO) {

		ParentBundlePOJO obj = new ParentBundlePOJO();

		try {

			// Save Parent Bundle
			Parent_Bundle parentBundleObj = new Parent_Bundle();
			parentBundleObj.setBundle_name(parentBundlePOJO.getParentBundle());
			parentBundleObj.setPurpose(parentBundlePOJO.getParentPurpose());
			parentBundleObj.setIs_delivery_room(parentBundlePOJO.getParentApplicable());
			parentBundleObj.setIs_sub_bundle(parentBundlePOJO.getParentOption());

			parentBundleObj = parentBundleRepository.save(parentBundleObj);

			// Save Sub-Bundles
			List<SubBundlesPOJO> subBundlesList = parentBundlePOJO.getSubBundles();
			for (SubBundlesPOJO subBundlesObj : subBundlesList) {
				Sub_Bundle subBunobj = new Sub_Bundle();
				subBunobj.setBundle_name(subBundlesObj.getBundle());
				subBunobj.setIn_delivery_room(subBundlesObj.getApplicable());
				subBunobj.setPurpose(subBundlesObj.getPurpose());
				subBunobj.setParent_bundle_id(parentBundleObj.getParent_bundle_id());

				subBunobj = subBundleRepository.save(subBunobj);

				// Save Criteria Sets
				for (int i = 0; i < subBundlesObj.getCriteriasName().size(); i++) {
					Criteria_Bundles criteriaBundlesObj = new Criteria_Bundles();
					criteriaBundlesObj.setParent_bundle_id(parentBundleObj.getParent_bundle_id());
					criteriaBundlesObj.setSub_bundle_id(subBunobj.getSub_bundle_id());
					criteriaBundlesObj.setCriteria_name(subBundlesObj.getCriteriasName().get(i));
					if (null != (subBundlesObj.getRepeatTime().get(i)))
						criteriaBundlesObj.setRepeat_time(subBundlesObj.getRepeatTime().get(i));
					if (null != (subBundlesObj.getRepeatUnit().get(i)))
						criteriaBundlesObj.setRepeat_unit(subBundlesObj.getRepeatUnit().get(i));
					if (null != (subBundlesObj.getTermination().get(i)))
						criteriaBundlesObj.setTermination(subBundlesObj.getTermination().get(i));

					criteriaBundlesObj = criteriaBundlesRepository.save(criteriaBundlesObj);

					List<Criteria_Object> criteriaList = subBundlesObj.getCriteriaObjectList().get(i);

					for (Criteria_Object obj1 : criteriaList) {
						if (obj1.getField_name().equalsIgnoreCase("Gestation")
								|| obj1.getField_name().equalsIgnoreCase("Birth Weight")) {
							if (null == (obj1.getFrom_value())) {
								continue;
							}
						}
						obj1.setCriteria_bundles_id(criteriaBundlesObj.getCriteria_bundles_id());
						criteriaObjectRepository.save(obj1);
					}
				}

				// Save Recommendation Sets
				for (int i = 0; i < subBundlesObj.getRecommendationObjectList().size(); i++) {
					Recommendation_Bundle recommendationBundlesObj = new Recommendation_Bundle();
					recommendationBundlesObj.setParent_bundle_id(parentBundleObj.getParent_bundle_id());
					recommendationBundlesObj.setSub_bundle_id(subBunobj.getSub_bundle_id());

					recommendationBundlesObj = recommendationBundleRepository.save(recommendationBundlesObj);

					List<Recommendation_Object> recommendationList = subBundlesObj.getRecommendationObjectList().get(i);

					for (Recommendation_Object obj1 : recommendationList) {
						obj1.setRecommendation_bundles_id(recommendationBundlesObj.getRecommendation_bundle_id());
						recommendationObjectRepository.save(obj1);
					}
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	/*
	 * Example of a get by id call public Rule findById(Long id){ Optional<Rule>
	 * rules = rulesRepository.findById(id); if (rules.isPresent()){ return
	 * rules.get(); }else { return null; } }
	 */

	/**
	 * Get all the rules, and return them as a list of type Rule
	 *
	 * @return List of Rule objects
	 */
	public List<Rule> getAll() {
		return rulesRepository.findAll();
	}

	/**
	 * Add a rule to the database
	 *
	 * @param rule Rule type to be added
	 * @return Rule type that was added
	 */
	public Rule add(Rule rule) {
		return rulesRepository.save(rule);
	}

}
