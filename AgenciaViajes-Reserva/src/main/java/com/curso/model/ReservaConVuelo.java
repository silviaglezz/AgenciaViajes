package com.curso.model;

/**
 * Clase ReservaConVuelo
 * Esta es una clase auxiliar para el método get de las reservas
 * 
 * @author Silvia González 
 * @version 1.0, 31/12/2024
 *
 */
public class ReservaConVuelo {
    private String nombreCliente;
    private String dni;
    private VueloDTO vuelo;
    
    public ReservaConVuelo() {
		super();
	}

	public ReservaConVuelo(String nombreCliente, String dni, VueloDTO vuelo) {
		super();
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.vuelo = vuelo;
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

    public VueloDTO getVuelo() {
        return vuelo;
    }

    public void setVuelo(VueloDTO vuelo) {
        this.vuelo = vuelo;
    }
}
