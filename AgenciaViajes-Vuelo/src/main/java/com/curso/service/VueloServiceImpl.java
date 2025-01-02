package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;

/**
 * Clase VueloServiceImpl
 * Es un servicio que implementa los métodos de la interfaz VueloService
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
@Service
public class VueloServiceImpl implements VueloService {
	@Autowired
	VueloRepository repository;

	/**
	 * Método para mostrar un listado de los vuelos que estén disponibles
	 * 
	 * @param plazasReserva plazas que se quieren reservar
	 * @return List<Vuelo> vuelos que tengas plazas disponibles para esa reserva
	 */
	@Override
	public List<Vuelo> vuelosDisponibles(int plazasReserva) {
		return repository.vuelosDisponibles(plazasReserva);
	}

	/**
	 * Método que actualiza el número de plazas disponibles en base a las plazas reservadas
	 * 
	 * @param idVuelo id del vuelo a actualizar
	 * @param plazasReservadas número de plazas que fueron reservadas para ese vuelo
	 */
	@Override
	public void actualizarVuelo(int idVuelo, int plazasReservadas) {
		Optional<Vuelo> vuelo = repository.findById(idVuelo);
		if(vuelo.isPresent()) {
			Vuelo vueloActualizar = vuelo.get();
			int plazasDisponibles = vueloActualizar.getPlazasDispo() - plazasReservadas;
			vueloActualizar.setPlazasDispo(plazasDisponibles);
			repository.save(vueloActualizar);
		}else {
			throw new IllegalArgumentException("El vuelo con id " + idVuelo + " no existe");
		}
	}

	/**
	 * Método que busca un vuelo por su id
	 * 
	 * @param idVuelo el id del vuelo a buscar
	 * @return Vuelo el vuelo encontrado con el id pasado por parámetro
	 */
	@Override
	public Vuelo obtenerVuelo(int idVuelo) {
		return repository.findById(idVuelo).orElse(null);
	}

}
