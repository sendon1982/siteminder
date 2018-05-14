package com.mjiang.email.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mjiang.email.exception.UnknownRemoteServerException;
import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.exception.NoRunningEmailServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

public class FailOverEmailService {

    private static final Logger logger = LoggerFactory.getLogger(FailOverEmailService.class);

    private Map<EmailServiceVendor, EmailService> registeredEmailServiceMap;

    private LocalTime localTime;

    private boolean debug = false;

    public void sendEmail(EmailRequest request) {
        Map<EmailServiceVendor, EmailService> runningEmailServiceMap = getRunningEmailServiceMap();

        boolean success = false;
        int retryCount = 0;

        while (!success && retryCount <= runningEmailServiceMap.size()) {
            EmailServiceVendor emailServiceVendor = getRandomVendor(runningEmailServiceMap);
            EmailService emailService = runningEmailServiceMap.get(emailServiceVendor);

            retryCount++;

            try {
                emailService.sendEmail(request);
                success = true;
            } catch (UnknownRemoteServerException e) {
                logger.error(emailServiceVendor + " email service is not working properly!", e);

                emailService.markServiceDown();
                runningEmailServiceMap = getRunningEmailServiceMap();
                logger.info("Remove email service {} from running email service list", emailServiceVendor);

                logger.info("Choose another running server from list {}", runningEmailServiceMap);
            }
        }
    }

    void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    void setDebug(boolean debug) {
        this.debug = debug;
    }

    private Map<EmailServiceVendor, EmailService> getRunningEmailServiceMap() {
        if (CollectionUtils.isEmpty(registeredEmailServiceMap)) {
            throw new NoRunningEmailServerException("No registered email server");
        }

        Map<EmailServiceVendor, EmailService> runningEmailServiceMap = new LinkedHashMap<>();

        registeredEmailServiceMap.keySet().forEach(emailServiceVendor -> {
            EmailService emailService = registeredEmailServiceMap.get(emailServiceVendor);
            if (emailService.isRunning()) {
                runningEmailServiceMap.put(emailServiceVendor, emailService);
            }
        });

        if (CollectionUtils.isEmpty(runningEmailServiceMap)) {
            throw new NoRunningEmailServerException("No running email server");
        }

        return runningEmailServiceMap;
    }

    private EmailServiceVendor getRandomVendor(Map<EmailServiceVendor, EmailService> runningEmailServiceMap) {
        int runningEmailServiceCount = runningEmailServiceMap.size();

        logger.info("There are {} running email service", runningEmailServiceCount);

        int emailServiceVendorIndex = getRandomNumber(runningEmailServiceCount);

        List<EmailServiceVendor> emailServiceVendors = new ArrayList<>(runningEmailServiceMap.keySet());
        EmailServiceVendor emailServiceVendor = emailServiceVendors.get(emailServiceVendorIndex);

        logger.info("Choose {} as email service vendor to send email", emailServiceVendor);

        return emailServiceVendor;
    }

    private int getRandomNumber(int runningEmailServerCount) {
        if (localTime == null) {
            localTime = LocalTime.now();
        }

        int second = localTime.getSecond();

        if (!debug) {
            second = LocalTime.now().getSecond();
        }

        return (second % runningEmailServerCount);
    }

    public void setRegisteredEmailServiceMap(Map<EmailServiceVendor, EmailService> registeredEmailServiceMap) {
        this.registeredEmailServiceMap = registeredEmailServiceMap;
    }

}
