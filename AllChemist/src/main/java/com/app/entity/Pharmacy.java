package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.app.dto.PharmacyDto;

@Entity 
public class Pharmacy {
	private String pharmacyName;
	@Id
	private int id;
	private String licenseNumber;
	private String email;
	private String password;

	public Pharmacy() {
		System.out.println("in pharmacy constructor");
	}

	public Pharmacy(String pharmacyName,String email, String licenseNumber, String password) {
		super();
		this.email=email;
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
	
	

	public String getEmail() {
		return email;
	}

	public void getEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pharmacy [pharmacyName=" + pharmacyName + ", licenseNumber=" + licenseNumber + "]";
	}

	public Pharmacy toBean(PharmacyDto pharmacy) {
		this.email=pharmacy.getEmail();
		this.licenseNumber=pharmacy.getLicenseNumber();
		this.password=pharmacy.getPassword();
		this.pharmacyName=pharmacy.getPharmacyName();
		this.id=pharmacy.getId();
		
		return this;
	}
	

}
