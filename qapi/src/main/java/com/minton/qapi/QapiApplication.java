package com.minton.qapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.minton.qapi.mapper")
public class QapiApplication {

	public static void main(String[] args) {
		System.out.println("mainApplication ---------------");
		SpringApplication.run(QapiApplication.class, args);
	}

}