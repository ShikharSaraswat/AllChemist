package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.app.dto.HospitalDto;
import com.app.dto.PharmacyDto;
import com.app.entity.Hospital;
import com.app.entity.PatientEntity;
import com.app.entity.Pharmacy;
import com.app.service.IAdminService;
import com.app.service.IPatientService;

@SpringBootTest
public class TestAdminLayers {

	@Autowired
	private IAdminService adminService;
	private HospitalDto hospital = new HospitalDto(4, "kshitij@gmail.com", "kshitij", "kshitij");
	private PharmacyDto pharmacy = new PharmacyDto("meme", "meme@gmail.com", "meme", "meme");

	@Test
	public void testRegisterHospital() {

		HospitalDto h = adminService.registerHospital(hospital);
		assertEquals("kshitij", h.getName());
	}

	@Test
	public void testRegisterPharmacy() {

		PharmacyDto registerPharma = adminService.registerPharmacy(pharmacy);
		assertEquals("meme", registerPharma.getPharmacyName());
	}

	@Test
	public void testDeleteHospital() {

		String removeHospital = adminService.removeHospital(10);
		assertEquals("Hospital Removed", removeHospital);
	}

	@Test
	public void testDeletePharmacy() {
		String removePharma = adminService.removePharmacy(3);
		assertEquals("Pharmacy Removed", removePharma);
	}

}
