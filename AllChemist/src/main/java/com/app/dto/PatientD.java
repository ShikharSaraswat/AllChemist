package com.app.dto;

import com.app.entity.BloodGroup;

public class PatientD {
	
	private int id;
	private String password;
	private String name;
	private BloodGroup bloodGroup;
	private String address;
	
	//Default Constr
	public PatientD() {
	
	}
	
	//Parameterized Constr
	public PatientD(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	//For Updating Details
	public PatientD(int id, String password, String name, BloodGroup bloodGroup, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.address = address;
	}

	//Getter and Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
