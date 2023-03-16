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

@ConditionalOnProperty(value = "datasource.moscow-enabled", havingValue = "true")
@Configuration
@RequiredArgsConstructor
public class MoscowDataSourceConfig {

    @Value("${spring.datasource.url-moscow}")
    private String moscowUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private final LiquibaseConfig liquibaseConfig;

    @Bean
    public DbConnectionManager moscowDbConnectionManager(){
        return new DbConnectionManager(moscowUrl, username, password);
    }

    @Bean
    public UserRepository moscowUserRepository(DbConnectionManager moscowDbConnectionManager){
        return new UserRepository(moscowDbConnectionManager);
    }

    @Bean
    public OrderRepository moscowOrderRepository(DbConnectionManager moscowDbConnectionManager){
        return new OrderRepository(moscowDbConnectionManager);
    }

    @Bean
    public SpringLiquibase moscowLiquibase() {
        return liquibaseConfig.springLiquibase(DataSourceBuilder.create()
                .url(moscowUrl)
                .driverClassName(Driver.class.getName())
                .username(username)
                .password(password)
                .build());
    }
}
