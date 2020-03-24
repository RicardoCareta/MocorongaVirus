package com.rd.mocoronga.backend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rd.mocoronga.backend.dto.PatientDTO;
import com.rd.mocoronga.backend.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@CrossOrigin(value="*")
	@GetMapping()
	public HashMap<String, List<PatientDTO>> getAll () {
		HashMap<String, List<PatientDTO>> modelPatient = new HashMap<String, List<PatientDTO>>();
		modelPatient.put("patient", patientService.getAll());
		return modelPatient;
	}
	
	@CrossOrigin(value="*")
	@PostMapping
	public PatientDTO addPatient (@RequestBody PatientDTO patientDTO) {
		return patientService.addPatient(patientDTO);
	}
	
	@CrossOrigin(value="*")
	@PutMapping
	public PatientDTO updatePatient (@RequestBody PatientDTO patientDTO) {
		return patientService.updatePatient(patientDTO);
	}
	
	@CrossOrigin(value="*")
	@PatchMapping("/{id}/{corona}")
	public PatientDTO setCorona(@PathVariable Long id, @PathVariable boolean corona) {
		return patientService.setCorona(id, corona);
	}
	
	@CrossOrigin(value="*")
	@PatchMapping("/attend/{id}")
	public PatientDTO setAttend(@PathVariable Long id) {
		return patientService.setAttend(id);
	}
}
