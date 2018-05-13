package com.mjiang.email.service;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mjiang.email.model.EmailRequest;

public class TestUtil {

    public static Set<String> asSet(String... source) {
        Set<String> set = new LinkedHashSet<>();
        for (String temp : source) {
            set.add(temp);
        }

        return set;
    }

    public static EmailRequest buildEmailRequest() {
        EmailRequest emailRequest = new EmailRequest();

        emailRequest.setFrom(sampleFrom());
        emailRequest.setTo(sampleTo());
        emailRequest.setCc(sampleCc());
        emailRequest.setBcc(sampleBcc());
        emailRequest.setSubject(sampleSubject());
        emailRequest.setBody(sampleBody());

        return emailRequest;
    }

    static String sampleFrom() {
        return "onebyzero@viator.com";
    }

    static Set<String> sampleTo() {
        return Collections.singleton("mjiang@viator.com");
    }

    static Set<String> sampleCc() {
        return Collections.singleton("mjiang_cc@viator.com");
    }

    static Set<String> sampleBcc() {
        return Collections.singleton("mjiang_bcc@viator.com");
    }

    static String sampleSubject() {
        return "Sample subject";
    }

    static String sampleBody() {
        return "Sample body";
    }
}
