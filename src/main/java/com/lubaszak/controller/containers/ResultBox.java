package com.lubaszak.controller.containers;

import com.lubaszak.controller.FoodSearchController;
import com.lubaszak.model.Product;
import com.lubaszak.model.ProductCommonResponse;
import com.lubaszak.model.ProductResponse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class ResultBox extends AnchorPane {

    @FXML
    private ImageView foodImage;

    @FXML
    private Text foodNameText;


    public ResultBox() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/ResultBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


    }

    public void setContent() {
        ProductResponse.CommonProductInfo product = FoodSearchController.product;

        Image image = new Image(product.getPhoto().getThumb());
        foodImage.setImage(image);
        foodNameText.setText(product.getFoodName());
    }
}
