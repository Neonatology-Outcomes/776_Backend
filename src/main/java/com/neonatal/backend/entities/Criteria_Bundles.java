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
@Table(name = "criteria_bundles", schema="quality")
@NamedQuery(name = "Criteria_Bundles.findAll", query = "SELECT b FROM Criteria_Bundles b")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Criteria_Bundles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long criteria_bundles_id;

	@Column(name = "criteria_name")
	private String criteria_name;

	@Column(name = "parent_bundle_id")
	private long parent_bundle_id;

	@Column(name = "sub_bundle_id")
	private long sub_bundle_id;

	@Column(name = "repeat_time")
	private int repeat_time;

	@Column(name = "repeat_unit")
	private String repeat_unit;

	@Column(name = "termination")
	private int termination;

	public Criteria_Bundles(long criteria_bundles_id, String criteria_name, long parent_bundle_id, long sub_bundle_id,
			int repeat_time, String repeat_unit, int termination) {
		this.criteria_bundles_id = criteria_bundles_id;
		this.criteria_name = criteria_name;
		this.parent_bundle_id = parent_bundle_id;
		this.sub_bundle_id = sub_bundle_id;
		this.repeat_time = repeat_time;
		this.repeat_unit = repeat_unit;
		this.termination = termination;
	}

	public Criteria_Bundles() {

	}

	public long getCriteria_bundles_id() {
		return criteria_bundles_id;
	}

	public void setCriteria_bundles_id(long criteria_bundles_id) {
		this.criteria_bundles_id = criteria_bundles_id;
	}

	public String getCriteria_name() {
		return criteria_name;
	}

	public void setCriteria_name(String criteria_name) {
		this.criteria_name = criteria_name;
	}

	public long getParent_bundle_id() {
		return parent_bundle_id;
	}

	public void setParent_bundle_id(long parent_bundle_id) {
		this.parent_bundle_id = parent_bundle_id;
	}

	public long getSub_bundle_id() {
		return sub_bundle_id;
	}

	public void setSub_bundle_id(long sub_bundle_id) {
		this.sub_bundle_id = sub_bundle_id;
	}

	public int getRepeat_time() {
		return repeat_time;
	}

	public void setRepeat_time(int repeat_time) {
		this.repeat_time = repeat_time;
	}

	public String getRepeat_unit() {
		return repeat_unit;
	}

	public void setRepeat_unit(String repeat_unit) {
		this.repeat_unit = repeat_unit;
	}

	public int getTermination() {
		return termination;
	}

	public void setTermination(int termination) {
		this.termination = termination;
	}

}