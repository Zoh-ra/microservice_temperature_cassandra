package com.zohra.microservice_temperature.service;

import com.zohra.microservice_temperature.entity.Sonde;

import com.zohra.microservice_temperature.projection.TemperatureProjection;
import com.zohra.microservice_temperature.repository.SondeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SondeService {

    @Autowired
    private SondeRepository sondeRepository;

    public List<TemperatureProjection> getTemperaturesBySondeAndDateRange(String sonde, LocalDateTime startDate, LocalDateTime endDate) {
        return sondeRepository.findTemperaturesBySondeAndDateBetween(sonde, startDate, endDate);
    }
}

