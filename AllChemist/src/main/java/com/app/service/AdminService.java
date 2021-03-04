package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HospitalD;
import com.app.dto.PharmacyDto;
import com.app.entity.Hospital;
import com.app.entity.Pharmacy;
import com.app.repository.HospitalDao;
import com.app.repository.PharmacyDao;

@Service
@Transactional
public class AdminService implements IAdminService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private PharmacyDao pharmacyDao;

	@Override
	public Hospital registerHospital(HospitalD hospital) {
		Hospital newHospital = new Hospital();
		newHospital = newHospital.toBean(hospital);
		return hospitalDao.save(newHospital);
	}

	@Override
	public Pharmacy registerPharmacy(PharmacyDto pharmacy) {
		Pharmacy newPharmacy = new Pharmacy();
		newPharmacy.toBean(pharmacy);
		return pharmacyDao.save(newPharmacy);
	}

	@Override
	public String removeHospital(int id) {
		Hospital hospital = hospitalDao.findById(id).get();
		hospitalDao.delete(hospital);
		return "Hospital Removed";
	}

	@Override
	public String removePharmacy(int id) {
		Pharmacy pharmacy = pharmacyDao.findById(id).get();
		pharmacyDao.delete(pharmacy);
		return "Pharmacy Removed";
	}
	
	
}
