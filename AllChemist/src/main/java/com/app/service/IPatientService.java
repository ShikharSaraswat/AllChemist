package com.app.service;

import java.util.List;

import com.app.dto.PatientDto;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;


public interface IPatientService {
	
	 PatientEntity getPatientByIdAndPassword(int id, String password);
	 
//	 @Query("UPDATE TABLE patient p set p.address =:add where p.id=:id")
//	Optional<Patient> setPatientDetails(@Param("id") int Id, @Param("add") String add);
	 
	// PatientD updateDetails(PatientD patient);
	 
	 PatientDto updatePatientDetails(PatientDto patient);
	 
	 PatientEntity findPatientById(int id);
	 
	 List<Prescription>  fetchHistory(int id);
	 
	// PatientEntity findByEmail(String email);
}
