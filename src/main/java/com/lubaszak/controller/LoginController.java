package com.lubaszak.controller;

import com.lubaszak.config.StageManager;
import com.lubaszak.service.FoodService;
import com.lubaszak.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import com.lubaszak.service.UserService;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.util.prefs.Preferences;


@Controller
public class LoginController {

	private String email;
	private String password;

	@Autowired
	@Lazy
	private StageManager stageManager;


	@Autowired
	private FoodService foodService;

	@Autowired
	private UserService userService;
	@FXML
	private TextField emailField;

	@FXML
	private Button registerButton;

	@FXML
	private TextField passwordField;

	@FXML
	void loginUser(ActionEvent event) {
		if (getPassword() != null && getUsername() != null) {

			email = emailField.getText();
			password = passwordField.getText();

			System.out.println(email + password);
			boolean ifValid = userService.authenticate(email, password);


			if(ifValid==true) {
				Preferences prefs = Preferences.systemNodeForPackage(com.lubaszak.controller.UserController.class);
				prefs.getBoolean("info", true);


				stageManager.switchScene(FxmlView.USER);
			}
		}
	}

	@FXML
	void registerUser(ActionEvent event) {
		stageManager.switchScene(FxmlView.REGISTER);

	}


	private String getPassword() {

		return passwordField.getText();
	}

	private String getUsername() {
		return emailField.getText();

	}
}
