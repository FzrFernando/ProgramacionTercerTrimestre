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
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.pueblos = new HashSet<Pueblo>();
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
	}

	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo == null) {
			throw new ProvinciaException("No puede ser nulo");
		}
		if (codigo.length() == 2 && codigo.chars().allMatch(Character::isDigit)) {
			this.codigo = codigo;
		} else {
			throw new ProvinciaException("El código tiene que tener una longitud 2 y ser numérico");
		}
	}

	private boolean existePueblo(String pueblo) throws ProvinciaException {
		boolean resultado = false;
		if (pueblo == null) {
			throw new ProvinciaException("El pueblo no puede ser nulo");
		}
		Iterator<Pueblo> siguiente = this.pueblos.iterator();
		while (siguiente.hasNext() && resultado == false) {
			Pueblo p = siguiente.next();
			if (p.getNombre().equalsIgnoreCase(pueblo)) {
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean addPueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita,
			double superficie) throws ProvinciaException, PuebloException {
		boolean add = false;
		String codigonuevo = this.codigo + codigo;
		if (nombre == null) {
			throw new ProvinciaException("El nombre de la provincia no puede ser nulo");
		}
		if (existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo ya existe");
		} else {
			Pueblo p2 = new Pueblo(nombre, codigonuevo, numeroHabitantes, rentaPerCapita, superficie);
			pueblos.add(p2);
			add = true;
			this.superficie += superficie;
			this.numeroHabitantes += numeroHabitantes;
			this.rentaPerCapita += rentaPerCapita;
		}
		return add;
	}

	public String listadoNombresPueblos() {
		StringBuilder cadenafinal = new StringBuilder();
		for (Pueblo p : this.pueblos) {
			cadenafinal.append(p.getNombre() + "\n");
		}
		return cadenafinal.toString();
	}

	public String listadoPueblos() {
		StringBuilder cadenafinal = new StringBuilder();
		for (Pueblo p : this.pueblos) {
			cadenafinal.append(p.toString() + "\n");
		}
		return cadenafinal.toString();
	}

	public boolean delPueblo(String nombre) {
		boolean eliminado = false;
		Iterator<Pueblo> siguiente = this.pueblos.iterator();
		while (siguiente.hasNext()) {
			Pueblo p = siguiente.next();
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				this.numeroHabitantes -= p.getNumeroHabitantes();
				this.rentaPerCapita -= p.getRentaPerCapita();
				this.superficie -= p.getSuperficie();
				this.pueblos.remove(p);
				eliminado = true;

			}
		}
		return eliminado;
	}

	public boolean setSuperficie(String pueblo, double superficie) throws ProvinciaException, PuebloException {
		boolean resultado = false;
		double diferencia = 0;
		if (superficie < 0) {
			throw new ProvinciaException("La superficie debe ser válida");
		}
		if (existePueblo(pueblo)) {
			Iterator<Pueblo> siguiente = this.pueblos.iterator();
			while (siguiente.hasNext()) {
				Pueblo p = siguiente.next();
				if (p.getNombre().equalsIgnoreCase(pueblo)) {
					diferencia = superficie - p.getSuperficie();
					p.setSuperficie(superficie);
				}
			}
			this.superficie += diferencia;
			resultado = true;
		} else {
			throw new ProvinciaException("No existe el pueblo");
		}
		return resultado;
	}

	public boolean setNumeroHabitantes(String pueblo, int numeroHabitantes) throws ProvinciaException, PuebloException {
		boolean resultado = false;
		double diferencia = 0;
		if (numeroHabitantes < 0) {
			throw new ProvinciaException("Los numeros de habitantes deben ser válidos");
		}
		if (existePueblo(pueblo)) {
			Iterator<Pueblo> siguiente = this.pueblos.iterator();
			while (siguiente.hasNext()) {
				Pueblo p = siguiente.next();
				if (p.getNombre().equalsIgnoreCase(pueblo)) {
					diferencia = numeroHabitantes - p.getNumeroHabitantes();
					p.setNumeroHabitantes(numeroHabitantes);
				}
			}
			this.numeroHabitantes += diferencia;
			resultado = true;
		} else {
			throw new ProvinciaException("No existe el pueblo");
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

	public String getProvincia() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public double getSuperficie() {
		return superficie;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", pueblos=" + pueblos + "]";
	}

	public String getInformacionPueblo(String pueblo) throws ProvinciaException {
		String cadenafinal = null;
		if (pueblo == null || !existePueblo(pueblo)) {
			cadenafinal = null;
		} else {
			for (Pueblo p : this.pueblos) {
				if (p.getNombre().equalsIgnoreCase(pueblo)) {
					cadenafinal = p.toString() + "\n";
				}
			}
		}
		return cadenafinal;
	}
}
