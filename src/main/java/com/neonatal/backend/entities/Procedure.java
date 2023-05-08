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
@Table(name="procedure", schema = "quality")

public class Procedure 
{
	@Id
    @Column(name="procedure_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long procedureid;
  
	@Column(name = "uhid")
    private String uhid;

	@Column(name = "procedure_type")
	private String proceduretype;

	

}
