package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HistoryDto;
import com.app.dto.PatientDto;
import com.app.entity.PatientEntity;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/patient")
//@PreAuthorize("hasRole('PATIENT')")	
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

	@SuppressWarnings("unchecked")
	@PutMapping("/update_details")
	//@PreAuthorize("hasRole('PATIENT')")	
	public ResponseEntity<PatientDto> updateDetails(@RequestBody PatientDto person) {
		System.out.println(person + "in controller");
		PatientDto p = patientService.updatePatientDetails(person);
		if (p != null) {
			return ResponseEntity.ok(p);
		} else {
			return (ResponseEntity<PatientDto>) ResponseEntity.notFound();
		}

	}

	@GetMapping("/history/{id}")
	//@PreAuthorize("hasRole('PATIENT')")	
	public ResponseEntity<HistoryDto> getPatientHistory(@PathVariable int id) {
		PatientEntity patient = patientService.findPatientById(id);
		HistoryDto history = new HistoryDto();
		history.setHistory(patient.getHistory());


		return ResponseEntity.ok(history);


		

	}

}
