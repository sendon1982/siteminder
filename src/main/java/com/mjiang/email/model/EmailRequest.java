package com.mjiang.email.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class EmailRequest {

    @NotBlank(message = "Email from can't empty!")
    @Email
    private String from;

    private Set<String> to = new LinkedHashSet<>();

    private Set<String> cc =  new LinkedHashSet<>();

    private Set<String> bcc = new LinkedHashSet<>();

    @NotNull
    @Size(min = 3)
    private String subject;

    @NotNull
    @Size(min = 5)
    private String body;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Set<String> getTo() {
        return to;
    }

    public void setTo(Set<String> to) {
        this.to = to;
    }

    public Set<String> getCc() {
        return cc;
    }

    public void setCc(Set<String> cc) {
        this.cc = cc;
    }

    public Set<String> getBcc() {
        return bcc;
    }

    public void setBcc(Set<String> bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmailRequest{");
        sb.append("from='").append(from).append('\'');
        sb.append(", to=").append(to);
        sb.append(", cc=").append(cc);
        sb.append(", bcc=").append(bcc);
        sb.append(", subject='").append(subject).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmailRequest that = (EmailRequest) o;
        return Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(cc, that.cc) &&
            Objects.equals(bcc, that.bcc) && Objects.equals(subject, that.subject) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to, cc, bcc, subject, body);
    }
}
