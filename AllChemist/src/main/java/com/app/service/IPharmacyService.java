package com.app.service;

import com.app.dto.PharmacyDto;
import com.app.entity.Pharmacy;
import com.app.entity.Prescription;

public interface IPharmacyService {
	
	Prescription checkPrescription(int id);
	
	String invalidatePrescription(int id);
	
	Pharmacy updatePharmacyDetails(PharmacyDto pharmacy);
}
