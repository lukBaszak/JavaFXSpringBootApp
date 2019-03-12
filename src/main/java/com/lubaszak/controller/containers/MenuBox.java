package com.lubaszak.controller.containers;

import javafx.fxml.FXMLLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuBox {

    public MenuBox(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/MenuBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
