package com.rd.mocoronga.backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rd.mocoronga.backend.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

	Optional<Login> findByToken(UUID token);
}
