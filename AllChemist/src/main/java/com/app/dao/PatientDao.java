package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dto.PatientD;
import com.app.entity.PatientEntity;
import com.app.repository.PatientRepo;

@Repository
public class PatientDao implements IPatientDao {

	@Autowired
	private PatientRepo patientRepo;
	@Override
	public PatientD updatePatientDetails(PatientD patient) {
		// TODO Auto-generated method stub]
		PatientEntity pat = PatientEntity.toEntity(patient);
		PatientEntity patUpdated = patientRepo.saveAndFlush(pat);
		System.out.println(patUpdated);
		return  patUpdated.toBean() ;
	}
	
	
	
	
}
