package com.zohra.microservice_temperature.repository;

import com.zohra.microservice_temperature.entity.SondeUn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SondeUnRepository extends JpaRepository<SondeUn, Integer> {
    List<SondeUn> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);



   // List<LocalDateTime> findMissingMeasurements(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
