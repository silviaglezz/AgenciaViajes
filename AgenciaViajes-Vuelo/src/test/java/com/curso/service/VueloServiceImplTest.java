package com.curso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesVueloApplication;
import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;

@SpringBootTest(classes = AgenciaViajesVueloApplication.class)
@ContextConfiguration(classes = AgenciaViajesVueloApplication.class)
class VueloServiceImplTest {
	@Autowired
	VueloRepository repository;
	@Autowired
	VueloServiceImpl service;
	
	@BeforeEach 
	public void setUp() {
		repository.save(new Vuelo("Iberia", LocalDate.of(2025,01,15), 150.0, 100));
		repository.save(new Vuelo("Ryanair", LocalDate.of(2025,01,22), 750.0, 16));
	}

	@Test
	public void vuelosDisponiblesTest() {
		List<Vuelo> vuelos = service.vuelosDisponibles(95);
		
		assertNotNull(vuelos);
		assertEquals(1, vuelos.size());
		assertEquals("Iberia", vuelos.get(0).getCompany());
	}

	@Test
	public void actualizarVueloTest() {
		service.actualizarVuelo(1, 10);
		Vuelo vuelo = repository.findById(1).orElse(null);
		
		assertNotNull(vuelo);
		assertEquals(90, vuelo.getPlazasDispo());
	}

	@Test
	public void obtenerVueloTest() {
		Vuelo vuelo = service.obtenerVuelo(1);
		
		assertNotNull(vuelo);
		assertEquals("Iberia", vuelo.getCompany());
	}

}
