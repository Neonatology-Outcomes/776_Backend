package com.neonatal.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class for the role table of the quality schema from the neonatal database
 */
@Entity
@Table(name = "role", schema = "quality")
public class Role {

    @Id
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "rolename")
    private String rolename;

    @Column(name = "description")
    private String description;

    public Role(int roleid, String rolename, String description) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.description = description;
    }

    public Role() {

    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
