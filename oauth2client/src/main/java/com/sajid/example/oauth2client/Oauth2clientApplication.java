package com.sajid.example.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration.class}
        )
@ComponentScan("com.sajid.example")

public class Oauth2clientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2clientApplication.class, args);
	}

}
