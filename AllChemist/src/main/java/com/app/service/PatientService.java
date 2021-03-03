package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PatientDao;
import com.app.entity.Patient;

@Service
@Transactional
public class PatientService implements IPatientService {
	
	@Autowired 
	PatientDao dao;
	
	@Override
	public Optional<Patient> getPatientByIdAndPassword(int id, String password) {
		return dao.findByIdAndPassword(id,password);
	}

//	@Override
//	public Optional<Patient> setPatientDetails(int Id, String add) {
//		
//		return dao.setPatientDetails(Id, add);
//	}

}
