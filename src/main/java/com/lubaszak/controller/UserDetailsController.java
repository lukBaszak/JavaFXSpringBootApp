package com.lubaszak.controller;

import com.lubaszak.model.UserDetail;
import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utils.Activity;
import com.lubaszak.utils.Sex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Controller
public class UserDetailsController implements Initializable {

    private Sex sex;
    private Activity activity;

    @Autowired
    @Qualifier("userDetailsStoringServiceImpl")
    UserDetailsStoringService userDetailsStoringService;

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



    private UserDetail user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    void saveUserSettings(ActionEvent event)
    {
        if(sexToggleGroup.selectedToggleProperty()==null) {
        }
        else {
            user = new UserDetail(getSex(), getBirthDate(), getHeight(),getWeight(), getActivityLevel());

            userDetailsStoringService.saveUserMeasurement(user);



        }
    }


    public double getHeight() {
        return Integer.parseInt(heightField.getText());
    }

    public double getWeight() {
        return Integer.parseInt(weightField.getText());
    }

    public LocalDate getBirthDate() {
        return dateOfBirth.getValue();
    }

    public Sex getSex() {
        RadioButton selected = (RadioButton) sexToggleGroup.getSelectedToggle();



        if(selected== maleButton) {
            sex = Sex.MAN;
        }

        else if(selected==femaleButton) {
            sex = Sex.WOMAN;

        }

        return sex;
    }

    public Activity getActivityLevel() {
        RadioButton selected = (RadioButton) activityToggleGroup.getSelectedToggle();


        if(selected== reallyLowActivityButton) {
          activity= Activity.VERY_LOW;
        }
        else if(selected == lowActivityButton) {
            activity= Activity.LOW;
        }
        else if(selected == mediumActivityButton) {
            activity= Activity.MEDIUM;
        }
        else if(selected == highActivityButton) {
            activity= Activity.HIGH;
        }


        return activity;
    }



    private String getButtonText(RadioButton radioButton) {
        return radioButton.getText();
    }






}
