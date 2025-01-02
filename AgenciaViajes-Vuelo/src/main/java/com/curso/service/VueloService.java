package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

/**
 * Interfaz VueloService
 * Esta interfaz define los diferentes métodos que se realizarán sobre los vuelos
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
public interface VueloService {
	List<Vuelo> vuelosDisponibles(int plazasReserva);
	void actualizarVuelo(int idVuelo, int plazasReservadas);
	Vuelo obtenerVuelo(int idVuelo);
}
