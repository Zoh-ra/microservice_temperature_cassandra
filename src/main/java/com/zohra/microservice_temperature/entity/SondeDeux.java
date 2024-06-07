package com.zohra.microservice_temperature.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "210100B")
public class SondeDeux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private Double temperature;
    private Double tensionBatterie;
    private Double rssi;
    private String concentrateur;
    private LocalDateTime heureReception;
    private Boolean archivage;
    private Integer intervalleMesure;

}
