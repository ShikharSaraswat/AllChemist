package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.PatientDto;
import com.app.dto.PharmacyDto;
import com.app.entity.Pharmacy;
import com.app.service.IPharmacyService;

@SpringBootTest
public class TestPharmacyLayers {
	
	@Autowired
	private IPharmacyService pharmacyService;
	
	Pharmacy pharma = new Pharmacy();
	PharmacyDto setPharmacy =new PharmacyDto("med", "med@gmail.com", "med1234", "m1234");
	
	@Test
	public void testUpdatePharmacy() {
			
		assertEquals("med1234", pharmacyService.updatePharmacyDetails(setPharmacy).getLicenseNumber());
	}
	

}
