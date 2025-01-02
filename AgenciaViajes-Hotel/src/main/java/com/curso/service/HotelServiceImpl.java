package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

/**
 * Clase HotelServiceImpl
 * Es un servicio que implementa los métodos de la interfaz HotelService
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepository repository;

	/**
	 * Método para obtener los hoteles que estén disponibles
	 * 
	 * @return List<Hotel> una lista de hoteles disponibles
	 */
	@Override
	public List<Hotel> hotelesDisponibles() {
		return repository.hotelesDisponibles();
	}

	/**
	 * Método para obtener hoteles por el nombre
	 * 
	 * @param String nombre nombre de los hoteles a listar
	 * @return List<Hotel> una lista de hoteles con el nombre pasado por parámetro
	 */
	@Override
	public List<Hotel> findByNombre(String nombre) {
		if(nombre != null) {
			return repository.findByNombre(nombre);
		}
		return null;
	}
	
	/**
	 * Método que devuelve un hotel al buscar por su nombre
	 * 
	 * @param nombre el nombre del hotel que queremos buscar
	 * @return Hotel el hotel encontrado
	 */
	@Override
	public Hotel findOneByNombre(String nombre) {
		return repository.findFirstByNombre(nombre);
	}

}
