package com.mjiang.email.service;

import com.mjiang.email.model.EmailRequest;

public interface EmailService {

    public void sendEmail(EmailRequest request);

    public boolean isRunning();

    public void markServiceDown();
}
