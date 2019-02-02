package com.lubaszak.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FoodDailyMenu {


    private List<Product> breakfast;
    private List<Product> lunch;
    private List<Product> brunch;
    private List<Product> dinner;

    public FoodDailyMenu(List<Product> breakfast, List<Product> brunch, List<Product> lunch, List<Product> dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.brunch = brunch;
        this.dinner = dinner;
    }

    public FoodDailyMenu() {
    }

    public List<Product> getBreakfast() {
        return breakfast;
    }
    public void setBreakfast(List<Product> breakfast) {
        this.breakfast = breakfast;
    }
    public List<Product> getLunch() {
        return lunch;
    }
    public void setLunch(List<Product> lunch) {
        this.lunch = lunch;
    }
    public List<Product> getBrunch() {
        return brunch;
    }
    public void setBrunch(List<Product> brunch) { this.brunch = brunch; }
    public List<Product> getDinner() {
        return dinner;
    }
    public void setDinner(List<Product> dinner) {
        this.dinner = dinner;
    }
}
