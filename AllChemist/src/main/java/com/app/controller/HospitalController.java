package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HospitalDto;
import com.app.dto.PatientDto;
import com.app.dto.PrescriptionDto;
import com.app.entity.Hospital;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.service.IHospitalService;


@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "http://localhost:3000")
public class HospitalController {
	@Autowired
	private IHospitalService hospitalService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createPrescription(@RequestBody PrescriptionDto prescription) {
		System.out.println(prescription.getPatientId());
		hospitalService.createPrescription(prescription);
		return ResponseEntity.ok(new String("Prescription Added successfully"));
	}

	@GetMapping("/get_history/{id}")
	public ResponseEntity<List<Prescription>> viewHistory(@PathVariable int id){
		//List<Prescription> list = hospitalService.fetchHistory(id);
		return ResponseEntity.ok(hospitalService.fetchHistory(id));
	}
	
	@PostMapping("/create/patient")
	public ResponseEntity<?> createPatient(@RequestBody PatientDto patient){
		
		  PatientEntity newPatient = new PatientEntity();
		  newPatient.setDetails(patient);
		 
		
		return ResponseEntity.ok(hospitalService.createPatient(newPatient).getId());
	}
	
	@PutMapping("/update_details")
	public ResponseEntity<?> updateHospitalDetails(@RequestBody HospitalDto hospital){
		
		HospitalDto updatedHospital=hospitalService.updateHospitalDetails(hospital);
		
		return ResponseEntity.ok(updatedHospital);
	}
}
