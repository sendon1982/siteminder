package com.mjiang.email.web.rest;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
	private List<FieldError> fieldErrors = new ArrayList<>();

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	
}
