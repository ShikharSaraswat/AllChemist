package com.app.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Hospital;


@Repository
public interface HospitalDao extends JpaRepository<Hospital, Integer>{
	
	Optional<Hospital> findByIdAndPassword(int id, String password);
	
}
