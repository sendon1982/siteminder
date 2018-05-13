package com.mjiang.email.gateway.sendgrid.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendGridEmailRequest {

    @JsonProperty("personalizations")
    private List<Personalization> personalizations = new ArrayList<>();

    @JsonProperty("from")
    private Recipient from;

    @JsonProperty("content")
    private List<Content> content = new ArrayList<>();

    public List<Personalization> getPersonalizations() {
        return personalizations;
    }

    public void setPersonalizations(List<Personalization> personalizations) {
        this.personalizations = personalizations;
    }

    public Recipient getFrom() {
        return from;
    }

    public void setFrom(Recipient from) {
        this.from = from;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}
