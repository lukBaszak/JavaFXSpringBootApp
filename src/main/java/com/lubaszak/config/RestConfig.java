package com.lubaszak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestConfig {

    @Bean
    public RestOperations createRestTemplate() {

        return new RestTemplate();
    }




}
