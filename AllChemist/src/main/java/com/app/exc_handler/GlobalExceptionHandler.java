
package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.AdminHandlingException;
import com.app.custom_exceptions.HospitalHandlingException;
import com.app.custom_exceptions.PatientDetailsHandlingException;
import com.app.custom_exceptions.PharmacyDetailsHandlingException;
import com.app.custom_exceptions.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserHandlingException.class) //can be array of  exception within ({})
	public ResponseEntity<?> handleCustomerHandlingException(UserHandlingException e) {
		System.out.println("in cust hand exc " + e);
		return new ResponseEntity<>(new ErrorResponse("Customer Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(PatientDetailsHandlingException.class)
	public ResponseEntity<?> handleAccountHandlingException(PatientDetailsHandlingException e) {
		return new ResponseEntity<>(new ErrorResponse("Account Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(PharmacyDetailsHandlingException.class)
	public ResponseEntity<?> handleAccountHandlingException(PharmacyDetailsHandlingException e) {
		return new ResponseEntity<>(new ErrorResponse("Account Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(HospitalHandlingException.class)
	public ResponseEntity<?> handleAccountHandlingException(HospitalHandlingException e) {
		return new ResponseEntity<>(new ErrorResponse("Account Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(AdminHandlingException.class)
	public ResponseEntity<?> handleAccountHandlingException(AdminHandlingException e) {
		return new ResponseEntity<>(new ErrorResponse("Account Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}
	
}
