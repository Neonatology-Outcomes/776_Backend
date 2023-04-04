package com.neonatal.backend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neonatal.backend.dao.PatientDao;
import com.neonatal.backend.entities.Criteria_Bundles;
import com.neonatal.backend.entities.Criteria_Object;
import com.neonatal.backend.entities.Parent_Bundle;
import com.neonatal.backend.entities.Recommendation_Bundle;
import com.neonatal.backend.entities.Recommendation_Object;
import com.neonatal.backend.entities.Sub_Bundle;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.SubBundlesPOJO;
import com.neonatal.backend.services.RulesService;

/**
 *
 * @author iNICU
 *
 */
@Service
public class RulesServiceImpl implements RulesService {

	@Autowired
	PatientDao patientDao;

	public RulesServiceImpl() {
		System.out.println("Analytics Service Layer");
	}

	@Override
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
			parentBundleObj = (Parent_Bundle) patientDao.saveObject(parentBundleObj);
			// Save Sub-Bundles
			List<SubBundlesPOJO> subBundlesList = parentBundlePOJO.getSubBundles();
			for (SubBundlesPOJO subBundlesObj : subBundlesList) {
				Sub_Bundle subBunobj = new Sub_Bundle();
				subBunobj.setBundle_name(subBundlesObj.getBundle());
				subBunobj.setPurpose(subBundlesObj.getPurpose());
				subBunobj.setParent_bundle_id(parentBundleObj.getParent_bundle_id());

				subBunobj = (Sub_Bundle) patientDao.saveObject(subBunobj);

				// Save Criteria Sets
				for (int i = 0; i < subBundlesObj.getCriteriasName().size(); i++) {
					Criteria_Bundles criteriaBundlesObj = new Criteria_Bundles();
					criteriaBundlesObj.setParent_bundle_id(parentBundleObj.getParent_bundle_id());
					criteriaBundlesObj.setSub_bundle_id(subBunobj.getSub_bundle_id());
					criteriaBundlesObj.setCriteria_name(subBundlesObj.getCriteriasName().get(i));

					criteriaBundlesObj = (Criteria_Bundles) patientDao.saveObject(criteriaBundlesObj);

					List<Criteria_Object> criteriaList = subBundlesObj.getCriteriaObjectList().get(i);

					for (Criteria_Object obj1 : criteriaList) {
						if (obj1.getField_name() != null) {
							if (obj1.getField_name().equalsIgnoreCase("Gestation")
									|| obj1.getField_name().equalsIgnoreCase("Birth Weight")) {
								if (null == (obj1.getField_name())) {
									continue;
								}
							}
							obj1.setCriteria_bundles_id(criteriaBundlesObj.getCriteria_bundles_id());
							patientDao.saveObject(obj1);
						}
					}
				}

				// Save Recommendation Sets
				for (int i = 0; i < subBundlesObj.getRecommendationObjectList().size(); i++) {
					Recommendation_Bundle recommendationBundlesObj = new Recommendation_Bundle();
					recommendationBundlesObj.setParent_bundle_id(parentBundleObj.getParent_bundle_id());
					recommendationBundlesObj.setSub_bundle_id(subBunobj.getSub_bundle_id());

					recommendationBundlesObj = (Recommendation_Bundle) patientDao.saveObject(recommendationBundlesObj);

					List<Recommendation_Object> recommendationList = subBundlesObj.getRecommendationObjectList().get(i);

					for (Recommendation_Object obj1 : recommendationList) {
						obj1.setRecommendation_bundles_id(recommendationBundlesObj.getRecommendation_bundle_id());
						patientDao.saveObject(obj1);
					}
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
