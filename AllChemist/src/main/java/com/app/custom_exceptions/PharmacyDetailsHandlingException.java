package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class PharmacyDetailsHandlingException extends RuntimeException {
public PharmacyDetailsHandlingException(String mesg) {
	super(mesg);
}
}
