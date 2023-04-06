package com.neonatal.backend.entities;

import jakarta.persistence.*;

/**
 * Entity class for the ref_bundle_master_values table of the quality schema from the neonatal database
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name = "ref_bundle_master_values", schema = "quality")
public class Ref_Bundle_Master_Values {

    @Id
    @Column(name = "mastervalueid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long mastervalueid;

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

    public long getMastervalueid() {
        return mastervalueid;
    }

    public void setMastervalueid(long mastervalueid) {
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
