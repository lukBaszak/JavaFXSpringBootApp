package com.lubaszak.controller;

import com.lubaszak.config.SpringFXMLLoader;
import com.lubaszak.config.StageManager;
import com.lubaszak.model.MacroProperties;
import com.lubaszak.model.Product;
import com.lubaszak.model.Menu;
import com.lubaszak.service.FoodProviderService;
import com.lubaszak.service.MenuService;
import com.lubaszak.utils.FxmlView;
import com.lubaszak.utils.MealTime;

import com.lubaszak.utils.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.lubaszak.utils.MealTime.BREAKFAST;


@Controller
public class MainController implements Initializable {

    VBox breakfastBox;
    VBox brunchBox;
    VBox lunchBox;
    VBox dinnerBox;
    VBox mainBox;
    public static Date chosenDate;


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
    private AnchorPane lunchPane;
    @FXML
    private Text lunchProtText;
    @FXML
    private Text lunchCarbText;
    @FXML
    private Text lunchFatText;
    @FXML
    private AnchorPane breakfastPane;
    @FXML
    private Text breakfastProtText;
    @FXML
    private Text breakfastFatText;
    @FXML
    private Text breakfastCarbText;
    @FXML
    private AnchorPane brunchPane;
    @FXML
    private Text brunchProtText;
    @FXML
    private Text brunchFatText;
    @FXML
    private Text brunchCarbText;
    @FXML
    private AnchorPane dinnerPane;
    @FXML
    private Text dinnerProtText;
    @FXML
    private Text dinnerFatText;
    @FXML
    private Text dinnerCarbText;
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

    public static MealTime mealTime;

    @FXML
    void addToBreakfast(ActionEvent event) {
        mealTime = BREAKFAST;
        stageManager.openNewStage(FxmlView.FOOD_SEARCH);
    }

    @FXML
    void addToBrunch(ActionEvent event) {
        mealTime = MealTime.BRUNCH;
        stageManager.openNewStage(FxmlView.FOOD_SEARCH);
    }

    @FXML
    void addToDinner(ActionEvent event) {
        mealTime = MealTime.DINNER;
        stageManager.openNewStage(FxmlView.FOOD_SEARCH);
    }

    @FXML
    void addToLunch(ActionEvent event) {
        mealTime = MealTime.LUNCH;
        stageManager.openNewStage(FxmlView.FOOD_SEARCH);
    }

    @FXML
    void loadMenuData(ActionEvent event) {

    }

    private List<Menu> breakfastList;
    private List<Menu> brunchList;
    private List<Menu> lunchList;
    private List<Menu> dinnerList;

    private double breakfastCalorie = 0;
    private double breakfastProt = 0;
    private double breakfastFat = 0;
    private double breakfastCarb = 0;
    private double brunchProt = 0;
    private double brunchFat = 0;
    private double brunchCarb = 0;
    private double brunchCalorie = 0;
    private double lunchProt = 0;
    private double lunchCarb = 0;
    private double lunchFat = 0;
    private double lunchCalorie = 0;
    private double dinnerProt = 0;
    private double dinnerFat = 0;
    private double dinnerCarb = 0;
    private double dinnerCalorie = 0;
    VBox[] vBoxes;

    private Menu[] menus;
    final MacroProperties macroProperties = new MacroProperties();
    LocalDate localDate;

    public void initialize(URL location, ResourceBundle resources) {


        localDate = LocalDate.now();
        dataPicker.setValue(localDate);
        chosenDate = getDate(localDate);
        menus = menuService.findByDateAndUserID(chosenDate, UserSession.getSession().getId());
        setLists(menus);
    }


       private void setLists(Menu[] list) {
            for(Menu menu:list) {
                switch(menu.getMealTime()) {
                    case BREAKFAST:
                        breakfastList.add(menu);

                        break;
                    case BRUNCH:
                        brunchList.add(menu);
                        break;
                    case LUNCH:
                        lunchList.add(menu);
                        break;
                    case DINNER:
                        dinnerList.add(menu);
                        break;
                }

            }

           try {
               breakfastBox = getBoxes(breakfastList);
               brunchBox = getBoxes(brunchList);
               lunchBox = getBoxes(lunchList);
               dinnerBox = getBoxes(dinnerList);
           } catch (NullPointerException e) {
               e.printStackTrace();
           }
       }

