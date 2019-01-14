package com.lubaszak.service;

import com.lubaszak.model.FoodDailyMenu;

import java.util.Date;

public interface FoodMenuService {

    FoodDailyMenu getMenuByDate(Date date);
    void saveMenu(FoodDailyMenu foodDailyMenu, Date date);

}
