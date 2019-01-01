package com.lubaszak.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.TouchEvent;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class UserController implements Initializable {


    @FXML
    private RadioButton maleButton;
    @FXML
    private RadioButton femaleButton;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private RadioButton reallyLowActivityButton;
    @FXML
    private RadioButton lowActivityButton;
    @FXML
    private RadioButton mediumActivityButton;
    @FXML
    private RadioButton highActivityButton;
    private ToggleGroup activityToggleGroup;
    private ToggleGroup sexToggleGroup;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activityToggleGroup = new ToggleGroup();
        reallyLowActivityButton.setToggleGroup(activityToggleGroup);
        lowActivityButton.setToggleGroup(activityToggleGroup);
        mediumActivityButton.setToggleGroup(activityToggleGroup);
        highActivityButton.setToggleGroup(activityToggleGroup);

        sexToggleGroup = new ToggleGroup();
        maleButton.setToggleGroup(sexToggleGroup);
        femaleButton.setToggleGroup(sexToggleGroup);

    }

    @FXML
    void saveUserSettings(ActionEvent event)
    {
        sexToggleGroup.selectedToggleProperty();
    }




}
