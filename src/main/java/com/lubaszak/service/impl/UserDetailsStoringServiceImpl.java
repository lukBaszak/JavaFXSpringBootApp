package com.lubaszak.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lubaszak.model.UserDetail;
import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utils.ProjectPathProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;


@Service
public class UserDetailsStoringServiceImpl implements UserDetailsStoringService {

    @Autowired
    ProjectPathProvider projectPathProvider;

    BufferedReader bufferedReader;

    @Override
    public UserDetail getUserMeasurement() {

        try {
            bufferedReader = new BufferedReader(new FileReader(projectPathProvider.getProjectPath() + "\\src\\main\\resources\\UserInformation\\user.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();


        UserDetail userDetail = gson.fromJson(bufferedReader, UserDetail.class);
        return userDetail;
    }

    @Override
    public void saveUserMeasurement(UserDetail userDetail) {

        Writer writer;
        try {

            writer = new FileWriter(projectPathProvider.getProjectPath() + "\\src\\main\\resources\\UserInformation\\user.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(userDetail, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
