package com.lubaszak.controller;

import com.lubaszak.utils.MealTime;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Controller
public class FoodSearchController implements Initializable {

    @FXML private TextField searchField;
    @FXML private Text textId;
    @FXML
    void searchForFood(InputMethodEvent event) {

    }

    private MealTime mealTime;
    private Date date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setFood(Date date) {
        this.date = date;

    }

    public String getFood() {
        System.out.println("Method: " + date);
        return date.toString();
    }
}
