package com.app.service;

import java.util.List;

import com.app.dto.PharmacyDto;
import com.app.entity.Pharmacy;
import com.app.entity.Prescription;

public interface IPharmacyService {
	
	List<Prescription> checkPrescription(int id);
	
	String invalidatePrescription(int id,int imageId);
	
	Pharmacy updatePharmacyDetails(PharmacyDto pharmacy);
}
