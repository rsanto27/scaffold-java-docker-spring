package com.seed.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationFieldError extends StandardError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationFieldError(Integer status, String message, Long timeStamp) {
		super(status, message, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addFields(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	

}
