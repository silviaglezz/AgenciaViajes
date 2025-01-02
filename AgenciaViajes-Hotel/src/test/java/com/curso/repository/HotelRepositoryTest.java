package com.curso.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesHotelApplication;
import com.curso.model.Hotel;

@DataJpaTest
@ContextConfiguration(classes = AgenciaViajesHotelApplication.class)
class HotelRepositoryTest {
	@Autowired
	private HotelRepository repository;

	@BeforeEach
	public void setUp() {
		repository.save(new Hotel("Bahia Azul", "resort", 35.0, true));
		repository.save(new Hotel("Casa Pepe", "rural", 45.5, true));
	}

	@Test
	void hotelesDisponiblesTest() {
		List<Hotel> hoteles = repository.hotelesDisponibles();

		assertNotNull(hoteles);
		assertEquals(2, hoteles.size());
	}

	@Test
	void findByNombreTest() {
		List<Hotel> hoteles = repository.findByNombre("Bahia Azul");

		assertNotNull(hoteles);
		assertEquals(1, hoteles.size());
		assertEquals("Bahia Azul", hoteles.get(0).getNombre());
	}

	@Test
	void findFirstByNombreTest() {
		Hotel hotel = repository.findFirstByNombre("Bahia Azul");

		assertNotNull(hotel);
		assertEquals("Bahia Azul", hotel.getNombre());
	}

}
