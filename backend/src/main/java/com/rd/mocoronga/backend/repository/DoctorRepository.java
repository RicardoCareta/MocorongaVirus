package com.rd.mocoronga.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rd.mocoronga.backend.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	Optional<Doctor> findByEmailAndPassword (String email, String password);
	Optional<Doctor> findByName(String name);
}
