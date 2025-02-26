package dev.guilhermeluan.weatherapi.controller;

import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;
import dev.guilhermeluan.weatherapi.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{location}")
    public GetWeatherResponseDTO getTodayWeather(
            @PathVariable("location") String location,
            @RequestParam(value = "unitGroup", defaultValue = "metric", required = false) String unitGroup,
            @RequestParam(value = "contentType", defaultValue = "json", required = false) String contentType
    ) {
        return weatherService.getTodayWeather(location, contentType, unitGroup);
    }
}
