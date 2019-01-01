package com.lubaszak.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonFoodInfo {

    @JsonProperty("food_name")
    private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
