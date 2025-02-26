package dev.guilhermeluan.weatherapi.infra.client;

public record GetWeatherResponse(
        String address,
        String timezone,
        String description,
        String temp,
        String tempMax,
        String tempMin,
        String feelsLike
) {
}
