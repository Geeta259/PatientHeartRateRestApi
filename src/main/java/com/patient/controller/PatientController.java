package com.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dao.PatientRepository;
import com.patient.entity.Patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient", description = "Patient Management APIs")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Operation(summary = "Add a new patient", description = "Creates a new patient record")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patient.getHeartRates().forEach(heartRate -> heartRate.setPatient(patient));
        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get patient details", description = "Retrieves details of a patient by ID")
    
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
