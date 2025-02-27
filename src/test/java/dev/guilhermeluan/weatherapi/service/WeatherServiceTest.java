package dev.guilhermeluan.weatherapi.service;

import dev.guilhermeluan.weatherapi.infra.client.DayDTO;
import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;
import dev.guilhermeluan.weatherapi.infra.client.SendVisualCrossing;
import dev.guilhermeluan.weatherapi.utils.CreateWeather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private SendVisualCrossing sendVisualCrossing;

    private GetWeatherResponseDTO expectedWeather;

    @InjectMocks
    private CreateWeather createWeather;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(weatherService, "apiKey", "Apikey");

        expectedWeather = createWeather.createTodayWeather();
    }

    @Test
    void getTodayWeather_ShouldReturn_TodaysWeather() {
        BDDMockito.given(sendVisualCrossing.getTodayWeather(anyString(), anyString(), anyString(), anyString()))
                .willReturn(expectedWeather);

        GetWeatherResponseDTO todayWeather = weatherService.getTodayWeather("Brasil", "Apikey","json");

        Assertions.assertThat(todayWeather).isNotNull().isEqualTo(expectedWeather);
    }
}