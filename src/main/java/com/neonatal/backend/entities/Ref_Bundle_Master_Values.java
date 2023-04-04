package com.neonatal.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ref_bundle_master_values", schema="quality")
@NamedQuery(name = "Ref_Bundle_Master_Values.findAll", query = "SELECT r FROM Ref_Bundle_Master_Values r")
public class Ref_Bundle_Master_Values implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mastervalueid")
	private int mastervalueid;

	@Column(name = "valuename")
	private String valuename;

	@Column(name = "field_id")
	private int field_id;

	public Ref_Bundle_Master_Values(int mastervalueid, String valuename, int field_id) {
		this.mastervalueid = mastervalueid;
		this.valuename = valuename;
		this.field_id = field_id;
	}

	public Ref_Bundle_Master_Values() {

	}

	public int getMastervalueid() {
		return mastervalueid;
	}

	public void setMastervalueid(int mastervalueid) {
		this.mastervalueid = mastervalueid;
	}

	public String getValuename() {
		return valuename;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}

	public int getField_id() {
		return field_id;
	}

	public void setField_id(int field_id) {
		this.field_id = field_id;
	}

}