package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HistoryD;
import com.app.dto.HospitalD;
import com.app.dto.PrescriptionDto;
import com.app.entity.Hospital;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.repository.HospitalDao;
import com.app.repository.PatientRepo;
@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
	@Autowired
	private PatientRepo patientDao;
	@Autowired
	private PrescriptionService prescriptionService;
	@Autowired
	private HospitalDao hospitalDao;
	
	@Override
	public void createPrescription(PrescriptionDto prescription) {
		PatientEntity p =  patientDao.findById(prescription.getPatientId()).get();
		System.out.println(p);
		Prescription newPrescription = new Prescription(prescription);
		newPrescription.setPatientId(p);
		prescriptionService.savePrescription(newPrescription);
		
		
		List<Prescription> pres = p.getHistory(); 
		p.setHistory(pres);
		pres.forEach(System.out::println);
		patientDao.save(p);
		
	}
	@Override
	public List<Prescription> fetchHistory(int id) {
		PatientEntity patient = patientDao.findById(id).get();
		HistoryD history = new HistoryD(patient.getHistory());
		System.out.println(history.getHistory());
		return history.getHistory();
	}
	@Override
	public PatientEntity createPatient(PatientEntity patient) {
		
		return patientDao.save(patient); 
	}
	@Override
	public Hospital updateHospitalDetails(HospitalD hospital) {
		Hospital newHospital= new Hospital();
		newHospital.toBean(hospital);
		
		return hospitalDao.save(newHospital);
	}

}
