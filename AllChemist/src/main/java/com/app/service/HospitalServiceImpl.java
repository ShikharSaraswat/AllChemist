package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.PatientDetailsHandlingException;
import com.app.dto.HistoryDto;
import com.app.dto.HospitalDto;
import com.app.dto.PrescriptionDto;
import com.app.entity.ERole;
import com.app.entity.Hospital;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.HospitalDao;
import com.app.repository.PatientRepo;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
	@Autowired
	private PatientRepo patientDao;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private PrescriptionServiceImpl prescriptionService;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private RoleRepository roleDao;
	
	@Autowired 
	private UserRepository userDao;

	@Override
	public void createPrescription(PrescriptionDto prescription) {
		PatientEntity p = patientDao.findById(prescription.getPatientId())
				.orElseThrow(() -> new PatientDetailsHandlingException("Patient id invalid"));
		System.out.println(p);
		Prescription newPrescription = new Prescription(prescription);
		newPrescription.setPatientId(p);
		prescriptionService.savePrescription(newPrescription);



	}

	@Override
	public List<Prescription> fetchHistory(int id) {
		PatientEntity patient = patientDao.findById(id)
				.orElseThrow(() -> new PatientDetailsHandlingException("Patient id invalid"));
		HistoryDto history = new HistoryDto(patient.getHistory());
		System.out.println(history.getHistory());
		return history.getHistory();
	}

	@Override
	public PatientEntity createPatient(PatientEntity patient) {
		
		//ce
		if(patientDao.existsByEmail(patient.getEmail())) {
			throw new PatientDetailsHandlingException("Patient with given email id already exists.");
		}
		PatientEntity patientEntity = patientDao.save(patient); //persistent
		Role role = roleDao.save(new Role(ERole.PATIENT)); //assigned role
		User user = new User( patient.getName(),patient.getEmail(), encoder.encode(patient.getPassword()),patientEntity.getId());
		user.getRoles().add(role);
		
		userDao.save(user);
		return  patientEntity;
	}

	@Override
	public Hospital updateHospitalDetails(HospitalDto hospital) {
		Hospital newHospital = new Hospital();
		newHospital.toBean(hospital);

		return hospitalDao.save(newHospital);
	}

}
