package com.lubaszak.controller;

import com.lubaszak.bean.UserDetails;
import com.lubaszak.utilities.Activity;
import com.lubaszak.utilities.Sex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Controller
public class UserDetailsController implements Initializable {



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
    private ToggleGroup activityToggleGroup;
    @FXML
    private ToggleGroup sexToggleGroup;
    @FXML
    private RadioButton reallyLowActivityButton;
    @FXML
    private RadioButton lowActivityButton;
    @FXML
    private RadioButton mediumActivityButton;
    @FXML
    private RadioButton highActivityButton;



    private UserDetails user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    void saveUserSettings(ActionEvent event)
    {
        if(sexToggleGroup.selectedToggleProperty()==null) {
        }
        else {
            user = new UserDetails(getSex(), getBirthDate(), getHeight(),getWeight(), getActivityLevel());
            System.out.println("done");

        }
    }


    public int getHeight() {
        return Integer.parseInt(heightField.getText());
    }

    public int getWeight() {
        return Integer.parseInt(weightField.getText());
    }

    public LocalDate getBirthDate() {
        return dateOfBirth.getValue();
    }

    public Enum<Sex> getSex() {
        String selected = activityToggleGroup.getSelectedToggle().toString();

        if(selected==getButtonText(maleButton)) {
            return Sex.MAN;
        }

        else if(selected==getButtonText(femaleButton)) {
            return Sex.WOMAN;
        }

        return null;
    }

    public Enum<Activity> getActivityLevel() {
        String selected = activityToggleGroup.getSelectedToggle().toString();

        if(selected== getButtonText(reallyLowActivityButton)) {
           return Activity.VERY_LOW;
        }
        else if(selected == getButtonText(lowActivityButton)) {
            return Activity.LOW;
        }
        else if(selected == getButtonText(mediumActivityButton)) {
            return Activity.MEDIUM;
        }
        else if(selected == getButtonText(highActivityButton)) {
            return Activity.HIGH;
        }

        return null;
    }



    private String getButtonText(RadioButton radioButton) {
        return radioButton.getText();
    }






}
