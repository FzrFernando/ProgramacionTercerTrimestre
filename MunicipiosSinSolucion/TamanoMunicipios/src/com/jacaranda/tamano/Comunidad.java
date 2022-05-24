package com.jacaranda.tamano;

import java.util.ArrayList;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;
	
	public Comunidad(String descrip) {
		listMunicipio = new ArrayList<>();
		this.nombre = descrip;
	}
	
	
	
}
