package dev.guilhermeluan.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiApplication.class, args);
    }

}
