package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PharmacyDto;
import com.app.entity.Pharmacy;
import com.app.entity.Prescription;
import com.app.service.IPharmacyService;

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin(origins = "http://localhost:3000")
public class PharmacyController {

		@Autowired
		private IPharmacyService pharmacyService;
		
		
		@GetMapping("/view_prescription/{id}")
		public  ResponseEntity<?> viewPrescription(@PathVariable int id){
			List<Prescription> p = pharmacyService.checkPrescription(id);
			if(p!=null) {
				return ResponseEntity.ok(p);
			}else {
				return  new ResponseEntity<>(HttpStatus.NO_CONTENT);  /// Resolve : how to handle this ?
			}
			
		}
		@CrossOrigin
		@GetMapping("/invalidate_active_prescription/{id}/{imageId}")
		public ResponseEntity<String> invalidatePrescription(@PathVariable int id, @PathVariable int imageId){
			
			return ResponseEntity.ok(pharmacyService.invalidatePrescription(id,imageId));
			
		}
		
		@PutMapping("/update_pharmacy")
		public ResponseEntity<PharmacyDto> updatePharmacy(@RequestBody PharmacyDto pharmacy){
			
			PharmacyDto updatedPharmacy = pharmacyService.updatePharmacyDetails(pharmacy);
			
			return ResponseEntity.ok(updatedPharmacy);
		}
		
}
