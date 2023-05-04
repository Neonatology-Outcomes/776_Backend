package com.neonatal.backend.models;

import java.util.List;

public class CompliancePOJO {
    String uhid = new String();
    List<AssessmentPOJO> assessments;
    public CompliancePOJO() {
    }
    public CompliancePOJO(String uhid, List<AssessmentPOJO> assessments) {
        this.uhid = uhid;
        this.assessments = assessments;
    }

    public String getUhid() {
        return uhid;
    }

    public void setUhid(String uhid) {
        this.uhid = uhid;
    }

    public List<AssessmentPOJO> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<AssessmentPOJO> assessments) {
        this.assessments = assessments;
    }
}
