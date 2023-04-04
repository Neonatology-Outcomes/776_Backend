package com.neonatal.backend.models;

import java.util.ArrayList;

public class RuleObject {
    String ruleName = new String();
    String condition = new String();
    String action = new String();

    public RuleObject(String ruleName, String condition, String action) {
        this.ruleName = ruleName;
        this.condition = condition;
        this.action = action;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
