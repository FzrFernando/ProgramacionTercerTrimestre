package com.jacaranda.tamano;

import java.util.ArrayList;

public class Municipio {

	private String  descrip;
	private ArrayList <Datos> datos;
	
	public Municipio(String descrip, ArrayList<Datos> datos) {
		super();
		this.descrip = descrip;
		this.datos = datos;
	}

	public String getDescrip() {
		return descrip;
	}
	
	public String mostrarDatos(int anno) {
		StringBuilder datosFinales = new StringBuilder();
		for (Datos d: datos) {
			if (d.getAno()==anno) {
				datosFinales.append(d + "\n");
			}
		}
		return datosFinales.toString();
	}
	
}
