package com.curso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesHotelApplication;
import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

@SpringBootTest(classes = AgenciaViajesHotelApplication.class)
@ContextConfiguration(classes = AgenciaViajesHotelApplication.class)
class HotelServiceImplTest {
	@Autowired
	private HotelServiceImpl service;
	@Autowired
	private HotelRepository repository;

	@BeforeEach
	public void setUp() {
		repository.save(new Hotel("Bahia Azul", "resort", 35.0, true));
		repository.save(new Hotel("Casa Pepe", "rural", 45.5, true));
	}

	@Test
	void hotelesDisponiblesTest() {
		List<Hotel> hoteles = service.hotelesDisponibles();

		assertNotNull(hoteles);
		assertEquals(6, hoteles.size()); //2 hoteles del setUp y 4 creados en BD
	}

	@Test
	void findByNombreTest() {
		List<Hotel> hoteles = service.findByNombre("Bahia Azul");

		assertNotNull(hoteles);
		assertEquals(2, hoteles.size()); //1 creado en setUp y otro en BD
		assertEquals("Bahia Azul", hoteles.get(0).getNombre());
	}

	@Test
	void findFirstByNombreTest() {
		Hotel hotel = service.findOneByNombre("Bahia Azul");

		assertNotNull(hotel);
		assertEquals("Bahia Azul", hotel.getNombre());
	}
}
