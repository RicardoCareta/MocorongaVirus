package com.rd.mocoronga.backend.service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rd.mocoronga.backend.dto.LoginDTO;
import com.rd.mocoronga.backend.exception.ApiErrorRequest;
import com.rd.mocoronga.backend.models.Doctor;
import com.rd.mocoronga.backend.models.Login;
import com.rd.mocoronga.backend.repository.DoctorRepository;
import com.rd.mocoronga.backend.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	public LoginDTO login (String email, String password) {
		Optional<Doctor> doctor = doctorRepository.findByEmailAndPassword(email, password);
		if (!doctor.isPresent()) {
			throw new ApiErrorRequest("Login invalid", HttpStatus.UNAUTHORIZED);
		}

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setDoctorName(doctor.get().getName());
		loginDTO.setToken(UUID.randomUUID());
		
		addLogin(loginDTO, doctor.get());
		
		return loginDTO;
	}
	
	public boolean authenticateToken (String token) {
		UUID uuid = UUID.fromString(token);
		Optional<Login> loginOpt = loginRepository.findByToken(uuid);
		if(loginOpt.isPresent()) {
			long dif = (Calendar.getInstance().getTime().getTime() - loginOpt.get().getLastLoginDate().getTime());
			long minutes = dif / (1000 * 60);
			if (minutes > 1) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	/*
	private void addLogin(LoginDTO loginDTO) {
		addLogin(loginDTO, null);
	}
	*/
	
	private void addLogin (LoginDTO loginDTO, Doctor doctor) {
		if(loginDTO.getDoctorName().isEmpty()) {
			throw new ApiErrorRequest("Doctor name is empty", HttpStatus.BAD_REQUEST);
		}
		
		if(doctor == null)
			doctor = doctorRepository.findByName(loginDTO.getDoctorName()).get();
		
		if (doctor == null) {
			throw new ApiErrorRequest("Doctor not exists", HttpStatus.UNAUTHORIZED);
		}
		
		
		Login login = new Login();
		login.setLastLoginDate(loginDTO.getLastLoginDate());
		login.setToken(loginDTO.getToken());
		login.setDoctor(doctor);
		
		loginRepository.save(login);
	}
}
