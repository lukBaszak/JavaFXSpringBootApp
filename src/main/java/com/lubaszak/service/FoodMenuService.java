package com.lubaszak.service;

import com.lubaszak.model.FoodDailyMenu;

import java.io.FileNotFoundException;
import java.util.Date;

public interface FoodMenuService {

    FoodDailyMenu getMenuByDate(Date date) throws FileNotFoundException;
    void saveMenu(FoodDailyMenu foodDailyMenu, Date date);

}
