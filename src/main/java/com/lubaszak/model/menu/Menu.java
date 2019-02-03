package com.lubaszak.model.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "menu")
@Table(name = "menu")
public class Menu {


    private Date date;
    private String mealTime;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_ID")
    private String productId;
    private int weight;

    public Menu() {

    }

    public Menu(Date date, String mealTime, String productName, String productId, int weight) {
        this.date = date;
        this.mealTime = mealTime;
        this.productName = productName;
        this.productId = productId;
        this.weight = weight;
    }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getMealTime() { return mealTime; }
    public void setMealTime(String mealTime) { this.mealTime = mealTime; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
