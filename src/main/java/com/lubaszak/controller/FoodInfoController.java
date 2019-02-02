package com.lubaszak.controller;

import com.lubaszak.model.Product;
import com.lubaszak.service.FoodProviderService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

public class FoodInfoController implements Initializable {

    @Autowired
    private FoodProviderService foodProviderService;

    private String foodId;
    @FXML
    private Text foodName;

    @FXML
    private ScrollPane infoScrollPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(foodId);
       Product product = foodProviderService.getProductByName(foodId);
       foodName.setText(product.getFoodName());
    }


    public void setFoodSearchId(String nixItemId) {
        this.foodId = nixItemId;
    }

    public String getFoodId() {
        return foodId;
    }


}
