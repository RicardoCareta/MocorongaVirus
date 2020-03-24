package com.rd.mocoronga.backend.models;


public enum Risk {
	NOT_URGENCY ("Não urgente"),
	LITTLE_URGENCY("Pouco urgente"),
	URGENCY ("Urgente"),
	VERY_URGENCY ("Muito urgente"),
	EMERGENCY ("Emergente");
	
	
	private String riskDesc;
	Risk (String riskDesc) {
		this.riskDesc = riskDesc;
	}
	
	public String getRiskDesc() {
		return this.riskDesc;
	}
}
