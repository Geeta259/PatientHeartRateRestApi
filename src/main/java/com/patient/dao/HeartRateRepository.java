package com.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.HeartRate;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
}