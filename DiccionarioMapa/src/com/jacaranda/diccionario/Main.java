package com.jacaranda.diccionario;

public class Main {

	public static void main(String[] args) {
		Diccionario d1 = new Diccionario();
		d1.anadirPalabra("Hola", "significado 1");
		d1.anadirPalabra("Adios", "significado 4");
		System.out.println(d1);
		d1.anadirPalabra("Hola", "significado 4");
		System.out.println(d1);
	}
}
