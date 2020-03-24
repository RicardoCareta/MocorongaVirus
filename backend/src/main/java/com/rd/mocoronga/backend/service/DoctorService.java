package com.rd.mocoronga.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rd.mocoronga.backend.dto.DoctorDTO;
import com.rd.mocoronga.backend.exception.ApiErrorRequest;
import com.rd.mocoronga.backend.models.Doctor;
import com.rd.mocoronga.backend.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public DoctorDTO addDoctor (DoctorDTO doctorDTO) {
		if (doctorDTO.getName().isEmpty()) {
			throw new ApiErrorRequest("Name can not be empty", HttpStatus.BAD_REQUEST);
		}
		if (doctorDTO.getEmail().isEmpty()) {
			throw new ApiErrorRequest("Email can not be empty", HttpStatus.BAD_REQUEST);
		}
		if(doctorDTO.getPassword().isEmpty()) {
			throw new ApiErrorRequest("Password can not be empty", HttpStatus.BAD_REQUEST);
		}
		
		return convertToDTO(doctorRepository.save(convertToEntity(doctorDTO)));
	}
	
	private DoctorDTO convertToDTO(Doctor doctor) {
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setEmail(doctor.getEmail());
		doctorDTO.setName(doctor.getName());
		doctorDTO.setPassword(doctor.getPassword());
		doctorDTO.setId(doctor.getId());
		return doctorDTO;
	}
	
	private Doctor convertToEntity (DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		doctor.setId(doctorDTO.getId());
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setName(doctorDTO.getName());
		doctor.setPassword(doctorDTO.getPassword());
		return doctor;
	}
}
