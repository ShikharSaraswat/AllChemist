package com.app.service;

import com.app.dto.HospitalDto;
import com.app.dto.PharmacyDto;
import com.app.entity.Hospital;
import com.app.entity.Pharmacy;

public interface IAdminService {
	
	HospitalDto registerHospital(HospitalDto hospital);
	
	PharmacyDto registerPharmacy(PharmacyDto pharmacy);
	
	String removeHospital(int id);
	
	String removePharmacy(int id);
	
}
