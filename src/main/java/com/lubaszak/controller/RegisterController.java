package com.lubaszak.controller;

import com.lubaszak.model.User;
import com.lubaszak.config.StageManager;
import com.lubaszak.service.UserService;
import com.lubaszak.utils.FxmlView;
import com.lubaszak.utils.RegexPattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    @Lazy
    private StageManager stageManager;

    @FXML
    private Text passwordMessage;

    @FXML
    private Text emailMessage;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField repeatedPasswordField;

    @FXML
    void registerUser(ActionEvent event) {
        boolean isEmailValid = false;
        boolean isPasswordValid = false;

        if(getEmail().matches(RegexPattern.EMAIL_PATTERN)) {
            if (userService.findByEmail(getEmail()) == null) {
                isEmailValid = true;
                emailMessage.setVisible(false);
            }
            else {
                emailMessage.setText("email already in use, choose another one");
                emailMessage.setVisible(true);
                isEmailValid = false;
            }
        }
        else {
            emailMessage.setText("Wrong email format");
            emailMessage.setVisible(true);
            isEmailValid = false;
           }



        if( getPassword().matches(RegexPattern.PASSWORD_PATTERN)) {
            if(getPassword().equals(getRepeatedPassword())) {
                isPasswordValid = true;
                passwordMessage.setVisible(false);
            }
            else {
                passwordMessage.setText("Passwords are not equal");
                passwordMessage.setVisible(true);
                isPasswordValid = false;
            }
        }
        else {
            passwordMessage.setText("Password has to contain at least 6 characters including one letter and one number");
            passwordMessage.setVisible(true);
            isPasswordValid = false;
        }

        if(isPasswordValid&&isEmailValid) {

            userService.save(new User(getEmail(), getPassword()));

            stageManager.switchScene(FxmlView.LOGIN);

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

    private boolean arePasswordTheSame(String first, String second) {
        return first.equals(second);
    }

}
