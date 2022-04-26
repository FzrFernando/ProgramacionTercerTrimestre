package com.jacaranda.diccionario;

import java.util.LinkedList;

public class Diccionario {

	private LinkedList<PalabrasEmpiezan> letras;

	public Diccionario() {
		super();
		letras = new LinkedList<PalabrasEmpiezan>();
		inicializa();

	}

	private void inicializa() {
		for (int i = 65; i <= 90; i++) {
			PalabrasEmpiezan aux = new PalabrasEmpiezan((char) i);
			letras.add(aux);
		}
	}

	public boolean annadirPalabra(String palabra, String significado) throws Exception {
		boolean resul = false;
		Character aux=(palabra.charAt(0));
		PalabrasEmpiezan primeraLetra = new PalabrasEmpiezan(aux);
		int pos = letras.indexOf(primeraLetra);
		if (pos < 0) {
			throw new Exception("Caracter no válido");
		} else {
			letras.get(pos).addPalabra(palabra, significado);
			resul = true;
		}
		return resul;
	}

	public boolean borrarPalabra(String palabra) throws Exception {
		boolean resul = false;
		Character aux=(palabra.charAt(0));
		PalabrasEmpiezan primeraLetra = new PalabrasEmpiezan(aux);
		int pos = letras.indexOf(primeraLetra);
		if(pos<0) {
			throw new Exception("Carácter no válido");
		}
		else {
			letras.get(pos).delPalabra(palabra);
			resul=true;
		}
		return resul;
	}
	
	@Override
	public String toString() {
		return letras.toString();
	}

}
