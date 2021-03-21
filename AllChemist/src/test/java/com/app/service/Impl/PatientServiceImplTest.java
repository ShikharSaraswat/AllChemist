package com.app.service.Impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.custom_exceptions.PatientDetailsHandlingException;
import com.app.dto.PatientDto;
import com.app.entity.BloodGroup;
import com.app.entity.PatientEntity;
import com.app.repository.PatientRepo;
import com.app.service.PatientServiceImpl;


public class PatientServiceImplTest {

	// implementation class where mock object injection is done
	@InjectMocks
	PatientServiceImpl patientService;

	// creating mock object ref and give desired to return op
	@Mock
	PatientRepo patientRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void getPatientByIdAndPassword() {

		PatientEntity patientEntity = new PatientEntity("tejas", LocalDate.parse("2020-11-11"), "Nagothane",
				BloodGroup.A_POSITIVE, null);
		patientEntity.setHeight(5.9f);
		patientEntity.setWeight(78);

		// method to return patient entity when method is called
		when(patientRepository.findByIdAndPassword(anyInt(), anyString())).thenReturn(Optional.of(patientEntity));
		System.out.println("sdfafa");
		PatientEntity pEntity = patientService.getPatientByIdAndPassword(1, "abc@gmail.com");
		
		assertNotNull(pEntity);
		assertEquals("tejas", pEntity.getName());

	}



	@Test
	final void getupdatePatientDetails() {
		PatientEntity patientEntity = new PatientEntity("tejas", LocalDate.parse("2020-11-11"), "Nagothane",
				BloodGroup.A_POSITIVE, null);
		patientEntity.setHeight(5.9f);
		patientEntity.setWeight(78);

		when(patientRepository.findById(anyInt())).thenReturn(Optional.of(patientEntity));
		PatientEntity pEntity = patientService.findPatientById(133);
		

		assertNotNull(pEntity);
		assertEquals("tejas", pEntity.getName());
	}

}
