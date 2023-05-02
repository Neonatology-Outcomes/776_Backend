package com.neonatal.backend.models;

import java.util.List;
import com.neonatal.backend.entities.Criteria_Object;
import com.neonatal.backend.entities.Recommendation_Object;

public class SubBundlePOJO {
    private String parentBundle;
    private String parentPurpose;
    private String parentApplicable;
    private String bundle;
    private String purpose;
    private String applicable;
    private List<String> criteriasName;
    private List<String> criteriasCategories;
    private List<String> criteriasFields;
    private List<List<Criteria_Object>> criteriaObjectList;
    private List<String> recommendationCategories;
    private List<String> recommendationFields;
    private List<List<Recommendation_Object>> recommendationObjectList;

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

    public List<List<Criteria_Object>> getCriteriaObjectList() {
        return criteriaObjectList;
    }

    public void setCriteriaObjectList(List<List<Criteria_Object>> criteriaObjectList) {
        this.criteriaObjectList = criteriaObjectList;
    }

    public List<String> getRecommendationCategories() {
        return recommendationCategories;
    }

    public void setRecommendationCategories(List<String> recommendationCategories) {
        this.recommendationCategories = recommendationCategories;
    }

    public List<String> getRecommendationFields() {
        return recommendationFields;
    }

    public void setRecommendationFields(List<String> recommendationFields) {
        this.recommendationFields = recommendationFields;
    }

    public List<List<Recommendation_Object>> getRecommendationObjectList() {
        return recommendationObjectList;
    }

    public void setRecommendationObjectList(List<List<Recommendation_Object>> recommendationObjectList) {
        this.recommendationObjectList = recommendationObjectList;
    }
}
