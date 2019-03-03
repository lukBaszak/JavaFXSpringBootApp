package com.lubaszak.controller.containers;

import com.lubaszak.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import javafx.scene.text.Text;

public class QuantityBox extends AnchorPane {

    @FXML
    private Text quantityMeasure;
    @FXML
    private TextField quantityField;
    @FXML
    private Text gramatureText;
    @FXML
    private Text calorieQuantity;
    @FXML
    private Button acceptButton;

    int multiplier = 1;
    public QuantityBox(Product product, Product.Measures measures) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "/fxml/QuantityBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        quantityMeasure.setText(measures.getMeasure());
        gramatureText.setText(String.format("%.2f",measures.getServingWeight()));
        double caloriePerGram = product.getCalories()/product.getServingWeightGrams();
        calorieQuantity.setText(String.format("%.1f", caloriePerGram*measures.getServingWeight()));

        quantityField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                quantityField.setText(newValue.replaceAll("[^\\d]", ""));
            }

            multiplier = Integer.parseInt(newValue);
            gramatureText.setText(String.format("%.2f",measures.getServingWeight()*multiplier));
            calorieQuantity.setText(String.format("%.1f", caloriePerGram*measures.getServingWeight()*multiplier));
        });




    }




}
