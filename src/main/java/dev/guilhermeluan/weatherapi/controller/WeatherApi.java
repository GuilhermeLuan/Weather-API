package dev.guilhermeluan.weatherapi.controller;

import dev.guilhermeluan.weatherapi.infra.client.GetWeatherResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Tag(name = "Weather API", description = "The Weather API")
public interface WeatherApi {

    @Operation(summary = "Get today's weather",
            description = "Get today's weather for a specific location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A successfully processed request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetWeatherResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "The format of the API is incorrect or an invalid parameter or combination of parameters was supplied",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                                            {
                                                "timestamp": "2025-03-03T21:57:36.553+00:00",
                                                "status": 400,
                                                "error": "Bad Request",
                                                "message": "Bad API Request:Invalid location parameter value.",
                                                "path": "/v1/weather/a"
                                            }
                                            """))),
            @ApiResponse(responseCode = "404", description = "The request cannot be matched to any valid API request endpoint structure.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                                            {
                                                "timestamp": "2025-03-03T21:56:32.174+00:00",
                                                "status": 404,
                                                "error": "Not Found",
                                                "message": "No static resource v1/weather/.",
                                                "path": "/v1/weather/a"
                                            }
                                            """)))})
    @GetMapping(value = "/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetWeatherResponseDTO> getTodayWeather(
            @Parameter(description = "Is the address, partial address or latitude," +
                                     " longitude location for which to retrieve weather data. " +
                                     "You can also use US ZIP Codes. ") @PathVariable("location") String location,
            @Parameter(description = "The system of units used for the output data. Supported values are us, uk, metric, and base")
            @RequestParam(value = "unitGroup", defaultValue = "metric", required = false) String unitGroup,
            @Parameter(description = "indicates the output format for the API.")
            @RequestParam(value = "contentType", defaultValue = "json", required = false) String contentType
    );
}
