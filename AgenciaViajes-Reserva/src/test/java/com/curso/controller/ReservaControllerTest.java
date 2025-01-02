package com.curso.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesReservaApplication;
import com.curso.model.Reserva;
import com.curso.model.ReservaConVuelo;
import com.curso.repository.ReservaRepository;

@SpringBootTest(classes = AgenciaViajesReservaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = AgenciaViajesReservaApplication.class)
class ReservaControllerTest {
	@Autowired
	private TestRestTemplate template;
	@Autowired
	ReservaRepository repository;

	@BeforeEach
	public void setUp() {
		repository.save(new Reserva("Pepe", "28564738D", 1, 2, 2));
		repository.save(new Reserva("Luz", "27584933F", 2, 2, 4));
		repository.save(new Reserva("Ana", "47584937R", 1, 1, 3));
	}

	@Test
	void registrarReservaTest() {
		Reserva reserva = new Reserva("Juan", "12345678A", 3, 2, 2);
		HttpEntity<Reserva> request = new HttpEntity<>(reserva); //Encapsula reserva para ser enviado en la solicitud POST
		ResponseEntity<Void> response = template.postForEntity("/reservas", request, Void.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
		Reserva reservaGuardada = repository.findById(4).orElse(null);
		assertNotNull(reservaGuardada);
		assertEquals("Juan", reservaGuardada.getNombreCliente());
	}

	@Test
	void getReservasPorNombreHotelTest() {
		ResponseEntity<ReservaConVuelo[]> response = template.getForEntity("/reservas/Hostal Pepe",
				ReservaConVuelo[].class);
		ReservaConVuelo[] reservas = response.getBody();
		
		assertNotNull(reservas);
		assertEquals(2, reservas.length); // 1 en setUp y 1 en BD
		assertEquals("Ryanair", reservas[0].getVuelo().getCompany());
	}

}
