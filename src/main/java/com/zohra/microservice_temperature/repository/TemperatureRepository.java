package com.zohra.microservice_temperature.repository;
import com.zohra.microservice_temperature.entity.Temperature;
import com.zohra.microservice_temperature.projection.DateProjection;
import com.zohra.microservice_temperature.projection.TemperatureProjection;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TemperatureRepository extends CassandraRepository<Temperature, Integer> {
    @Query("SELECT sonde, date, temperature FROM temperature_sonde_periode WHERE sonde = :sonde AND date >= :startDate AND date <= :endDate")
    List<TemperatureProjection> findTemperaturesBySondeAndDateBetween(
            @Param("sonde") String sonde,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT COUNT(*) FROM temperature_sonde_periode WHERE sonde = :sonde AND date >= :startDate AND date <= :endDate")
    Integer countTemperaturesBySondeAndDatePeriod(
            @Param("sonde") String sonde,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT date FROM temperature_sonde_periode WHERE sonde = :sonde AND date >= :startDate AND date <= :endDate")
    List<DateProjection> findMissingTemperaturesBySondeAndDateBetween(
            @Param("sonde") String sonde,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);


}