package com.api_fipe.api_fipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiFipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFipeApplication.class, args);
	}

}
