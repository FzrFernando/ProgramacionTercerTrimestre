package com.jacaranda.tamano;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}
	
	public void cargarDatos(String datos) {
		Gson gson = new Gson();
		ArrayList<Comunidad> lista = gson.fromJson(datos, new TypeToken<ArrayList<Comunidad>>() {}.getType());
	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista + "]";
	}
	
	
}
