package com.app.dto;

import java.time.LocalDate;

import com.app.entity.BloodGroup;
import com.app.entity.Gender;

public class PatientDto {

	private int id;
	private String password;
	private String name;
	private String email;
	private String height;
	private String weight;
	private Gender gender;
	private BloodGroup bloodGroup;
	private String address;
	private LocalDate dateOfBirth;

	// Default Constr
	public PatientDto() {

	}

	// Parameterized Constr
	public PatientDto(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

//	// For Updating Details
//	public PatientD(int id, String password, String name, BloodGroup bloodGroup, String address) {
//		super();
//		this.id = id;
//		this.password = password;
//		this.name = name;
//		this.bloodGroup = bloodGroup;
//		this.address = address;
//	}

	// Getter and Setter
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "PatientDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", height="
				+ height + ", weight=" + weight + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", address="
				+ address + ", dateOfBirth=" + dateOfBirth + "]";
	}



}
