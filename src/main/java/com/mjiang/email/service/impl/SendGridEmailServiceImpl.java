package com.mjiang.email.service.impl;

import com.mjiang.email.gateway.EmailServiceGateway;
import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendGridEmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(SendGridEmailServiceImpl.class);

    private EmailServiceGateway emailServiceGateway;

    private boolean isRunning = true;

    @Override
    public void sendEmail(EmailRequest request) {
        logger.info("Start to send email for {}", request);
        emailServiceGateway.sendEmail(request);
        logger.info("Email sent successfully via SendGrid");
    }

    @Override
    public void markServiceDown() {
        this.isRunning = false;
    }

    public void setEmailServiceGateway(EmailServiceGateway emailServiceGateway) {
        this.emailServiceGateway = emailServiceGateway;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
