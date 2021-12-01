package com.ironhack.raportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RaportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaportServiceApplication.class, args);
	}

}
