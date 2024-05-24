package com.example.connect_health.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableJpaRepositories(basePackages = "com.example.connect_health.repository")
@EntityScan("com.example.connect_health.model")
public class ConnectHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectHealthApplication.class, args);
	}

}
