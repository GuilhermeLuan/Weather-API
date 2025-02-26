package dev.guilhermeluan.weatherapi.service;

import dev.guilhermeluan.weatherapi.infra.client.SendVisualCrossing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Value("${api.key.visual_crossing}")
    private String apiKey;
    private final SendVisualCrossing sendVisualCrossing;

    public WeatherService(SendVisualCrossing sendVisualCrossing) {
        this.sendVisualCrossing = sendVisualCrossing;
    }

    public Object getTodayWeather() {
        return sendVisualCrossing.getTodayWeather("Brazil", apiKey, "json");
    }
}
