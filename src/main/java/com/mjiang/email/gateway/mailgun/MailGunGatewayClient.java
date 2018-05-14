package com.mjiang.email.gateway.mailgun;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Set;

import com.mjiang.email.gateway.EmailServiceGateway;
import com.mjiang.email.gateway.client.BaseGatewayClient;
import com.mjiang.email.model.EmailRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

public class MailGunGatewayClient extends BaseGatewayClient implements EmailServiceGateway {

    private static final Logger logger = LoggerFactory.getLogger(MailGunGatewayClient.class);

    private Environment env;

    @Override
    public void sendEmail(EmailRequest request) {
        String endpoint = env.getProperty("mailgun.api.endpoint");
        String basicAuth = buildHttpBasicAuthHeader("api", env.getProperty("mailgun.api.user.apiKey"));

        // TODO handle cc and bcc
        String path = String.format("%s?from=%s&to=%s&subject=%s&text=%s",
            endpoint,
            request.getFrom(),
            splitSetToStringByComma(request.getTo()),
            encodeString(request.getSubject()),
            encodeString(request.getBody()));

        if (!CollectionUtils.isEmpty(request.getCc())) {
            path = path + "&cc=" + splitSetToStringByComma(request.getCc());
        }

        if (!CollectionUtils.isEmpty(request.getBcc())) {
            path = path + "&bcc=" + splitSetToStringByComma(request.getBcc());
        }

        HttpPost httpPost = createHttpPost(path, basicAuth);

        executeHttpRequest(httpPost);
    }

    private String splitSetToStringByComma(Set<String> emailSet) {
        StringBuilder sb = new StringBuilder();

        for (String email : emailSet) {
            if (sb.length() > 1) {
                sb.append(",");
            }

            sb.append(email);
        }

        return sb.toString();
    }

    private String encodeString(String queryString) {
        try {
            queryString = URLEncoder.encode(queryString, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return queryString;
    }

    private static String buildHttpBasicAuthHeader(String username, String password) {
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        return "Basic " + encodedAuth;
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
