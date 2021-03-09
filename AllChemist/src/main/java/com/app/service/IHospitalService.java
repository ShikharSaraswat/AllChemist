package com.app.service;

import java.util.List;

import com.app.dto.HospitalD;
import com.app.dto.PrescriptionDto;
import com.app.entity.Hospital;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;

public interface IHospitalService {
	

	void createPrescription(PrescriptionDto prescription);
	
	List<Prescription> fetchHistory(int id);
	
	PatientEntity createPatient(PatientEntity patient);
	
	Hospital updateHospitalDetails(HospitalD hospital);
}
