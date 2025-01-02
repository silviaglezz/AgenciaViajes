package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.HotelDTO;
import com.curso.model.Reserva;
import com.curso.model.ReservaConVuelo;
import com.curso.model.VueloDTO;
import com.curso.repository.ReservaRepository;

/**
 * Clase ReservaServiceImpl Es un servicio que implementa los métodos de la
 * interfaz ReservaService
 * 
 * @author Silvia González
 * @version 1.0, 31/12/2024
 *
 */
@Service
public class ReservaServiceImpl implements ReservaService {
	@Autowired
	RestTemplate template;
	@Autowired
	ReservaRepository repository;

	/**
	 * Método que obtiene un vuelo a partir de su id Se usa el RestTemplate para
	 * obtener el vuelo del servicio de vuelos
	 * 
	 * @param idVuelo el id del vuelo que queremos buscar
	 * @return VueloDTO un vuelo
	 */
	@Override
	public VueloDTO getVueloById(int idVuelo) {
		return template.getForObject("http://localhost:9000/vuelos/vuelo/" + idVuelo, VueloDTO.class);
	}

	/**
	 * Método que obtiene un hotel a partir de su nombre Se usa el RestTemplate para
	 * obtener el hotel del servicio de hoteles
	 * 
	 * @param nombreHotel el nombre del hotel a buscar
	 * @return HotelDTO un hotel
	 */
	@Override
	public HotelDTO getHotelById(String nombreHotel) {
		return template.getForObject("http://localhost:8080/hoteles/nombre/" + nombreHotel, HotelDTO.class);
	}

	/**
	 * Método que registra una reserva Al registrar la reserva se actualizan las
	 * plazas de los vuelos mediante el RestTemplate
	 * 
	 * @param reserva la reserva que se quiere registrar
	 */
	@Override
	public void registrarReserva(Reserva reserva) {
		if(reserva != null) {
			repository.save(reserva);
			
			template.put("http://localhost:9000/vuelos/" + reserva.getIdVuelo() + "/" + reserva.getTotalPersonas(), null,Void.class);
		}else {
			System.out.println("la reserva es nula"); 
		}
		
	}

	/**
	 * Método que devuelve una lista de reservas a partir del id del hotel
	 * 
	 * @param idHotel el id del hotel para obtener sus reservas
	 * @return List<Reserva> una lista de las reservas del hotel buscado
	 */
	@Override
	public List<Reserva> getReservasPorIdHotel(int idHotel) {
		return repository.findByIdHotel(idHotel);
	}

	/**
	 * Método que devuelve una lista de reservas a partir del nombre del hotel
	 * 
	 * @param nombreHotel el nombre del hotel a buscar para obtener sus reservas
	 * @return List<ReservaConVuelo> una lista de las reservas del hotel buscado por nombre
	 */
	@Override
	public List<ReservaConVuelo> getReservasPorNombreHotel(String nombreHotel) {
		HotelDTO hotel = getHotelById(nombreHotel);
		int idHotel = hotel.getIdHotel();
		List<Reserva> reservas = getReservasPorIdHotel(idHotel);
		
		return reservas.stream().map(reserva ->{
			VueloDTO vuelo = getVueloById(reserva.getIdVuelo());
			ReservaConVuelo reservaConVuelo = new ReservaConVuelo();
			reservaConVuelo.setNombreCliente(reserva.getNombreCliente());
			reservaConVuelo.setDni(reserva.getDni());
			reservaConVuelo.setVuelo(vuelo);			
			
			return reservaConVuelo;
		}).collect(Collectors.toList());
	}

}
