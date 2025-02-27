package dev.guilhermeluan.weatherapi.service;

import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;
import dev.guilhermeluan.weatherapi.infra.client.SendVisualCrossing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Value("${api.key.visual_crossing}")
    private String apiKey;
    private final SendVisualCrossing sendVisualCrossing;

    public WeatherService(SendVisualCrossing sendVisualCrossing) {
        this.sendVisualCrossing = sendVisualCrossing;
    }

    @Cacheable(value = "today_weather", key = "#location + #unitGroup + #contentType + T(java.time.LocalDate).now()")
    public GetWeatherResponseDTO getTodayWeather(String location, String contentType, String unitGroup) {
        return sendVisualCrossing.getTodayWeather(location, apiKey, contentType, unitGroup);
    }
}
