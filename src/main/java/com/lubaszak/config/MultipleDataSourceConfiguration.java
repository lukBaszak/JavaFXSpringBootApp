package com.lubaszak.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

public class MultipleDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.Mysql")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.h2")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}