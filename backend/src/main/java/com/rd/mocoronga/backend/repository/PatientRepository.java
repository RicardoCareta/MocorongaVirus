package com.rd.mocoronga.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rd.mocoronga.backend.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
}
