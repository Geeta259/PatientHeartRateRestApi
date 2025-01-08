package com.patient.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dao.HeartRateRepository;
import com.patient.dao.PatientRepository;
import com.patient.entity.HeartRate;
import com.patient.entity.Patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/heartRates")
@Tag(name = "Heart Rate", description = "Heart Rate Management APIs")
public class HeartRateController {

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/{patientId}")
    @Operation(summary = "Record heart rate", description = "Records heart rate data for a patient")
    
    public ResponseEntity<String> addHeartRate(
            @PathVariable Long patientId, @RequestBody HeartRate heartRate) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        heartRate.setPatient(patient);
        heartRate.setTimestamp(LocalDateTime.now());
        heartRateRepository.save(heartRate);

        return ResponseEntity.ok("Heart rate recorded.");
    }

    @GetMapping("/{patientId}")
    @Operation(summary = "Get heart rate details", description = "Retrieves heart rate data for a patient")
    
    public ResponseEntity<List<HeartRate>> getHeartRates(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return ResponseEntity.ok(patient.getHeartRates());
    }
}
