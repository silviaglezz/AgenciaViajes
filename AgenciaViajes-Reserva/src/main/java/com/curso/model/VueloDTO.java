package com.curso.model;

import java.time.LocalDate;

/**
 * Clase VueloDTO que se usa para enviar y recibir datos a las reservas
 * 
 * @author Silvia González
 * @version 1.0, 31/12/2024
 *
 */
public class VueloDTO {
	private int idVuelo;
	private String company;
	private LocalDate fechaVuelo;
	private Double precio;
	private int plazasDispo;
	
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
