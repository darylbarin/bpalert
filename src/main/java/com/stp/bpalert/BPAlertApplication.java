package com.stp.bpalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties
public class BPAlertApplication {

	public static void main(String[] args) {
		SpringApplication.run(BPAlertApplication.class, args);
	}

}
