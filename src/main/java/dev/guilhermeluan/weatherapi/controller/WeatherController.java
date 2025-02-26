package dev.guilhermeluan.weatherapi.controller;

import dev.guilhermeluan.weatherapi.infra.client.SendVisualCrossing;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Value("${api.key.visual_crossing}")
    private String apiKey;
    private SendVisualCrossing sendVisualCrossing;

    public WeatherController(SendVisualCrossing sendVisualCrossing) {
        this.sendVisualCrossing = sendVisualCrossing;
    }

    @GetMapping
    public String getWeather() {
        return sendVisualCrossing.getWeather("Brazil", apiKey, "json").toString();
    }
}
