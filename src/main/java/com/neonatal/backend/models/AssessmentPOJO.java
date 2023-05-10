package com.neonatal.backend.models;

import java.math.BigInteger;

public class AssessmentPOJO {

    String fieldName;
    BigInteger recommendation_bundle_id;
    BigInteger criteria_bundle_id;
    int occurrences;

    public AssessmentPOJO() {
    }

    public AssessmentPOJO(String fieldName, BigInteger recommendation_bundle_id, BigInteger criteria_bundle_id) {
        this.fieldName = fieldName;
        this.recommendation_bundle_id = recommendation_bundle_id;
        this.criteria_bundle_id = criteria_bundle_id;
    }

    public AssessmentPOJO(String fieldName, BigInteger recommendation_bundle_id, BigInteger criteria_bundle_id, int occurences){
        this.fieldName = fieldName;
        this.recommendation_bundle_id = recommendation_bundle_id;
        this.criteria_bundle_id = criteria_bundle_id;
        this.occurrences = occurences;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setRecommendation_bundle_id(BigInteger recommendation_bundle_id) {
        this.recommendation_bundle_id = recommendation_bundle_id;
    }

    public void setCriteria_bundle_id(BigInteger criteria_bundle_id) {
        this.criteria_bundle_id = criteria_bundle_id;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public String getFieldName() {
        return fieldName;
    }

    public BigInteger getRecommendation_bundle_id() {
        return recommendation_bundle_id;
    }

    public BigInteger getCriteria_bundle_id() {
        return criteria_bundle_id;
    }

    public int getOccurrences() {
        return occurrences;
    }


}
