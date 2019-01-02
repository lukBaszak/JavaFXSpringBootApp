package com.lubaszak.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lubaszak.bean.UserDetails;
import com.lubaszak.service.UserDetailsStoringService;
import com.lubaszak.utilities.ProjectPathProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class UserDetailsStoringServiceImpl implements UserDetailsStoringService {

    @Autowired
    ProjectPathProvider projectPathProvider;

    @Override
    @Bean
    public UserDetails getUserMeasurement() {
        return null;
    }

    @Override

    public void saveUserMeasurement(UserDetails userDetails) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(projectPathProvider.getProjectPath()+"\\src\\main\\resources\\UserInformation\\user"), userDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
