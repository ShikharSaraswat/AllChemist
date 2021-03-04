package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.repository.PatientRepo;
@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
	@Autowired
	private PatientRepo patientDao;
	@Override
	public void createPrescription(int id) {
		PatientEntity p =  patientDao.findById(id).get();
		System.out.println(p);
		Prescription prescription = new Prescription(LocalDate.now(), null);
		
		List<Prescription> pres = p.getHistory();
		pres.add(prescription);
		pres.forEach(System.out::println);
		patientDao.save(p);
		
	}

}
