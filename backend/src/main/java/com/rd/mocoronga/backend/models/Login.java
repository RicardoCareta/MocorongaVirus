package com.rd.mocoronga.backend.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	@Column(name="last_login_date")
	private Date lastLoginDate;
	private UUID token;
	
	public Long getId() {
		return id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public UUID getToken() {
		return token;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	
}
