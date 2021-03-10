package com.app.entity;

import javax.persistence.Entity;

import com.app.dto.HospitalD;

@Entity
public class Hospital extends BaseEntity {
	private String hospitalName;
	private int patientCount;
	private String password;
	private String email;
	
	public Hospital() {
		System.out.println("in hospital constructor");
	}

	public Hospital(String hospitalName,String email, int patientCount, String password) {
		super();
		this.email=email;
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
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", patientCount=" + patientCount + "]";
	}
	
	public Hospital toBean(HospitalD hospital) {
		this.email=hospital.getEmail();
		this.hospitalName=hospital.getName();
		this.password=hospital.getPassword();
		this.setId(hospital.getId());
		
		return this;
		
	}
	
	
	
}
