package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IPatientDao;
import com.app.dto.PatientD;
import com.app.entity.PatientEntity;
import com.app.repository.PatientRepo;

@Service
@Transactional
public class PatientService implements IPatientService {
	
	@Autowired 
	PatientRepo dao;
	
	@Autowired
	IPatientDao patientDao;
	
	
	
	@Override
	public Optional<PatientEntity> getPatientByIdAndPassword(int id, String password) {
		return dao.findByIdAndPassword(id,password);
	}

//	@Override
//	public Optional<Patient> setPatientDetails(int Id, String add) {
//		
//		return dao.setPatientDetails(Id, add);
//	}
	
	public PatientEntity updatePatientDetails(PatientD patient) {
		
		PatientEntity patientEntity = new PatientEntity();
		BeanUtils.copyProperties(patient, patientEntity);
		patientEntity = dao.save(patientEntity);
		
		return patientEntity;
		
		
		
	}
	
	public PatientD updateDetails(PatientD patient) {
			
		
		return patientDao.updatePatientDetails(patient);
		
	}

}
