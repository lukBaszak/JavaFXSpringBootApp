package com.lubaszak.controller;

import com.lubaszak.bean.User;
import com.lubaszak.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField repeatedPasswordField;

    @FXML
    void registerUser(ActionEvent event) {
        if(getEmail() != null && getPassword().equals(getRepeatedPassword()) && getPassword() != null && getRepeatedPassword()!=null ) {
           if (userService.findByEmail(getEmail())==null) {
               userService.save(new User(getEmail(), getPassword()));

           }
           else {
               System.out.println("Błąd");
           }
        }
        else {
            System.out.println("Błednie wprowadzone dane");
        }
    }


    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getRepeatedPassword() {
        return repeatedPasswordField.getText();
    }
}
