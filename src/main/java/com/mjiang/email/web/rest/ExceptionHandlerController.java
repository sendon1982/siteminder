package com.mjiang.email.web.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonParseException;
import com.mjiang.email.exception.RequestValidationException;

@ControllerAdvice
public class ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RequestValidationException.class)
    @ResponseBody
    public ResponseEntity<ValidationError> handleValidationException(HttpServletRequest request, RequestValidationException e) {
        logger.error("Unhandled exception for URL : " + request.getRequestURL(), e);
        return new ResponseEntity<>(e.getValidationError(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ValidationError> processValidationError(HttpMessageNotReadableException ex) {
        ValidationError validationError = new ValidationError();
        validationError.getFieldErrors().add(new FieldError("Http payload", "payload is not valid json for EmailRequest"));
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ValidationError> handleGeneralException(HttpServletRequest request, Exception e) {
        logger.error("Unhandled exception for URL : " + request.getRequestURL(), e);
        ValidationError validationError = new ValidationError();
        validationError.getFieldErrors().add(new FieldError("unknown", "Unknown reason"));
		return new ResponseEntity<>(validationError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
