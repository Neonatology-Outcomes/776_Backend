package com.neonatal.backend.entities;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Entity class for the assessment table within the neonatal database
 */
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
@Table(name="assessment", schema = "quality")
public class Assessment {

    @Id
    @Column(name="assessment_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private long assessment_id;

    /*
    @Column(name = "creationtime")

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationtime;

    @Column(name = "modificationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationtime;
     */


    @Column(name = "parent_bundle_id")
    private BigInteger parent_bundle_id;

    @Column(name = "sub_bundle_id")
    private BigInteger sub_bundle_id;

    @Column(name = "recommendation_bundle_id")
    private BigInteger recommendation_bundle_id;
    
    @Column(name = "criteria_bundles_id")
    private BigInteger criteria_bundles_id;

	@Column(name = "uhid")
    private String uhid;

    @Column(name = "field_name")
    private String field_name;

    @Column(name = "entrytimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrytimestamp;

    public Assessment(long assessment_id, BigInteger parent_bundle_id, BigInteger sub_bundle_id,
                      String uhid, String field_name, Date entrytimestamp, BigInteger recommendation_bundle_id, BigInteger criteria_bundles_id) {
        this.assessment_id = assessment_id;
        this.parent_bundle_id = parent_bundle_id;
        this.sub_bundle_id = sub_bundle_id;
        this.uhid = uhid;
        this.field_name = field_name;
        this.entrytimestamp = entrytimestamp;
        this.recommendation_bundle_id = recommendation_bundle_id;
        this.criteria_bundles_id = criteria_bundles_id;
    }

    public Assessment() {

    }

    public long getAssessment_id() {
        return assessment_id;
    }

    public void setAssessment_id(long assessment_id) {
        this.assessment_id = assessment_id;
    }

    public BigInteger getParent_bundle_id() {
        return parent_bundle_id;
    }

    public void setParent_bundle_id(BigInteger parent_bundle_id) {
        this.parent_bundle_id = parent_bundle_id;
    }

    public BigInteger getSub_bundle_id() {
        return sub_bundle_id;
    }

    public void setSub_bundle_id(BigInteger sub_bundle_id) {
        this.sub_bundle_id = sub_bundle_id;
    }
    
    public BigInteger getRecommendation_bundle_id() {
		return recommendation_bundle_id;
	}

	public void setRecommendation_bundle_id(BigInteger recommendation_bundle_id) {
		this.recommendation_bundle_id = recommendation_bundle_id;
	}

	public BigInteger getCriteria_bundles_id() {
		return criteria_bundles_id;
	}

	public void setCriteria_bundles_id(BigInteger criteria_bundles_id) {
		this.criteria_bundles_id = criteria_bundles_id;
	}
	
    public String getUhid() {
        return uhid;
    }

    public void setUhid(String uhid) {
        this.uhid = uhid;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public Date getEntrytimestamp() {
        return entrytimestamp;
    }

    public void setEntrytimestamp(Date entrytimestamp) {
        this.entrytimestamp = entrytimestamp;
    }
}
