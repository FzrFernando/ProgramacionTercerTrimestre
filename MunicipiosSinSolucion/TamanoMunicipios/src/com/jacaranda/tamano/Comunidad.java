package com.jacaranda.tamano;

import java.util.ArrayList;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;
	
	
	public Comunidad(String descrip) {
		this.nombre = descrip;
	}


	public Comunidad(String nombre, ArrayList<Municipio> listMunicipio) {
		super();
		this.nombre = nombre;
		this.listMunicipio = listMunicipio;
	}
	

	
}
