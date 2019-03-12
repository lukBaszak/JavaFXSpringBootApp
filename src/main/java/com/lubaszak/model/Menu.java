package com.lubaszak.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lubaszak.utils.MealTime;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;


@Entity(name = "menu")
@Table(name = "menu")

public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "userID")
    private int userID;

    @Enumerated(EnumType.STRING)
    @Column(name="meal_time")
    private MealTime mealTime;
    @Column(name = "product_name")
    private String productName;


    private double weight;
    @Temporal(TemporalType.DATE)
    private Date date;


    public Menu() {

    }

    public Menu(MealTime mealTime, String productName, double weight, Date date, int user) {


        this.userID = user;
        this.mealTime = mealTime;
        this.productName = productName;
        this.weight = weight;
        this.date = date;


    }


    public int getUser() {
        return userID;
    }

    public void setUser(int user) {
        this.userID = user;
    }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public MealTime getMealTime() { return mealTime; }
    public void setMealTime(MealTime mealTime) { this.mealTime = mealTime; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
