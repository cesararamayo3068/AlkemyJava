package com.arg.prog.disney.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSONAJES")
public class Personaje {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name="ID")
    private Long id;
    @Column(name="IMAGEN")
	private String imagen;
    @Column(name="NOMBRE")
	private String nombre;
    @Column(name="EDAD")
	private int edad;
    @Column(name="PESO")
	private int peso;
    @Column(name="HISTORIA")
	private String historia;
    @Column(name="ID_PELICULAS_SERIES")
	private Long idpeliculas_serie;

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public Long getIdpeliculas_serie() {
		return idpeliculas_serie;
	}

	public void setIdpeliculas_serie(Long idpeliculas_serie) {
		this.idpeliculas_serie = idpeliculas_serie;
	}

}
