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
@Table(name = "ref_bundle_category" , schema="quality")
@NamedQuery(name = "Ref_Bundle_Category.findAll", query = "SELECT r FROM Ref_Bundle_Category r")
public class Ref_Bundle_Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "categoryid")
	private Long categoryid;

	@Column(name = "categoryname")
	private String categoryname;

	public Ref_Bundle_Category(Long categoryid, String categoryname) {
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}

	public Ref_Bundle_Category() {

	}

	public Long categoryid() {
		return categoryid;
	}

	public void setCategory_id(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategorynamename() {
		return categoryname;
	}

	public void setCategorynamename(String categoryname) {
		this.categoryname = categoryname;
	}

}
