package dev.guilhermeluan.weatherapi.controller;

import dev.guilhermeluan.weatherapi.config.RestAssuredConfig;
import dev.guilhermeluan.weatherapi.infra.client.SendVisualCrossing;
import dev.guilhermeluan.weatherapi.utils.FileUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RestAssuredConfig.class)
@EnableCaching
@AutoConfigureWireMock(port = 0, files = "classpath:/wiremock/visual-crossing", stubs = "classpath:/wiremock/visual-crossing/mappings")
@EnableFeignClients(basePackageClasses = SendVisualCrossing.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class WeatherControllerTestIT {
    private static final String URL = "/v1/weather";
    @Autowired
    private FileUtil fileUtil;

    @Autowired
    @Qualifier(value = "requestSpecificationRestAssured")
    private RequestSpecification requestSpecification;


    @BeforeEach
    void setUp() {
        RestAssured.requestSpecification = requestSpecification;
    }

    @Test
    @DisplayName("GET /v1/weather/Brasil returns Brasil's weather when successful")
    void getTodayWeather_ReturnsGetWeatherResponseDTO_WhenSuccessful() throws IOException {
        var location = "Brasil";
        var expectedResponse = fileUtil.readResourceFile("weather/expected-get-weather-response-200.json");

        RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get(URL + "/{location}", location)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(Matchers.equalTo(expectedResponse))
                .log().all();
    }
}