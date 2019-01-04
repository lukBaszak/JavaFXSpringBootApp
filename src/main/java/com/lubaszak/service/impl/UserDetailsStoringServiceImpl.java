package com.lubaszak.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.lubaszak.bean.UserDetails;
import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utilities.ProjectPathProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class UserDetailsStoringServiceImpl implements UserDetailsStoringService {

    ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
            .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    UserDetails testObj;

    @Autowired
    ProjectPathProvider projectPathProvider;

    BufferedReader bufferedReader;

    @Override
    public UserDetails getUserMeasurement() {

        try {
            bufferedReader = new BufferedReader(new FileReader(projectPathProvider.getProjectPath()+"\\src\\main\\resources\\UserInformation\\user.json"));

        } catch (FileNotFoundException e) { }

        Gson gson = new Gson();

        UserDetails userDetails = gson.fromJson(bufferedReader, UserDetails.class);


        return userDetails;
    }

    @Override
    public void saveUserMeasurement(UserDetails userDetails) {

Gson gson = new Gson();

        try {
            gson.toJson(userDetails, new FileWriter(projectPathProvider.getProjectPath()+"\\src\\main\\resources\\UserInformation\\user.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
