package com.rd.mocoronga.backend.dto;

import java.util.Date;
import java.util.UUID;

public class LoginDTO {
	
	private Date lastLoginDate;
	private UUID token;
	private String doctorName;
	
	public LoginDTO() {
		lastLoginDate = new Date();
	}
	
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public UUID getToken() {
		return token;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
