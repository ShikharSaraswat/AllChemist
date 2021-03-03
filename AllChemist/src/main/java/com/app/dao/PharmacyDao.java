package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Pharmacy;

@Repository
public interface PharmacyDao extends JpaRepository<Pharmacy, Integer> {

}
