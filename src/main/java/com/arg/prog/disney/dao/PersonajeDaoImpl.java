package com.arg.prog.disney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arg.prog.disney.models.Personaje;

@Repository
@Transactional
public class PersonajeDaoImpl implements PersonajeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Personaje> getPersonajes() {

		String query = "FROM Personaje";
		 
		return entityManager.createQuery(query).getResultList();
	}

	
	

}
