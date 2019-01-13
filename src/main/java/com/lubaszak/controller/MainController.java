package com.lubaszak.controller;

import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utils.TimeProvider;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


@Controller
public class MainController implements Initializable {


    @FXML VBox vBox;

    @FXML VBox firstSubVBox;
    @FXML VBox firstSubMenuList;
    @FXML Button firstMenu;
    Map<VBox,VBox> map = new HashMap<VBox,VBox>();

    @Autowired
    TimeProvider timeProvider;

    public void initialize(URL location, ResourceBundle resources) {


        addMenusToMapImpl();
        firstMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                toolsSlider(firstSubVBox, firstSubMenuList);
                removeOtherMenus(firstSubVBox);

            }
        });
    }

    private void addMenusToMapImpl() {

        map.put(firstSubVBox,firstSubMenuList);
        for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
            entry.getKey().getChildren().remove(entry.getValue());
        }
    }

    private void toolsSlider(VBox menu,VBox subMenu) {

        if(menu.getChildren().contains(subMenu)){
            menu.getChildren().remove(subMenu);

        }else{
            menu.getChildren().add(subMenu);
        }
    }

    public void removeOtherMenus(VBox menu){
        removeOtherMenusImpl(menu);
    }
    private void removeOtherMenusImpl(VBox menu) {
        for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
            if(!entry.getKey().equals(menu))
                entry.getKey().getChildren().remove(entry.getValue());
        }
    }

}
