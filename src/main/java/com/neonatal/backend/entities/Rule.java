package com.neonatal.backend.entities;

import javax.persistence.*;

/**
 * This is the Rule entity class.  This class represents an entry within the rules table of the database,
 * and is used for CRUD operations between the service, controller, and repository.  Each private variable
 * corresponds to a column in the rules table of the database.  The @Id annotation identifies the primary key.
 */
@Entity
@Table(name="rules")
public class Rule {

    @Id
    private Integer id;

    @Column(name = "rule")
    private String rule;

    @Column(name = "action")
    private String action;

    public Rule(Integer id, String rule, String action) {
        this.id = id;
        this.rule = rule;
        this.action = action;
    }

    public Rule(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}