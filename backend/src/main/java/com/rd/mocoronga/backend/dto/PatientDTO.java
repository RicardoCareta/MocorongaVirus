package com.rd.mocoronga.backend.dto;


public class PatientDTO {
	
	private Long id;
	private String name;
	private int age;
	private String prognostic;

	private String risk;
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
	public String getRisk() {
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
	public void setRisk(String risk) {
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
