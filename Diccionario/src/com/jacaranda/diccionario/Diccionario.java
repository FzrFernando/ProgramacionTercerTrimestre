package com.jacaranda.diccionario;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Diccionario {

private ArrayList<Letra> letras;

	
	public Diccionario() throws LetraException {
		super();
		this.letras = new ArrayList<>();
		addLetras();
	}
	
	private void addLetras() throws LetraException {
		for(int i=65; i<79; i++) {
			letras.add(new Letra((char)i));
		}
		letras.add(new Letra('?'));
		for(int i=79; i<91; i++) {
			letras.add(new Letra((char)i));
		}
	}
	
	
	public void addPalabra(String palabra, String significado) throws DiccionarioException {
		if(palabra==null || palabra.isBlank() || palabra.isEmpty()) {
			throw new DiccionarioException("La palabra no puede ser nula, estar vac?a o solo contener espacios en blanco.");
		}
		if(significado==null || significado.isBlank() || significado.isEmpty()) {
			throw new DiccionarioException("La definici?n no puede ser nula, ni estar vac?a ni solo contener espacios en blanco.");
		}
		Letra aux;
		try {
			aux = new Letra(Character.toUpperCase(palabra.charAt(0)));
			this.letras.get(this.letras.indexOf(aux)).addPalabra(palabra, significado);
		} catch (LetraException e) {
			throw new DiccionarioException(e.getMessage());
		}
	}
	
	
	public void borrarPalabra(String palabra) throws DiccionarioException {
		if(palabra==null || palabra.isBlank() || palabra.isEmpty()) {
			throw new DiccionarioException("La palabra no puede ser nula, estar vac?a o solo contener espacios en blanco.");
		}
		Letra aux;
		try {
			aux = new Letra(palabra.charAt(0));
			this.letras.get(this.letras.indexOf(aux)).borrarPalabra(palabra);
		} catch (LetraException e) {
			throw new DiccionarioException(e.getMessage());
		}
	}
	

	public String buscarPalabra(String palabra) throws DiccionarioException {
		String mensaje = null;
		if(palabra==null || palabra.isBlank() || palabra.isEmpty()) {
			throw new DiccionarioException("La palabra no puede ser nula, estar vac?a o solo contener espacios en blanco.");
		}
		Letra aux;
		try {
			aux = new Letra(palabra.charAt(0));
			mensaje = this.letras.get(this.letras.indexOf(aux)).buscarPalabra(palabra).toString();
		} catch (LetraException e) {
			throw new DiccionarioException(e.getMessage());
		}
		return mensaje;
	}

	public String listadoPalabrasQueEmpiezanPor(String cadena) throws DiccionarioException {
		String mensaje = null;
		if(cadena==null || cadena.isBlank() || cadena.isEmpty()) {
			throw new DiccionarioException("La palabra no puede ser nula, estar vac?a o solo contener espacios en blanco.");
		}
		Letra aux;
		try {
			aux = new Letra(cadena.charAt(0));
			mensaje = this.letras.get(this.letras.indexOf(aux)).listaPalabras(cadena);
		} catch (LetraException e) {
			throw new DiccionarioException(e.getMessage());
		}
		return mensaje;
	}

	@Override
	public String toString() {
		return "Diccionario [letras=" + letras + "]";
	}
	
	
}
