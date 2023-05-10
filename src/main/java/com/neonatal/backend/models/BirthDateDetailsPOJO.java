package com.neonatal.backend.models;

import com.neonatal.backend.entities.Birth_Details;

import java.util.Date;

public class BirthDateDetailsPOJO extends Birth_Details {

    int year;
    int month;
    int day;

    public BirthDateDetailsPOJO() {
    }

    public BirthDateDetailsPOJO(long birth_details_id, String uhid, int birth_weight, int birth_gestation_week, int birth_gestation_days, Date dateofbirth, String timeofbirth, Date dateofadmission, String timeofadmission, int year, int month, int day) {
        super(birth_details_id, uhid, birth_weight, birth_gestation_week, birth_gestation_days, dateofbirth, timeofbirth, dateofadmission, timeofadmission);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
