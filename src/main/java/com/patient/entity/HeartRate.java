package com.patient.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HeartRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rate; // heart rate value

    @Column(nullable = false)
    private LocalDateTime timestamp; // when the reading was taken

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

	public HeartRate(Long id, int rate, LocalDateTime timestamp, Patient patient) {
		super();
		this.id = id;
		this.rate = rate;
		this.timestamp = timestamp;
		this.patient = patient;
	}

	public HeartRate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "HeartRate [id=" + id + ", rate=" + rate + ", timestamp=" + timestamp + ", patient=" + patient + "]";
	}

   
}
