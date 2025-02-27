package dev.guilhermeluan.weatherapi.utils;

import dev.guilhermeluan.weatherapi.infra.client.DayDTO;
import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;

import java.util.List;

public class CreateWeather {
    public GetWeatherResponseDTO createTodayWeather() {
        DayDTO day = new DayDTO("2025-02-27", 24.3, 29.6, 20.0, 24.2);

        List<DayDTO> days = List.of(day);

        return new GetWeatherResponseDTO(
                "2025-02-27",
                "Brasil",
                "America/Sao_Paulo",
                "Similar temperatures continuing with no rain expected.",
                days
        );
    }
}