    private VBox getBoxes(List<Menu> productList) throws NullPointerException {
        for(Menu menu: productList) {

        }

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
        macroProperties.calorieProperty().addListener((observable, oldValue, newValue) -> caloriesProgressBar.setProgress(newValue.doubleValue()/1000));

        addMenusToMenu();
        vBoxes = new VBox[] {
            breakfastBox,
            brunchBox,
            lunchBox,
            dinnerBox
        };

        loadMenu();

        mainBox.setOnMouseClicked(event -> {
           String panel = event.getPickResult().getIntersectedNode().getId();


           switch(panel) {
               case "breakfastPane":
                   if(breakfastBox.getChildren().size() < 2) {
                       for (Product product : breakfast) {
                           GridPane gridPane = createProductBox(product);
                           breakfastBox.getChildren().add(gridPane);
                           brunchBox.getChildren().remove(1, brunchBox.getChildren().size());
                           removeOtherMenus(breakfastBox);
                       }
                   }
                   else {
                       breakfastBox.getChildren().remove(1, breakfastBox.getChildren().size());
                       }
                   break;
               case "brunchPane":
                   if(brunchBox.getChildren().size() < 2) {
                       for (Product product :brunch) {
                           GridPane gridPane = createProductBox(product);
                           brunchBox.getChildren().add(gridPane);
                           removeOtherMenus(brunchBox);
                       }
                   }
                   else {
                      brunchBox.getChildren().remove(1, brunchBox.getChildren().size());
                   }
                  break;
               case "lunchPane":
                   if(lunchBox.getChildren().size() < 2) {
                       for (Product product :lunch) {
                           GridPane gridPane = createProductBox(product);
                           lunchBox.getChildren().add(gridPane);
                           removeOtherMenus(lunchBox);
                       }
                   }
                   else {
                       lunchBox.getChildren().remove(1, lunchBox.getChildren().size());
                   }
                  break;
               case "dinnerPane":
                   if(dinnerBox.getChildren().size() < 2) {
                       for (Product product :dinner) {
                           GridPane gridPane = createProductBox(product);
                           dinnerBox.getChildren().add(gridPane);
                           removeOtherMenus(dinnerBox);
                       }
                   }
                   else {
                       dinnerBox.getChildren().remove(1, dinnerBox.getChildren().size());
                   }
                   break;
           }

        });

    }

    private void removeOtherMenus(VBox vBox) {

        for(int i =0; i<vBoxes.length;i++) {
            if(vBoxes[i] != vBox) {

            vBoxes[i].getChildren().remove(1, vBoxes[i].getChildren().size());
             }
        }
    }

    private void addMenusToMenu() {
        breakfastBox = new VBox();
        brunchBox = new VBox();
        lunchBox = new VBox();
        dinnerBox = new VBox();

        breakfastBox.getChildren().add(breakfastPane);
        brunchBox.getChildren().add(brunchPane);
        lunchBox.getChildren().add(lunchPane);
        dinnerBox.getChildren().add(dinnerPane);
        mainBox = new VBox();

        mainBox.getChildren().addAll(breakfastBox, brunchBox, lunchBox, dinnerBox);
        scrollMenuPane.setContent(mainBox);
    }


