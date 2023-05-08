package com.neonatal.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name="medication", schema = "quality")

public class Medication 
{
	@Id
    @Column(name="medication_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long medicationid;
	
	@Column(name = "uhid")
    private String uhid;

	@Column(name = "medication_name")
	private String medicationname;

	public long getMedicationid() {
		return medicationid;
	}

	public void setMedicationid(long medicationid) {
		this.medicationid = medicationid;
	}

	public String getUhid() {
		return uhid;
	}

	public void setUhid(String uhid) {
		this.uhid = uhid;
	}

	public String getMedicationname() {
		return medicationname;
	}

	public void setMedicationname(String medicationname) {
		this.medicationname = medicationname;
	}

	
}
