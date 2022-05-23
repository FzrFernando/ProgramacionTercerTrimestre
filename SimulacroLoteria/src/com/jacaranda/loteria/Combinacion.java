package com.jacaranda.loteria;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Combinacion {

	private Set<Integer> numeros;
	private Set<Integer> estrellas;
	//He elegido la interfaz Set, ya que no puede tener elementos repetidos.
	
	public Combinacion(Integer n1, Integer n2, Integer n3, Integer n4, Integer n5, Integer e1, Integer e2) throws CombinacionException {
		super();
		numeros = new HashSet<>();
		if (n1 < 1 || n1 > 50 || n2 < 1 || n2 > 50 || n3 < 1 || n3 > 50 || n4 < 1 || n4 > 50 || n5 < 1 || n5 > 50) {
			throw new CombinacionException("Tiene que se entre 1 y 50");
		}
		else {
			numeros.add(n1);
			numeros.add(n2);
			numeros.add(n3);
			numeros.add(n4);
			numeros.add(n5);
		}
		estrellas = new HashSet<>();
		if (e1 < 1 || e1 > 12 || e2 < 1 || e2 > 12) {
			throw new CombinacionException("Tiene que se entre 1 y 12");
		}
		else {
			numeros.add(e1);
			numeros.add(e2);
		}
	}
	
	public String toStringNumeros() {
		StringBuilder cadenafinal = new StringBuilder();
		for (Integer num : numeros){
			cadenafinal.append(num + "-");
		}
		return cadenafinal.toString();
	}
	
	public String toStringEstrellas() {
		StringBuilder cadenafinal = new StringBuilder();
		for (Integer num : estrellas){
			cadenafinal.append(num + "-");
		}
		return cadenafinal.toString();
	}

	public String toStringCompleto() {
		return toStringNumeros() + " Estrellas: " + toStringEstrellas();
	}

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}
	
	public int comprobarAciertos(Combinacion c1) {
		int aciertos = 0;
		Iterator<Integer> numero = numeros.iterator();
		while (numero.hasNext()) {
			if (numero.toString().equals(c1.toStringNumeros())) {
				aciertos++;
			}
		}
		Iterator<Integer> estrella = estrellas.iterator();
		while (estrella.hasNext()) {
			if (estrella.toString().equals(c1.toStringEstrellas())) {
				aciertos++;
			}
		}
		return aciertos;
	}
	
	
	
	
	
	
}
