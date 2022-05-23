package com.jacaranda.loteria;

import java.time.LocalDate;
import java.util.HashMap;

public class Historial {

	private HashMap<LocalDate, Combinacion> historial;
	
	public Historial(HashMap<LocalDate, Combinacion> historial) {
		super();
		this.historial = historial;
	}

	public boolean addSorteo(LocalDate fecha, Combinacion c1) {
		boolean resultado;
		if(historial.containsKey(fecha)) {
			resultado = false;
		}
		else{
			historial.put(fecha, c1);
			resultado = true;
		}
		return resultado;
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion c1) {
		boolean actualizado = false;
		if (historial.containsKey(fecha)) {
			historial.replace(fecha, c1);
			actualizado = true;
		}
		return actualizado;
	}
	
	public boolean borrarSorteo(LocalDate fecha) {
		boolean borrado = false;
		if (historial.containsKey(fecha)) {
			historial.remove(fecha);
			borrado = true;
		}
		return borrado;
	}
	
	public int comprobarAciertos(LocalDate fecha, Combinacion c1) {
		int aciertos = 0;
		if (historial.containsKey(fecha)) {
			if (historial.get(c1) != null) {
				aciertos=c1.comprobarAciertos(c1);
			}
		}
		return aciertos;
	}
	
	
}
