package com.mjiang.email.gateway.sendgrid.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class From {

    @JsonProperty("email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}