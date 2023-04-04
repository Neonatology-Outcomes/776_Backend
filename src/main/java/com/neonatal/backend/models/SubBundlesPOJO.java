package com.neonatal.backend.models;

import java.util.List;

import com.neonatal.backend.entities.Criteria_Object;
import com.neonatal.backend.entities.Recommendation_Object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubBundlesPOJO {

	private String parentBundle;
	private String parentPurpose;
	private String parentApplicable;
	private String bundle;
	private String purpose;
	private String applicable;
	private List<String> criteriasName;
	private List<Integer> counts;
	private List<String> noncriteriasName;

	private List<Float> repeatTime;
	private List<String> repeatUnit;
	private List<String> termination;

	private List<String> targetName;
	private List<String> criteriasCategories;
	private List<String> criteriasFields;
	private List<String> recommendationFields;
	private List<String> targetsCategories;
	private List<String> targetsFields;
	private List<String> recommendationCategories;
	private List<List<Criteria_Object>> criteriaObjectList;
	public List<List<Criteria_Object>> getCriteriaObjectList() {
		return criteriaObjectList;
	}

	public void setCriteriaObjectList(List<List<Criteria_Object>> criteriaObjectList) {
		this.criteriaObjectList = criteriaObjectList;
	}

	public List<List<Recommendation_Object>> getRecommendationObjectList() {
		return recommendationObjectList;
	}

	public void setRecommendationObjectList(List<List<Recommendation_Object>> recommendationObjectList) {
		this.recommendationObjectList = recommendationObjectList;
	}

	public List<List<Criteria_Object>> getNoncriteriaObjectList() {
		return noncriteriaObjectList;
	}

	public void setNoncriteriaObjectList(List<List<Criteria_Object>> noncriteriaObjectList) {
		this.noncriteriaObjectList = noncriteriaObjectList;
	}

	public List<List<Recommendation_Object>> getNonrecommendationObjectList() {
		return nonrecommendationObjectList;
	}

	public void setNonrecommendationObjectList(List<List<Recommendation_Object>> nonrecommendationObjectList) {
		this.nonrecommendationObjectList = nonrecommendationObjectList;
	}

	private List<List<Recommendation_Object>> recommendationObjectList;

	private List<List<Criteria_Object>> noncriteriaObjectList;
	private List<List<Recommendation_Object>> nonrecommendationObjectList;

	public String getParentBundle() {
		return parentBundle;
	}

	public void setParentBundle(String parentBundle) {
		this.parentBundle = parentBundle;
	}

	public String getParentPurpose() {
		return parentPurpose;
	}

	public void setParentPurpose(String parentPurpose) {
		this.parentPurpose = parentPurpose;
	}

	public String getParentApplicable() {
		return parentApplicable;
	}

	public void setParentApplicable(String parentApplicable) {
		this.parentApplicable = parentApplicable;
	}

	public String getBundle() {
		return bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getApplicable() {
		return applicable;
	}

	public void setApplicable(String applicable) {
		this.applicable = applicable;
	}

	public List<String> getCriteriasName() {
		return criteriasName;
	}

	public void setCriteriasName(List<String> criteriasName) {
		this.criteriasName = criteriasName;
	}

	public List<Integer> getCounts() {
		return counts;
	}

	public void setCounts(List<Integer> counts) {
		this.counts = counts;
	}

	public List<String> getNoncriteriasName() {
		return noncriteriasName;
	}

	public void setNoncriteriasName(List<String> noncriteriasName) {
		this.noncriteriasName = noncriteriasName;
	}

	public List<Float> getRepeatTime() {
		return repeatTime;
	}

	public void setRepeatTime(List<Float> repeatTime) {
		this.repeatTime = repeatTime;
	}

	public List<String> getRepeatUnit() {
		return repeatUnit;
	}

	public void setRepeatUnit(List<String> repeatUnit) {
		this.repeatUnit = repeatUnit;
	}

	public List<String> getTermination() {
		return termination;
	}

	public void setTermination(List<String> termination) {
		this.termination = termination;
	}

	public List<String> getTargetName() {
		return targetName;
	}

	public void setTargetName(List<String> targetName) {
		this.targetName = targetName;
	}

	public List<String> getCriteriasCategories() {
		return criteriasCategories;
	}

	public void setCriteriasCategories(List<String> criteriasCategories) {
		this.criteriasCategories = criteriasCategories;
	}

	public List<String> getCriteriasFields() {
		return criteriasFields;
	}

	public void setCriteriasFields(List<String> criteriasFields) {
		this.criteriasFields = criteriasFields;
	}

	public List<String> getRecommendationFields() {
		return recommendationFields;
	}

	public void setRecommendationFields(List<String> recommendationFields) {
		this.recommendationFields = recommendationFields;
	}

	public List<String> getTargetsCategories() {
		return targetsCategories;
	}

	public void setTargetsCategories(List<String> targetsCategories) {
		this.targetsCategories = targetsCategories;
	}

	public List<String> getTargetsFields() {
		return targetsFields;
	}

	public void setTargetsFields(List<String> targetsFields) {
		this.targetsFields = targetsFields;
	}

	public List<String> getRecommendationCategories() {
		return recommendationCategories;
	}

	public void setRecommendationCategories(List<String> recommendationCategories) {
		this.recommendationCategories = recommendationCategories;
	}

}
