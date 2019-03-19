package com.lubaszak.controller;


import com.lubaszak.config.StageManager;
import com.lubaszak.controller.containers.QuantityBox;
import com.lubaszak.model.Menu;
import com.lubaszak.model.Product;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.MenuService;
import com.lubaszak.utils.FxmlView;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class QuantityController implements Initializable {

    @Autowired
    FoodProviderService foodService;

    @Autowired
    @Lazy
    StageManager stageManager;

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

            QuantityBox quantityBox = new QuantityBox(product,product.getMeasures()[i]);
            measures2 = product.getMeasures()[i];

            Product.Measures measures = product.getMeasures()[i];

            quantityBox.getAcceptButton().setOnAction(event -> {
                try {
                    menuService.save(new Menu(MainController.mealTimeChosen, product.getFoodName(), measures.getServingWeight() * quantityBox.getMultiplier(), MainController.chosenDate, UserSession.getSession().getId()));
                    stageManager.switchScene(FxmlView.MAIN);
                }
                catch(NumberFormatException e) {
                    System.out.println("Provide quantity of product");
                }
            });
            vBox.getChildren().add(quantityBox);


        }
        quantityPane.setContent(vBox);

    }
}

