package com.arg.prog.disney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arg.prog.disney.models.Personaje;

@Repository
@Transactional
public class PersonajeDaoImpl implements PersonajeDao {
	@Lazy
	@Autowired
     PersonajeDao personajeDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Personaje> getPersonajes() {

		String query = "FROM Personaje";
		 
		return entityManager.createQuery(query).getResultList();
	}


	
	

}
