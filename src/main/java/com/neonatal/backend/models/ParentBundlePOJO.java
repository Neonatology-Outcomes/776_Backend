package com.neonatal.backend.models;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentBundlePOJO {
	
	private String parentBundle;
	private String parentPurpose;
	private String parentApplicable;
	private String parentOption;

	private List<SubBundlesPOJO>  subBundles;
	private RefBundleMasterList masterDropdownObject;
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
	public List<SubBundlesPOJO> getSubBundles() {
		return subBundles;
	}
	public void setSubBundles(List<SubBundlesPOJO> subBundles) {
		this.subBundles = subBundles;
	}
	public RefBundleMasterList getMasterDropdownObject() {
		return masterDropdownObject;
	}
	public void setMasterDropdownObject(RefBundleMasterList masterDropdownObject) {
		this.masterDropdownObject = masterDropdownObject;
	}

}
