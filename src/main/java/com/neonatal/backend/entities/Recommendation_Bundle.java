package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigInteger;

/**
 * Entity class for the table recommendation_bundle of the schema quality from the database neonatal
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name = "recommendation_bundle", schema = "quality")
public class Recommendation_Bundle {

    @Id
    @Column(name = "recommendation_bundle_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long recommendation_bundle_id;

    @Column(name = "sub_bundle_id")
    private long sub_bundle_id;

    @Column(name = "parent_bundle_id")
    private long parent_bundle_id;

    @Column(name = "criteria_bundles_id")
    private long criteria_bundles_id;

    public Recommendation_Bundle(long sub_bundle_id, long parent_bundle_id, long criteria_bundles_id) {
        this.sub_bundle_id = sub_bundle_id;
        this.parent_bundle_id = parent_bundle_id;
        this.criteria_bundles_id = criteria_bundles_id;
    }

    public Recommendation_Bundle() {

    }

    public long getRecommendation_bundle_id() {
        return recommendation_bundle_id;
    }

    public void setRecommendation_bundle_id(long recommendation_bundle_id) {
        this.recommendation_bundle_id = recommendation_bundle_id;
    }

    public long getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(long sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }

    public long getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(long parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }

    public long getCriteria_bundles_id() {
        return criteria_bundles_id;
    }

    public void setCriteria_bundles_id(long criteria_bundles_id) {
        this.criteria_bundles_id = criteria_bundles_id;
    }
}
