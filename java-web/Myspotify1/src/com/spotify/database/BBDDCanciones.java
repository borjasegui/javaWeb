package com.spotify.database;

import java.util.ArrayList;

import com.spotify.models.Cancion;

public class BBDDCanciones {

	public ArrayList<Cancion> canciones = new ArrayList<Cancion>();

	public BBDDCanciones() {
		this.fillcanciones();
	}

	private boolean fillcanciones() {

		canciones.add(new Cancion(1,"Baby one more time", "Britney Spears","./imgs/britney.jpg","./audios/Baby",93.56));
		canciones.add(new Cancion(2,"Baby one more time", "Britney Spears","./imgs/britney.jpg","./audios/Baby",93.56));
		

		return true;
	}
}
