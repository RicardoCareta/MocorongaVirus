package com.rd.mocoronga.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rd.mocoronga.backend.dto.PatientDTO;
import com.rd.mocoronga.backend.exception.ApiErrorRequest;
import com.rd.mocoronga.backend.models.Patient;
import com.rd.mocoronga.backend.models.Risk;
import com.rd.mocoronga.backend.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostConstruct
	public void init () {
		patientRepository.save(
			new Patient("Nome 1", 1, "Dor", Risk.VERY_URGENCY, false, "Doctor", true)
		);
	}
	
	public PatientDTO setAttend(Long id) {
		Patient patient = getPatientById(id);
		patient.setStatus(false);
		patientRepository.save(patient);
		return convertToDTO(patient);
	}
	
	public List<PatientDTO> getAll() {
		return patientRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public PatientDTO addPatient (PatientDTO patientDTO) {
		patientDTO.setId(null);
		patientDTO.setStatus(true);
		patientDTO.setCorona(false);
		
		if (patientDTO.getName() == null || patientDTO.getName().equals("")) 
			throw new ApiErrorRequest("Name is required", HttpStatus.BAD_REQUEST);
		
		if (patientDTO.getAge() < 0)
			throw new ApiErrorRequest("Age can not be negative", HttpStatus.BAD_REQUEST);
		
		if (patientDTO.getDoctor() == null || patientDTO.getDoctor().equals(""))
			throw new ApiErrorRequest("Doctor is required", HttpStatus.BAD_REQUEST);
		
		if (patientDTO.getPrognostic() == null || patientDTO.getPrognostic().equals(""))
			throw new ApiErrorRequest("Prognostic is required", HttpStatus.BAD_REQUEST);
		
		
		return convertToDTO(patientRepository.save(convertToEntity(patientDTO)));
	}
	
	public PatientDTO updatePatient (PatientDTO patientDTO) { 
		getPatientById(patientDTO.getId());
		return convertToDTO(patientRepository.save(convertToEntity(patientDTO)));
	}
	
	public PatientDTO setCorona(Long id, boolean corona) {
		Patient patient = getPatientById(id);
		patient.setCorona(corona);
		patientRepository.save(patient);
		return convertToDTO(patient);
	}
	
	private Patient getPatientById(Long id) {
		Optional<Patient> patientOp = patientRepository.findById(id);
		if(!patientOp.isPresent()) {
			throw new ApiErrorRequest("Patient not found", HttpStatus.NOT_FOUND);
		}
		return patientOp.get();
	}

	private PatientDTO convertToDTO (Patient patient) {
		PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
		return patientDTO;
	}
	private Patient convertToEntity(PatientDTO patientDTO) {
		Patient patient = modelMapper.map(patientDTO, Patient.class);
		if(patient.getRisk() == null) {
			for (Risk risk : Risk.values()) {
				if(risk.getRiskDesc().equalsIgnoreCase(patientDTO.getRisk())) {
					patient.setRisk(risk);
					break;
				}
			}
			if(patient.getRisk() == null) {
				throw new ApiErrorRequest("Risk not found", HttpStatus.NOT_FOUND);
			}
		}
		return patient;
	}
}
