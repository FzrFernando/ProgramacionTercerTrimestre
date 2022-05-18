package com.jacaranda.country;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Country {
	private int idCountry;
	private String country;
	private List<City> ciudades;

	public Country(int idCountry, String country) {
		super();
		this.idCountry = idCountry;
		this.country = country;
		this.ciudades = new LinkedList<>();
	}

	public int getidCountry() {
		return idCountry;
	}

	public void setidCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public City getCiudad(int idCity) {
		City aux = new City(idCity, null);
		int posicion = this.ciudades.indexOf(aux);
		if (posicion==-1) {
			return null;
		}else {
			return this.ciudades.get(posicion);
		}
		
	}

	public void addCity(int idCity, String city) {
		City aux=new City(idCity,city);
		int posicion=this.ciudades.indexOf(aux);
		if (posicion==-1) {
			this.ciudades.add(aux);
		}
	}
	@Override
	public String toString() {
		return "Country [country_id=" + idCountry + ", country=" + country + ", ciudades=" + ciudades + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCountry);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return idCountry == other.idCountry;
	}



	public String escribirFichero() {
		StringBuilder resultado = new StringBuilder();

		Collections.sort(ciudades);
		
		for (City c : ciudades) {
			resultado.append(c.escribirFichero());
		}
		return "Pais: " + country + "\nCountryId: " + idCountry + "\nNumeroCiudades: " + ciudades.size() + "\n"
				+ resultado;

	}
	public String escribirCiudades() {
		StringBuilder resultado=new StringBuilder();
		for (City siguiente:this.ciudades) {
			resultado.append(siguiente.escribirFicheroCiudades());
		}
		return resultado.toString();
	}
}
