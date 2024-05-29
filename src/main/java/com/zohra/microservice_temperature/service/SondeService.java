package com.zohra.microservice_temperature.service;

import com.zohra.microservice_temperature.entity.SondeUn;
import com.zohra.microservice_temperature.repository.SondeUnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SondeService {

    @Autowired
    private SondeUnRepository sondeUnRepository;

    public List<SondeUn> getTemperaturesByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        return sondeUnRepository.findByDateBetween(startDate, endDate);
    }

    public boolean hasTemperatureGaps(Long sondeId, LocalDateTime startDate, LocalDateTime endDate, int intervalleMesure) {
        List<SondeUn> records = sondeUnRepository.findByDateBetween(startDate, endDate);
        for (int i = 1; i < records.size(); i++) {
            LocalDateTime expectedDate = records.get(i - 1).getDate().plusMinutes(intervalleMesure);
            if (!records.get(i).getDate().equals(expectedDate)) {
                return true;
            }
        }
        return false;
    }

}
