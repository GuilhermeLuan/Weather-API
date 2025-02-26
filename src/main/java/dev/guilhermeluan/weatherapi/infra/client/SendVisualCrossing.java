package dev.guilhermeluan.weatherapi.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "visual-crossing",
        url = "${api.base_url.visual_crossing}")
public interface SendVisualCrossing {
    @GetMapping("/{location}/today")
    Object getTodayWeather(
            @PathVariable("location") String location,
            @RequestParam("key") String apiKey,
            @RequestParam(value = "contentType", defaultValue = "json", required = false) String contentType
    );
}
