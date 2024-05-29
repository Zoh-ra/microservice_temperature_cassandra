package com.zohra.microservice_temperature.repository;

import com.zohra.microservice_temperature.entity.SondeUn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SondeUnRepository extends JpaRepository<SondeUn, Integer> {
    List<SondeUn> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
