package com.lubaszak.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lubaszak.utilities.Activity;

import com.lubaszak.utilities.Sex;

import java.time.LocalDate;

public class UserDetails {


    private Enum<Sex> sex;
    private LocalDate birthDate;
    private int height;
    private int weight;

    private Enum<Activity> activityLevel;

    public UserDetails(Enum<Sex> sex, LocalDate birthDate, int height, int weight, Enum<Activity> activityLevel) {
        this.sex = sex;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
    }

    public UserDetails() {}

    public Enum getSex() {
        return sex;
    }

    public void setSex(Enum sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Enum<Activity> getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(Enum<Activity> activityLevel) {
        this.activityLevel = activityLevel;
    }
}
