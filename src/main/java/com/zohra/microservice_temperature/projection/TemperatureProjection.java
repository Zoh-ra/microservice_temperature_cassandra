package com.zohra.microservice_temperature.projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TemperatureProjection {
    private Double temperature;
    private String sonde;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

    // Default constructor for JPA
    public TemperatureProjection() {
    }

    // Constructor with parameters
    public TemperatureProjection(Double temperature, String sonde, LocalDateTime date) {
        this.temperature = temperature;
        this.sonde = sonde;
        this.date = date;
    }

    // Getters and Setters
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getSonde() {
        return sonde;
    }

    public void setSonde(String sonde) {
        this.sonde = sonde;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}