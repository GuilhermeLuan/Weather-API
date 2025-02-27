package dev.guilhermeluan.weatherapi.infra.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class GetWeatherResponseDTO implements Serializable {

    private String datetime;
    private String address;
    private String timezone;
    private String description;
    private Double temp;
    private Double tempMax;
    private Double tempMin;
    private Double feelsLike;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonCreator
    public GetWeatherResponseDTO(
            @JsonProperty("datetime") String datetime,
            @JsonProperty("address") String address,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("description") String description,
            @JsonProperty("days") List<DayDTO> days) {
        this.datetime = datetime;
        this.address = address;
        this.timezone = timezone;
        this.description = description;

        if (days != null && !days.isEmpty()) {
            DayDTO day = days.getFirst();
            this.datetime = day.getDatetime();
            this.temp = day.getTemp();
            this.tempMax = day.getTempmax();
            this.tempMin = day.getTempmin();
            this.feelsLike = day.getFeelslike();
        }
    }
}

class DayDTO implements Serializable {

    private String datetime;
    private Double temp;
    private Double tempmax;
    private Double tempmin;
    private Double feelslike;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempmax() {
        return tempmax;
    }

    public void setTempmax(Double tempmax) {
        this.tempmax = tempmax;
    }

    public Double getTempmin() {
        return tempmin;
    }

    public void setTempmin(Double tempmin) {
        this.tempmin = tempmin;
    }

    public Double getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Double feelslike) {
        this.feelslike = feelslike;
    }

    @JsonCreator
    public DayDTO(
            @JsonProperty("datetime") String datetime,
            @JsonProperty("temp") Double temp,
            @JsonProperty("tempmax") Double tempmax,
            @JsonProperty("tempmin") Double tempmin,
            @JsonProperty("feelslike") Double feelslike) {
        this.datetime = datetime;
        this.temp = temp;
        this.tempmax = tempmax;
        this.tempmin = tempmin;
        this.feelslike = feelslike;
    }
}
