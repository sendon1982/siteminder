package com.mjiang.email.gateway.sendgrid.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personalization {

    @JsonProperty("to")
    private List<Recipient> to;

    @JsonProperty("cc")
    private List<Recipient> cc;

    @JsonProperty("bcc")
    private List<Recipient> bcc;

    @JsonProperty("subject")
    private String subject;

    public List<Recipient> getTo() {
        return to;
    }

    public void setTo(List<Recipient> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Recipient> getCc() {
        return cc;
    }

    public void setCc(List<Recipient> cc) {
        this.cc = cc;
    }

    public List<Recipient> getBcc() {
        return bcc;
    }

    public void setBcc(List<Recipient> bcc) {
        this.bcc = bcc;
    }
}