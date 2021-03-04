package com.app.dto;

import java.time.LocalDate;



import com.app.entity.PatientEntity;

public class PrescriptionDto {
	
	private int id;
	private int patientId;
	
	private LocalDate date;
	
	private byte[] prescriptionFile;
	
	private boolean status;
	
	

	public PrescriptionDto(int id, int patientId, LocalDate date, byte[] prescriptionFile, boolean status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.date = date;
		this.prescriptionFile = prescriptionFile;
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

	public byte[] getPrescriptionFile() {
		return prescriptionFile;
	}

	public void setPrescriptionFile(byte[] prescriptionFile) {
		this.prescriptionFile = prescriptionFile;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
