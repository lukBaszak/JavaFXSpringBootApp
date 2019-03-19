package com.lubaszak.controller;

import com.lubaszak.config.SpringFXMLLoader;
import com.lubaszak.config.StageManager;
import com.lubaszak.controller.containers.MealDescriptionBox;
import com.lubaszak.controller.containers.MenuBox;
import com.lubaszak.model.MacroProperties;
import com.lubaszak.model.Product;
import com.lubaszak.model.Menu;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.MenuService;
import com.lubaszak.utils.FxmlView;
import com.lubaszak.utils.MealTime;

import com.lubaszak.utils.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.lubaszak.utils.MealTime.*;


@Controller
@Component
public class MainController implements Initializable {

    VBox breakfastBox;
    VBox brunchBox;
    VBox lunchBox;
    VBox dinnerBox;
    VBox mainBox;
    public static Date chosenDate;

    public static Menu product;

    @Autowired
    @Lazy
    StageManager stageManager;

    @Autowired
    SpringFXMLLoader springFXMLLoader;

    @FXML
    private DatePicker dataPicker;
    @FXML
    private ScrollPane scrollMenuPane;

    @FXML
    private Text testText;

    @FXML
    private ProgressBar proteinProgressBar;

    @FXML
    private ProgressBar fatProgressBar;

    @FXML
    private ProgressBar carbProgressBar;

    @Autowired
    MenuService menuService;

    @Autowired
    FoodProviderService foodProviderService;

    @FXML
    private ProgressBar caloriesProgressBar;

    public static MealTime mealTimeChosen;
    private VBox secondRateBreakfastBox;
    private VBox secondRateBrunchBox;
    private VBox secondRateLunchBox;
    private VBox secondRateDinnerBox;


    private List<Menu> breakfastList;
    private List<Menu> brunchList;
    private List<Menu> lunchList;
    private List<Menu> dinnerList;

    public static double calories =0;

    MealDescriptionBox breakfastDescription;
    MealDescriptionBox brunchDescription;
    MealDescriptionBox lunchDescription;
    MealDescriptionBox dinnerDescription;

    private Menu[] menus;
    final MacroProperties macroProperties = new MacroProperties();
    LocalDate localDate;

    public void initialize(URL location, ResourceBundle resources) {

        macroProperties.setCalorie(calories);
        macroProperties.calorieProperty().addListener((observable, oldValue, newValue) -> caloriesProgressBar.setProgress(newValue.doubleValue()/1000));

        breakfastBox = new VBox();
        brunchBox = new VBox();
        lunchBox = new VBox();
        dinnerBox = new VBox();
        mainBox = new VBox();

        breakfastList = new ArrayList<>();



        localDate = LocalDate.now();
        dataPicker.setValue(localDate);
        chosenDate = getDate(localDate);
        Menu[] menu = menuService.findByDateAndUserID(chosenDate, UserSession.getSession().getId());
        setLists(menu);
    }

       private void setLists(Menu[] list) {
            for(Menu menu:list) {

                switch(menu.getMealTime()) {
                    case breakfast:

                        breakfastList.add(menu);
                        break;
                    case brunch:
                        breakfastList.add(menu);
                        break;
                    case lunch:
                        breakfastList.add(menu);
                        break;
                    case dinner:
                        breakfastList.add(menu);
                        break;
                }
            }

               secondRateBreakfastBox = getBoxes(breakfastList);
               breakfastDescription = createDescriptionBox(breakfast, secondRateBreakfastBox);
               breakfastBox.getChildren().add(breakfastDescription);

               secondRateBrunchBox = getBoxes(brunchList);
               brunchDescription = createDescriptionBox(brunch, secondRateBrunchBox);
               brunchBox.getChildren().add(brunchDescription);

               secondRateLunchBox = getBoxes(lunchList);
               lunchDescription = createDescriptionBox(lunch, secondRateLunchBox);
               lunchBox.getChildren().add(lunchDescription);

               secondRateDinnerBox = getBoxes(dinnerList);
               dinnerDescription = createDescriptionBox(dinner, secondRateDinnerBox);
               dinnerBox.getChildren().add(dinnerDescription);


               mainBox.getChildren().addAll(breakfastBox, brunchBox, lunchBox, dinnerBox);
               scrollMenuPane.setContent(mainBox);
       }

    private MealDescriptionBox createDescriptionBox(MealTime mealTime, VBox productsBox) {
        MealDescriptionBox mealDescriptionBox = new MealDescriptionBox(mealTime, productsBox);
        mealDescriptionBox.setOnMouseClicked(mouseEvent ->{
            menageMealTimeBox(mealTime);
        });
        mealDescriptionBox.getAddToMealListButton().setOnAction(event -> {
            mealTimeChosen = mealTime;
            stageManager.switchScene(FxmlView.FOOD_SEARCH);
        });
        return mealDescriptionBox;
    }

    private void menageMealTimeBox(MealTime mealTime) {
        switch(mealTime) {
            case breakfast:
                if (breakfastBox.getChildren().contains(secondRateBreakfastBox)) breakfastBox.getChildren().remove(secondRateBreakfastBox);
                else breakfastBox.getChildren().add(secondRateBreakfastBox);
            case brunch:
                if (brunchBox.getChildren().contains(secondRateBrunchBox)) brunchBox.getChildren().remove(secondRateBrunchBox);
                else brunchBox.getChildren().add(secondRateBrunchBox);
            case lunch:
                if (lunchBox.getChildren().contains(secondRateLunchBox)) breakfastBox.getChildren().remove(secondRateLunchBox);
                else lunchBox.getChildren().add(secondRateLunchBox);
            case dinner:
                if (dinnerBox.getChildren().contains(secondRateDinnerBox)) dinnerBox.getChildren().remove(secondRateDinnerBox);
                else dinnerBox.getChildren().add(secondRateDinnerBox);
        }
    }

    private VBox getBoxes(List<Menu> productList) throws NullPointerException {
        VBox vBox = new VBox();

        try {
            for (Menu menu : productList) {

                Product product = foodProviderService.getProductByName(menu.getProductName());

                MenuBox mainBox = new MenuBox(product, menu.getWeight());
                mainBox.getDeleteButton().setOnAction(event -> {
                    vBox.getChildren().remove(mainBox);
                    menuService.delete(menu);

                });
                vBox.getChildren().add(mainBox);
            }
        }
        catch(NullPointerException e) {
        }
        return vBox;
    }

    private Date getDate(LocalDate localDate) { return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }
}
  /*
        dataPicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            chosenDate = getDate(newValue);
        });

        macroProperties.setCalorie(0);
        macroProperties.setFat(0);
        macroProperties.setProtein(0);
        macroProperties.setCarb(0);


        macroProperties.proteinProperty().addListener((observable, oldValue, newValue) -> proteinProgressBar.setProgress(newValue.doubleValue()/100));
        macroProperties.carbProperty().addListener((observable, oldValue, newValue) -> carbProgressBar.setProgress(newValue.doubleValue()/100));
        macroProperties.fatProperty().addListener((observable, oldValue, newValue) -> fatProgressBar.setProgress(newValue.doubleValue()/100));
        */






