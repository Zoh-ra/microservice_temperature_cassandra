
package com.zohra.microservice_temperature.controller;
import com.zohra.microservice_temperature.dto.MissingTemperatureResponse;
import com.zohra.microservice_temperature.dto.TemperatureResponse;
import com.zohra.microservice_temperature.service.TemperatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/temperature")
@Tag(name = "Sonde Controller", description = "Récupérer les températures d’une ou plusieurs sondes sur une période donnée")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @Operation(summary = "Temperature par periode")
    @GetMapping("/sonde")
    public ResponseEntity<TemperatureResponse> getSondesData(

            @RequestParam String sonde,

            @Parameter(description = "Date de début au format 'yyyy-MM-ddTHH:mm:ss'")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,

            @Parameter(description = "Date de fin au format 'yyyy-MM-ddTHH:mm:ss'")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate) {
        TemperatureResponse response = temperatureService.getTemperaturesBySondeAndDateRange(sonde, startDate, endDate);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Manquement de température par période")
    @GetMapping("/missing")
    public ResponseEntity<MissingTemperatureResponse> getMissingTemperatures(
            @RequestParam String sonde,

            @Parameter(description = "Date de début au format 'yyyy-MM-ddTHH:mm:ss'")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,

            @Parameter(description = "Date de fin au format 'yyyy-MM-ddTHH:mm:ss'")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate) {
        MissingTemperatureResponse missingTemperatures = temperatureService.getMissingTemperatures(sonde, startDate, endDate);
        return ResponseEntity.ok(missingTemperatures);
    }
}