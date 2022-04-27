package com.jacaranda.diccionario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Palabra {

	private String palabra;
	private Set<String> significado;
	
	public Palabra(String palabra) {
		super();
		this.palabra = palabra;
		this.significado = new HashSet<>();
	}
	
	public Palabra(String palabra, String significado) {
		super();
		this.palabra = palabra;
		this.significado = new HashSet<>();
		this.significado.add(significado);
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public Character getInicialPalabra() {
		return this.getPalabra().charAt(0);
	}

	public void addSignificado(String significado) throws PalabraException {
		if(significado == null) {
			throw new PalabraException("No puede ser nulo");
		}
		else {
			this.significado.add(significado);
			if (!(this.significado.add(significado))) {
				throw new PalabraException ("El significado ya está en la lista");
			}
		}
	}
	
	public void delSignificado(String significado) throws PalabraException {
		if (significado == null) {
			throw new PalabraException("No puede ser nulo");
		}
		else {
			boolean resultado = false;
			Iterator<String> siguiente = this.significado.iterator();
			while (siguiente.hasNext()) {
				String p1 = siguiente.next();
				if(p1.equalsIgnoreCase(significado)) {
					this.significado.remove(significado);
					resultado = true;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", significado=" + significado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra, significado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}
	
	
	
}
