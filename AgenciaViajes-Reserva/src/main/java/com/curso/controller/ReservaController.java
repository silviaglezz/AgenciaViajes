package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.model.ReservaConVuelo;
import com.curso.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Reservas", description = "La API de reservas")
@RestController
public class ReservaController {
	@Autowired
	ReservaService service;
	
	// http://localhost:7000/reservas
	@Operation(summary = "Crear una nueva reserva", description = "Añadir una nueva reserva a la lista", responses = {
			@ApiResponse(responseCode = "201", description = "Reserva creada con éxito"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida") })
	@PostMapping(value="reservas")
	public ResponseEntity<Void> registrarReserva(@RequestBody Reserva reserva) {
		try{
			service.registrarReserva(reserva);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// http://localhost:7000/reservas/{nombreHotel}
	@Operation(summary = "Listar reservas por nombre de hotel", description = "Listar todas las reservas por el nombre del hotel")
	@GetMapping(value="reservas/{nombreHotel}")
	public ResponseEntity<List<ReservaConVuelo>> getReservasPorNombreHotel(@PathVariable String nombreHotel){
		List<ReservaConVuelo> reservas = service.getReservasPorNombreHotel(nombreHotel);
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
}
