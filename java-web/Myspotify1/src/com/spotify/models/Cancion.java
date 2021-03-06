package com.spotify.models;

public class Cancion {
	private int id;
	private String titulo;
	private String autor;
	private String imagen;
	private String mp3;
	private double duracion;
	

	public Cancion(int id, String titulo, String autor, String imagen, String mp3, double duracion) {
		
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.imagen = imagen;
		this.mp3 = mp3;
		this.duracion = duracion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getMp3() {
		return mp3;
	}
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	
}
