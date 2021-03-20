package com.app.dto;

import java.time.LocalDate;

import com.app.entity.BloodGroup;

public class PrescriptionDto {
	
	private int id;
	private String name;
	private int patientId;
	private String email;
	private LocalDate date;
	private int age;
	private BloodGroup bloodGroup;
	private String description;
	private String bloodPressure;
	private String prescriptionDetails;
	private int imageId;
	private boolean status;
	
	
	


	public PrescriptionDto(int id, String name, int patientId, String email, LocalDate date, int age,
			BloodGroup bloodGroup, String description, String bloodPressure, String prescriptionDetails, int imageId,
			boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.patientId = patientId;
		this.email = email;
		this.date = date;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.description = description;
		this.bloodPressure = bloodPressure;
		this.prescriptionDetails = prescriptionDetails;
		this.imageId = imageId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPrescriptionFile() {
		return imageId;
	}

	public void setPrescriptionFile(int prescriptionFile) {
		this.imageId = prescriptionFile;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getPrescriptionDetails() {
		return prescriptionDetails;
	}

	public void setPrescriptionDetails(String prescriptionDetails) {
		this.prescriptionDetails = prescriptionDetails;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
	
}
