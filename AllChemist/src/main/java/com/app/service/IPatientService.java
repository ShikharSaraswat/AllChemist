package com.app.service;

import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Patient;


public interface IPatientService {
	
	 Optional<Patient> getPatientByIdAndPassword(int id, String password);
	 
//	 @Query("UPDATE TABLE patient p set p.address =:add where p.id=:id")
//	Optional<Patient> setPatientDetails(@Param("id") int Id, @Param("add") String add);
}
