package com.neonatal.backend.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class for the assessment table within the neonatal database
 */

@Entity
@Getter
@Setter
@Table(name = "assessment", schema="quality")
@NamedQuery(name = "Assessment.findAll", query = "SELECT b FROM Assessment b")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assessment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "assessment_id")
	private Long assessment_id;

	/*
	 * @Column(name = "creationtime")
	 *
	 * @Temporal(TemporalType.TIMESTAMP) private Date creationtime;
	 *
	 * @Column(name = "modificationtime")
	 *
	 * @Temporal(TemporalType.TIMESTAMP) private Date modificationtime;
	 */

	@Column(name = "parent_bundle_id")
	private Long parent_bundle_id;

	@Column(name = "sub_bundle_id")
	private Long sub_bundle_id;

	@Column(name = "uhid")
	private String uhid;

	@Column(name = "field_name")
	private String field_name;

	@Column(name = "entrytimestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrytimestamp;

	public Assessment(Long assessment_id, Long parent_bundle_id, Long sub_bundle_id, String uhid, String field_name,
			Date entrytimestamp) {
		this.assessment_id = assessment_id;
		this.parent_bundle_id = parent_bundle_id;
		this.sub_bundle_id = sub_bundle_id;
		this.uhid = uhid;
		this.field_name = field_name;
		this.entrytimestamp = entrytimestamp;
	}

	public Assessment() {

	}

	public Long getAssessment_id() {
		return assessment_id;
	}

	public void setAssessment_id(Long assessment_id) {
		this.assessment_id = assessment_id;
	}

	/*
	 * public Date getCreationtime() { return creationtime; }
	 *
	 * public void setCreationtime(Date creationtime) { this.creationtime =
	 * creationtime; }
	 *
	 * public Date getModificationtime() { return modificationtime; }
	 *
	 * public void setModificationtime(Date modificationtime) {
	 * this.modificationtime = modificationtime; }
	 */

	public Long getParent_bundle_id() {
		return parent_bundle_id;
	}

	public void setParent_bundle_id(Long parent_bundle_id) {
		this.parent_bundle_id = parent_bundle_id;
	}

	public Long getSub_bundle_id() {
		return sub_bundle_id;
	}

	public void setSub_bundle_id(Long sub_bundle_id) {
		this.sub_bundle_id = sub_bundle_id;
	}

	public String getUhid() {
		return uhid;
	}

	public void setUhid(String uhid) {
		this.uhid = uhid;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public Date getEntrytimestamp() {
		return entrytimestamp;
	}

	public void setEntrytimestamp(Date entrytimestamp) {
		this.entrytimestamp = entrytimestamp;
	}
}
