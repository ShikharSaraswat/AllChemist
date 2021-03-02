package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Pharmacy {
	private String pharmacyName;
	@Id
	private String licenseNumber;
	private String password;

	public Pharmacy() {
		System.out.println("in pharmacy constructor");
	}

	public Pharmacy(String pharmacyName, String licenseNumber, String password) {
		super();
		this.pharmacyName = pharmacyName;
		this.licenseNumber = licenseNumber;
		this.password = password;
	}

	// setters and getters
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

	@Override
	public String toString() {
		return "Pharmacy [pharmacyName=" + pharmacyName + ", licenseNumber=" + licenseNumber + "]";
	}


	

}
