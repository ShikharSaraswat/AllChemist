package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientD;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientController  {
	
	@Autowired
	private IPatientService patientService;
	
	@PostMapping(
	        value = "/login"
	      //  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	       // produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	        )
	public ResponseEntity<PatientD> postBody(@RequestBody PatientD person){
		
		System.out.println(person);
		PatientEntity patient = patientService.getPatientByIdAndPassword(person.getId(), person.getPassword()).get();
		if(patient!=null) {
		PatientD pat = new PatientD(patient.getId(), patient.getPassword(), patient.getName(), patient.getBloodGroup(), patient.getAddress());
		return new ResponseEntity<>(pat, HttpStatus.OK);
		}else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
//	@PutMapping("/update_details")
//	public ResponseEntity<PatientD> updateDetails(@RequestBody PatientD person){
//		System.out.println(person + "in controller");
//		PatientD updatedPatient = patientService.updateDetails(person);
//		if(updatedPatient!=null) {
//			return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
//			}else {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//		
//	}
	
	@PutMapping("/update_details")
	public ResponseEntity<PatientD> updateDetails(@RequestBody PatientD person){
		System.out.println(person + "in controller");
		PatientD updatedPatient = patientService.updatePatientDetails(person);
		if(updatedPatient!=null) {
			return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
			}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
	}
}
