package com.neonatal.backend.models;

import java.util.List;

public class ParentBundlePOJO {

    String parentBundle;
    String parentPurpose;
    String parentApplicable;
    String parentOption;
    List<SubBundlePOJO> subBundles;

    public ParentBundlePOJO(String parentBundle, String parentPurpose, String parentApplicable, String parentOption, List<SubBundlePOJO> subBundles) {
        this.parentBundle = parentBundle;
        this.parentPurpose = parentPurpose;
        this.parentApplicable = parentApplicable;
        this.parentOption = parentOption;
        this.subBundles = subBundles;
    }

    public String getParentBundle() {
        return parentBundle;
    }

    public void setParentBundle(String parentBundle) {
        this.parentBundle = parentBundle;
    }

    public String getParentPurpose() {
        return parentPurpose;
    }

    public void setParentPurpose(String parentPurpose) {
        this.parentPurpose = parentPurpose;
    }

    public String getParentApplicable() {
        return parentApplicable;
    }

    public void setParentApplicable(String parentApplicable) {
        this.parentApplicable = parentApplicable;
    }

    public String getParentOption() {
        return parentOption;
    }

    public void setParentOption(String parentOption) {
        this.parentOption = parentOption;
    }

    public List<SubBundlePOJO> getSubBundles() {
        return subBundles;
    }

    public void setSubBundles(List<SubBundlePOJO> subBundles) {
        this.subBundles = subBundles;
    }
}
