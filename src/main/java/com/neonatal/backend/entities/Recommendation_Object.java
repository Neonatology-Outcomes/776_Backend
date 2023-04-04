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
@Table(name = "recommendation_object", schema="quality")
@NamedQuery(name = "Recommendation_Object.findAll", query = "SELECT b FROM Recommendation_Object b")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recommendation_Object implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recommendation_object_id;

	@Column(name = "recommendation_bundle_id")
	private Long recommendation_bundle_id;

	@Column(name = "category_name")
	private String category_name;

	@Column(name = "field_name")
	private String field_name;

	@Column(name = "repeat_time")
	private int repeat_time;

	@Column(name = "repeat_unit")
	private String repeat_unit;

	@Column(name = "type")
	private String type;

	@Column(columnDefinition = "Float4", name = "from_value")
	private Float from_value;

	@Column(columnDefinition = "Float4", name = "to_value")
	private Float to_value;

	@Column(name = "unit")
	private String unit;

	@Column(name = "time")
	private String time;

	@Column(name = "or_condition")
	private String or_condition;

	@Column(name = "bin")
	private String bin;

	public Recommendation_Object(long recommendation_object_id, long recommendation_bundle_id, String category_name,
			String field_name, int repeat_time, String repeat_unit, String type, Float from_value, Float to_value,
			String unit, String time, String or_condition, String bin) {
		this.recommendation_object_id = recommendation_object_id;
		this.recommendation_bundle_id = recommendation_bundle_id;
		this.category_name = category_name;
		this.field_name = field_name;
		this.repeat_time = repeat_time;
		this.repeat_unit = repeat_unit;
		this.type = type;
		this.from_value = from_value;
		this.to_value = to_value;
		this.unit = unit;
		this.time = time;
		this.or_condition = or_condition;
		this.bin = bin;
	}

	public Recommendation_Object() {

	}

	public long getRecommendation_object_id() {
		return recommendation_object_id;
	}

	public void setRecommendation_object_id(long recommendation_object_id) {
		this.recommendation_object_id = recommendation_object_id;
	}

	public long getRecommendation_bundle_id() {
		return recommendation_bundle_id;
	}

	public void setRecommendation_bundles_id(long recommendation_bundle_id) {
		this.recommendation_bundle_id = recommendation_bundle_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getFrom_value() {
		return from_value;
	}

	public void setFrom_value(Float from_value) {
		this.from_value = from_value;
	}

	public Float getTo_value() {
		return to_value;
	}

	public void setTo_value(Float to_value) {
		this.to_value = to_value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOr_condition() {
		return or_condition;
	}

	public void setOr_condition(String or_condition) {
		this.or_condition = or_condition;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

}
