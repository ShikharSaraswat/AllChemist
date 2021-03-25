package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.PatientDetailsHandlingException;
import com.app.dto.HistoryDto;
import com.app.dto.PatientDto;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.repository.PatientRepo;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	PatientRepo dao;

	@Override
	public PatientEntity getPatientByIdAndPassword(int id, String password) {

		Optional<PatientEntity> opt = dao.findByIdAndPassword(id, password);
		return opt.orElseThrow(() -> new PatientDetailsHandlingException("Invalid Credentials"));
	}

//	@Override
//	public Optional<Patient> setPatientDetails(int Id, String add) {
//		
//		return dao.setPatientDetails(Id, add);
//	}

	public PatientDto updatePatientDetails(PatientDto patient) {

		System.out.println(patient.getId());
		PatientEntity patientEntity = dao.findById(patient.getId())
				.orElseThrow(() -> new PatientDetailsHandlingException("Patient with given id does not exist"));
		System.out.println(patientEntity + " existing Patient");
		patientEntity.setDetails(patient);
//	BeanUtils.copyProperties(patient, patientEntity);
		patientEntity = dao.save(patientEntity);
		System.out.println(patientEntity);
		return patientEntity.toBean();

	}

//	public PatientD updateDetails(PatientD patient) {
//			
//		 PatientD patientDetails = patientDao.updatePatientDetails(patient);
//		return patientDetails;
//		
//	}

	@Override
	public PatientEntity findPatientById(int id) {

		return dao.findById(id)
				.orElseThrow(() -> new PatientDetailsHandlingException("Patient with given id does not exist"));
	}

	@Override
	public List<Prescription> fetchHistory(int id) {
		PatientEntity patient = dao.findById(id)
				.orElseThrow(() -> new PatientDetailsHandlingException("Patient with given id does not exist"));
		System.out.println(patient.getHistory());
		HistoryDto history = new HistoryDto(patient.getHistory());

		return history.getHistory();
	}

}
