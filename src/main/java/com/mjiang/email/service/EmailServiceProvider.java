package com.mjiang.email.service;

import java.util.Map;

public class EmailServiceProvider {

    private Map<EmailServiceVendor, EmailService> registeredEmailServiceMap;

    public Map<EmailServiceVendor, EmailService> getRegisteredEmailServiceMap() {
        return registeredEmailServiceMap;
    }

    public void setRegisteredEmailServiceMap(Map<EmailServiceVendor, EmailService> registeredEmailServiceMap) {
        this.registeredEmailServiceMap = registeredEmailServiceMap;
    }
}
