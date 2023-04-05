package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Entity class file for the criteria_bundles table in the quality schema of the neonatal dtabase
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name = "criteria_bundles", schema = "quality")
public class Criteria_Bundles {

    @Id
    @Column(name = "criteria_bundles_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long criteria_bundles_id;

    @Column(name = "criteria_name")
    private String criteria_name;

    @Column(name = "parent_bundle_id")
    private long parent_bundle_id;

    @Column(name = "sub_bundle_id")
    private long sub_bundle_id;

    @Column(name = "repeat_time")
    private int repeat_time;

    @Column(name = "repeat_unit")
    private int repeat_unit;

    @Column(name = "termination")
    private int termination;

    public Criteria_Bundles(String criteria_name, long parent_bundle_id, long sub_bundle_id) {
        this.criteria_name = criteria_name;
        this.parent_bundle_id = parent_bundle_id;
        this.sub_bundle_id = sub_bundle_id;
    }

    public long getCriteria_bundles_id() {
        return criteria_bundles_id;
    }

    public void setCriteria_bundles_id(long criteria_bundles_id) {
        this.criteria_bundles_id = criteria_bundles_id;
    }

    public String getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(String criteria_name) {
        this.criteria_name = criteria_name;
    }

    public long getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(long parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }

    public long getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(long sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }

    public int getRepeat_time() {
        return repeat_time;
    }

    public void setRepeat_time(int repeat_time) {
        this.repeat_time = repeat_time;
    }

    public int getRepeat_unit() {
        return repeat_unit;
    }

    public void setRepeat_unit(int repeat_unit) {
        this.repeat_unit = repeat_unit;
    }

    public int getTermination() {
        return termination;
    }

    public void setTermination(int termination) {
        this.termination = termination;
    }
}
