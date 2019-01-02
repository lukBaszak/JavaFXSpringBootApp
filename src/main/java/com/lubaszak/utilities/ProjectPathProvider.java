package com.lubaszak.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProjectPathProvider {

    @Bean
    public String getProjectPath() {
        String cwd = System.getProperty("user.dir");

        return cwd;
    }
}
