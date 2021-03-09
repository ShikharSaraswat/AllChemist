package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.PatientDetailsHandlingException;
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
	public PatientEntity getPatientByIdAndPassword(int id, String password) {
		
		Optional<PatientEntity> opt = dao.findByIdAndPassword(id,password);
		return opt.orElseThrow(() -> new PatientDetailsHandlingException("Invalid Credentials"));
	}

//	@Override
//	public Optional<Patient> setPatientDetails(int Id, String add) {
//		
//		return dao.setPatientDetails(Id, add);
//	}
	
	public PatientD updatePatientDetails(PatientD patient) {
		
		System.out.println(patient.getId());
		PatientEntity patientEntity = dao.findById(patient.getId()).get();
		System.out.println(patientEntity+" existing Patient");
		patientEntity.setDetails(patient);
//	BeanUtils.copyProperties(patient, patientEntity);
		patientEntity = dao.save(patientEntity);
		System.out.println(patientEntity);
		return patientEntity.toBean();
		
		
		
	}
	
	public PatientD updateDetails(PatientD patient) {
			
		
		return patientDao.updatePatientDetails(patient);
		
	}

	@Override
	public PatientEntity findPatientById(int id) {
	
		return dao.findById(id).get();
	}

}
