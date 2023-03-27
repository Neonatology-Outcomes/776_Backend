package com.neonatal.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class for the ref_bundle_fields table of the quality schema from the neonatal database
 */
@Entity
@Table(name = "ref_bundle_fields", schema = "quality")
public class Ref_Bundle_Fields {

    @Id
    @Column(name = "fieldid")
    private int fieldid;

    @Column(name = "fieldname")
    private String fieldname;

    @Column(name = "category_id")
    private int category_id;

    public Ref_Bundle_Fields(int fieldid, String fieldname, int category_id) {
        this.fieldid = fieldid;
        this.fieldname = fieldname;
        this.category_id = category_id;
    }

    public Ref_Bundle_Fields() {

    }

    public int getFieldid() {
        return fieldid;
    }

    public void setFieldid(int fieldid) {
        this.fieldid = fieldid;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
