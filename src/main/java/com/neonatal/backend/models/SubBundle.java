package com.neonatal.backend.models;


import java.util.ArrayList;
import java.util.List;

public class SubBundle {
    private String parentBundle;
    private String parentPurpose;
    private String parentApplicable;
    private String bundle;
    private String purpose;
    private String applicable;
    private List<String> criteriasName;
    private List<String> criteriasCategories;
    private List<String> criteriasFields;
    private List<List<CriteriaObject>> criteriaObjectList;
    private List<String> recommendationCategories;
    private List<String> recommendationFields;
    private List<List<RecommendationObject>> recommendationObjectList;

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

    public List<List<CriteriaObject>> getCriteriaObjectList() {
        return criteriaObjectList;
    }

    public void setCriteriaObjectList(List<List<CriteriaObject>> criteriaObjectList) {
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

    public List<List<RecommendationObject>> getRecommendationObjectList() {
        return recommendationObjectList;
    }

    public void setRecommendationObjectList(List<List<RecommendationObject>> recommendationObjectList) {
        this.recommendationObjectList = recommendationObjectList;
    }
}
