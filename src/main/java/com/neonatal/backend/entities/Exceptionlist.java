package com.neonatal.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for the exceptionlist table in the quality schema of the neonatal database
 */
@Entity
@Table(name = "exceptionlist", schema = "quality")
public class Exceptionlist {

    @Id
    @Column(name = "exceptionid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long exceptionid;

    @Column(name = "exceptiontype")
    private String exceptiontype;

    @Column(name = "loggedinuser")
    private String loggedinuser;

    @Column(name = "uhid")
    private String uhid;

    @Column(name = "exceptionmessage")
    private String exceptionmessage;

    public Exceptionlist(Long exceptionid, String exceptiontype, String loggedinuser, String uhid,
                         String exceptionmessage) {
        this.exceptionid = exceptionid;
        this.exceptiontype = exceptiontype;
        this.loggedinuser = loggedinuser;
        this.uhid = uhid;
        this.exceptionmessage = exceptionmessage;
    }

    public Exceptionlist() {

    }

    public Long getExceptionid() {
        return exceptionid;
    }

    public void setExceptionid(Long exceptionid) {
        this.exceptionid = exceptionid;
    }

    public String getExceptiontype() {
        return exceptiontype;
    }

    public void setExceptiontype(String exceptiontype) {
        this.exceptiontype = exceptiontype;
    }

    public String getLoggedinuser() {
        return loggedinuser;
    }

    public void setLoggedinuser(String loggedinuser) {
        this.loggedinuser = loggedinuser;
    }

    public String getUhid() {
        return uhid;
    }

    public void setUhid(String uhid) {
        this.uhid = uhid;
    }

    public String getExceptionmessage() {
        return exceptionmessage;
    }

    public void setExceptionmessage(String exceptionmessage) {
        this.exceptionmessage = exceptionmessage;
    }
}
