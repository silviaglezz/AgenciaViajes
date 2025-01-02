package com.curso.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Vuelo que almacena los datos de los diferentes vuelos
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 *
 */
@Entity
@Table(name="vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_vuelo")
	private int idVuelo;
	private String company;
	@Column(name="fecha_vuelo")
	private LocalDate fechaVuelo;
	private Double precio;
	@Column(name="plazas_disponibles")
	private int plazasDispo;
	
	public Vuelo() {
		super();
	}

	public Vuelo(String company, LocalDate fechaVuelo, Double precio, int plazasDispo) {
		super();
		this.company = company;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDispo = plazasDispo;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getPlazasDispo() {
		return plazasDispo;
	}

	public void setPlazasDispo(int plazasDispo) {
		this.plazasDispo = plazasDispo;
	}	
}
