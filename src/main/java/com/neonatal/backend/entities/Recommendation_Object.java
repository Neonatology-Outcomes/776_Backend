package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Entity class for the recommendation_object table of the quality schema from the neonatal database
 */
@Entity
@Table(name = "recommendation_object", schema = "quality")
public class Recommendation_Object {

    @Id
    @Column(name = "recommendation_object_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recommendation_object_id;

    @Column(name = "recommendation_bundle_id")
    private BigInteger recommendation_bundle_id;

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

    @Column(name = "or_condition")
    private String or_condition;

    @Column(name = "bin")
    private String bin;

    public Recommendation_Object(long recommendation_object_id, BigInteger recommendation_bundle_id,
                                 String category_name, String field_name, String type, BigDecimal from_value,
                                 BigDecimal to_value, String unit, String time, String or_condition, String bin) {
        this.recommendation_object_id = recommendation_object_id;
        this.recommendation_bundle_id = recommendation_bundle_id;
        this.category_name = category_name;
        this.field_name = field_name;
        this.type = type;
        this.from_value = from_value;
        this.to_value = to_value;
        this.unit = unit;
        this.time = time;
        this.or_condition = or_condition;
        this.bin = bin;
    }

    public Recommendation_Object() {

    }

    public long getRecommendation_object_id() {
        return recommendation_object_id;
    }

    public void setRecommendation_object_id(long recommendation_object_id) {
        this.recommendation_object_id = recommendation_object_id;
    }

    public BigInteger getRecommendation_bundle_id() {
        return recommendation_bundle_id;
    }

    public void setRecommendation_bundle_id(BigInteger recommendation_bundle_id) {
        this.recommendation_bundle_id = recommendation_bundle_id;
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
