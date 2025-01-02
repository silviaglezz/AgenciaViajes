package com.curso.model;

/**
 * Clase HotelDTO que se usa para enviar y recibir datos a las reservas
 * 
 * @author Silvia González
 * @version 1.0, 31/12/2024
 *
 */
public class HotelDTO {
	private int idHotel;
	private String nombre;
	private String categoria;
	private Double precio;
	private boolean disponible;
	
	public int getIdHotel() {
		return idHotel;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
