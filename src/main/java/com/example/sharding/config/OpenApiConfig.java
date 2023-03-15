package com.example.sharding.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурирование объектов для декларирования API с помощью OAS3
 */
@Configuration
public class OpenApiConfig {

    public static final String SHARDING = "Sharding";

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Sharding service").version("1.0.0"));
    }
}
