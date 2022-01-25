package com.arg.prog.disney.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arg.prog.disney.dao.PersonajeDao;
import com.arg.prog.disney.models.Personaje;
import com.arg.prog.disney.repository.PersonajeRepository;

@RestController
public class PersonajeController {

	@Autowired
	PersonajeRepository personajeRepository;

	@Autowired
	private PersonajeDao personajeDao;

	// @RequestMapping(value = "/personaje/{id}", method = RequestMethod.GET)
//	public Personaje getPersonaje(@PathVariable Long id) {
//		Personaje personaje = new Personaje();
//		//personaje.setId(id);
//				personaje.setImagen(
//				"https://www.lapatria.com/sites/default/files/styles/620x/public/imagenprincipal/2013/Nov/mickey09.jpg");
//				personaje.setNombre("Mickey");
//
//		personaje.setEdad(35);
//		personaje.setPeso(50);
//		personaje.setHistoria(
//				"Mickey Mouse es un personaje ficticio de la serie del mismo nombre, emblema de la compañía Disney.Creado el 18 de noviembre de 1928, este ratón tiene un origen disputado");
//		personaje.setIdpeliculas_serie(23L);
//		return personaje;
	// }

	// listar todos los personajes
	@RequestMapping(value = "/characters")
	public List<Personaje> getPersonajes() {
		return personajeDao.getPersonajes();
	}

	// Editar Personaje
	@PutMapping({ "/personaje/{id}" })
	public Personaje updatePersonaje(@PathVariable long id, @RequestBody Personaje personaje) {
		Personaje personajeBD = null;
		Optional<Personaje> optionalPersonaje = this.personajeRepository.findById(Long.valueOf(id));
		if (optionalPersonaje.isPresent()) {
			personajeBD = optionalPersonaje.get();
			personajeBD.setImagen(personaje.getImagen());
			personajeBD.setNombre(personaje.getNombre());
			personajeBD.setEdad(personaje.getEdad());
			personajeBD.setPeso(personaje.getPeso());
			personajeBD.setHistoria(personaje.getHistoria());
			personajeBD.setIdpeliculas_serie(personaje.getIdpeliculas_serie());
			personajeBD = (Personaje) this.personajeRepository.save(personajeBD);
		}
		return personajeBD;
	}

	// Crear Personaje
	@PostMapping({ "/personajes" })
	public Personaje createPersona(@RequestBody Personaje personaje) {
		Personaje personajeBD = null;
		try {
			personajeBD = (Personaje) this.personajeRepository
					.save(new Personaje(personaje.getImagen(), personaje.getNombre(), personaje.getEdad(),
							personaje.getPeso(), personaje.getHistoria(), personaje.getIdpeliculas_serie()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personajeBD;
	}

	// Eliminar Personaje
	@DeleteMapping({ "/personaje/{id}" })
	public void deletePersonaje(@PathVariable long id) {

		try {
			this.personajeRepository.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Buscar Personaje por Nombre
	@RequestMapping(value = "/personaje/{nombre}")
	public ResponseEntity<Personaje> findByNombre(@PathVariable("nombre") String nombre) {
		Personaje personaje = personajeRepository.findByNombre(nombre);

		if (personaje == null) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(personaje);
		}

		return ResponseEntity.status(HttpStatus.OK).body(personaje);

	}
	
	// Buscar Personaje por Edad
		@RequestMapping(value = "/personajes/{edad}")
		public ResponseEntity<Personaje> findByNombre(@PathVariable("edad") int edad) {
			Personaje personaje = personajeRepository.findByEdad(edad);

			if (personaje == null) {
				ResponseEntity.status(HttpStatus.BAD_REQUEST).body(personaje);
			}

			return ResponseEntity.status(HttpStatus.OK).body(personaje);

		}
}
