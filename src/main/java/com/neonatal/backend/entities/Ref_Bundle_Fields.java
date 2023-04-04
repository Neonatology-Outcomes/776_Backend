package com.neonatal.backend.entities;

import jakarta.persistence.*;

/**
 * Entity class for the ref_bundle_fields table of the quality schema from the neonatal database
 */
@Entity
@Table(name = "ref_bundle_fields", schema = "quality")
public class Ref_Bundle_Fields {

    @Id
    @Column(name = "fieldid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fieldid;

    @Column(name = "fieldname")
    private String fieldname;

    @Column(name = "category_id")
    private int category_id;

    public Ref_Bundle_Fields(long fieldid, String fieldname, int category_id) {
        this.fieldid = fieldid;
        this.fieldname = fieldname;
        this.category_id = category_id;
    }

    public Ref_Bundle_Fields() {

    }

    public long getFieldid() {
        return fieldid;
    }

    public void setFieldid(long fieldid) {
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
