package com.neonatal.backend.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name="ventilator", schema = "quality")
public class Ventilator {
    @Id
    @Column(name="ventilator_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long ventilator_id;

    @Column(name = "creationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationtime;

    @Column(name = "modificationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationtime;

    @Column(name = "uhid")
    private String uhid;

    @Column(name = "vent_mode")
    private String vent_mode;

    public Ventilator(long ventilator_id, Date creationtime, Date modificationtime, String uhid, String vent_mode){
        this.ventilator_id = ventilator_id;
        this.creationtime = creationtime;
        this.modificationtime = modificationtime;
        this.uhid = uhid;
        this.vent_mode = vent_mode;
    }

    public Ventilator(){
        // Default constructor.
    }

    public long getVentilator_id() { return ventilator_id; }

    public void setVentilator_id(long ventilator_id) { this.ventilator_id = ventilator_id; }

    public Date getCreationtime() { return creationtime; }

    public void setCreationtime(Date creationtime) { this.creationtime = creationtime; }

    public Date getModificationtime() { return modificationtime; }

    public void setModificationtime(Date modificationtime) { this.modificationtime = modificationtime; }

    public String getUhid() { return uhid; }

    public void setUhid(String uhid) { this.uhid = uhid; }

    public String getVent_mode() { return vent_mode; }

    public void setVent_mode(String vent_mode) { this.vent_mode = vent_mode; }
}
