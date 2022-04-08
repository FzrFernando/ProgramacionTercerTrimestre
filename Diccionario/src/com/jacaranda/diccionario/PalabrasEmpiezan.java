package com.jacaranda.diccionario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PalabrasEmpiezan {
	
	private char letra;
	private List<Palabra> palabra;
	
	public PalabrasEmpiezan(char letra) {
		super();
		this.letra = letra;
		this.palabra = new LinkedList<>();
	}

	public char getLetra() {
		return letra;
	}

	@Override
	public String toString() {
		return "PalabrasEmpiezan [letra=" + letra + ", palabra=" + palabra + "]";
	}
	
	public void addPalabra(String palabra, String significado) throws PalabrasEmpiezanException, PalabraException {
		if(palabra == null || significado == null) {
			throw new PalabrasEmpiezanException("No puede ser nulo");
		}
		else {
			Iterator<Palabra> siguiente = this.palabra.iterator();
			boolean encontrado = false;
			while(siguiente.hasNext() && !encontrado) {
				Palabra p1 = siguiente.next();
				if (p1.getPalabra().equalsIgnoreCase(palabra)) {
					p1.addSignificado(significado);
				}
				else {
					int posicion = buscarSuSitio(palabra);
					Palabra aux = new Palabra(palabra, significado);
					this.palabra.add(aux);
				}
			}
		}
	}
	
	private int buscarSuSitio(String nuevo) {
		boolean encontradoPosicion = false;
		int pos = 0;
		Iterator<Palabra> it = palabra.iterator();
		Palabra elemento;
		
		while (it.hasNext() && !encontradoPosicion) {
			elemento = it.next();
			if (nuevo.compareTo(elemento.getPalabra()) < 0) {
				encontradoPosicion = true;
			}
			else {
				pos++;
			}
		}
		return pos;
	}
}
