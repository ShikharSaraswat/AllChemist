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
		System.out.println("In updatePatientDetails");
		PatientEntity pat = PatientEntity.toEntity(patient);
		System.out.println(pat+" "+pat.getId());
		PatientEntity patUpdated = patientRepo.save(pat);
		System.out.println(patUpdated+" "+patUpdated.getId());
		return  patUpdated.toBean() ;
	}
	
	
	
	
}
