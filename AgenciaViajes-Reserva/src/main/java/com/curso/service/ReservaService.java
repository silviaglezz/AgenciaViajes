package com.curso.service;

import java.util.List;

import com.curso.model.HotelDTO;
import com.curso.model.Reserva;
import com.curso.model.ReservaConVuelo;
import com.curso.model.VueloDTO;

/**
 * Interfaz ReservaSerice
 * Esta interfaz define los diferentes métodos que se realizarán sobre las reservas
 * Estas reservas interaccionan con los vuelos y los hoteles
 * 
 * @author Silvia González
 * @version 1.0, 31/12/2024
 *
 */
public interface ReservaService {
	public VueloDTO getVueloById(int idVuelo);
	public HotelDTO getHotelById(String nombreHotel);
	public void registrarReserva(Reserva reserva);
	public List<Reserva> getReservasPorIdHotel(int idHotel);
	public List<ReservaConVuelo> getReservasPorNombreHotel(String nombreHotel);
}
