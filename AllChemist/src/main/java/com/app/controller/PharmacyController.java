package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class PharmacyController {

		@Autowired
		private IPharmacyService pharmacyService;
		
		@SuppressWarnings("unchecked")
		@GetMapping("/view_prescription/{id}")
		public  ResponseEntity<Prescription> viewPrescription(@PathVariable int id){
			Prescription p = pharmacyService.checkPrescription(id);
			if(p!=null) {
				return ResponseEntity.ok(p);
			}else {
				return  (ResponseEntity<Prescription>) ResponseEntity.notFound();  /// Resolve : how to handle this ?
			}
			
		}
		
		@GetMapping("/invalidate_active_prescription/{id}")
		public ResponseEntity<String> invalidatePrescription(@PathVariable int id){
			
			return ResponseEntity.ok(pharmacyService.invalidatePrescription(id));
			
		}
		
		@PutMapping("/update_pharmacy")
		public ResponseEntity<Pharmacy> updatePharmacy(@RequestBody PharmacyDto pharmacy){
			
			Pharmacy updatedPharmacy = pharmacyService.updatePharmacyDetails(pharmacy);
			return ResponseEntity.ok(updatedPharmacy);
		}
}
