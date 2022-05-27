package com.jacaranda.almacen;

import java.util.Objects;

public class Tornillo extends Mercancia {

	private double diametro;
	
	public Tornillo(String codigo, String descripcion, double precio, double diametro) {
		super(codigo, descripcion, precio);
		this.diametro = diametro;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diametro);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tornillo other = (Tornillo) obj;
		return Double.doubleToLongBits(diametro) == Double.doubleToLongBits(other.diametro);
	}

	@Override
	public String toString() {
		return "Tornillo [diametro=" + diametro + "]";
	}

	
}
