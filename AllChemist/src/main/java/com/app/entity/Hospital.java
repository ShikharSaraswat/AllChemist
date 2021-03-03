package com.app.entity;

import javax.persistence.Entity;

@Entity
public class Hospital extends BaseEntity {
	private String hospitalName;
	private int patientCount;
	private String password;
	
	public Hospital() {
		System.out.println("in hospital constructor");
	}

	public Hospital(String hospitalName, int patientCount, String password) {
		super();
		this.hospitalName = hospitalName;
		this.patientCount = patientCount;
		this.password = password;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", patientCount=" + patientCount + "]";
	}
	
	
}
