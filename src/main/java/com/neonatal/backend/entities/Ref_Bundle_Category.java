package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigInteger;

/**
 * Entity class for the ref_bundle_category table of the quality schema from the neonatal databse
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name = "ref_bundle_category", schema = "quality")
public class Ref_Bundle_Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long category_id;

    @Column(name = "criteria_name")
    private String criteria_name;

    public Ref_Bundle_Category(long category_id, String criteria_name) {
        this.category_id = category_id;
        this.criteria_name = criteria_name;
    }

    public Ref_Bundle_Category() {

    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(String criteria_name) {
        this.criteria_name = criteria_name;
    }
}
