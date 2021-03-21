package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.PatientDto;
import com.app.entity.BloodGroup;
import com.app.entity.Gender;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.service.IPatientService;

@SpringBootTest
public class TestPatientLayers {
	
	@Autowired
	private IPatientService patientService;
	
	PatientDto patientDto = new PatientDto(1, "raj");
	PatientDto setPatient = new PatientDto(1, "raj", "raj", "raj@gmail.com","6", "58", Gender.MALE, BloodGroup.B_POSITIVE, "Pune", LocalDate.parse("2020-11-11"));
	
	@Test
	public void testgetPatientName() {
		PatientEntity patient = patientService.findPatientById(1);
		assertEquals("raj", patient.getName());
	}
	
	
	@Test
	public void testUpdateDetails() {
		PatientDto patient = patientService.updatePatientDetails(setPatient);
	
		assertEquals("58.0", patient.getWeight());
	}

	/*
	 * @Test public void testgetPatienHistory() { List<Prescription> patient =
	 * patientService.fetchHistory(1); assertEquals("raj", patient.); }
	 */


}
