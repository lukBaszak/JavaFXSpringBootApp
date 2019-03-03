package com.lubaszak.controller;

import com.lubaszak.config.SpringFXMLLoader;
import com.lubaszak.config.StageManager;
import com.lubaszak.model.Product;
import com.lubaszak.model.ProductResponse;
import com.lubaszak.service.FoodProviderService;

import com.lubaszak.utils.FxContainer;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Controller
public class FoodSearchController implements Initializable {

    @Autowired
    FoodProviderService foodProviderService;

    @FXML
    private TextField searchField;
    @FXML
    private Text textId;
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

    public static String getProductId() {
        return productId;
    }

    public static void setProductId(String productId) {
        FoodSearchController.productId = productId;
    }

    public static String productId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (searchField.getText().length() > 4) {
                doSthMeth();
            }
        });
    }


    public void doSthMeth() {

        ProductResponse products = foodProviderService.getProductsByQuery(searchField.getText());


        VBox vBox = new VBox();

        for (int i = 0; products.getCommon().length > i; i++) {


            Image image = new Image(products.getCommon()[i].getPhoto().getThumb());
            ImageView imageView = new ImageView(image);

            imageView.setLayoutX(14);
            imageView.setLayoutY(6);
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);

            Text name = new Text(products.getCommon()[i].getFoodName());

            name.setLayoutX(93);
            name.setLayoutY(55);

            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefSize(300, 60);
            anchorPane.setStyle("-fx-border-style: none none solid none; -fx-border-width: 2; -fx-border-color: black;");
            anchorPane.getChildren().addAll(imageView, name);
            String food = products.getBranded()[i].getFoodName();

            anchorPane.setOnMouseClicked(event -> {

                productId = food;
                System.out.println(productId);
                stageManager.openNewStage(FxmlView.QUANTITY);
            });

            vBox.getChildren().add(anchorPane);

        }
        foodSearchPanel.setContent(vBox);

    }
}






