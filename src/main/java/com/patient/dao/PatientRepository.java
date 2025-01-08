package com.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
