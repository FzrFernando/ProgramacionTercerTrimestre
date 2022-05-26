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


	public String getNombre() {
		return nombre;
	}
	
	public String mostrarMunicipios(int anno) {
		StringBuilder resul=new StringBuilder();
		for(Municipio m:listMunicipio) {
			resul.append(m.getDescrip()+m.mostrarDatos(anno));
		}
		return resul.toString();
	}
	
}
