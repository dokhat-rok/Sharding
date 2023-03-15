package com.example.sharding.config;

import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.repository.OrderRepository;
import com.example.sharding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {

    @Value("${spring.datasource.url-rostov}")
    private String rostovUrl;

    @Value("${spring.datasource.url-moscow}")
    private String moscowUrl;

    @Value("${spring.datasource.url-biysk}")
    private String biyskUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @ConditionalOnProperty(value = "datasource.rostov-enabled", havingValue = "true")
    @Bean
    public DbConnectionManager rostovDbConnectionManager(){
        return new DbConnectionManager(rostovUrl, username, password);
    }

    @ConditionalOnProperty(value = "datasource.moscow-enabled", havingValue = "true")
    @Bean
    public DbConnectionManager moscowDbConnectionManager(){
        return new DbConnectionManager(moscowUrl, username, password);
    }

    @ConditionalOnProperty(value = "datasource.biysk-enabled", havingValue = "true")
    @Bean
    public DbConnectionManager biyskDbConnectionManager(){
        return new DbConnectionManager(biyskUrl, username, password);
    }

    @ConditionalOnProperty(value = "datasource.rostov-enabled", havingValue = "true")
    @Bean
    public UserRepository rostovUserRepository(DbConnectionManager rostovDbConnectionManager){
        return new UserRepository(rostovDbConnectionManager);
    }

    @ConditionalOnProperty(value = "datasource.moscow-enabled", havingValue = "true")
    @Bean
    public UserRepository moscowUserRepository(DbConnectionManager moscowDbConnectionManager){
        return new UserRepository(moscowDbConnectionManager);
    }

    @ConditionalOnProperty(value = "datasource.biysk-enabled", havingValue = "true")
    @Bean
    public UserRepository biyskUserRepository(DbConnectionManager biyskDbConnectionManager){
        return new UserRepository(biyskDbConnectionManager);
    }

    @ConditionalOnProperty(value = "datasource.rostov-enabled", havingValue = "true")
    @Bean
    public OrderRepository rostovOrderRepository(DbConnectionManager rostovDbConnectionManager){
        return new OrderRepository(rostovDbConnectionManager);
    }

    @ConditionalOnProperty(value = "datasource.moscow-enabled", havingValue = "true")
    @Bean
    public OrderRepository moscowOrderRepository(DbConnectionManager moscowDbConnectionManager){
        return new OrderRepository(moscowDbConnectionManager);
    }

    @ConditionalOnProperty(value = "datasource.biysk-enabled", havingValue = "true")
    @Bean
    public OrderRepository biyskOrderRepository(DbConnectionManager biyskDbConnectionManager){
        return new OrderRepository(biyskDbConnectionManager);
    }
}