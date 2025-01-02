package com.curso.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesVueloApplication;
import com.curso.model.Vuelo;

@DataJpaTest
@ContextConfiguration(classes = AgenciaViajesVueloApplication.class)
class VueloRepositoryTest {

	@Autowired
	private VueloRepository repository;

	@BeforeEach 
	public void setUp() {
		repository.save(new Vuelo("Iberia", LocalDate.of(2025,01,15), 150.0, 100));
		repository.save(new Vuelo("Ryanair", LocalDate.of(2025,01,22), 750.0, 56));
	}

	@Test
	void vuelosDisponiblesTest() {
		List<Vuelo> vuelos = repository.vuelosDisponibles(60);

		assertNotNull(vuelos);
		assertEquals(1, vuelos.size());
		assertEquals("Iberia", vuelos.get(0).getCompany());
	}

}
