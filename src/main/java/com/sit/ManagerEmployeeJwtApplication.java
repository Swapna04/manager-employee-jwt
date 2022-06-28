package com.sit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ManagerEmployeeJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerEmployeeJwtApplication.class, args);
	}

}
