package com.app.service;

import com.app.entity.Prescription;

public interface IPharmacyService {
	
	Prescription checkPrescription(int id);
	
	String invalidatePrescription(int id);
}
