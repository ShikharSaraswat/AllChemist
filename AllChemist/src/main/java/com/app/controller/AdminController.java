package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HospitalD;
import com.app.dto.PharmacyDto;
import com.app.entity.Hospital;
import com.app.entity.Pharmacy;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	
	@PostMapping("/register_hospital")
	public ResponseEntity<Hospital> registerHospital(@RequestBody HospitalD hospital){ // ResponseEntity<?> : why ??
		
		return ResponseEntity.ok(adminService.registerHospital(hospital));
	}
	
	@PostMapping("/register_pharmacy")
	public ResponseEntity<Pharmacy> registerPharmacy(@RequestBody PharmacyDto pharmacy){
		
		return ResponseEntity.ok(adminService.registerPharmacy(pharmacy));
	}
	
	@DeleteMapping("/remove_hospital/{id}")
	public ResponseEntity<String> deleteHospital(@PathVariable int id){
		
			return ResponseEntity.ok(adminService.removeHospital(id));
	}
	
	@DeleteMapping("/remove_pharmacy/{id}")
	public ResponseEntity<String> deletePharmacy(@PathVariable int id){
		
			return ResponseEntity.ok(adminService.removePharmacy(id));
	}
	
}
