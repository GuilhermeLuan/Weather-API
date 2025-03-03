package dev.guilhermeluan.weatherapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Weather API",
                version = "1.0",
                description = "A lightweight RESTful API built with Spring Boot to fetch current weather data for any location.",
                contact = @Contact(
                        name = "Guilherme Luan",
                        email = "guilhermeluan@pm.me")
        )
)
public class OpenApiConfig {
}
