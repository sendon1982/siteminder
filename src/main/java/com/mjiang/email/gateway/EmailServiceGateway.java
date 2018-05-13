package com.mjiang.email.gateway;

import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public interface EmailServiceGateway {

    public void sendEmail(EmailRequest request);
}
