package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Prescription;
import com.app.repository.PrescriptionDao;
@Service
@Transactional
public class PrescriptionService implements IPrescriptionService {
	
	@Autowired
	PrescriptionDao prescriptionDao;
	@Override
	public void savePrescription(Prescription prescription) {
		
		prescriptionDao.save(prescription);

	}

}
