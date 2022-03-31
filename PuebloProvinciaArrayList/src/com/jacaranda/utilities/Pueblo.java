package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo>{

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
	}

	private void setCodigo(String codigo) throws PuebloException {
		if (codigo == null || (codigo.length() != 5 && !codigo.chars().allMatch(Character :: isDigit))) {
			throw new PuebloException("El código es nulo o no cumple con la longitud concreta");
		}
		this.codigo = codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if (numeroHabitantes < 0) {
			throw new PuebloException("Tiene que introducir un valor positivo");
		}
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (rentaPerCapita < 0) {
			throw new PuebloException("Tiene que introducir un valor positivo");
		}
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws PuebloException {
		if (superficie < 0) {
			throw new PuebloException("Tiene que introducir un valor positivo");
		}
		this.superficie = superficie;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public int compareTo(Pueblo o) {
		int resultado = 0;
		if (o == null) {
			resultado = -1;
		}
		else {
			resultado = this.nombre.compareTo(o.nombre);
			if (resultado == 0) {
				resultado = this.getCodigo().compareTo(o.getCodigo());
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	
	
	
}
