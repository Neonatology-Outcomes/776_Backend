package com.neonatal.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Entity class file for the criteria_bundles table in the quality schema of the neonatal dtabase
 */
@Entity
@Table(name = "criteria_bundles", schema = "quality")
public class Criteria_Bundles {

    @Id
    @Column(name = "criteria_bundles_id")
    private BigInteger criteria_bundles_id;

    @Column(name = "criteria_name")
    private String criteria_name;

    @Column(name = "parent_bundle_id")
    private int parent_bundle_id;

    @Column(name = "sub_bundle_id")
    private int sub_bundle_id;

    @Column(name = "repeat_time")
    private BigDecimal repeat_time;

    @Column(name = "repeat_unit")
    private BigDecimal repeat_unit;

    @Column(name = "termination")
    private int termination;

    public Criteria_Bundles(BigInteger criteria_bundles_id, String criteria_name, int parent_bundle_id,
                            int sub_bundle_id, BigDecimal repeat_time, BigDecimal repeat_unit, int termination) {
        this.criteria_bundles_id = criteria_bundles_id;
        this.criteria_name = criteria_name;
        this.parent_bundle_id = parent_bundle_id;
        this.sub_bundle_id = sub_bundle_id;
        this.repeat_time = repeat_time;
        this.repeat_unit = repeat_unit;
        this.termination = termination;
    }

    public Criteria_Bundles() {

    }

    public BigInteger getCriteria_bundles_id() {
        return criteria_bundles_id;
    }

    public void setCriteria_bundles_id(BigInteger criteria_bundles_id) {
        this.criteria_bundles_id = criteria_bundles_id;
    }

    public String getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(String criteria_name) {
        this.criteria_name = criteria_name;
    }

    public int getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(int parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }

    public int getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(int sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }

    public BigDecimal getRepeat_time() {
        return repeat_time;
    }

    public void setRepeat_time(BigDecimal repeat_time) {
        this.repeat_time = repeat_time;
    }

    public BigDecimal getRepeat_unit() {
        return repeat_unit;
    }

    public void setRepeat_unit(BigDecimal repeat_unit) {
        this.repeat_unit = repeat_unit;
    }

    public int getTermination() {
        return termination;
    }

    public void setTermination(int termination) {
        this.termination = termination;
    }
}
