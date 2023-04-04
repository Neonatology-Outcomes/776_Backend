package com.neonatal.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "parent_bundle", schema="quality")
@NamedQuery(name = "Parent_Bundle.findAll", query = "SELECT b FROM Parent_Bundle b")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parent_Bundle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parent_bundle_id;

	@Column(name = "bundle_name")
	private String bundle_name;

	@Column(name = "purpose")
	private String purpose;

	@Column(name = "is_delivery_room")
	private String is_delivery_room;

	@Column(name = "is_sub_bundle")
	private String is_sub_bundle;

	@Column(name = "branchname")
	private String branchname;

	public Parent_Bundle(long parent_bundle_id, String bundle_name, String purpose, String is_delivery_room,
			String is_sub_bundle, String branchname) {
		this.parent_bundle_id = parent_bundle_id;
		this.bundle_name = bundle_name;
		this.purpose = purpose;
		this.is_delivery_room = is_delivery_room;
		this.is_sub_bundle = is_sub_bundle;
		this.branchname = branchname;
	}

	public Parent_Bundle() {

	}

	public long getParent_bundle_id() {
		return parent_bundle_id;
	}

	public void setParent_bundle_id(long parent_bundle_id) {
		this.parent_bundle_id = parent_bundle_id;
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

	public String getIs_delivery_room() {
		return is_delivery_room;
	}

	public void setIs_delivery_room(String is_delivery_room) {
		this.is_delivery_room = is_delivery_room;
	}

	public String getIs_sub_bundle() {
		return is_sub_bundle;
	}

	public void setIs_sub_bundle(String is_sub_bundle) {
		this.is_sub_bundle = is_sub_bundle;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

}
