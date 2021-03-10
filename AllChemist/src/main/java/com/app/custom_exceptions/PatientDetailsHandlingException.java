package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class PatientDetailsHandlingException extends RuntimeException {
public PatientDetailsHandlingException(String mesg) {
	super(mesg);
}
}
