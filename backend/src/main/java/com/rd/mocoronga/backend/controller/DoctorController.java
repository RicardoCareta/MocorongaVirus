package com.rd.mocoronga.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rd.mocoronga.backend.dto.DoctorDTO;
import com.rd.mocoronga.backend.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@CrossOrigin(value="*")
	@PostMapping
	public ResponseEntity<?> addDoctor (@RequestBody DoctorDTO doctorDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(doctorDTO));
	}
}
