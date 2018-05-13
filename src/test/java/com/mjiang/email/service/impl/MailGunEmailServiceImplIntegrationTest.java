package com.mjiang.email.service.impl;

import java.util.Collections;

import com.mjiang.email.gateway.mailgun.MailGunGatewayClient;
import com.mjiang.email.model.EmailRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application-test.properties")
@Tag("IntegrationTest")
public class MailGunEmailServiceImplIntegrationTest {

    @Autowired
    Environment env;

    MailGunGatewayClient gatewayClient;

    static HttpClient httpClient;

    @BeforeAll
    public static void setUpBeforeClass() {
        httpClient = createHttpClient();
    }

    @BeforeEach
    public void setUp() throws Exception {
        gatewayClient = new MailGunGatewayClient();
        gatewayClient.setHttpClient(httpClient);
        gatewayClient.setEnv(env);
    }

    @Test
    public void sendMail() {
        EmailRequest request = new EmailRequest();
        request.setFrom("sendon1982@mailgun.com");

        request.setTo(Collections.singleton("mjiang@tripadvisor.com"));

        request.setCc(Collections.singleton("mjiang@viator.com"));
        request.setBcc(Collections.singleton("mjiang@viator.com"));

        request.setSubject("MailGun Subject");
        request.setBody("MailGun Body");

        gatewayClient.sendEmail(request);
    }

    static HttpClient createHttpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        httpClientBuilder.setMaxConnPerRoute(100);
        httpClientBuilder.setMaxConnTotal(200);

        return httpClientBuilder.build();
    }
}