package com.lubaszak.controller;


import com.lubaszak.controller.containers.QuantityBox;
import com.lubaszak.model.Menu;
import com.lubaszak.model.Product;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.MenuService;
import com.lubaszak.utils.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class QuantityController implements Initializable {

    @Autowired
    FoodProviderService foodService;

    @Autowired
    MenuService menuService;

    @FXML
    private ScrollPane quantityPane;

    public static Product.Measures measures2;
    public static Product product;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        VBox vBox = new VBox();
         product = foodService.getProductByName(FoodSearchController.productId);


        for(int i =0; i<product.getMeasures().length; i++) {
            ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.lubaszak.controller.containers");
            QuantityBox quantityBox = context.getBean(QuantityBox.class);
            measures2 = product.getMeasures()[i];

            Product.Measures measures = product.getMeasures()[i];
            quantityBox.completeBox();
            quantityBox.getAcceptButton().setOnAction(event -> {
                try {
                    menuService.save(new Menu(MainController.mealTime, product.getFoodName(), measures.getServingWeight() * quantityBox.getMultiplier(), MainController.chosenDate, UserSession.getSession().getId()));
                    Stage stage = (Stage) quantityPane.getScene().getWindow();
                    stage.close();
                }
                catch(NumberFormatException e) {
                    System.out.println("Provide quantity of product");
                }
            });
            vBox.getChildren().add(quantityBox);
            context.close();

        }
        quantityPane.setContent(vBox);

    }
}

