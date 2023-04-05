package com.neonatal.backend.models;

public class CriteriaObjectPOJO {
    private String category_name;
    private String field_name;
    private String type;
    private float from_value;
    private float to_value;
    private long criteria_object_id;
    private int criteria_bundles_id;
    private String creationtime;
    private String modificationtime;
    private String unit;
    private String time;
    private String medicine;
    private String vent;
    private String discontinueVent;
    private String or;
    private String discontinueMedicine;
    private String bin;
    private String assessment;

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

    public long getCriteria_object_id() {
        return criteria_object_id;
    }

    public void setCriteria_object_id(long criteria_object_id) {
        this.criteria_object_id = criteria_object_id;
    }

    public int getCriteria_bundles_id() {
        return criteria_bundles_id;
    }

    public void setCriteria_bundles_id(int criteria_bundles_id) {
        this.criteria_bundles_id = criteria_bundles_id;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getModificationtime() {
        return modificationtime;
    }

    public void setModificationtime(String modificationtime) {
        this.modificationtime = modificationtime;
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

    public String getDiscontinueVent() {
        return discontinueVent;
    }

    public void setDiscontinueVent(String discontinueVent) {
        this.discontinueVent = discontinueVent;
    }

    public String getOr() {
        return or;
    }

    public void setOr(String or) {
        this.or = or;
    }

    public String getDiscontinueMedicine() {
        return discontinueMedicine;
    }

    public void setDiscontinueMedicine(String discontinueMedicine) {
        this.discontinueMedicine = discontinueMedicine;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
}
