package com.lubaszak.config;


import com.lubaszak.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.lubaszak.model.menu")
@PropertySource({ "classpath:application.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = MenuRepository.class,
        entityManagerFactoryRef = "menuEntityManagerFactory",
        transactionManagerRef = "menuTransactionManager"
)
public class H2DbConfig {


    @Bean(name = "menuTransactionManager")
    public PlatformTransactionManager menuTransactionManager(
            @Qualifier("menuEntityManagerFactory") EntityManagerFactory
                    menuEntityManagerFactory
    ) {
        return new JpaTransactionManager(menuEntityManagerFactory);
    }


    @Bean(name = "menuEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    menuEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("menuDataSource") DataSource dataSource
    ) {
        return builder
                        .dataSource(dataSource)
                        .packages("com.lubaszak.model.menu")
                        .persistenceUnit("menu")
                        .build();
    }

    @Bean("menuDataSource")
    @ConfigurationProperties(prefix="spring.h2")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }


}