package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Entity class for the criteria_object table from the quality schema of the neonatal databse
 */
@Entity
@Table(name = "criteria_object", schema = "quality")
public class Criteria_Object {

    @Id
    @Column(name = "criteria_object_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long criteria_object_id;

    @Column(name = "criteria_bundles_id")
    private BigInteger criteria_bundles_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "field_name")
    private String field_name;

    @Column(name = "type")
    private String type;

    @Column(name = "from_value")
    private BigDecimal from_value;

    @Column(name = "to_value")
    private BigDecimal to_value;

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

    public Criteria_Object(long criteria_object_id, BigInteger criteria_bundles_id, String category_name,
                           String field_name, String type, BigDecimal from_value, BigDecimal to_value, String unit,
                           String time, String medicine, String vent, String or_condition, String bin) {
        this.criteria_object_id = criteria_object_id;
        this.criteria_bundles_id = criteria_bundles_id;
        this.category_name = category_name;
        this.field_name = field_name;
        this.type = type;
        this.from_value = from_value;
        this.to_value = to_value;
        this.unit = unit;
        this.time = time;
        this.medicine = medicine;
        this.vent = vent;
        this.or_condition = or_condition;
        this.bin = bin;
    }

    public Criteria_Object() {

    }

    public long getCriteria_object_id() {
        return criteria_object_id;
    }

    public void setCriteria_object_id(long criteria_object_id) {
        this.criteria_object_id = criteria_object_id;
    }

    public BigInteger getCriteria_bundles_id() {
        return criteria_bundles_id;
    }

    public void setCriteria_bundles_id(BigInteger criteria_bundles_id) {
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

    public BigDecimal getFrom_value() {
        return from_value;
    }

    public void setFrom_value(BigDecimal from_value) {
        this.from_value = from_value;
    }

    public BigDecimal getTo_value() {
        return to_value;
    }

    public void setTo_value(BigDecimal to_value) {
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
