package com.zohra.microservice_temperature.repository;
import com.zohra.microservice_temperature.entity.Temperature;
import com.zohra.microservice_temperature.projection.TemperatureProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {

    @Query("SELECT new com.zohra.microservice_temperature.projection.TemperatureProjection(s.temperature, s.sonde, s.date) FROM Temperature s WHERE s.sonde = :sonde AND s.date BETWEEN :startDate AND :endDate")
    List<TemperatureProjection> findTemperaturesBySondeAndDateBetween(
            @Param("sonde") String sonde,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT COUNT(s) FROM Temperature s WHERE s.sonde = :sonde AND s.date BETWEEN :startDate AND :endDate")
    Integer countTemperaturesBySondeAndDateRange(@Param("sonde") String sonde, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT s FROM Temperature s WHERE s.sonde = :sonde AND s.date BETWEEN :startDate AND :endDate ORDER BY s.date ASC")
    List<Temperature> findAllBySondeAndDateBetween(
            @Param("sonde") String sonde,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);


}