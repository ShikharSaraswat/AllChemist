package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class AdminHandlingException extends RuntimeException {
public AdminHandlingException(String mesg) {
	super(mesg);
}
}
