package com.departmentmicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition( info = @Info(
		title = "Department microservice",
		description = "Rest API for creating, fetching department",
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
public class DepartmentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMicroserviceApplication.class, args);
	}

}
