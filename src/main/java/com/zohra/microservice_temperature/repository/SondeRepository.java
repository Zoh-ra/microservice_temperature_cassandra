package com.zohra.microservice_temperature.repository;
import com.zohra.microservice_temperature.entity.Sonde;
import com.zohra.microservice_temperature.projection.TemperatureProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SondeRepository extends JpaRepository<Sonde, Integer> {

    @Query("SELECT s.temperature AS temperature FROM Sonde s WHERE s.sonde = :sonde AND s.date BETWEEN :startDate AND :endDate")
    List<TemperatureProjection> findTemperaturesBySondeAndDateBetween(
            @Param("sonde") String sonde,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
}