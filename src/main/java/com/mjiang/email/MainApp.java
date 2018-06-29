package com.mjiang.email;

import java.util.Arrays;
import java.util.UUID;

import com.mjiang.email.config.AppConfig;
import com.mjiang.email.gateway.mailgun.MailGunGatewayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    @Autowired
    private AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {

                if (beanName.equals("httpClient")) {
                    System.out.println(ctx.getBean("httpClient"));
                } else if (beanName.equals("mailGunGatewayClient")) {
                    MailGunGatewayClient mailGunGatewayClient =
                        ctx.getBean("mailGunGatewayClient", MailGunGatewayClient.class);
                    System.out.println(mailGunGatewayClient.getHttpClient());
                }


            }
        };
    }
}
