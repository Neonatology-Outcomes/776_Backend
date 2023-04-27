package com.neonatal.backend.models;

import java.util.Date;
import java.util.List;

public class NurseTasks {
	
	private String uhid;
	
	private int birth_weight;
	
	private Date dateofbirth;
	
	private List<String> tasks;

	public String getUhid() {
		return uhid;
	}

	public void setUhid(String uhid) {
		this.uhid = uhid;
	}

	public int getBirth_weight() {
		return birth_weight;
	}

	public void setBirth_weight(int birth_weight) {
		this.birth_weight = birth_weight;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
	
}