package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.PatientEntity;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity, Integer> {

	Optional<PatientEntity> findByIdAndPassword(int id, String password);
	
//	@Query("UPDATE patient p set p.address =:add where p.id=:id")
//	Optional<Patient> setPatientDetails(@Param("id") int Id, @Param("add") String add);
	
	
	
}
