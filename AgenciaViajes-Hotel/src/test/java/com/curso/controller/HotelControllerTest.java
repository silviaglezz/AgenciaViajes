package com.curso.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesHotelApplication;
import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

@SpringBootTest(classes = AgenciaViajesHotelApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = AgenciaViajesHotelApplication.class)
class HotelControllerTest {
	@Autowired
	private TestRestTemplate template;
	@Autowired
	private HotelRepository repository;

	@BeforeEach
	public void setUp() {
		repository.save(new Hotel("Bahia Azul", "resort", 35.0, true));
		repository.save(new Hotel("Casa Pepe", "rural", 45.5, true));
	}

	@Test
	public void testHotelesDisponibles() {
		ResponseEntity<Hotel[]> response = template.getForEntity("/hoteles", Hotel[].class);
		Hotel[] hoteles = response.getBody();

		assertNotNull(hoteles);
		assertEquals(6, hoteles.length); //2 hoteles del setUp y 4 creados en BD
	}
	
	@Test
	void hotelesPorNombreTest() {
		ResponseEntity<Hotel[]> response = template.getForEntity("/hoteles/Bahia Azul", Hotel[].class);
		Hotel[] hoteles = response.getBody();
		
		assertNotNull(hoteles);
		assertEquals(2, hoteles.length); // 1 del setUp y 1 de la BD
		assertEquals("Bahia Azul", hoteles[0].getNombre());
	}

	@Test
	void findFirstByNombreTest() {
		ResponseEntity<Hotel> response = template.getForEntity("/hoteles/nombre/Bahia Azul", Hotel.class);
		Hotel hotel = response.getBody();
		
		assertNotNull(hotel);
		assertEquals("Bahia Azul", hotel.getNombre());
	}

}
