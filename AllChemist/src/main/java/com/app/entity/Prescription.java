package com.app.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@Lob
	@Column(name = "prescription_file", columnDefinition="BLOB")
	private byte[] prescriptionFile;
	@Column(name = "prescription_status")
	private boolean status;
	
	//no args constructor
	public Prescription() {
		System.out.println("in prescription");
	}
	
	public Prescription(PrescriptionDto prescription) {
		this.date=prescription.getDate();
		this.prescriptionFile=prescription.getPrescriptionFile();
		this.status=prescription.getStatus();
		
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

	@Override
	public String toString() {
		return "Prescription [" + ", date=" + date + ", prescriptionFile="
				+ Arrays.toString(prescriptionFile) + ", status=" + status + "]";
	}
	
	
	
	
	
}
