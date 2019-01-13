package com.lubaszak.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProjectPathProvider {


    public String getProjectPath() {
        String cwd = System.getProperty("user.dir");

        return cwd;
    }
}
