
package com.zohra.microservice_temperature.controller;
import com.zohra.microservice_temperature.projection.TemperatureProjection;
import com.zohra.microservice_temperature.service.SondeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sondes")
@Tag(name = "Sonde Controller", description = "Récupérer les températures d’une ou plusieurs sondes sur une période donnée")
public class SondeController {

    @Autowired
    private SondeService sondeService;

    @Operation(summary = "Manquement de température par période")
    @GetMapping("/temperatures/sonde")
    public List<TemperatureProjection> getTemperaturesBySonde(
            @RequestParam String sonde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return sondeService.getTemperaturesBySondeAndDateRange(sonde, startDate, endDate);
    }

}