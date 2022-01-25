package com.arg.prog.disney.repository;

import org.springframework.data.repository.CrudRepository;

import com.arg.prog.disney.models.Personaje;

public interface PersonajeRepository extends CrudRepository<Personaje, Long> {

}
