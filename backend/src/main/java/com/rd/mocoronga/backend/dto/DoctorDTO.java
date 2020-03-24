package com.rd.mocoronga.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DoctorDTO {
	
	private Long id;
	private String name;
	private String email;
	
	@JsonIgnoreProperties(allowGetters=false, allowSetters=true)
	private String password;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
