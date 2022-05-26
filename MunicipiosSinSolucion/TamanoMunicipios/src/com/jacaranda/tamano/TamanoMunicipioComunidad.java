package com.jacaranda.tamano;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;
	
	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}
	
	public void cargarDatos() {
		Gson gson = new Gson();
		lista = gson.fromJson("tamanoMunicipioComunidad.json", new TypeToken<ArrayList<Comunidad>>(){}.getType());
	}
	
	public String mostrarComunidadesPorAnno(String comunidad, int anno) {
		StringBuilder comunidades = new StringBuilder();
		Iterator<Comunidad> siguiente = this.lista.iterator();
		boolean encontrado = false;
		while(siguiente.hasNext() && !encontrado) {
			Comunidad c = siguiente.next();
			if(c.getNombre().toUpperCase().equalsIgnoreCase(comunidad.toUpperCase())) {
				comunidades.append(c.getNombre()+c.mostrarMunicipios(anno));
				encontrado=true;
			}
		}
		return comunidades.toString();
	}
}
