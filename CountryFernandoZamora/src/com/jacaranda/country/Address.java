package com.jacaranda.country;

import java.util.Objects;

public class Address {
	private int idAddress;
	private String address;

	public Address(int idAddress, String address) {
		super();
		this.idAddress = idAddress;
		this.address = address;
	}

	public int getidAddress() {
		return idAddress;
	}

	public void setidAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [adrress_id=" + idAddress + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return idAddress == other.idAddress;
	}
}
