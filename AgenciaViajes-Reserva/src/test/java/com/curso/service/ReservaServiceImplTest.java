package com.curso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.inicio.AgenciaViajesReservaApplication;
import com.curso.model.HotelDTO;
import com.curso.model.Reserva;
import com.curso.model.ReservaConVuelo;
import com.curso.model.VueloDTO;
import com.curso.repository.ReservaRepository;

@SpringBootTest(classes = AgenciaViajesReservaApplication.class)
@ContextConfiguration(classes = AgenciaViajesReservaApplication.class)
class ReservaServiceImplTest {
	@Autowired
	private ReservaRepository repository;
	@Autowired
	private ReservaServiceImpl service;

	@BeforeEach
	public void setUp() {
		repository.save(new Reserva("Pepe", "28564738D", 1, 2, 2));
		repository.save(new Reserva("Luz", "27584933F", 2, 2, 4));
		repository.save(new Reserva("Ana", "47584937R", 1, 1, 3));
	}

	@Test
	public void getVueloById() {
		VueloDTO vuelo = service.getVueloById(1);

		assertNotNull(vuelo);
		assertEquals("Iberia", vuelo.getCompany());
	}

	@Test
	public void getHotelById() {
		HotelDTO hotel = service.getHotelById("Bahia Azul");

		assertNotNull(hotel);
		assertEquals("Bahia Azul", hotel.getNombre());

	}

	@Test
	public void registrarReserva() {
		Reserva reserva = new Reserva("Pepe", "28564738D", 1, 2, 2);
		service.registrarReserva(reserva);

		Reserva reservaGuardada = repository.findById(1).orElse(null);
		assertNotNull(reservaGuardada);
		assertEquals(2, reservaGuardada.getTotalPersonas());
	}

	@Test
	public void getReservasPorIdHotel() {
		List<Reserva> reservas = service.getReservasPorIdHotel(3);

		assertNotNull(reservas);
		assertEquals(0, reservas.size());
	}

	@Test
	public void getReservasPorNombreHotel() {
		List<ReservaConVuelo> reservas = service.getReservasPorNombreHotel("Bahia Azul");

		assertNotNull(reservas);
		assertEquals(2, reservas.size());
		assertEquals("Ryanair", reservas.get(0).getVuelo().getCompany());
	}

}
