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
@Table(name = "ref_bundle_fields", schema="quality")
@NamedQuery(name = "Ref_Bundle_Fields.findAll", query = "SELECT r FROM Ref_Bundle_Fields r")
public class Ref_Bundle_Fields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fieldid")
	private int fieldid;

	@Column(name = "fieldname")
	private String fieldname;

	@Column(name = "category_id")
	private int category_id;

	public Ref_Bundle_Fields(int fieldid, String fieldname, int category_id) {
		this.fieldid = fieldid;
		this.fieldname = fieldname;
		this.category_id = category_id;
	}

	public Ref_Bundle_Fields() {

	}

	public int getFieldid() {
		return fieldid;
	}

	public void setFieldid(int fieldid) {
		this.fieldid = fieldid;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

}
