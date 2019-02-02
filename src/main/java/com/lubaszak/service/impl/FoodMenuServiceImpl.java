package com.lubaszak.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lubaszak.model.FoodDailyMenu;
import com.lubaszak.model.UserDetail;
import com.lubaszak.service.FoodMenuService;
import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utils.ProjectPathProvider;
import com.lubaszak.utils.TimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;


@Service
public class FoodMenuServiceImpl implements FoodMenuService {

    @Autowired
    ProjectPathProvider pathProvider;

    @Autowired
    TimeProvider timeProvider;

    @Override
    public FoodDailyMenu getMenuByDate(Date date) throws FileNotFoundException{
        BufferedReader bufferedReader=null;
        {
            try {
               bufferedReader = new BufferedReader(new FileReader(pathProvider.getProjectPath() + "\\src\\main\\resources\\UserData\\user"+ timeProvider.getParticularStringDate(date) +".json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            finally {

                if(bufferedReader!=null) {
                    Gson gson = new Gson();
                    FoodDailyMenu dailyMenu = gson.fromJson(bufferedReader, FoodDailyMenu.class);


                    return dailyMenu;
                }

                return null;
            }

        }
    }

    @Override
    public void saveMenu(FoodDailyMenu foodDailyMenu, Date date) {

        Writer writer;
        try {

            writer = new FileWriter(pathProvider.getProjectPath() + "\\src\\main\\resources\\UserData\\user"+timeProvider.getParticularStringDate(date)+".json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(foodDailyMenu, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
