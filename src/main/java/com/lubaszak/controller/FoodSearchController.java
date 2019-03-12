package com.lubaszak.controller;

import com.lubaszak.config.SpringFXMLLoader;
import com.lubaszak.config.StageManager;
import com.lubaszak.controller.containers.QuantityBox;
import com.lubaszak.controller.containers.ResultBox;
import com.lubaszak.model.Product;
import com.lubaszak.model.ProductResponse;
import com.lubaszak.service.FoodProviderService;


import com.lubaszak.utils.FxmlView;
import com.lubaszak.utils.MealTime;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.validation.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Controller
public class FoodSearchController implements Initializable {

    public static ProductResponse.CommonProductInfo product;
    @Autowired
    FoodProviderService foodProviderService;

    @FXML
    private TextField searchField;

    @FXML
    private ScrollPane foodSearchPanel;

    @FXML
    private AnchorPane foodPanel;

    @FXML
    private Text servingUnit;

    @FXML
    private Text foodNameText;

    @Autowired
    SpringFXMLLoader loader;

    @Autowired
    @Lazy
    StageManager stageManager;

    private MealTime mealTime;
    private Date date;

    public static String productId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (searchField.getText().length() > 4) {
                long startTime = System.currentTimeMillis();
                loadList();
                long finishTime = System.currentTimeMillis();
                System.out.println("That took: " + (finishTime - startTime) + " ms");
            }
        });
    }


    public void loadList() {


        ProductResponse products = foodProviderService.getProductsByQuery(searchField.getText());

        VBox vBox = new VBox();
        for (int i = 0; products.getCommon().length > i; i++) {

            ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("com.lubaszak.controller.containers");
            ResultBox resultBox = ctx.getBean(ResultBox.class);
            product = products.getCommon()[i];
            resultBox.setContent();
            String food = products.getCommon()[i].getFoodName();
            resultBox.setOnMouseClicked(event -> {

                productId = food;
                stageManager.openNewStage(FxmlView.QUANTITY);
            });

            vBox.getChildren().add(resultBox);
        }
        foodSearchPanel.setContent(vBox);


    }
}






