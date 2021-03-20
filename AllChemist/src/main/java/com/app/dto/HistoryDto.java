package com.app.dto;

import java.util.List;

import com.app.entity.Prescription;


public class HistoryDto {
	
	//List of prescriptions
	private List<Prescription> prescriptions;
	
	//Default Constr
	public HistoryDto() {
		// TODO Auto-generated constructor stub
	}

	//Parameterized constructor
	public HistoryDto(List<Prescription> prescriptions) {
		super();
		this.prescriptions = prescriptions;
	}
	
	//Getters and Setters
	public List<Prescription> getHistory() {
		return prescriptions;
	}

	public void setHistory(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
}
