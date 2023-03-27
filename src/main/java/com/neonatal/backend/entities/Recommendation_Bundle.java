package com.neonatal.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;

/**
 * Entity class for the table recommendation_bundle of the schema quality from the database neonatal
 */
@Entity
@Table(name = "recommendation_bundle", schema = "quality")
public class Recommendation_Bundle {

    @Id
    @Column(name = "recommendation_bundle_id")
    private BigInteger recommendation_bundle_id;

    @Column(name = "criteria_name")
    private String criteria_name;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "parent_bundle_id")
    private BigInteger parent_bundle_id;

    @Column(name = "sub_bundle_id")
    private BigInteger sub_bundle_id;

    public Recommendation_Bundle(BigInteger recommendation_bundle_id, String criteria_name, String purpose, BigInteger parent_bundle_id, BigInteger sub_bundle_id) {
        this.recommendation_bundle_id = recommendation_bundle_id;
        this.criteria_name = criteria_name;
        this.purpose = purpose;
        this.parent_bundle_id = parent_bundle_id;
        this.sub_bundle_id = sub_bundle_id;
    }


    public Recommendation_Bundle() {

    }

    public BigInteger getRecommendation_bundle_id() {
        return recommendation_bundle_id;
    }

    public void setRecommendation_bundle_id(BigInteger recommendation_bundle_id) {
        this.recommendation_bundle_id = recommendation_bundle_id;
    }

    public String getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(String criteria_name) {
        this.criteria_name = criteria_name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public BigInteger getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(BigInteger parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }

    public BigInteger getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(BigInteger sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }
}
