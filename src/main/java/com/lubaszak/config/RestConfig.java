package com.lubaszak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class RestConfig {


    public RestOperations createRestTemplate() {

        return new RestTemplate();
    }




}
