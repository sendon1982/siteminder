package com.mjiang.email.gateway.sendgrid;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjiang.email.gateway.EmailServiceGateway;
import com.mjiang.email.gateway.client.BaseGatewayClient;
import com.mjiang.email.gateway.sendgrid.model.Content;
import com.mjiang.email.gateway.sendgrid.model.Personalization;
import com.mjiang.email.gateway.sendgrid.model.Recipient;
import com.mjiang.email.gateway.sendgrid.model.SendGridEmailRequest;
import com.mjiang.email.model.EmailRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import static com.mjiang.email.util.JsonUtil.convertToString;

public class SendGridGatewayClient extends BaseGatewayClient implements EmailServiceGateway {

    private static final Logger logger = LoggerFactory.getLogger(SendGridGatewayClient.class);

    private Environment env;

    @Override
    public void sendEmail(EmailRequest request) {
        String endpoint = env.getProperty("sendgrid.api.endpoint");
        String bearerAuthHeader = buildHttpBearerAuthHeader(env.getProperty("sendgrid.api.user.apiKey"));

        HttpPost httpPost = createHttpPost(endpoint, bearerAuthHeader);

        SendGridEmailRequest sendGridEmailRequest = buildSendGridEmailRequest(request);
        String jsonString = convertToString(sendGridEmailRequest);

        httpPost.setEntity(new StringEntity(jsonString, StandardCharsets.UTF_8));

        executeHttpRequest(httpPost);
    }

    private SendGridEmailRequest buildSendGridEmailRequest(EmailRequest request) {
        SendGridEmailRequest sendGridEmailRequest = new SendGridEmailRequest();
        Personalization personalization = buildPersonalization(sendGridEmailRequest);

        buildFrom(request, sendGridEmailRequest);

        buildTo(request, personalization);

        if (!request.getCc().isEmpty()) {
            buildCc(request, personalization);
        }

        if (!request.getBcc().isEmpty()) {
            buildBcc(request, personalization);
        }

        buildSubject(request, personalization);
        buildBody(request, sendGridEmailRequest);

        logger.info("EmailRequest is {}", request);

        return sendGridEmailRequest;
    }

    private Personalization buildPersonalization(SendGridEmailRequest sendGridEmailRequest) {
        List<Personalization> personalizations = new ArrayList<>();
        sendGridEmailRequest.setPersonalizations(personalizations);
        Personalization personalization = new Personalization();
        personalizations.add(personalization);

        return personalization;
    }

    private void buildFrom(EmailRequest request, SendGridEmailRequest sendGridEmailRequest) {
        Recipient from = new Recipient();
        from.setEmail(request.getFrom());
        sendGridEmailRequest.setFrom(from);
    }

    private void buildSubject(EmailRequest request, Personalization personalization) {
        personalization.setSubject(request.getSubject());
    }

    private void buildTo(EmailRequest request, Personalization personalization) {
        List<Recipient> toList = new ArrayList<>();
        personalization.setTo(toList);

        for (String email : request.getTo()) {
            Recipient toRecipient = new Recipient();
            toRecipient.setEmail(email);
            toList.add(toRecipient);
        }
    }

    private void buildCc(EmailRequest request, Personalization personalization) {
        List<Recipient> ccList = new ArrayList<>();
        personalization.setCc(ccList);

        for (String email : request.getCc()) {
            Recipient ccRecipient = new Recipient();
            ccRecipient.setEmail(email);
            ccList.add(ccRecipient);
        }
    }

    private void buildBcc(EmailRequest request, Personalization personalization) {
        List<Recipient> bccList = new ArrayList<>();
        personalization.setBcc(bccList);

        for (String email : request.getBcc()) {
            Recipient bccRecipient = new Recipient();
            bccRecipient.setEmail(email);
            bccList.add(bccRecipient);
        }
    }

    private void buildBody(EmailRequest request, SendGridEmailRequest sendGridEmailRequest) {
        List<Content> contentList = new ArrayList<>();
        Content content = new Content();
        content.setType(ContentType.TEXT_PLAIN.getMimeType());
        content.setValue(request.getBody());
        contentList.add(content);

        sendGridEmailRequest.setContent(contentList);
    }

    private static String buildHttpBearerAuthHeader(String apiKey) {
        return "Bearer " + apiKey;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public Environment getEnv() {
        return env;
    }
}
