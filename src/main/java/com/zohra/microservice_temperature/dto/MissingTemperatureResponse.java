package com.zohra.microservice_temperature.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zohra.microservice_temperature.entity.Temperature;
import com.zohra.microservice_temperature.projection.DateProjection;


import java.time.LocalDateTime;
import java.util.List;

public class MissingTemperatureResponse {
    private List<DateProjection> dataMissingTemperature;
    private Integer totalMissingTemperature;

    public List<DateProjection> getDataMissingTemperature() {
        return dataMissingTemperature;
    }

    public void setDataMissingTemperature(List<DateProjection> dataMissingTemperature) {
        this.dataMissingTemperature = dataMissingTemperature;
    }

    public Integer getTotalMissingTemperature() {
        return totalMissingTemperature;
    }

    public void setTotalMissingTemperature(Integer totalMissingTemperature) {
        this.totalMissingTemperature = totalMissingTemperature;
    }
}

