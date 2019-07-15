package com.mjiang.email;

import com.mjiang.email.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.Retryable;

@SpringBootApplication
@Retryable
public class MainAppRetry implements CommandLineRunner {

    @Autowired
    private AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(MainAppRetry.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
