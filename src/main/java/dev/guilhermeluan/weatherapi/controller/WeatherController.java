package dev.guilhermeluan.weatherapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @GetMapping
    public String getWeather() {
        return "It's sunny today!";
    }
}
