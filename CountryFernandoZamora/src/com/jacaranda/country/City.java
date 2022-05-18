package com.jacaranda.country;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class City implements Comparable<City> {
	private int idCity;
	private String city;
	private List<Address> direcciones;

	public City(int idCity, String city) {
		super();
		this.idCity = idCity;
		this.city = city;
		this.direcciones = new LinkedList<>();
	}

	public int getidCity() {
		return idCity;
	}

	public void setidCity(int idCity) {
		this.idCity = idCity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address getDirecciones(int idAddress) {
		Address aux = new Address(idAddress, null);
		int posicion = this.direcciones.indexOf(aux);
		return this.direcciones.get(posicion);
	}

	public void addAddress(int idAddress, String address) {
		Address a = new Address(idAddress, address);
		int posicion = this.direcciones.indexOf(a);
		if (posicion == -1) {
			this.direcciones.add(a);
		}
	}

	@Override
	public String toString() {
		return "City [city_id=" + idCity + ", city=" + city + ", direcciones=" + direcciones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return idCity == other.idCity;
	}

	public String escribirFichero() {
		return this.city + ": " + direcciones.size() + "\n";
	}

	public String escribirFicheroCiudades() {
		return this.getidCity() + " " + this.getCity() + "," + this.direcciones + "\n";
	}

	@Override
	public int compareTo(City o) {
		int comparar = this.direcciones.size() - o.direcciones.size();
		if (comparar == 0) {
			comparar = this.getCity().compareToIgnoreCase(o.getCity());
		}
		return comparar;
	}

}
