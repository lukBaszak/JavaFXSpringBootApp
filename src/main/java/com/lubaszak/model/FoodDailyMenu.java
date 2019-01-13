package com.lubaszak.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDailyMenu {

    private Product[] breakfast;
    private Product[] brunch;
    private Product[] midDinner;
    private Product[] dinner;

    public Product[] getBreakfest() {
        return breakfast;
    }
    public void setBreakfest(Product[] breakfast) {
        this.breakfast = breakfast;
    }
    public Product[] getBrunch() {
        return brunch;
    }
    public void setBrunch(Product[] brunch) {
        this.brunch = brunch;
    }
    public Product[] getMidDinner() {
        return midDinner;
    }
    public void setMidDinner(Product[] midDinner) {
        this.midDinner = midDinner;
    }
    public Product[] getDinner() {
        return dinner;
    }
    public void setDinner(Product[] dinner) {
        this.dinner = dinner;
    }
}
