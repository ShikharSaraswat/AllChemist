package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.AdminHandlingException;
import com.app.dto.HospitalD;
import com.app.dto.PharmacyDto;
import com.app.entity.ERole;
import com.app.entity.Hospital;
import com.app.entity.Pharmacy;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.HospitalDao;
import com.app.repository.PharmacyDao;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class AdminService implements IAdminService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private PharmacyDao pharmacyDao;
	
	@Autowired
	private RoleRepository roleDao;
	
	@Autowired 
	private UserRepository userDao;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public Hospital registerHospital(HospitalD hospital) {
		Hospital newHospital = new Hospital();
		newHospital = newHospital.toBean(hospital);
		Hospital hospitalPersistent = hospitalDao.save(newHospital);
		Role role = roleDao.save(new Role(ERole.HOSPITAL));
		User user = new User(hospital.getName()+""+hospitalPersistent.getId(), hospital.getEmail(), hospital.getPassword());
		user.getRoles().add(role);
		userDao.save(user);
		return hospitalPersistent;
	}

	@Override
	public Pharmacy registerPharmacy(PharmacyDto pharmacy) {
		Pharmacy newPharmacy = new Pharmacy();
		newPharmacy.toBean(pharmacy);
		Role role = roleDao.save(new Role(ERole.HOSPITAL));
		User user = new User(pharmacy.getPharmacyName(), pharmacy.getEmail(), pharmacy.getPassword());
		user.getRoles().add(role);
		userDao.save(user);
		return pharmacyDao.save(newPharmacy);
	}

	@Override
	public String removeHospital(int id) {
		Hospital hospital = hospitalDao.findById(id).orElseThrow(() -> new AdminHandlingException("Hospital with given id does not exist"));
		hospitalDao.delete(hospital);
		return "Hospital Removed";
	}

	@Override
	public String removePharmacy(int id) {
		Pharmacy pharmacy = pharmacyDao.findById(id).orElseThrow(() -> new AdminHandlingException("Pharmacy with given id does not exist"));
		pharmacyDao.delete(pharmacy);
		return "Pharmacy Removed";
	}
	
	
}
