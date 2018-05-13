package com.mjiang.email.exception;

import com.mjiang.email.web.rest.ValidationError;

public class RequestValidationException extends RuntimeException {
	
	private ValidationError validationError;
	
	public ValidationError getValidationError() {
		return validationError;
	}

	public void setValidationError(ValidationError validationError) {
		this.validationError = validationError;
	}

	public RequestValidationException() {
        super();
    }

    public RequestValidationException(String message) {
        super(message);
    }

    public RequestValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
