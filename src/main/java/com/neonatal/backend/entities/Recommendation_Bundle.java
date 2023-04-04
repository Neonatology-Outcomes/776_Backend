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
@Table(name = "recommendation_bundle", schema="quality")
@NamedQuery(name = "Recommendation_Bundle.findAll", query = "SELECT b FROM Recommendation_Bundle b")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recommendation_Bundle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recommendation_bundle_id;

	@Column(name = "parent_bundle_id")
	private long parent_bundle_id;

	@Column(name = "sub_bundle_id")
	private long sub_bundle_id;

	@Column(name = "criteria_bundles_id")
	private long criteria_bundles_id;

	public Long getRecommendation_bundle_id() {
		return recommendation_bundle_id;
	}

	public void setRecommendation_bundle_id(Long recommendation_bundle_id) {
		this.recommendation_bundle_id = recommendation_bundle_id;
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

	public long getCriteria_bundles_id() {
		return criteria_bundles_id;
	}

	public void setCriteria_bundles_id(long criteria_bundles_id) {
		this.criteria_bundles_id = criteria_bundles_id;
	}

	public Recommendation_Bundle(long recommendation_bundle_id, String criteria_name, long parent_bundle_id,
			long sub_bundle_id, long criteria_bundles_id) {
		this.recommendation_bundle_id = recommendation_bundle_id;
		this.parent_bundle_id = parent_bundle_id;
		this.sub_bundle_id = sub_bundle_id;
		this.criteria_bundles_id = criteria_bundles_id;
	}

	public Recommendation_Bundle() {

	}

}
