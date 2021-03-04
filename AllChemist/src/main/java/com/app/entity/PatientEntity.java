package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;

import com.app.dto.PatientD;
@Entity
public class PatientEntity extends BaseEntity {
	@Column(name = "patient_name", length = 50)
	private String name;
	private LocalDate dateOfBirth;
	@Column(name = "address", length = 150)
	private String address;
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	private String password;
	@OneToMany(mappedBy = "patientId" , cascade = CascadeType.ALL ,  orphanRemoval = true)
	private List<Prescription> history = new ArrayList<>();

	// no args constructor
	public PatientEntity() {
		System.out.println("in patient constructor");
	}

	// constructor
	public PatientEntity(String name, LocalDate dateOfBirth, String address, BloodGroup bloodGroup,
			List<Prescription> history) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.history = history;
	}

	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<Prescription> getHistory() {
		return history;
	}

	public void setHistory(List<Prescription> history) {
		this.history = history;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", bloodGroup="
				+ bloodGroup + "]";
	}
	
	public PatientD toBean() {
		PatientD  patientDto = new PatientD();
		BeanUtils.copyProperties(this, patientDto,"history");
		return patientDto;
	}
	
	public static PatientEntity toEntity(PatientD patient) { //field should be with same name
		PatientEntity pat = new PatientEntity();
		BeanUtils.copyProperties(patient, pat,"history");
		//patient.
		return pat;
	}
}
