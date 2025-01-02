package com.curso.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesReservaApplication;
import com.curso.model.Reserva;

@DataJpaTest
@ContextConfiguration(classes = AgenciaViajesReservaApplication.class)
class ReservaRepositoryTest {
	@Autowired
	private ReservaRepository repository;
	
	@BeforeEach
	public void setUp() {
		repository.save(new Reserva("Pepe", "28564738D", 1, 2, 2));
		repository.save(new Reserva("Luz", "27584933F", 2, 2, 4));
		repository.save(new Reserva("Ana", "47584937R", 1, 1, 3));
	}

	@Test
	void findByIdHotelTest() {
		List<Reserva> reservas = repository.findByIdHotel(1);
		
		assertNotNull(reservas);
		assertEquals(2, reservas.size());
		assertEquals(1, reservas.get(0).getIdHotel());
		assertEquals(1, reservas.get(1).getIdHotel());
	}

}