    private void loadMenu() throws NullPointerException  {
        Menu[] menu;
        breakfastCalorie=breakfastProt=breakfastFat=breakfastCarb=brunchProt=brunchFat=brunchCarb=brunchCalorie=lunchProt=lunchCarb=lunchFat=lunchCalorie=dinnerProt=dinnerFat=dinnerCarb=dinnerCalorie=0;

        dinnerProtText.setText("0");
        dinnerFatText.setText(String.valueOf(dinnerFat));
        //dinnerCalorieText.setText(String.valueOf(dinnerProt));
        dinnerCarbText.setText(String.valueOf(dinnerCarb));
        lunchProtText.setText(String.valueOf(lunchProt));
        lunchFatText.setText(String.valueOf(lunchFat));
        //luchCalorieText.setText(String.valueOf(lunchProt));
        lunchCarbText.setText(String.valueOf(lunchCarb));
        brunchProtText.setText(String.valueOf(brunchProt));
        brunchFatText.setText(String.valueOf(brunchFat));
        //brunchCalorieText.setText(String.valueOf(brunchProt));
        brunchCarbText.setText("0");
        breakfastProtText.setText(String.valueOf(breakfastProt));
        breakfastFatText.setText(String.valueOf(breakfastFat));
        //breakfastCalorieText.setText(String.valueOf(breakfastProt));
        breakfastCarbText.setText(String.valueOf(breakfastCarb));



      *//*  menu = menuService.findByDateAndUserID(getDate(dataPicker.getValue()), LoginController.userId);
            if(menu!=null) {
                for(int i=0;i<menu.length;i++) {
                    MealTime mealTime = (MealTime) menu[i].getMealTime();
                    Product product = foodProviderService.getProductByName(menu[i].getProductName());
                    switch (mealTime) {
                        case BREAKFAST:
                            breakfastFat += product.getTotalFat() ;
                            breakfastCalorie += product.getCalories();
                            breakfastCarb += product.getTotalCarbohydrate();
                            breakfastProt += product.getProtein();
                        case LUNCH:
                            lunchFat += product.getTotalFat();
                            lunchCalorie += product.getCalories();
                            lunchCarb += product.getTotalCarbohydrate();
                            lunchProt += product.getProtein();

                        case BRUNCH:
                            brunchFat += product.getTotalFat();
                            brunchCalorie += product.getCalories();
                            brunchCarb += product.getTotalCarbohydrate();
                            brunchProt += product.getProtein();
                        case DINNER:
                            brunchFat += product.getTotalFat();
                            brunchCalorie += product.getCalories();
                            brunchCarb += product.getTotalCarbohydrate();
                            brunchProt += product.getProtein();
                    }

                }

                }*//*
        macroProperties.setCarb(breakfastCarb+lunchCarb+brunchCarb+dinnerCarb);
        macroProperties.setProtein(breakfastProt+brunchProt+lunchProt+dinnerCarb);
        macroProperties.setFat(breakfastFat+brunchFat+lunchFat+dinnerFat);
        macroProperties.setCalorie(breakfastCalorie+brunchCalorie+lunchCalorie+dinnerCalorie);

        dinnerProtText.setText(String.valueOf(dinnerProt));
        dinnerFatText.setText(String.valueOf(dinnerFat));
        //dinnerCalorieText.setText(String.valueOf(dinnerProt));
        dinnerCarbText.setText(String.valueOf(dinnerCarb));
        lunchProtText.setText(String.valueOf(lunchProt));
        lunchFatText.setText(String.valueOf(lunchFat));
        //luchCalorieText.setText(String.valueOf(lunchProt));
        lunchCarbText.setText(String.valueOf(lunchCarb));
        brunchProtText.setText(String.valueOf(brunchProt));
        brunchFatText.setText(String.valueOf(brunchFat));
        //brunchCalorieText.setText(String.valueOf(brunchProt));
        brunchCarbText.setText(String.valueOf(brunchCarb));
        breakfastProtText.setText(String.valueOf(breakfastProt));
        breakfastFatText.setText(String.valueOf(breakfastFat));
        //breakfastCalorieText.setText(String.valueOf(breakfastProt));
        breakfastCarbText.setText(String.valueOf(breakfastCarb));

    }

        public GridPane createProductBox(Product product) {
            GridPane gridPane = new GridPane();
            gridPane.setPrefSize(100,50);
            gridPane.add(new Text(product.getFoodName()),0,0);
            gridPane.add(new Text("Calories:" + product.getCalories()), 0,1);
            gridPane.setOnMouseClicked(event -> {


            });
            gridPane.setId("product-pane");
            return gridPane;
        }

    public void resetMenu() {

            macroProperties.setCalorie(0);
            macroProperties.setFat(0);
            macroProperties.setProtein(0);
            macroProperties.setCarb(0);

        }
*/



