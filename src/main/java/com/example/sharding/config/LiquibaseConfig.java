package com.example.sharding.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@ConditionalOnProperty(value = "spring.liquibase.enabled", havingValue = "true")
@Configuration
public class LiquibaseConfig {

    @Value("${liquibase.changelog-file}")
    private String changelogs;

    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(changelogs);
        return liquibase;
    }
}