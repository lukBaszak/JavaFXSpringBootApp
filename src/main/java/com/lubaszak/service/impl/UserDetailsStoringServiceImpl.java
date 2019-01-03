package com.lubaszak.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lubaszak.bean.UserDetails;
import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utilities.ProjectPathProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class UserDetailsStoringServiceImpl implements UserDetailsStoringService {

    ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
            .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    UserDetails testObj;

    @Autowired
    ProjectPathProvider projectPathProvider;

    @Override
    public UserDetails getUserMeasurement() {



        try {
            testObj = mapper.readValue(new File(projectPathProvider.getProjectPath()+"\\src\\main\\resources\\UserInformation\\user.json"), UserDetails.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testObj;
    }

    @Override
    public void saveUserMeasurement(UserDetails userDetails) {


        try {
            mapper.writeValue(new File(projectPathProvider.getProjectPath()+"\\src\\main\\resources\\UserInformation\\user.json"), userDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
