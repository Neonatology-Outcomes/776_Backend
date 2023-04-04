package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigInteger;

/**
 * Entity clas for the user table of the quality schema from the neonatal databse
 */
@Entity
@Table(name = "user", schema = "quality")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "roleid")
    private String roleid;

    public User(long id, String username, String password, String emailaddress, String firstname,
                String lastname, String roleid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emailaddress = emailaddress;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roleid = roleid;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}
