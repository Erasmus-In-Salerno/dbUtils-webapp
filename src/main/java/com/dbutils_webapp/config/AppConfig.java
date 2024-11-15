package com.dbutils_webapp.config;

import com.dbutils_webapp.repository.DatabaseUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DatabaseUtil databaseUtil() {
        return new DatabaseUtil(dataSource);
    }
}
