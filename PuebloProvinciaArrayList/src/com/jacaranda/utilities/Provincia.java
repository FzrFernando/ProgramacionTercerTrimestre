package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Provincia {
	private String nombre;
	private String codigo;
	private int numHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private LinkedList<Pueblo> pueblos;

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		if(nombre==null|| codigo==null) {
			throw new ProvinciaException("Nombre o codigo no v�lido");
		}
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.pueblos = new LinkedList<Pueblo>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumHabitantes() {
		return numHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo.length() != 2 || !(codigo.chars().allMatch(Character::isDigit))) {
			throw new ProvinciaException("Codigo no valido");
		}
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	private boolean existePueblo(String nombre) {
		boolean resul = false;
		for (Pueblo p : pueblos) {
			if (p.getNombre().equals(nombre)) {
				resul = true;
			}
		}
		return resul;
	}

	public boolean addPueblo(String nombre, String codigo, int numhabitantes, double renta, double superficie)
			throws PuebloException, ProvinciaException {
		boolean resultado = false;
		String nuevoCodigo=this.codigo+codigo;
		Pueblo aux = new Pueblo(nombre, nuevoCodigo, numhabitantes, renta, superficie);
		if (!existePueblo(aux.getNombre())) {
			pueblos.add(aux);
			this.superficie += aux.getSuperficie();
			this.numHabitantes += aux.getNumeroHabitantes();
			this.rentaPerCapita += aux.getRentaPerCapita();
			resultado = true;
		}
		else {
			throw new ProvinciaException("El pueblo no puede crearse");
		}
		return resultado;
	}

	public String listadoPueblosNombre() {
		StringBuilder resul = new StringBuilder();
		for (Pueblo p : pueblos) {
			resul.append(p.getNombre() + " ");
		}
		return resul.toString();
	}

	public String listadoPueblos() {
		StringBuilder resul = new StringBuilder();
		for (Pueblo p : pueblos) {
			resul.append(p.toString() + " ");
		}
		return resul.toString();
	}

	public boolean delPueblo(String nombre) throws ProvinciaException {
		boolean resul = false;
		if (!existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo no existe");
		}
		for (Pueblo p : pueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				this.superficie -= p.getSuperficie();
				this.numHabitantes -= p.getNumeroHabitantes();
				this.rentaPerCapita -= p.getRentaPerCapita();
				pueblos.remove(p);
				resul = true;
			}
		}
		return resul;
	}

	public boolean setSuperficie(String nombre, double superficie) throws PuebloException {
		boolean resul = false;
		Iterator<Pueblo> iterator=pueblos.iterator();
		while(iterator.hasNext()&& !resul) {
			Pueblo aux=iterator.next();
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				double au=superficie-aux.getSuperficie();
				aux.setSuperficie(superficie);
				this.superficie+=au;
				resul = true;
			}
		}
		return resul;
	}

	public boolean setNumeroHabitantes(String nombre, int numHabitantes) throws PuebloException {
		boolean resul = false;
		Iterator<Pueblo> iterator=pueblos.iterator();
		while(iterator.hasNext()&& !resul) {
			Pueblo aux=iterator.next();
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				int au=numHabitantes-aux.getNumeroHabitantes();
				aux.setNumeroHabitantes(numHabitantes);
				this.numHabitantes+=au;
				resul = true;
			}
		}
		return resul;
	}

	public int numPueblos() {
		return pueblos.size();
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numHabitantes=" + numHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", listadoPueblos="
				+ pueblos + "]";
	}

	public String getInformacionPueblo(String pueblo) throws ProvinciaException {
		if (!existePueblo(pueblo)) {
			throw new ProvinciaException("No existe ese pueblo");
		}
		String resul = "";
		for (Pueblo p : pueblos) {
			if (p.getNombre().equalsIgnoreCase(pueblo)) {
				resul = p.toString();
			}
		}
		return resul;
	}

}