package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

/**
 * Interfaz HotelService
 * Esta interfaz define los diferentes métodos que se realizarán sobre los hoteles
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
public interface HotelService {
	List<Hotel> hotelesDisponibles();
	List<Hotel> findByNombre(String nombre);
	Hotel findOneByNombre(String nombre);
}
