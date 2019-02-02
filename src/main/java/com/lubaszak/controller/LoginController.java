package com.lubaszak.controller;

import com.lubaszak.config.StageManager;
import com.lubaszak.service.FoodMenuService;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.impl.UserDetailsStoringServiceImpl;
import com.lubaszak.utils.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import com.lubaszak.service.UserService;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {

	private String email;
	private String password;

	@Autowired
	@Lazy
	private StageManager stageManager;

	@Autowired
	UserDetailsStoringServiceImpl userDetailsStoringService;

	@Autowired
	private FoodProviderService foodService;

	@Autowired
	private UserService userService;

	@Autowired
	private FoodMenuService foodMenuService;

	@FXML
	private Text errorMessage;

	@FXML
	private TextField emailField;

	@FXML
	private Button registerButton;

	@FXML
	private TextField passwordField;

	@FXML
	void loginUser(ActionEvent event) {


		if (!emailField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty() ) {


			email = emailField.getText();
			password = passwordField.getText();


			boolean ifValid = userService.authenticate(email, password);

			if(ifValid) {

				if(userDetailsStoringService.getUserMeasurement()==null) {
					stageManager.switchScene(FxmlView.USER_DETAIL);
				}
				else stageManager.switchScene(FxmlView.MAIN);
			}
			else {
				errorMessage.setText("Wrong login"); //add reference to external file with error messages
				errorMessage.setVisible(true);
			}
		}

		else {

			errorMessage.setText("please input correct email and password");
			errorMessage.setVisible(true);
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
