package com.zohra.microservice_temperature.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class MissingTemperatureResponse {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private List<LocalDateTime> missingDates;
    private int totalMissing;

    // Constructors, Getters and Setters

    public MissingTemperatureResponse() {
    }

    public MissingTemperatureResponse(List<LocalDateTime> missingDates, int totalMissing) {
        this.missingDates = missingDates;
        this.totalMissing = totalMissing;
    }

    public List<LocalDateTime> getMissingDates() {
        return missingDates;
    }

    public void setMissingDates(List<LocalDateTime> missingDates) {
        this.missingDates = missingDates;
    }

    public int getTotalMissing() {
        return totalMissing;
    }

    public void setTotalMissing(int totalMissing) {
        this.totalMissing = totalMissing;
    }
}
