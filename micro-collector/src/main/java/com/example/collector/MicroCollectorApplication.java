package com.example.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCollectorApplication.class, args);
	}

}
