package com.organisationmicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition( info = @Info(
		title = "Organisation microservice",
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
public class OrganisationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationMicroserviceApplication.class, args);
	}

}
