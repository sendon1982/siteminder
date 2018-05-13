package com.mjiang.email.web.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    private static final String EXCEPTION_MSG = "Exception occurred during processing request";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleGeneralException(HttpServletRequest request, Exception e) {
        logger.error("Unhandled exception for URL : " + request.getRequestURL(), e);
        return new ResponseEntity<>(EXCEPTION_MSG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
