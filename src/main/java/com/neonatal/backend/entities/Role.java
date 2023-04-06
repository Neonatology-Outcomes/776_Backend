package com.neonatal.backend.entities;

import jakarta.persistence.*;

/**
 * Entity class for the role table of the quality schema from the neonatal database
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name = "role", schema = "quality")
public class Role {

    @Id
    @Column(name = "roleid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long roleid;

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

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
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
