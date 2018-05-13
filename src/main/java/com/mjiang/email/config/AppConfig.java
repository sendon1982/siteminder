package com.mjiang.email.config;

import java.util.LinkedHashMap;
import java.util.Map;

import com.mjiang.email.gateway.EmailServiceGateway;
import com.mjiang.email.gateway.mailgun.MailGunGatewayClient;
import com.mjiang.email.gateway.sendgrid.SendGridGatewayClient;
import com.mjiang.email.service.EmailService;
import com.mjiang.email.service.EmailServiceProvider;
import com.mjiang.email.service.EmailServiceVendor;
import com.mjiang.email.service.FailOverEmailService;
import com.mjiang.email.service.impl.MailGunEmailServiceImpl;
import com.mjiang.email.service.impl.SendGridEmailServiceImpl;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public HttpClient httpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        httpClientBuilder.setMaxConnPerRoute(100);
        httpClientBuilder.setMaxConnTotal(200);

        return httpClientBuilder.build();
    }

    @Bean
    public EmailServiceProvider emailServiceProvider() {
        EmailServiceProvider emailServiceProvider = new EmailServiceProvider();

        Map<EmailServiceVendor, EmailService> availableEmailServiceMap = new LinkedHashMap<>();
        availableEmailServiceMap.put(EmailServiceVendor.MAILGUN, mailGunEmailService());
        availableEmailServiceMap.put(EmailServiceVendor.SENDGRID, sendGridEmailService());

        emailServiceProvider.setRegisteredEmailServiceMap(availableEmailServiceMap);

        return emailServiceProvider;
    }

    @Bean
    public FailOverEmailService failOverEmailService() {
        FailOverEmailService failOverEmailService = new FailOverEmailService();
        failOverEmailService.setRegisteredEmailServiceMap(emailServiceProvider().getRegisteredEmailServiceMap());
        return failOverEmailService;
    }

    @Bean
    public EmailService mailGunEmailService() {
        MailGunEmailServiceImpl emailService = new MailGunEmailServiceImpl();
        emailService.setEmailServiceGateway(mailGunGatewayClient());
        return emailService;
    }

    @Bean
    public EmailService sendGridEmailService() {
        SendGridEmailServiceImpl emailService = new SendGridEmailServiceImpl();
        emailService.setEmailServiceGateway(sendGridGatewayClient());
        return emailService;
    }

    @Bean
    public EmailServiceGateway mailGunGatewayClient() {
        MailGunGatewayClient mailGunGatewayClient = new MailGunGatewayClient();
        mailGunGatewayClient.setEnv(environment);
        mailGunGatewayClient.setHttpClient(httpClient());

        return mailGunGatewayClient;
    }

    @Bean
    public EmailServiceGateway sendGridGatewayClient() {
        SendGridGatewayClient sendGridGatewayClient = new SendGridGatewayClient();
        sendGridGatewayClient.setEnv(environment);
        sendGridGatewayClient.setHttpClient(httpClient());

        return sendGridGatewayClient;
    }
}
