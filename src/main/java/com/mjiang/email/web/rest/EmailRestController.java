package com.mjiang.email.web.rest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mjiang.email.exception.RequestValidationException;
import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.FailOverEmailService;
import com.mjiang.email.service.impl.SendGridEmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/email/")
public class EmailRestController {

    private static final Logger logger = LoggerFactory.getLogger(SendGridEmailServiceImpl.class);

    private static final Pattern EMAIL_REGEX = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
    
    private static final int MIN_EMAIL_SUBJECT_LENGTH = 3;
    private static final int MIN_EMAIL_BODY_LENGTH = 5;

    @Autowired
    private FailOverEmailService failOverEmailService;

    @PostMapping(value = "send", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailRequest request, Errors errors) {
        logger.info("Sending email for request {}", request);

        validateEmailRequest(request);

        failOverEmailService.sendEmail(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void setFailOverEmailService(FailOverEmailService failOverEmailService) {
        this.failOverEmailService = failOverEmailService;
    }

    private void validateEmailRequest(EmailRequest emailRequest) {
    	List<FieldError> fieldErrors = new ArrayList<>();
    	
    	validateEmailField(fieldErrors, emailRequest.getFrom(), "from");
		validateEmailField(fieldErrors, emailRequest.getTo(), "to");
		validateEmailField(fieldErrors, emailRequest.getCc(), "cc");
		validateEmailField(fieldErrors, emailRequest.getBcc(), "bcc");
		
		validateSubjectField(fieldErrors, emailRequest.getSubject());
		validateBodyField(fieldErrors, emailRequest.getBody());
    	
    	if (fieldErrors.size() > 0 ) {
        	ValidationError validationError = new ValidationError();
        	validationError.setFieldErrors(fieldErrors);
        	
        	RequestValidationException exception = new RequestValidationException();
        	exception.setValidationError(validationError);
        	throw exception;
    	}
    }
    
	private void validateEmailField(List<FieldError> fieldErrors, Set<String> emailSet, String fieldName) {
		for (String email : emailSet) {
			validateEmailField(fieldErrors, email, fieldName);
		}
	}

	private void validateEmailField(List<FieldError> fieldErrors, String email, String fieldName) {
		if (StringUtils.isEmpty(email)) {
    		FieldError fieldError = new FieldError(fieldName, "this field cannot be empty");
    		fieldErrors.add(fieldError);
    	} else {
    		if (!isValidEmail(email)) {
        		FieldError fieldError = new FieldError(fieldName, "email format is not valid");
        		fieldErrors.add(fieldError);
    		}
    	}
	}
	
	private void validateSubjectField(List<FieldError> fieldErrors, String subject) {
		if (StringUtils.isEmpty(subject)) {
    		FieldError fieldError = new FieldError("subject", "this field cannot be empty");
    		fieldErrors.add(fieldError);
    	} else {
    		if (subject.length() < MIN_EMAIL_SUBJECT_LENGTH) {
        		FieldError fieldError = new FieldError("subject", "this field lenght must be at least " + MIN_EMAIL_SUBJECT_LENGTH);
        		fieldErrors.add(fieldError);
    		}
    	}
	}
	
	private void validateBodyField(List<FieldError> fieldErrors, String subject) {
		if (StringUtils.isEmpty(subject)) {
    		FieldError fieldError = new FieldError("body", "this field cannot be empty");
    		fieldErrors.add(fieldError);
    	} else {
    		if (subject.length() < MIN_EMAIL_BODY_LENGTH) {
        		FieldError fieldError = new FieldError("body", "this field lenght must be at least " + MIN_EMAIL_BODY_LENGTH);
        		fieldErrors.add(fieldError);
    		}
    	}
	}
    
    private boolean isValidEmail(String email) {
    	Matcher matcher = EMAIL_REGEX.matcher(email);
    	if (matcher.find()) {
    		return true;
    	}
    		
    	return false;
    }
}
