package com.employeemicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition( info = @Info(
		title = "Employee microservice",
		description = "Rest API for creating, fetching employee",
		version = "1.0.0",
		contact = @Contact(
				name = "Sourav Kumar",
				email = "isauravshing@gmail.com",
				url = "https://sauraevshing-portfolio.netlify.app/"
		),
		license = @License(
				name = "Apache"
		),
		termsOfService = "All rights reserved"
))
public class EmployeeMicroserviceApplication {

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroserviceApplication.class, args);
	}

}
