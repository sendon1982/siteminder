package com.mjiang.email.web.rest;

import javax.validation.Valid;
import java.util.regex.Pattern;

import com.mjiang.email.config.AppConfig;
import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.FailOverEmailService;
import com.mjiang.email.service.impl.SendGridEmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    }
}
