package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Prescription extends BaseEntity {
	@ManyToOne
	@JoinColumn(name="patient",nullable = false)
	private Patient patientId;
	@Column(name = "issue_date")
	private LocalDate date;
	@Lob
	@Column(name = "prescription_file", columnDefinition="BLOB")
	private byte[] prescriptionFile;
	@Column(name = "prescription_status")
	private boolean status;
	
	//no args constructor
	public Prescription() {
		System.out.println("in prescription");
	}
	//constructor
	public Prescription(LocalDate date, byte[] prescriptionFile) {
		super();
		this.date = date;
		this.prescriptionFile = prescriptionFile;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public byte[] getPrescriptionFile() {
		return prescriptionFile;
	}

	public void setPrescriptionFile(byte[] prescriptionFile) {
		this.prescriptionFile = prescriptionFile;
	}
	public Patient getPatientId() {
		return patientId;
	}
	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
}
