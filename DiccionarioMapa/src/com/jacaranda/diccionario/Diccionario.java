package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Diccionario {
	
	private HashMap <String, HashSet<String>> palabras;

	
	public Diccionario() {
		this.palabras = new HashMap<>();
	}
	
	public boolean addPalabra(String palabra, String significado) throws DiccionarioException {
		boolean resultado = true;
		
		HashSet<String> significados = this.palabras.get(noEsNulo(palabra).toUpperCase());
		if(significados==null) {  
			significados = new HashSet<>();
			significados.add(noEsNulo(significado).toUpperCase());
			if(this.palabras.put(palabra.toUpperCase(), significados) == null) {
				resultado = false;
			}
		}else {
			resultado = significados.add(noEsNulo(significado).toUpperCase());
		}
		
		return resultado;
	}
	
	
	public boolean borrarPalabra(String palabra) throws DiccionarioException {
		return this.palabras.remove(noEsNulo(palabra).toUpperCase()) != null;
	}
	
	
	public boolean borrarSignificadoPalabra(String palabra, String significado) throws DiccionarioException {
		return this.palabras.get(noEsNulo(palabra).toUpperCase()).remove(noEsNulo(significado).toUpperCase());
	}
	
	
	private String noEsNulo(String palabra) throws DiccionarioException {
		if(palabra==null) {
			throw new DiccionarioException("No puede ser un valor nulo.");
		}
		return palabra;
	}
	
	
	public String palabrasQueEmpiecen(String cadena) throws DiccionarioException {
		if(cadena==null) {
			throw new DiccionarioException("La cadena no puede ser nula.");
		}
		StringBuilder mensaje = new StringBuilder();
		Iterator iterator = palabras.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if(entry.getKey().toString().startsWith(cadena.toUpperCase())) {
				mensaje.append(entry.getKey() + "\n" + entry.getValue());
			}
		}
		if(mensaje.length()==0) {
			mensaje.append("No existen palabras que empiecen por " + cadena);
		}
		return mensaje.toString();
	}
	
	
	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}
	
	
	
}