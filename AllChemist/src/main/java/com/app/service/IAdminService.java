package com.app.service;

import com.app.dto.HospitalDto;
import com.app.dto.PharmacyDto;
import com.app.entity.Hospital;
import com.app.entity.Pharmacy;

public interface IAdminService {
	
	Hospital registerHospital(HospitalDto hospital);
	
	Pharmacy registerPharmacy(PharmacyDto pharmacy);
	
	String removeHospital(int id);
	
	String removePharmacy(int id);
	
}
