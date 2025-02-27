package dev.guilhermeluan.weatherapi.infra.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DayDTO implements Serializable {

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
