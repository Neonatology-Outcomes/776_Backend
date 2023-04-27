package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigInteger;

/**
 * Entity class for the sub_bundle table of the quality schema from the neonatal database
 */
@Entity
@SequenceGenerator(name="seq", initialValue = 1, allocationSize = 100)
@Table(name = "sub_bundle", schema = "quality")
public class Sub_Bundle {

    @Id
    @Column(name = "sub_bundle_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq"
    )
    private long sub_bundle_id;

    @Column(name = "bundle_name")
    private String bundle_name;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "at_admission")
    private String at_admission;

    @Column(name = "in_delivery_room")
    private String in_delivery_room;

    @Column(name = "in_nicu")
    private String in_nicu;

    @Column(name = "at_discharge")
    private String at_discharge;

    @Column(name = "parent_bundle_id")
    private long parent_bundle_id;

    public Sub_Bundle(String bundle_name, String purpose, String at_admission,
                      String in_delivery_room, String in_nicu, String at_discharge, long parent_bundle_id) {
        this.bundle_name = bundle_name;
        this.purpose = purpose;
        this.at_admission = at_admission;
        this.in_delivery_room = in_delivery_room;
        this.in_nicu = in_nicu;
        this.at_discharge = at_discharge;
        this.parent_bundle_id = parent_bundle_id;
    }

    public Sub_Bundle(String bundle_name, String purpose, long parent_bundle_id){
        this.bundle_name = bundle_name;
        this.purpose = purpose;
        this.parent_bundle_id = parent_bundle_id;
    }
    public Sub_Bundle() {

    }

    public long getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(long sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }

    public String getBundle_name() {
        return bundle_name;
    }

    public void setBundle_name(String bundle_name) {
        this.bundle_name = bundle_name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAt_admission() {
        return at_admission;
    }

    public void setAt_admission(String at_admission) {
        this.at_admission = at_admission;
    }

    public String getIn_delivery_room() {
        return in_delivery_room;
    }

    public void setIn_delivery_room(String in_delivery_room) {
        this.in_delivery_room = in_delivery_room;
    }

    public String getIn_nicu() {
        return in_nicu;
    }

    public void setIn_nicu(String in_nicu) {
        this.in_nicu = in_nicu;
    }

    public String getAt_discharge() {
        return at_discharge;
    }

    public void setAt_discharge(String at_discharge) {
        this.at_discharge = at_discharge;
    }

    public long getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(long parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }
}
