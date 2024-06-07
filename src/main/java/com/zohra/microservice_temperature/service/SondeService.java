package com.zohra.microservice_temperature.service;

import com.zohra.microservice_temperature.entity.SondeUn;

import com.zohra.microservice_temperature.repository.SondeUnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SondeService {

    @Autowired
    private SondeUnRepository sondeUnRepository;


    public List<SondeUn> getTemperaturesByPeriodForSondeUn(LocalDateTime startDate, LocalDateTime endDate) {
        System.out.println("temperatures: " + startDate + " and " + endDate);
        List<SondeUn> result = sondeUnRepository.findByDateBetween(startDate, endDate);
        System.out.println("result: " + result.size());
        return result;
    }

    public List<LocalDateTime> getTemperatureGapsForSondeUn(LocalDateTime startDate, LocalDateTime endDate) {
        List<SondeUn> records = sondeUnRepository.findByDateBetween(startDate, endDate);
        int intervalleMesure = 10;
        List<LocalDateTime> gaps = new ArrayList<>();

        for (int i = 1; i < records.size(); i++) {
            LocalDateTime expectedDate = records.get(i - 1).getDate().plusMinutes(intervalleMesure);
            if (!records.get(i).getDate().equals(expectedDate)) {
                gaps.add(expectedDate);
            }
        }

        return gaps;
    }
}

