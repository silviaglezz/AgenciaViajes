package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clase HotelController A través del servicio del hotel se ejecutan los
 * diferentes métodos de la API de hoteles creada
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
@Tag(name = "Hoteles", description = "La API de hoteles")
@RestController
public class HotelController {
	@Autowired
	HotelService service;

	// http://localhost:8080/hoteles
	@Operation(summary = "Listar hoteles disponibles", description = "Listar todos los hoteles que estén disponibles")
	@GetMapping(value = "hoteles")
	public ResponseEntity<List<Hotel>> hotelesDisponibles() {
		List<Hotel> hoteles = service.hotelesDisponibles();
		return new ResponseEntity<>(hoteles, HttpStatus.OK);
	}

	// http://localhost:8080/hoteles/{nombre}
	@Operation(summary = "Listar hoteles por nombre", description = "Listar todos los hoteles cuyo nombre sea igual al pasado en la url")
	@GetMapping(value = "hoteles/{nombre}")
	public ResponseEntity<List<Hotel>> hotelesPorNombre(@PathVariable String nombre) {
		List<Hotel> hoteles = service.findByNombre(nombre);
		return new ResponseEntity<>(hoteles, HttpStatus.OK);
	}

	// http://localhost:8080/hoteles/nombre/{nombre}
	@Operation(summary = "Obtener hotel por nombre", description = "Mostrar el hotel encontrado por el nombre buscado", responses = {
			@ApiResponse(responseCode = "200", description = "Detalles del hotel obtenidos con éxito"),
			@ApiResponse(responseCode = "404", description = "Hotel no encontrado") })
	@GetMapping(value = "hoteles/nombre/{nombre}")
	public ResponseEntity<Hotel> obtenerHotel(@PathVariable String nombre) {
		Hotel hotel = service.findOneByNombre(nombre);
		if (hotel != null) {
			return new ResponseEntity<>(hotel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
