package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientDto;
import com.app.entity.PatientEntity;
import com.app.entity.Prescription;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/patient")
//@PreAuthorize("hasRole('PATIENT')")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

	@Autowired
	private IPatientService patientService;

//	@PostMapping(value="/login"
	// consumes = {MediaType.APPLICATION_JSON_VALUE,
	// MediaType.APPLICATION_XML_VALUE},
	// produces = {MediaType.APPLICATION_JSON_VALUE,
	// MediaType.APPLICATION_XML_VALUE}
//	)

//	//@PreAuthorize("hasRole('PATIENT')")		
//	public ResponseEntity<PatientD> authenticatePatient(@RequestBody PatientD person) {
//		System.out.println(person);
//		PatientEntity patient = patientService.getPatientByIdAndPassword(person.getId(), person.getPassword());
//		if (patient != null) {
//			PatientD pat = new PatientD(patient.getId(), patient.getPassword(), patient.getName(),
//					patient.getBloodGroup(), patient.getAddress());
//			return new ResponseEntity<>(pat, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//	}

	@GetMapping("/details/{id}")
	public ResponseEntity<PatientDto> getDetails(@PathVariable int id){
		PatientEntity patient = patientService.findPatientById(id);
		PatientDto p = patient.toBean();
	 //use logger instead of syso
		//if(patient!=null) {
			return ResponseEntity.ok(p);
		
		/*}else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);  /// Resolve : how to handle this ?
		}*/
		
	}

	
	@PutMapping("/update_details")
	//@PreAuthorize("hasRole('PATIENT')")	
	public ResponseEntity<?> updateDetails(@RequestBody PatientDto person) {
		System.out.println(person + "in controller");
		PatientDto p = patientService.updatePatientDetails(person);
		return ResponseEntity.ok(p);
		

	}

	@GetMapping("/history/{id}")
	//@PreAuthorize("hasRole('PATIENT')")	
	public ResponseEntity<List<Prescription>> getPatientHistory(@PathVariable int id) {
		/*
		 * PatientEntity patient = patientService.findPatientById(id);
		 * System.out.println(patient.getHistory()); //HistoryDto history = new
		 * HistoryDto(patient.getHistory());
		 */
		return ResponseEntity.ok(patientService.fetchHistory(id));
	}

}
