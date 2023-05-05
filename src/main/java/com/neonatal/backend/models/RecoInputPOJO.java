package com.neonatal.backend.models;

public class RecoInputPOJO {

    String uhid;
    Long sub_bundle_id;
    Long parent_bundle_id;
//    int entrytimestamp;


    public RecoInputPOJO() {
    }

    public RecoInputPOJO(String uhid, Long sub_bundle_id, Long parent_bundle_id) {
        this.uhid = uhid;
        this.sub_bundle_id = sub_bundle_id;
        this.parent_bundle_id = parent_bundle_id;
    }

    public String getUhid() {
        return uhid;
    }

    public void setUhid(String uhid) {
        this.uhid = uhid;
    }

    public Long getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(Long sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }

    public Long getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(Long parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }
}
