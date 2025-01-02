package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.curso.model")
@EnableJpaRepositories(basePackages = "com.curso.repository")
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service"})
public class AgenciaViajesReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaViajesReservaApplication.class, args);
	}

	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
