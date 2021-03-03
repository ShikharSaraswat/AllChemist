package com.app.dto;



public class PharmacyDto {
		
	private String pharmacyName;
	private String licenseNumber;
	private String password;
	
	//Default constr
	public PharmacyDto() {
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized constr
	public PharmacyDto(String pharmacyName, String licenseNumber, String password) {
		super();
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
	
	
	
}
