package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;

/**
 * Interfaz ReservaRepository que extiende de JpaRepository
 * Se define un método mediante una keyword
 * 
 * @author Silvia González
 * @version 1.0, 31/12/2024
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	List<Reserva> findByIdHotel(int idHotel);
}
