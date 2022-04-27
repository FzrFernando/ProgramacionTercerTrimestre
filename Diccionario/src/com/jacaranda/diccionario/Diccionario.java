package com.jacaranda.diccionario;

import java.util.ArrayList;
import java.util.List;

public class Diccionario {

	private List<PalabrasEmpiezan> letras;

	public Diccionario() {
		super();
		letras = new ArrayList<PalabrasEmpiezan>();
		inicializa();

	}

	private void inicializa() {
		for (int i = 65; i <= 90; i++) {
			String letraEmpieza = Character.toString(i);
			PalabrasEmpiezan p1 = new PalabrasEmpiezan(letraEmpieza.charAt(0));
			letras.add(p1);
		}
	}

	public boolean annadirPalabra(String palabra, String significado) throws Exception {
		boolean resul = false;
		Character aux=palabra.toUpperCase().charAt(0);
		PalabrasEmpiezan primeraLetra = new PalabrasEmpiezan(aux);
		int pos = this.letras.indexOf(primeraLetra);
		if (pos < 0) {
			throw new Exception("Caracter no válido");
		} else {
			this.letras.get(pos).addPalabra(palabra, significado);
			resul = true;
		}
		return resul;
	}

	public boolean borrarPalabra(String palabra) throws Exception {
		boolean resul = false;
		PalabrasEmpiezan primeraLetra = new PalabrasEmpiezan(palabra.toUpperCase().charAt(0));
		int pos = this.letras.indexOf(primeraLetra);
		if(pos<0) {
			throw new Exception("Carácter no válido");
		}
		else {
			this.letras.get(pos).delPalabra(palabra);
			resul=true;
		}
		return resul;
	}
	
	@Override
	public String toString() {
		return letras.toString();
	}

}
