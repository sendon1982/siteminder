package com.mjiang.email.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    @Retryable(value= {RemoteAccessException.class}, maxAttempts = 5, backoff = @Backoff(delay = 5000l, multiplier = 1))
    public void retryTest() throws Exception {
        System.out.println("do something...");
        throw new RemoteAccessException("RemoteAccessException....");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("recover....");
    }
}
