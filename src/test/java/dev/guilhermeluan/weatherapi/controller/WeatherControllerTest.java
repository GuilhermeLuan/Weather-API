package dev.guilhermeluan.weatherapi.controller;

import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;
import dev.guilhermeluan.weatherapi.infra.client.SendVisualCrossing;
import dev.guilhermeluan.weatherapi.service.WeatherService;
import dev.guilhermeluan.weatherapi.utils.CreateWeather;
import dev.guilhermeluan.weatherapi.utils.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackages = {"dev.guilhermeluan.weatherapi"})
@WebMvcTest(controllers = WeatherController.class)
class WeatherControllerTest {
    public static final String URL = "/v1/weather";
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private WeatherService weatherService;
    @MockitoBean
    private SendVisualCrossing sendVisualCrossing;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private CreateWeather createWeather;
    private GetWeatherResponseDTO expectedWeather;

    @BeforeEach
    void setUp() {
        expectedWeather = createWeather.createTodayWeather();
    }

    @Test
    @DisplayName("GET /v1/weather/{location} returns today weather")
    void getTodayWeather_Returns_TodayWeather() throws Exception {
        String location = "Brazil";
        String unitGroup = "metric";
        String contentType = "json";

        BDDMockito.given(weatherService.getTodayWeather(location, contentType, unitGroup)).willReturn(expectedWeather);

        GetWeatherResponseDTO todayWeather = weatherService.getTodayWeather(location, unitGroup, contentType);

        var response = fileUtil.readResourceFile("weather/get-today-weather-metric-200.json");

        mockMvc.perform(get(URL + "/{location}", location)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response));
    }
}