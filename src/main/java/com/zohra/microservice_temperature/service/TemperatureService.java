package com.zohra.microservice_temperature.service;

import com.zohra.microservice_temperature.dto.MissingTemperatureResponse;
import com.zohra.microservice_temperature.entity.Temperature;
import com.zohra.microservice_temperature.projection.TemperatureProjection;
import com.zohra.microservice_temperature.dto.TemperatureResponse;
import com.zohra.microservice_temperature.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    public TemperatureResponse getTemperaturesBySondeAndDateRange(String sonde, LocalDateTime startDate, LocalDateTime endDate) {
        List<TemperatureProjection> temperatures = temperatureRepository.findTemperaturesBySondeAndDateBetween(sonde, startDate, endDate);
        Integer totalTemperature = temperatureRepository.countTemperaturesBySondeAndDateRange(sonde, startDate, endDate);

        TemperatureResponse response = new TemperatureResponse();
        response.setDataTemperature(temperatures);
        response.setTotalTemperature(totalTemperature);

        return response;
    }
//demander mieux est requete count ou list size?
    public MissingTemperatureResponse getMissingTemperatures(String sonde, LocalDateTime startDate, LocalDateTime endDate) {
        List<Temperature> measurements = temperatureRepository.findAllBySondeAndDateBetween(sonde, startDate, endDate);
        List<LocalDateTime> missingTimestamps = new ArrayList<>();

        LocalDateTime current = startDate;
        int index = 0;

        while (current.isBefore(endDate) || current.equals(endDate)) {
            if (index < measurements.size() && measurements.get(index).getDate().equals(current)) {
                index++;
            } else {
                missingTimestamps.add(current);
            }
            current = current.plusMinutes(10);
        }

        return new MissingTemperatureResponse(missingTimestamps, missingTimestamps.size());
    }
}

