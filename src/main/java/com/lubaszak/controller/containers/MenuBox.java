package com.lubaszak.controller.containers;

import com.lubaszak.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class MenuBox extends AnchorPane {

    @FXML
    private Text foodNameText;

    @FXML
    private Text calorieText;

    @FXML
    private Text proteinText;

    @FXML
    private Text carbText;

    @FXML
    private Text fatText;

    @FXML
    private Button deleteButton;

    private double calorie;
    private double protein;
    private double carbs;
    private double fat;

    public MenuBox(Product product, double weight){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/MenuBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);



        try {
            fxmlLoader.load();
            setContent(product, weight);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void setContent(Product product, double weight) {



        double multiplier = weight/product.getServingWeightGrams();
        calorie = product.getCalories()*multiplier;
        fat = product.getTotalFat()*multiplier;
        carbs = product.getTotalCarbohydrate()*multiplier;
        protein = product.getProtein()*multiplier;


        foodNameText.setText(product.getFoodName());
        calorieText.setText(String.format("%.2f", calorie));
        fatText.setText(String.format("%.2f", fat));
        carbText.setText(String.format("%.2f", carbs));
        proteinText.setText((String.format("%.2f", protein)));
    }

    public Button getDeleteButton() {
        return deleteButton;
    }


    public double getCalorie() {
        return calorie;
    }
    public double getProtein() { return protein; }
    public double getCarbs() { return carbs; }
    public double getFat() { return fat; }
}


