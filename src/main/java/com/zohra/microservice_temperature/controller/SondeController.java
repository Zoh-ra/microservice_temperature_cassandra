
package com.zohra.microservice_temperature.controller;

import com.zohra.microservice_temperature.entity.SondeUn;
import com.zohra.microservice_temperature.service.SondeService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/sondes")
@Tag(name = "Sonde Controller", description = "Récupérer les températures d’une ou plusieurs sondes sur une période donnée")
public class SondeController {

    @Autowired
    private SondeService sondeService;

    @Operation(summary = "Temperature par période")
    @GetMapping("/temperaturesByPeriodSondeUn")
    public List<SondeUn> getTemperaturesByPeriodForSondeUn(
            @Parameter(description = "Date de début au format yyyy-MM-dd HH:mm:ss")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") String startDate,
            @Parameter(description = "Date de fin au format yyyy-MM-dd HH:mm:ss")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        System.out.println("temp entre: " + start + " and " + end);
        List<SondeUn> result = sondeService.getTemperaturesByPeriodForSondeUn(start, end);
        System.out.println("Return" + result.size() + " result");
        return result;
    }

    @Operation(summary = "Manquement de température par période")
    @GetMapping("/manquementsSondeUn")
    public List<LocalDateTime> getTemperatureGapsForSondeUn(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        return sondeService.getTemperatureGapsForSondeUn(start, end);
    }

}