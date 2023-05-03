package com.neonatal.backend.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name="procedure", schema = "quality")
public class Procedure {
    @Id
    @Column(name="procedure_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long procedure_id;

    @Column(name = "creationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationtime;

    @Column(name = "modificationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationtime;

    @Column(name = "uhid")
    private String uhid;

    @Column(name = "procedure_type")
    private String procedure_type;

    public Procedure(long procedure_id, Date creationtime, Date modificationtime, String uhid, String procedure_type){
        this.procedure_id = procedure_id;
        this.creationtime = creationtime;
        this.modificationtime = modificationtime;
        this.uhid = uhid;
        this.procedure_type = procedure_type;
    }

    public Procedure(){
        // Default constructor.
    }

    public long getProcedure_id() { return procedure_id; }

    public void setProcedure_id(long procedure_id) { this.procedure_id = procedure_id; }

    public Date getCreationtime() { return creationtime; }

    public void setCreationtime(Date creationtime) { this.creationtime = creationtime; }

    public Date getModificationtime() { return modificationtime; }

    public void setModificationtime(Date modificationtime) { this.modificationtime = modificationtime; }

    public String getUhid() { return uhid; }

    public void setUhid(String uhid) { this.uhid = uhid; }

    public String getProcedure_type() { return procedure_type; }

    public void setProcedure_type(String procedure_type) { this.procedure_type = procedure_type; }
}
