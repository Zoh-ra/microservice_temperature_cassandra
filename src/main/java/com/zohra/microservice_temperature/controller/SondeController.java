package com.zohra.microservice_temperature.controller;

import com.zohra.microservice_temperature.entity.SondeUn;
import com.zohra.microservice_temperature.service.SondeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/sondes")
public class SondeController {

    @Autowired
    private SondeService sondeService;

    @GetMapping("/temperaturesByPeriod")
    public List<SondeUn> getTemperaturesByPeriod(@RequestParam String startDate,
                                         @RequestParam String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        return sondeService.getTemperaturesByPeriod(start, end);
    }

    @GetMapping("/manquements")
    public boolean hasTemperatureGaps(@RequestParam Long sondeId,
                                      @RequestParam String startDate,
                                      @RequestParam String endDate,
                                      @RequestParam int intervalleMesure) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        return sondeService.hasTemperatureGaps(sondeId, start, end, intervalleMesure);
    }
}
