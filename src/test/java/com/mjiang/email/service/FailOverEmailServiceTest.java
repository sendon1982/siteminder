package com.mjiang.email.service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.mjiang.email.exception.UnknownRemoteServerException;
import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.exception.NoRunningEmailServerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.mjiang.email.service.TestUtil.buildEmailRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

class FailOverEmailServiceTest {

    FailOverEmailService emailService;

    @Mock
    EmailService mailGunEmailService;

    @Mock
    EmailService sendGridEmailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        emailService = new FailOverEmailService();
        emailService.setRegisteredEmailServiceMap(sampleEmptyServiceMap());
    }

    @Test
    void test_sendEmail_NoEmailServiceVendor() {
        emailService.setRegisteredEmailServiceMap(sampleEmptyServiceMap());

        try {
            emailService.sendEmail(buildEmailRequest());

        } catch (NoRunningEmailServerException e) {
            assertThat(e, notNullValue());
            assertThat(e.getMessage(), containsString("No registered email server"));
        }

        Mockito.verifyNoMoreInteractions(sendGridEmailService);
        Mockito.verifyNoMoreInteractions(mailGunEmailService);
    }

    @Test
    void test_sendEmail_OneEmailServiceVendor_SendGrid() {
        Mockito.when(sendGridEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        emailService.setRegisteredEmailServiceMap(buildEmailServiceMap(EmailServiceVendor.SENDGRID, sendGridEmailService));

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(sendGridEmailService).isRunning();
        Mockito.verify(sendGridEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));

        Mockito.verifyNoMoreInteractions(sendGridEmailService);
        Mockito.verifyNoMoreInteractions(mailGunEmailService);
    }

    @Test
    void test_sendEmail_OneEmailServiceVendor_MailGun() {
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        emailService.setRegisteredEmailServiceMap(buildEmailServiceMap(EmailServiceVendor.MAILGUN, mailGunEmailService));

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(mailGunEmailService).isRunning();
        Mockito.verify(mailGunEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(mailGunEmailService);

        Mockito.verifyNoMoreInteractions(sendGridEmailService);
    }

    @Test
    void test_sendEmail_TwoEmailServiceVendor_MailGunIsRunning() {
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        Mockito.when(sendGridEmailService.isRunning()).thenReturn(false);
        Mockito.doNothing().when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        registerBothEmailServiceMap();

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(mailGunEmailService).isRunning();
        Mockito.verify(mailGunEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(mailGunEmailService);

        Mockito.verify(sendGridEmailService).isRunning();
        Mockito.verifyNoMoreInteractions(sendGridEmailService);
    }

    @Test
    void test_sendEmail_TwoEmailServiceVendor_SendGridRunning() {
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(false);
        Mockito.doNothing().when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        Mockito.when(sendGridEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        registerBothEmailServiceMap();

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(sendGridEmailService).isRunning();
        Mockito.verify(sendGridEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(sendGridEmailService);

        Mockito.verify(mailGunEmailService).isRunning();
        Mockito.verifyNoMoreInteractions(mailGunEmailService);
    }

    @Test
    void test_sendEmail_TwoEmailServiceVendor_BothRunning_PickMailGun() {
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        Mockito.when(sendGridEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        // Set the localTime to select EmailService index 0, which is mailGunEmailService
        emailService.setLocalTime(LocalTime.parse("10:10:00"));

        registerBothEmailServiceMap();

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(mailGunEmailService).isRunning();
        Mockito.verify(mailGunEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(mailGunEmailService);

        Mockito.verify(sendGridEmailService).isRunning();
        Mockito.verifyNoMoreInteractions(sendGridEmailService);
    }

    @Test
    void test_sendEmail_TwoEmailServiceVendor_BothRunning_PickSendGrid() {
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        Mockito.when(sendGridEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        // Set the localTime to select EmailService index 1, which is sendGridEmailService
        emailService.setLocalTime(LocalTime.parse("10:10:01"));

        registerBothEmailServiceMap();

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(sendGridEmailService).isRunning();
        Mockito.verify(sendGridEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(sendGridEmailService);

        Mockito.verify(mailGunEmailService).isRunning();
        Mockito.verifyNoMoreInteractions(mailGunEmailService);
    }

    @Test
    void test_sendEmail_TwoEmailServiceVendor_BothRunning_MailGunSendEmailFailed() {
        // First time return true during get running services, second time return false after calling #markServiceDown()
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(true, false);
        Mockito.doThrow(new UnknownRemoteServerException("ERROR")).when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        Mockito.when(sendGridEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        // Set the localTime to select EmailService index 0, which is mailGunEmailService
        emailService.setLocalTime(LocalTime.parse("10:10:00"));

        registerBothEmailServiceMap();

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(sendGridEmailService, Mockito.times(2)).isRunning();
        Mockito.verify(sendGridEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(sendGridEmailService);

        Mockito.verify(mailGunEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verify(mailGunEmailService, Mockito.times(2)).isRunning();
        Mockito.verify(mailGunEmailService).markServiceDown();
        Mockito.verifyNoMoreInteractions(mailGunEmailService);
    }

    @Test
    void test_sendEmail_TwoEmailServiceVendor_BothRunning_SendGridSendEmailFailed() {
        Mockito.when(mailGunEmailService.isRunning()).thenReturn(true);
        Mockito.doNothing().when(mailGunEmailService).sendEmail(Mockito.any(EmailRequest.class));

        // First time return true during get running services, second time return false after calling #markServiceDown()
        Mockito.when(sendGridEmailService.isRunning()).thenReturn(true, false);
        Mockito.doThrow(new UnknownRemoteServerException("ERROR")).when(sendGridEmailService).sendEmail(Mockito.any(EmailRequest.class));

        // Set the localTime to select EmailService index 0, which is mailGunEmailService
        emailService.setLocalTime(LocalTime.parse("10:10:01"));

        registerBothEmailServiceMap();

        emailService.sendEmail(buildEmailRequest());

        Mockito.verify(mailGunEmailService, Mockito.times(2)).isRunning();
        Mockito.verify(mailGunEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verifyNoMoreInteractions(mailGunEmailService);

        Mockito.verify(sendGridEmailService).sendEmail(Mockito.argThat(argument -> argument.equals(buildEmailRequest())));
        Mockito.verify(sendGridEmailService, Mockito.times(2)).isRunning();
        Mockito.verify(sendGridEmailService).markServiceDown();
        Mockito.verifyNoMoreInteractions(sendGridEmailService);
    }

    void registerBothEmailServiceMap() {
        Map<EmailServiceVendor, EmailService> registeredEmailServiceMap = buildEmailServiceMap(EmailServiceVendor.MAILGUN, mailGunEmailService);
        registeredEmailServiceMap.putAll(buildEmailServiceMap(EmailServiceVendor.SENDGRID, sendGridEmailService));
        emailService.setRegisteredEmailServiceMap(registeredEmailServiceMap);
    }

    Map<EmailServiceVendor, EmailService> sampleEmptyServiceMap() {
        return null;
    }

    Map<EmailServiceVendor, EmailService> buildEmailServiceMap(EmailServiceVendor emailServiceVendor, EmailService emailService) {
        Map<EmailServiceVendor, EmailService> emailServiceMap = new LinkedHashMap<>();
        emailServiceMap.put(emailServiceVendor, emailService);

        return emailServiceMap;
    }
}