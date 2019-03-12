package com.lubaszak.controller.containers;

import com.lubaszak.config.SpringFXMLLoader;
import com.lubaszak.controller.LoginController;
import com.lubaszak.controller.MainController;
import com.lubaszak.controller.QuantityController;
import com.lubaszak.model.Menu;
import com.lubaszak.model.Product;
import com.lubaszak.repository.MenuRepository;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.MenuService;
import com.lubaszak.utils.FxContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionListener;
import java.io.IOException;

import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;


@Component
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




    private int multiplier = 1;


    public QuantityBox() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/QuantityBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    @PostLoad
    public void completeBox() {

        Product.Measures measures = QuantityController.measures2;
        Product product = QuantityController.product;



        quantityMeasure.setText(measures.getMeasure());
        gramatureText.setText(String.format("%.2f",measures.getServingWeight()));
        double caloriePerGram = product.getCalories()/product.getServingWeightGrams();
        calorieQuantity.setText(String.format("%.1f", caloriePerGram*measures.getServingWeight()));

        quantityField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d{0,3}" )) {

                quantityField.setText(newValue.replaceAll("[^\\d{0,3}]", ""));
            }

            else {
                multiplier = Integer.parseInt(newValue);
                if (measures.getMeasure().equals("g")) {
                    calorieQuantity.setText(String.format("%.1f", caloriePerGram * multiplier));
                    gramatureText.setText(quantityField.getText());
                } else {
                    gramatureText.setText(String.format("%.2f", measures.getServingWeight() * multiplier));
                    calorieQuantity.setText(String.format("%.1f", caloriePerGram * measures.getServingWeight() * multiplier));
                }
            }
        });
    }

    public int getQuantity() {
        return Integer.parseInt(quantityField.getText());
    }

    public Button getAcceptButton() {
        return acceptButton;
    }


    public int getMultiplier() {
        return multiplier;
    }
}
