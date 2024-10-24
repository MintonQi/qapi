package com.minton.qapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.minton.qapi"})
public class QapiApplication {

	public static void main(String[] args) {
		System.out.println("mainApplication ---------------");
		SpringApplication.run(QapiApplication.class, args);
	}

}