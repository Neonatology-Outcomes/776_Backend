package com.neonatal.backend.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

/**
 * Entity class for the birth_details table within the neonatal database
 */
@Entity
@Table(name="birth_details", schema = "quality")
public class Birth_Details {

        @Id
        @Column(name = "birth_details_id")
        private BigInteger birth_details_id;

        @Column(name = "uhid")
        private String uhid;

        @Column(name = "birth_weight")
        private int birth_weight;

        @Column(name = "birth_gestation_week")
        private int birth_gestation_week;

        @Column(name = "birth_gestation_days")
        private int birth_gestation_days;

        @Temporal(TemporalType.DATE)
        @Column(name = "dateofbirth")
        private Date dateofbirth;

        @Column(name = "timeofbirth")
        private String timeofbirth;

        @Column(name = "dateofadmission")
        @Temporal(TemporalType.DATE)
        private Date dateofadmission;

        @Column(name = "timeofadmission")
        private String timeofadmission;

        public Birth_Details(BigInteger birth_details_id, String uhid, int birth_weight, int birth_gestation_week,
                             int birth_gestation_days, Date dateofbirth, String timeofbirth, Date dateofadmission,
                             String timeofadmission) {
                this.birth_details_id = birth_details_id;
                this.uhid = uhid;
                this.birth_weight = birth_weight;
                this.birth_gestation_week = birth_gestation_week;
                this.birth_gestation_days = birth_gestation_days;
                this.dateofbirth = dateofbirth;
                this.timeofbirth = timeofbirth;
                this.dateofadmission = dateofadmission;
                this.timeofadmission = timeofadmission;
        }

        public Birth_Details() {

        }

        public BigInteger getBirth_details_id() {
                return birth_details_id;
        }

        public void setBirth_details_id(BigInteger birth_details_id) {
                this.birth_details_id = birth_details_id;
        }

        public String getUhid() {
                return uhid;
        }

        public void setUhid(String uhid) {
                this.uhid = uhid;
        }

        public int getBirth_weight() {
                return birth_weight;
        }

        public void setBirth_weight(int birth_weight) {
                this.birth_weight = birth_weight;
        }

        public int getBirth_gestation_week() {
                return birth_gestation_week;
        }

        public void setBirth_gestation_week(int birth_gestation_week) {
                this.birth_gestation_week = birth_gestation_week;
        }

        public int getBirth_gestation_days() {
                return birth_gestation_days;
        }

        public void setBirth_gestation_days(int birth_gestation_days) {
                this.birth_gestation_days = birth_gestation_days;
        }

        public Date getDateofbirth() {
                return dateofbirth;
        }

        public void setDateofbirth(Date dateofbirth) {
                this.dateofbirth = dateofbirth;
        }

        public String getTimeofbirth() {
                return timeofbirth;
        }

        public void setTimeofbirth(String timeofbirth) {
                this.timeofbirth = timeofbirth;
        }

        public Date getDateofadmission() {
                return dateofadmission;
        }

        public void setDateofadmission(Date dateofadmission) {
                this.dateofadmission = dateofadmission;
        }

        public String getTimeofadmission() {
                return timeofadmission;
        }

        public void setTimeofadmission(String timeofadmission) {
                this.timeofadmission = timeofadmission;
        }
}
