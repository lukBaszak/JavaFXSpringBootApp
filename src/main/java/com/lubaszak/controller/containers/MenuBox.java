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
    private Button deleteButton;

    private double calorie;


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
        System.out.println(product.getServingWeightGrams());
        System.out.println(product.getCalories());
        System.out.println(weight ,);
        double multiplier = product.getServingWeightGrams()/weight;
        calorie = product.getCalories()*multiplier;

        foodNameText.setText(product.getFoodName());
        calorieText.setText(String.format("%.2f", calorie));
    }

    public Button getDeleteButton() {
        return deleteButton;
    }


    public double getCalorie() {
        return calorie;
    }
}


