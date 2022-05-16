package com.jacaranda.country;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class City {
	private int idCity;
	private String city;
	private int numero;
	private static int incremento=1;
	private HashMap<Integer, HashSet<Address>> address;
	
	public City(int idCity, String city) {
		super();
		this.idCity = idCity;
		this.city = city;
		this.numero=incremento++;
		address = new HashMap<>();
		
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
	
	public int getNumero() {
		return numero;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public HashMap<Integer, HashSet<Address>> getAddress() {
		return address;
	}

	public void setAddress(Integer idAddress, String addres) {

			Address a = new Address(idAddress, addres);
			
			if (addres.isEmpty()) {
				HashSet<Address>contentMap = new HashSet<>();
				
				contentMap.add(a);
				address.put(idAddress, contentMap);
			
				contentMap.add(a);
			}
		
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

	@Override
	public String toString() {
		return "City [city_id=" + idCity + ", city=" + city + "]";
	}
}
