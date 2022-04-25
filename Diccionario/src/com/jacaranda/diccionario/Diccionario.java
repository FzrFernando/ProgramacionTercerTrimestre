package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;

public class Diccionario {
	
	private HashMap<String,HashSet<String>> palabras;
	
	public Diccionario() {
		this.palabras = new HashMap<>();
	}
	
	public boolean anadirPalabra(String palabra, String significado) {
		boolean resultado= true;
		//Averiguar si la palabra ya está en el diccionario
		HashSet<String> valor = this.palabras.get(palabra);
		if(valor == null) {
			//Creo el HashSet, le añado el significado y añado al mapa
			HashSet<String> significados = new HashSet<>();
			significados.add(significado);
			if (this.palabras.put(palabra,significados) == null) {
				resultado = false;
			}
		}
		else { //En el caso que la palabra ya esté en el diccionario
			resultado = valor.add(significado);
		}
		return resultado;
	}

	public boolean borrarPalabra(String palabra) {
		boolean resultado;
		if (this.palabras.remove(palabra) == null) {
			resultado = false;
		}
		else {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean borrarSignificadoPalabra(String palabra, String significado) {
		boolean resultado;
		if (this.palabras.get(palabra).remove(significado) == true) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		return resultado;
	}
	
	public String buscarPalabra(String principio) {
		StringBuilder resultado = new StringBuilder();
		for(String clave : palabras.keySet()) {
			if (clave.toUpperCase().startsWith(principio)) {
				resultado.append(clave + "\n");
			}
		}
		return resultado.toString();
	}
	
	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}
	
	
}
