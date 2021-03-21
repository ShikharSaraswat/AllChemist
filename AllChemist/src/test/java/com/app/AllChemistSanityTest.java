package com.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.controller.AdminController;
import com.app.controller.AuthController;
import com.app.controller.HospitalController;
import com.app.controller.PatientController;
import com.app.controller.PharmacyController;

@SpringBootTest
class AllChemistSanityTest {
	@Autowired
	private AdminController adminController;
	@Autowired
	private HospitalController hospitalController;
	@Autowired
	private PatientController patientController;
	@Autowired
	private PharmacyController pharmacyController;
	@Autowired
	private AuthController AuthController;
	
	@Test
	void contextLoads() {
		System.out.println("in smoke testing ");
		assertNotNull(adminController);
		assertNotNull(hospitalController);
		assertNotNull(patientController);
		assertNotNull(pharmacyController);
		assertNotNull(AuthController);
	}

}
