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
@Table(name="ventilator", schema = "quality")
public class Ventilator 
{
  	@Id
    @Column(name="ventilator_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long ventilatorid;
  
	@Column(name = "uhid")
    private String uhid;

	@Column(name = "vent_mode")
	private String ventmode;

	public long getVentilatorid() {
		return ventilatorid;
	}

	public void setVentilatorid(long ventilatorid) {
		this.ventilatorid = ventilatorid;
	}

	public String getUhid() {
		return uhid;
	}

	public void setUhid(String uhid) {
		this.uhid = uhid;
	}

	public String getVentmode() {
		return ventmode;
	}

	public void setVentmode(String ventmode) {
		this.ventmode = ventmode;
	}
		

}
