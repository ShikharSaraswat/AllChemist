package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.AdminHandlingException;
import com.app.custom_exceptions.HospitalHandlingException;
import com.app.custom_exceptions.PharmacyDetailsHandlingException;
import com.app.dto.HospitalDto;
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
public class AdminServiceImpl implements IAdminService {
	
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
	public HospitalDto registerHospital(HospitalDto hospital) {
		Hospital newHospital = new Hospital();
		newHospital = newHospital.toBean(hospital); // transforming to Entity from DTO
		Hospital hospitalPersistent = hospitalDao.save(newHospital);
		Role role = roleDao.save(new Role(ERole.HOSPITAL)); // saving role in roles table
		User user = new User(hospitalPersistent.getHospitalName(), hospitalPersistent.getEmail(), encoder.encode(hospitalPersistent.getPassword()),hospitalPersistent.getId());
		user.getRoles().add(role);		// adding Hospital user in users table
		userDao.save(user);
		
		return hospitalPersistent.toBeanDto();
	}

	@Override
	public PharmacyDto registerPharmacy(PharmacyDto pharmacy) {
		Pharmacy newPharmacy = new Pharmacy();
		newPharmacy.toBean(pharmacy);  // converting to pharmacy bean from dto
		//System.out.print(newPharmacy.getId());
		 Pharmacy savedPharmacy = pharmacyDao.save(newPharmacy);
		Role role = roleDao.save(new Role(ERole.PHARMACY));  // persisting role in roles table
		//persisting user in users table
		User user = new User(savedPharmacy.getPharmacyName(), savedPharmacy.getEmail(), encoder.encode(savedPharmacy.getPassword()),savedPharmacy.getId());
		user.getRoles().add(role);
		userDao.save(user);
		//persisting pharmacy in entity table
		 return savedPharmacy.toBeanDto();
	}

	@Override
	public String removeHospital(int id) {
		Hospital hospital = hospitalDao.findById(id).orElseThrow(() -> new AdminHandlingException("Hospital with given id does not exist"));
		hospitalDao.delete(hospital); // deleting hospital 
		User user = userDao.findByUsername(hospital.getHospitalName()).orElseThrow(()-> new HospitalHandlingException("Hospital Does not exist"));
		user.getRoles().forEach(role->roleDao.delete(role));
		userDao.delete(user); // deleting user from users table
		return "Hospital Removed";
	}

	@Override
	public String removePharmacy(int id) {
		Pharmacy pharmacy = pharmacyDao.findById(id).orElseThrow(() -> new AdminHandlingException("Pharmacy with given id does not exist"));
		pharmacyDao.delete(pharmacy); // deleting Pharmacy from entity table
		User user = userDao.findByUsername(pharmacy.getPharmacyName()).orElseThrow(()->new PharmacyDetailsHandlingException("Pharmacy not found"));
		user.getRoles().forEach(role -> roleDao.delete(role));
		userDao.delete(user);  /// deleting pharmacy from users table
		return "Pharmacy Removed";
	}
	
	
}
