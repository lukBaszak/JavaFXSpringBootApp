package com.lubaszak.controller;

import com.lubaszak.config.StageManager;
import com.lubaszak.model.Menu;
import com.lubaszak.model.ProductResponse;
import com.lubaszak.model.user.User;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.MenuService;
import com.lubaszak.utils.FxmlView;
import com.lubaszak.utils.MealTime;
import com.lubaszak.utils.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import com.lubaszak.service.UserService;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;


@Controller
public class LoginController {


	private static String email;
	private static String password;

	@Autowired
	@Lazy
	private StageManager stageManager;




	@Autowired
	private FoodProviderService foodService;

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;

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
/*
				if(userDetailsStoringService.getUserMeasurement()==null) {
					stageManager.switchScene(FxmlView.USER_DETAIL);
				}*/
				User user = userService.findByEmail(email);
				UserSession.setSession(user.getId());

				stageManager.switchScene(FxmlView.MAIN);
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
	void registerUser() {
		stageManager.switchScene(FxmlView.REGISTER);
	}

}
