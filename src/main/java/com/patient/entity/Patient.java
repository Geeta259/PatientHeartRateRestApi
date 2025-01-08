package com.patient.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String identifier; 
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<HeartRate> heartRates = new ArrayList<>();

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, String name, String identifier, List<HeartRate> heartRates) {
		super();
		this.id = id;
		this.name = name;
		this.identifier = identifier;
		this.heartRates = heartRates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<HeartRate> getHeartRates() {
		return heartRates;
	}

	public void setHeartRates(List<HeartRate> heartRates) {
		this.heartRates = heartRates;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", identifier=" + identifier + "]";
	}

    
}
