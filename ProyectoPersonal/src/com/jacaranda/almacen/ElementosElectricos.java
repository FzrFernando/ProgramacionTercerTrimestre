package com.jacaranda.almacen;

import java.util.Objects;

public class ElementosElectricos extends Mercancia {

	private int bateria;
	
	public ElementosElectricos(String codigo, String descripcion, double precio, int bateria) {
		super(codigo, descripcion, precio);
		this.bateria = bateria;
	}

	public int getBateria() {
		return bateria;
	}

	public void setBateria(int bateria) {
		this.bateria = bateria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bateria);
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
		ElementosElectricos other = (ElementosElectricos) obj;
		return bateria == other.bateria;
	}

	@Override
	public String toString() {
		return "ElementosElectricos [bateria=" + bateria + "]";
	}

	
	
	

}
