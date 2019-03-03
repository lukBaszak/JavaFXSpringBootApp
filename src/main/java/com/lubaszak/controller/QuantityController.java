package com.lubaszak.controller;

import com.lubaszak.controller.containers.QuantityBox;
import com.lubaszak.model.Product;
import com.lubaszak.service.FoodProviderService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class QuantityController implements Initializable {

    @Autowired
    FoodProviderService foodService;

    @FXML
    private Pane pane;

    @FXML
    private ScrollPane quantityPane;

    @FXML
    private AnchorPane anchorPane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox vBox = new VBox();

        Product product = foodService.getProductByName("carrot");

        for(int i =0; i<product.getMeasures().length; i++) {
            QuantityBox quantityBox = new QuantityBox(product, product.getMeasures()[i]);
            vBox.getChildren().add(quantityBox);
        }
        quantityPane.setContent(vBox);

    }
}

