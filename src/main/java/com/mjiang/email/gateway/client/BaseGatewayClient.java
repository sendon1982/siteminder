package com.mjiang.email.gateway.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.mjiang.email.exception.UnknownRemoteServerException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseGatewayClient {

    private static final Logger logger = LoggerFactory.getLogger(BaseGatewayClient.class);

    protected HttpClient httpClient;

    protected String executeHttpRequest(HttpRequestBase httpRequest) {
        String result = null;

        try {
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseString = getResponseString(httpResponse);
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_ACCEPTED) {
                result = responseString;
            } else {
                throw new UnknownRemoteServerException("Unknown remote server exception");
            }
        } catch (IOException e) {
            throw new UnknownRemoteServerException("Unknown remote server exception", e);
        }

        return result;
    }

    protected HttpPost createHttpPost(String url, String basicAuth) {
        logger.info("POST to URL {}", url);

        HttpPost httpRequest = new HttpPost(url);
        setHttpHeadersCommonConfig(httpRequest, basicAuth);

        return httpRequest;
    }

    private String getResponseString(HttpResponse httpResponse) throws IOException {
        HttpEntity httpEntity = httpResponse.getEntity();

        String responseString = getStringFromInputStream(httpResponse.getEntity().getContent());
        EntityUtils.consume(httpEntity);

        logger.debug("Response is {}", responseString);

        return responseString;
    }

    private String getStringFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }

        return resultStringBuilder.toString();
    }

    private void setHttpHeadersCommonConfig(HttpRequestBase httpRequest, String basicAuth) {
        httpRequest.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        httpRequest.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
        httpRequest.setHeader(HttpHeaders.AUTHORIZATION, basicAuth);
    }
}
