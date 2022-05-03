package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Provincia {
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private Set<Pueblo> pueblos;

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		if (nombre == null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();
		this.setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
		this.pueblos = new HashSet<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws ProvinciaException {
		if (codigo==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		if (codigo.length() == 2 && codigo.chars().allMatch(Character::isDigit)) {
			this.codigo = codigo;
		} else {
			throw new ProvinciaException("El código no es correcto");
		}

	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public boolean setNumeroHabitantes(String nombre, int numeroHabitantes) throws ProvinciaException, PuebloException {
		boolean resultado=false;
		if (numeroHabitantes<0) {
			throw new ProvinciaException("Los números de habitantes debe de ser positiva");
		}
		Iterator<Pueblo> iterator=pueblos.iterator();
		while(iterator.hasNext()&& !resultado) {
			Pueblo aux=iterator.next();
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				int au=numeroHabitantes-aux.getNumeroHabitantes();
				aux.setNumeroHabitantes(numeroHabitantes);
				this.numeroHabitantes+=au;
				resultado = true;
			}
		}
		return resultado;
	}
	
	public int numPueblos() {
		return this.pueblos.size();
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public boolean setSuperficie(String pueblo, double superficie) throws ProvinciaException, PuebloException {
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

	public String getProvincia() {
		return nombre;
	}

	private boolean existePueblo(String nombre) throws ProvinciaException {
		boolean resultado = false;
		if (nombre==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		for (Pueblo p : this.pueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				resultado = true;
			}

		}
		return resultado;
	}

	public boolean addPueblo(String nombre, String codigo, int numhabitantes, double renta, double superficie)
			throws PuebloException, ProvinciaException {
		boolean resultado = false;
		String nuevoCodigo=this.codigo+codigo;
		Pueblo aux = new Pueblo(nombre, nuevoCodigo, numhabitantes, renta, superficie);
		if (!existePueblo(aux.getNombre())) {
			pueblos.add(aux);
			this.superficie += aux.getSuperficie();
			this.numeroHabitantes += aux.getNumeroHabitantes();
			this.rentaPerCapita += aux.getRentaPerCapita();
			resultado = true;
		}
		else {
			throw new ProvinciaException("El pueblo no puede crearse");
		}
		return resultado;
	}

	public String listadoNombrePueblo() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p.getNombre() + "\n");
		}
		return cadenaNueva.toString();
	}

	public String listadoPueblos() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p);
		}
		return cadenaNueva.toString();
	}

	public boolean delPueblo(String nombre) throws ProvinciaException {
		boolean resul = false;
		if (!existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo no existe");
		}
		for (Pueblo p : pueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				this.superficie -= p.getSuperficie();
				this.numeroHabitantes -= p.getNumeroHabitantes();
				this.rentaPerCapita -= p.getRentaPerCapita();
				pueblos.remove(p);
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", pueblos=" + pueblos + "]";
	}
	public String getInformacionPueblo(String nombre) throws ProvinciaException {
		String resultado="";
		if (!existePueblo(nombre) || nombre==null) {
			resultado=null;
		}else {
			for (Pueblo p:this.pueblos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					resultado=p.toString();
				}
			}
		}
		return resultado;
	}

}