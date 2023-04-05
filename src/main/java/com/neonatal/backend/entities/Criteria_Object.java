package com.neonatal.backend.entities;

import jakarta.persistence.*;

import javax.swing.text.html.HTMLDocument;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

/**
 * Entity class for the criteria_object table from the quality schema of the neonatal databse
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name = "criteria_object", schema = "quality")
public class Criteria_Object {

    @Id
    @Column(name = "criteria_object_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long criteria_object_id;

    @Column(name = "criteria_bundles_id")
    private long criteria_bundles_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "field_name")
    private String field_name;

    @Column(name = "type")
    private String type;

    @Column(name = "from_value")
    private Float from_value;

    @Column(name = "to_value")
    private Float to_value;

    @Column(name = "unit")
    private String unit;

    @Column(name = "time")
    private String time;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "vent")
    private String vent;

    @Column(name = "or_condition")
    private String or_condition;

    @Column(name = "bin")
    private String bin;

    public Criteria_Object(long criteria_bundles_id, String field_name, String type, float from_value, String time) {
        this.criteria_bundles_id = criteria_bundles_id;
        this.field_name = field_name;
        this.type = type;
        this.from_value = from_value;
        this.time = time;
    }

    public Criteria_Object() {

    }

    public long getCriteria_object_id() {
        return criteria_object_id;
    }

    public void setCriteria_object_id(long criteria_object_id) {
        this.criteria_object_id = criteria_object_id;
    }

    public long getCriteria_bundles_id() {
        return criteria_bundles_id;
    }

    public void setCriteria_bundles_id(long criteria_bundles_id) {
        this.criteria_bundles_id = criteria_bundles_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getFrom_value() {
        return from_value;
    }

    public void setFrom_value(float from_value) {
        this.from_value = from_value;
    }

    public float getTo_value() {
        return to_value;
    }

    public void setTo_value(float to_value) {
        this.to_value = to_value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getVent() {
        return vent;
    }

    public void setVent(String vent) {
        this.vent = vent;
    }

    public String getOr_condition() {
        return or_condition;
    }

    public void setOr_condition(String or_condition) {
        this.or_condition = or_condition;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }
}
