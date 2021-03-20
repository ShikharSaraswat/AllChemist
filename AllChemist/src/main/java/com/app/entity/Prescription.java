package com.app.entity;

import java.time.LocalDate;

//private int id;
//private String name;
//private int patientId;
//private String email;
//private LocalDate date;
//private int age;
//private BloodGroup bloodGroup;
//private String description;
//private String bloodPressure;
//private String prescriptionDetails;
//private int imageId;
//private boolean status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.dto.PrescriptionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Prescription extends BaseEntity {
	@ManyToOne
	@JsonIgnoreProperties("history")
	@JoinColumn(name="patient",nullable = false)
	private PatientEntity patientId;
	@Column(name = "issue_date")
	private LocalDate date;
	@Column(name = "image_id")
	private int imageId;
	@Column(name = "prescription_status")
	private boolean status;
	
	private String name;
	private String email;
	private int age;
	private BloodGroup bloodGroup;
	private String description;
	private String bloodPressure;
	private String prescriptionDetails;
	
	//no args constructor
	public Prescription() {
		System.out.println("in prescription");
	}
	
	public Prescription(PrescriptionDto prescription) {
		this.date=prescription.getDate();
		this.imageId=prescription.getImageId();
		this.status=prescription.getStatus();
		this.name=prescription.getName();
		this.email=prescription.getEmail();
		this.age = prescription.getAge();
		this.bloodGroup= prescription.getBloodGroup();
		this.description=prescription.getDescription();
		this.bloodPressure=prescription.getBloodPressure();
		this.prescriptionDetails=prescription.getPrescriptionDetails();
		
	}
	
	//constructor
	public Prescription(LocalDate date, int prescriptionFile) {
		super();
		this.date = date;
		this.imageId = prescriptionFile;
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
	public PatientEntity getPatientId() {
		return patientId;
	}
	public void setPatientId(PatientEntity patientId) {
		this.patientId = patientId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
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

	@Override
	public String toString() {
		return "Prescription [" + ", date=" + date + ", prescriptionFile="
				+ imageId + ", status=" + status + "]";
	}
	
	
	
	
	
}
