package com.mjiang.email.service.impl;

import com.mjiang.email.gateway.sendgrid.SendGridGatewayClient;
import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.TestUtil;
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
public class SendGridEmailServiceImplIntegrationTest {

    @Autowired
    Environment env;

    SendGridGatewayClient gatewayClient;

    static HttpClient httpClient;

    @BeforeAll
    public static void setUpBeforeClass() {
        httpClient = createHttpClient();
    }

    @BeforeEach
    public void setUp() throws Exception {
        gatewayClient = new SendGridGatewayClient();
        gatewayClient.setHttpClient(httpClient);
        gatewayClient.setEnv(env);
    }

    @Test
    public void sendMail() {
        EmailRequest request = new EmailRequest();
        request.setFrom("sendon1982@sendgrid.com");
        request.setTo(TestUtil.asSet("mjiang@viator.com", "mjiang@tripadvisor.com"));
        request.setCc(TestUtil.asSet("mjiang2@viator.com", "mjiang2@tripadvisor.com"));
        request.setBcc(TestUtil.asSet("sendon1982@gmail.com"));
        request.setSubject("SendGrid Subject");
        request.setBody("SendGrid Body");

        gatewayClient.sendEmail(request);
    }

    static HttpClient createHttpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        httpClientBuilder.setMaxConnPerRoute(100);
        httpClientBuilder.setMaxConnTotal(200);

        return httpClientBuilder.build();
    }
}