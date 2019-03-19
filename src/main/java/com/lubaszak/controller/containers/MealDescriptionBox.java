package com.lubaszak.controller.containers;

import com.lubaszak.controller.MainController;
import com.lubaszak.model.Menu;
import com.lubaszak.model.Product;
import com.lubaszak.utils.MealTime;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MealDescriptionBox extends AnchorPane {

    @FXML
    private Text mealNameText;

    @FXML
    private Text proteinText;

    @FXML
    private Text calorieText;

    @FXML
    private Text carbText;

    @FXML
    private Text fatText;

    @FXML
    private Button addToMealList;


    private static MealTime mealTime;
    private static VBox productsList;

    public MealDescriptionBox(MealTime mealTime, VBox vbox) {
        this.mealTime = mealTime;
        this.productsList = vbox;



        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/MealDescriptionBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            setContent();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void setContent() {
        double protein = 0;
        double carbs = 0;
        double fat = 0;
        double calories = 0;


        if (productsList != null) {
            for (int i = 0; i < productsList.getChildren().size(); i++) {
                MenuBox menuBox = (MenuBox) productsList.getChildren().get(i);
                calories += menuBox.getCalorie();
                System.out.println(calories);

            }
        }
        MainController.calories += calories;

            calorieText.setText(String.format("%.2f", calories));


            mealNameText.setText(mealTime.name());

        }


    public Button getAddToMealListButton() {
        return addToMealList;
    }
}
