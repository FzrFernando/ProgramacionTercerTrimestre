package com.jacaranda.tamano;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;
	
	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}
	
	public String mostrarLista() {
		Gson gson = new Gson();
		lista = gson.fromJson("tamanoMunicipioComunidad.json", new TypeToken<ArrayList<Comunidad>>(){}.getType());
		String json = gson.toJson(lista);
		return json;
	}
	
}
