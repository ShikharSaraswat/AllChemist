package com.app.dto;

import java.util.List;

import com.app.entity.Prescription;


public class HistoryD {
	
	//List of prescriptions
	private List<Prescription> prescriptions;
	
	//Default Constr
	public HistoryD() {
		// TODO Auto-generated constructor stub
	}

	//Parameterized constructor
	public HistoryD(List<Prescription> prescriptions) {
		super();
		this.prescriptions = prescriptions;
	}
	
	//Getters and Setters
	public List<Prescription> getHistory() {
		return prescriptions;
	}

	public void setAccounts(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
}
