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
import org.springframework.format.annotation.DateTimeFormat;

import com.app.dto.PatientDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PatientEntity extends BaseEntity {
	@Column(name = "patient_name", length = 50)
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")

	@Column(name = "patient_email", length = 50)
	private String email;
	private float height;
	private float weight;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private LocalDate dateOfBirth;
	@Column(name = "address", length = 150)
	private String address;
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	private String password;
	@JsonIgnoreProperties("patientID")
	@OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL, orphanRemoval = true)
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public PatientDto toBean() {
		PatientDto patientDto = new PatientDto();
		BeanUtils.copyProperties(this, patientDto, "history");
		return patientDto;
	}

	public static PatientEntity toEntity(PatientDto patient) { // field should be with same name
		PatientEntity pat = new PatientEntity();
		BeanUtils.copyProperties(patient, pat, "history");
		return pat;
	}

	public PatientEntity setDetails(PatientDto patient) {
		if (patient.getName() != null) {
			this.setName(patient.getName());
		}
		if (patient.getBloodGroup() != null) {
			this.setBloodGroup(patient.getBloodGroup());
		}
		if (patient.getDateOfBirth() != null) {
			this.setDateOfBirth(patient.getDateOfBirth());
			;
		}
		if (patient.getPassword() != null) {
			this.setPassword(patient.getPassword());
		}
		if (patient.getAddress() != null) {
			this.setAddress(patient.getAddress());
		}
		if (patient.getGender() != null) {
			this.setGender(patient.getGender());
		}
		if (patient.getEmail() != null) {
			this.setEmail(patient.getEmail());
		}
		if (patient.getHeight() != null) {
			this.setHeight(Float.parseFloat(patient.getHeight()));
		}
		if (patient.getWeight() != null) {
			this.setWeight(Float.parseFloat(patient.getWeight()));
		}
		return this;
	}
}
