package com.arg.prog.disney.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.arg.prog.disney.models.Personaje;

public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
	
	Personaje findByNombre(@Param("nombre") String nombre);
	
	Personaje findByEdad(@Param("edad") int edad);

}
