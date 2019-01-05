package com.lubaszak.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lubaszak.utilities.Activity;

import com.lubaszak.utilities.Sex;

import java.time.LocalDate;

public class UserDetail {


    private Sex sex;
    private LocalDate birthDate;
    private double height;
    private double weight;

    private Activity activityLevel;

    public UserDetail(Sex sex, LocalDate birthDate, double height, double weight, Activity activityLevel) {
        this.sex = sex;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
    }

    public UserDetail() {}

    public Enum getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Activity getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(Activity activityLevel) {
        this.activityLevel = activityLevel;
    }
}
