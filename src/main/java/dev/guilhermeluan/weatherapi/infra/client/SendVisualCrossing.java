package dev.guilhermeluan.weatherapi.infra.client;

import dev.guilhermeluan.weatherapi.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "visualCrossingClient",
        url = "${api.base_url.visual_crossing}",
        configuration = FeignConfig.class)
public interface SendVisualCrossing {
    @GetMapping("/{location}/today")
    GetWeatherResponseDTO getTodayWeather(
            @PathVariable("location") String location,
            @RequestParam("key") String apiKey,
            @RequestParam(value = "contentType", defaultValue = "json", required = false) String contentType,
            @RequestParam(value = "unitGroup", defaultValue = "metric", required = false) String unitGroup
    );
}

