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

@ConditionalOnProperty(value = "datasource.rostov-enabled", havingValue = "true")
@Configuration
@RequiredArgsConstructor
public class RostovDataSourceConfig {

    @Value("${spring.datasource.url-rostov}")
    private String rostovUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private final LiquibaseConfig liquibaseConfig;

    @Bean
    public DbConnectionManager rostovDbConnectionManager(){
        return new DbConnectionManager(rostovUrl, username, password);
    }

    @Bean
    public UserRepository rostovUserRepository(DbConnectionManager rostovDbConnectionManager){
        return new UserRepository(rostovDbConnectionManager);
    }

    @Bean
    public OrderRepository rostovOrderRepository(DbConnectionManager rostovDbConnectionManager,
                                                 UserRepository rostovUserRepository){
        return new OrderRepository(rostovDbConnectionManager, rostovUserRepository);
    }

    @Bean
    public SpringLiquibase rostovLiquibase() {
        return liquibaseConfig.springLiquibase(DataSourceBuilder.create()
                .url(rostovUrl)
                .driverClassName(Driver.class.getName())
                .username(username)
                .password(password)
                .build());
    }
}
