package com.app.dto;



public class PharmacyDto {
		
	private int id;
	private String pharmacyName;
	private String licenseNumber;
	private String email;
	private String password;
	
	//Default constr
	public PharmacyDto() {
		
	}
	
	//Parameterized constr
	public PharmacyDto(String pharmacyName,String email, String licenseNumber, String password) {
		super();
		this.email=email;
		this.pharmacyName = pharmacyName;
		this.licenseNumber = licenseNumber;
		this.password = password;
	}
	
	//Getters and Setters
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
