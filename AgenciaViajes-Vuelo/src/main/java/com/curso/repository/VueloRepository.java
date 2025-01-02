package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Vuelo;

/**
 * Interfaz VueloRepository que extiende de JpaRepository
 * Se define un método mediante una Query
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 *
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
	@Query("SELECT v FROM Vuelo v WHERE v.plazasDispo >= :plazasReserva")
	List<Vuelo> vuelosDisponibles(int plazasReserva);
}
