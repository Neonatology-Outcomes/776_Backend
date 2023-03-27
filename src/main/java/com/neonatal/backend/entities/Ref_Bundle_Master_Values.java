package com.neonatal.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class for the ref_bundle_master_values table of the quality schema from the neonatal database
 */
@Entity
@Table(name = "ref_bundle_master_values", schema = "quality")
public class Ref_Bundle_Master_Values {

    @Id
    @Column(name = "mastervalueid")
    private int mastervalueid;

    @Column(name = "valuename")
    private String valuename;

    @Column(name = "field_id")
    private int field_id;

    public Ref_Bundle_Master_Values(int mastervalueid, String valuename, int field_id) {
        this.mastervalueid = mastervalueid;
        this.valuename = valuename;
        this.field_id = field_id;
    }


    public Ref_Bundle_Master_Values() {

    }

    public int getMastervalueid() {
        return mastervalueid;
    }

    public void setMastervalueid(int mastervalueid) {
        this.mastervalueid = mastervalueid;
    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }
}
