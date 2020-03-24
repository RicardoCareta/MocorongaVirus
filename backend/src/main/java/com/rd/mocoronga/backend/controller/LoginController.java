package com.rd.mocoronga.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rd.mocoronga.backend.dto.LoginDTO;
import com.rd.mocoronga.backend.exception.ApiErrorRequest;
import com.rd.mocoronga.backend.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<LoginDTO> login(@RequestBody Map<String, String> loginValues) {
		if (!loginValues.containsKey("email") || !loginValues.containsKey("password")) {
			throw new ApiErrorRequest("Invalid body", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<LoginDTO>(loginService.login(loginValues.get("email"), loginValues.get("password")), HttpStatus.ACCEPTED);
	}
}
