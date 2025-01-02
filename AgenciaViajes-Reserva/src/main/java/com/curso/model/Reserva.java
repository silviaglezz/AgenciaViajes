package com.curso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Reserva que almacena los datos de las reservas
 * 
 * @author Silvia González
 * @version 1.0, 31/12/2024
 *
 */
@Entity
@Table(name = "reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReserva;
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	private String dni;
	@Column(name = "id_hotel")
	private int idHotel;
	@Column(name = "id_vuelo")
	private int idVuelo;
	@Column(name = "total_personas")
	private int totalPersonas;

	public Reserva() {
		super();
	}
	
	public Reserva(String nombreCliente, String dni, int idHotel, int idVuelo, int totalPersonas) {
		super();
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.totalPersonas = totalPersonas;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getTotalPersonas() {
		return totalPersonas;
	}

	public void setTotalPersonas(int totalPersonas) {
		this.totalPersonas = totalPersonas;
	}
}
