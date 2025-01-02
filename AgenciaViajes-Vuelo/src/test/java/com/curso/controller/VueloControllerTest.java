package com.curso.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesVueloApplication;
import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;

@SpringBootTest(classes = AgenciaViajesVueloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = AgenciaViajesVueloApplication.class)
class VueloControllerTest {
	@Autowired
	private TestRestTemplate template;
	@Autowired
	private VueloRepository repository;

	@BeforeEach 
	public void setUp() {
		repository.save(new Vuelo("Iberia", LocalDate.of(2025,01,15), 150.0, 100));
		repository.save(new Vuelo("Ryanair", LocalDate.of(2025,01,22), 750.0, 56));
	}

	@Test
	public void vuelosDisponiblesTest() {
		ResponseEntity<Vuelo[]> response = template.getForEntity("/vuelos/95", Vuelo[].class);
		Vuelo[] vuelos = response.getBody();

		assertNotNull(vuelos);
		assertEquals(1, vuelos.length);
		assertEquals("Iberia", vuelos[0].getCompany());
	}
	
	@Test
	void actualizarVueloTest() {
		ResponseEntity<Void> response = template.exchange("/vuelos/1/10", HttpMethod.PUT, null, Void.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		Vuelo vuelo = repository.findById(1).orElse(null);
		assertNotNull(vuelo);
		assertEquals(90, vuelo.getPlazasDispo());
	}

	@Test
	void obtenerVueloTest() {
		ResponseEntity<Vuelo> response = template.getForEntity("/vuelos/vuelo/1", Vuelo.class);
		Vuelo vuelo = response.getBody();
		
		assertNotNull(vuelo);
		assertEquals("Iberia", vuelo.getCompany());
	}


}
