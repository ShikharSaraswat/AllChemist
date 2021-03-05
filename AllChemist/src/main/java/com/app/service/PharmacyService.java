package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.repository.PatientRepo;
@Service
@Transactional
public class PharmacyService implements IPharmacyService {

	@Autowired
	PatientRepo patientDao;

	@Override
	public Prescription checkPrescription(int id) {
		List<Prescription> history = patientDao.findById(id).get().getHistory(); 
		Prescription p = history.get(history.size()-1);
		if(p.isStatus()==true) {
		return p;
		}
		else {
			return null;
		}
	}

	@Override
	public String invalidatePrescription(int id) {
		PatientEntity patient = patientDao.findById(id).get();
		List<Prescription> history = patient.getHistory(); 
		Prescription p = history.get(history.size()-1);
		if(p.isStatus()==true) {
			p.setStatus(false);
			patientDao.save(patient);
			return "Prescription Invalidated";
			}
			else {
				return "Prescription Already Invalidated";
			}
	}
	
	

	

}
