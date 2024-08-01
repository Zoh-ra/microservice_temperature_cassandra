package com.zohra.microservice_temperature.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table("temperature_sonde_periode")
public class Temperature {

    @PrimaryKeyColumn(name = "sonde", type = PrimaryKeyType.PARTITIONED)
    private String sonde;

    @PrimaryKeyColumn(name = "date", type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime date;

    private double temperature;
    private boolean Archivage;
    private String concentrateur;
    private LocalDateTime heureReception;
    private int intervalleMesure;
    private double rssi;
    private double tensionBatterie;

    public String getSonde() {
        return sonde;
    }

    public void setSonde(String sonde) {
        this.sonde = sonde;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isArchivage() {
        return Archivage;
    }

    public void setArchivage(boolean Archivage) {
        this.Archivage = Archivage;
    }

    public String getConcentrateur() {
        return concentrateur;
    }

    public void setConcentrateur(String concentrateur) {
        this.concentrateur = concentrateur;
    }

    public LocalDateTime getHeureReception() {
        return heureReception;
    }

    public void setHeureReception(LocalDateTime heureReception) {
        this.heureReception = heureReception;
    }

    public int getIntervalleMesure() {
        return intervalleMesure;
    }

    public void setIntervalleMesure(int intervalleMesure) {
        this.intervalleMesure = intervalleMesure;
    }

    public double getRssi() {
        return rssi;
    }

    public void setRssi(double rssi) {
        this.rssi = rssi;
    }

    public double getTensionBatterie() {
        return tensionBatterie;
    }

    public void setTensionBatterie(double tensionBatterie) {
        this.tensionBatterie = tensionBatterie;
    }
}
