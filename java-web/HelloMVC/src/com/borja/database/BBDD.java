package com.borja.database;

import java.util.ArrayList;

import com.borja.models.Habitacion;
import com.borja.models.Usuario;

//crear singleton
public class BBDD {
	private static BBDD instance = null;
	// esto no
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public ArrayList<Habitacion> Habitaciones = new ArrayList<Habitacion>();

	// crear singleton
	public static final BBDD getInstance() {

		if (instance == null)
			instance = new BBDD();

		return instance;
	}

	// crear singleton
	private BBDD() {
		this.fillUsuarios();
		this.fillHabitaciones();
		this.relacionaruserhab();
	}

	private boolean fillUsuarios() {

		usuarios.add(new Usuario(1, "luisa", "aaa", "prp@gmail.com", null));
		usuarios.add(new Usuario(2, "petra", "aaa", "amaia@gmail.com", null));
		usuarios.add(new Usuario(3, "pedro", "aaa", "ricardorsdp@gmail.com", null));

		return true;
	}

	private boolean fillHabitaciones() {
		Habitaciones.add(new Habitacion(3456, "cantarranas n3", 34));
		Habitaciones.add(new Habitacion(43432, "calle real n45", 200));
		Habitaciones.add(new Habitacion(1234, "ca�ada real n 9", 156));

		return true;
	}

	private boolean relacionaruserhab() {
		usuarios.get(0).setHabitacion(Habitaciones.get(2));
		usuarios.get(1).setHabitacion(Habitaciones.get(1));
		usuarios.get(2).setHabitacion(Habitaciones.get(0));

		return true;
		/*
		 * metodo que en funcion del id me devuelve un objeto usuario concreto si no
		 * existe devuelve null
		 */
	}

	public Usuario getUsuarioById(int id) {
		Usuario usuarioADevolver = null;
		// iteramos por cada usuario y cmparamos su id con el que nos indica

		for (Usuario unUsuario : this.usuarios) {
			if (unUsuario.getId() == id) {
				usuarioADevolver = unUsuario;
				break;
			}

		}

		return usuarioADevolver;
	}

	public Habitacion getHabitacionByHid(int hid) {
		Habitacion habitacionADevolver = null;
		// iteramos por cada usuario y cmparamos su id con el que nos indica

		for (Habitacion unaHabitacion : this.Habitaciones) {

			if (unaHabitacion.getHid() == hid) {

				habitacionADevolver = unaHabitacion;
				break;
			}

		}

		return habitacionADevolver;
	}

	public boolean existeUsuarioPorEmailYPass(String emailrecib, String passrecib) {

		boolean existeusuario = false;

		//
		for (Usuario unUsuario : this.usuarios) {

			if (unUsuario.getEmail().equals(emailrecib) && unUsuario.getPass().equals(passrecib)) {

				existeusuario = true;
				break;
			}

		}

		return existeusuario;
	}

	// nuevo usuario y a�adirle un id nuevo
	public int insertarUsuario(Usuario newUser) {
		int nuevoId = 0;

		nuevoId = this.usuarios.size() + 1;

		newUser.setId(nuevoId);

		this.usuarios.add(newUser);

		return nuevoId;

	}

	public int insertarHabitacion(Habitacion nuevaHabitacion) {
		int nuevoHid = 0;

		nuevoHid = this.Habitaciones.size() + 1;

		nuevaHabitacion.setHid(nuevoHid);

		this.Habitaciones.add(nuevaHabitacion);

		return nuevoHid;
		
	}
}
