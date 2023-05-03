package com.neonatal.backend.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name="medication", schema = "quality")
public class Medication {
    @Id
    @Column(name="medication_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long medication_id;

    @Column(name = "creationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationtime;

    @Column(name = "modificationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationtime;

    @Column(name = "uhid")
    private String uhid;

    @Column(name = "medication_name")
    private String medication_name;

    public Medication(long medication_id, Date creationtime, Date modificationtime, String uhid, String medication_name){
        this.medication_id = medication_id;
        this.creationtime = creationtime;
        this.modificationtime = modificationtime;
        this.uhid = uhid;
        this.medication_name = medication_name;
    }

    public Medication(){
        // Default constructor.
    }

    public long getMedication_id() { return medication_id; }

    public void setMedication_id(long medication_id) { this.medication_id = medication_id; }

    public Date getCreationtime() { return creationtime; }

    public void setCreationtime(Date creationtime) { this.creationtime = creationtime; }

    public Date getModificationtime() { return modificationtime; }

    public void setModificationtime(Date modificationtime) { this.modificationtime = modificationtime; }

    public String getUhid() { return uhid; }

    public void setUhid(String uhid) { this.uhid = uhid; }

    public String getMedication_name() { return medication_name; }

    public void setMedication_name(String medication_name) { this.medication_name = medication_name; }
}
