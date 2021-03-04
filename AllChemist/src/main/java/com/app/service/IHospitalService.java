package com.app.service;

import java.util.Optional;

import com.app.entity.Hospital;

public interface IHospitalService {
	
	Optional<Hospital> getDoctor(int id,String pass);

}
