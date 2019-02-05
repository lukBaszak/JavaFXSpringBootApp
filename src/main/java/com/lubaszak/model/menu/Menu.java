package com.lubaszak.model.menu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lubaszak.utils.MealTime;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "menu")
@Table(name = "menu")

public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name="meal_time")
    private Enum<MealTime> mealTime;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_id")
    private String productId;

    private int weight;




    public Menu() {

    }

    public Menu(Enum<MealTime> mealTime, String productName, String productId, int weight) {


        this.mealTime = mealTime;
        this.productName = productName;
        this.productId = productId;
        this.weight = weight;


    }






    public Enum<MealTime> getMealTime() { return mealTime; }
    public void setMealTime(Enum<MealTime> mealTime) { this.mealTime = mealTime; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
