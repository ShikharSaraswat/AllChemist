package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.PharmacyDetailsHandlingException;
import com.app.dto.PharmacyDto;
import com.app.entity.PatientEntity;
import com.app.entity.Pharmacy;
import com.app.entity.Prescription;
import com.app.repository.PatientRepo;
import com.app.repository.PharmacyDao;

@Service
@Transactional
public class PharmacyServiceImpl implements IPharmacyService {

	@Autowired
	private PatientRepo patientDao;

	@Autowired
	private PharmacyDao pharmacyDao;

	@Override
	public List<Prescription> checkPrescription(int id) {
		PatientEntity patient = patientDao.findById(id)
				.orElseThrow(() -> new PharmacyDetailsHandlingException("Patient id invalid"));
		List<Prescription> history = patient.getHistory();
		List<Prescription> validPrescriptions = new ArrayList<>();
		//Prescription p = history.get(history.size() - 1);
		history.forEach((p)->{
			if (p.isStatus() == true) {
				validPrescriptions.add(p);
			} 
		});
		return validPrescriptions;
		
	}

	@Override
	public String invalidatePrescription(int id,int imageId) {
		PatientEntity patient = patientDao.findById(id)
				.orElseThrow(() -> new PharmacyDetailsHandlingException("Patient id invalid"));
		List<Prescription> history = patient.getHistory();
		
		//Prescription p = history.get(history.size() - 1);
		history.forEach((p)->{
			if(p.getImageId()==imageId) {
				p.setStatus(false);
			}
		});
//		if (p.isStatus() == true) {
//			p.setStatus(false);
//			patientDao.save(patient);
//			return "Prescription Invalidated";
//		} else {
//			return "Prescription Already Invalidated";
//		}
		return "Prescription Invalidated";
	}

	@Override
	public Pharmacy updatePharmacyDetails(PharmacyDto pharmacy) {

		Pharmacy updatedPharmacy = new Pharmacy();
		updatedPharmacy.toBean(pharmacy);
		return pharmacyDao.save(updatedPharmacy);
	}

}
