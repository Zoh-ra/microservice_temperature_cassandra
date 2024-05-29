package com.zohra.microservice_temperature.repository;

import com.zohra.microservice_temperature.entity.SondeDeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SondeDeuxRepository extends JpaRepository<SondeDeux, Integer> {
    List<SondeDeux> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}