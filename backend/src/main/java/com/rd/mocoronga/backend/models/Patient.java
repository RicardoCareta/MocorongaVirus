package com.rd.mocoronga.backend.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Patient {
	
	public Patient() {}
	public Patient(String name, int age, String prognostic, Risk risk, boolean corona, String doctor, boolean status) {
		this.name = name;
		this.age = age;
		this.prognostic = prognostic;
		this.risk = risk;
		this.corona = corona;
		this.doctor = doctor;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private String prognostic;
	
	@Enumerated(EnumType.STRING)
	private Risk risk;
	private boolean corona;
	private String doctor;
	private boolean status;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPrognostic() {
		return prognostic;
	}
	public Risk getRisk() {
		return risk;
	}
	public boolean isCorona() {
		return corona;
	}
	public String getDoctor() {
		return doctor;
	}
	public boolean getStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPrognostic(String prognostic) {
		this.prognostic = prognostic;
	}
	public void setRisk(Risk risk) {
		this.risk = risk;
	}
	public void setCorona(boolean corona) {
		this.corona = corona;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
