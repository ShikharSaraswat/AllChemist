package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientD;
import com.app.entity.Patient;
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
		Patient patient = patientService.getPatientByIdAndPassword(person.getId(), person.getPassword()).get();
		if(patient!=null) {
		PatientD pat = new PatientD(patient.getId(), patient.getPassword(), patient.getName(), patient.getBloodGroup(), patient.getAddress());
		return new ResponseEntity<>(pat, HttpStatus.OK);
		}else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
