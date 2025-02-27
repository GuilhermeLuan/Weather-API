package dev.guilhermeluan.weatherapi.controller;

import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;
import dev.guilhermeluan.weatherapi.service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetWeatherResponseDTO> getTodayWeather(
            @PathVariable("location") String location,
            @RequestParam(value = "unitGroup", defaultValue = "metric", required = false) String unitGroup,
            @RequestParam(value = "contentType", defaultValue = "json", required = false) String contentType
    ) {
        GetWeatherResponseDTO response = weatherService.getTodayWeather(location, contentType, unitGroup);
        return ResponseEntity.ok(response);
    }
}
