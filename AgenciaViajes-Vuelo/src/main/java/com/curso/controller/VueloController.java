package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clase VueloController A través del servicio del vuelo se ejecutan los
 * diferentes métodos de la API de vuelos creada
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
@Tag(name = "Vuelos", description = "La API de vuelos")
@RestController
public class VueloController {
	@Autowired
	VueloService service;

	// http://localhost:9000/vuelos/{plazasReserva}
	@Operation(summary = "Listar vuelos disponibles", description = "Listar todos los vuelos que estén disponibles para ese número de plazas a reservar")
	@GetMapping(value = "vuelos/{plazasReserva}")
	public ResponseEntity<List<Vuelo>> vuelosDisponibles(@PathVariable int plazasReserva) {
		List<Vuelo> vuelos = service.vuelosDisponibles(plazasReserva);
		return new ResponseEntity<>(vuelos, HttpStatus.OK);
	}

	// http://localhost:9000/vuelos/{idVuelo}/{plazasReservadas}
	@Operation(summary = "Actualizar las plazas disponibles de un vuelo", description = "Actualizar las plazas disponibles de un vuelo de la lista", responses = {
			@ApiResponse(responseCode = "200", description = "Vuelo actualizado con éxito"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida") })
	@PutMapping(value = "vuelos/{idVuelo}/{plazasReservadas}") 
	public ResponseEntity<Void> actualizarVuelo(@PathVariable int idVuelo, @PathVariable int plazasReservadas) {
		try {
			service.actualizarVuelo(idVuelo, plazasReservadas);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// http://localhost:9000/vuelos/vuelo/{idVuelo}
	@Operation(summary = "Obtener vuelo por id", description = "Mostrar el vuelo encontrado por el id buscado", responses = {
			@ApiResponse(responseCode = "200", description = "Detalles del vuelo obtenidos con éxito"),
			@ApiResponse(responseCode = "404", description = "Vuelo no encontrado") })
	@GetMapping(value = "vuelos/vuelo/{idVuelo}")
	public ResponseEntity<Vuelo> obtenerVuelo(@PathVariable int idVuelo) {
		Vuelo vuelo = service.obtenerVuelo(idVuelo);
		if (vuelo != null) {
			return new ResponseEntity<>(vuelo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
