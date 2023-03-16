package com.example.sharding.config;

import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.repository.OrderRepository;
import com.example.sharding.repository.UserRepository;
import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(value = "datasource.biysk-enabled", havingValue = "true")
@Configuration
@RequiredArgsConstructor
public class BiyskDataSourceConfig {

    @Value("${spring.datasource.url-biysk}")
    private String biyskUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private final LiquibaseConfig liquibaseConfig;

    @Bean
    public DbConnectionManager biyskDbConnectionManager() {
        return new DbConnectionManager(biyskUrl, username, password);
    }

    @Bean
    public UserRepository biyskUserRepository(DbConnectionManager biyskDbConnectionManager) {
        return new UserRepository(biyskDbConnectionManager);
    }

    @Bean
    public OrderRepository biyskOrderRepository(DbConnectionManager biyskDbConnectionManager) {
        return new OrderRepository(biyskDbConnectionManager);
    }

    @Bean
    public SpringLiquibase biyskLiquibase() {
        return liquibaseConfig.springLiquibase(DataSourceBuilder.create()
                .url(biyskUrl)
                .driverClassName(Driver.class.getName())
                .username(username)
                .password(password)
                .build());
    }
}
