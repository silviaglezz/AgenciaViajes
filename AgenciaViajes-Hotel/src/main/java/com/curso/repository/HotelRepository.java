package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Hotel;

/**
 * Interfaz HotelRepository que extiende de JpaRespository
 * Se define un método mediante una Query
 * 
 * @author Silvia González
 * @version 1.0, 30/12/2024
 * @version 2.0, 31/12/2024
 *
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	@Query("SELECT h FROM Hotel h WHERE h.disponible = true")
	List<Hotel> hotelesDisponibles();
	List<Hotel> findByNombre(String nombre);
	Hotel findFirstByNombre(String nombre);
}
