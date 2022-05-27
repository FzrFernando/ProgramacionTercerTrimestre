package com.jacaranda.diccionario;

public class Main {

	public static void main(String[] args) {
		Diccionario d1 = new Diccionario();
		try {
			d1.addPalabra("Hola", "significado 1");
			d1.addPalabra("Adios", "significado 4");
			System.out.println(d1);
			d1.addPalabra("Hola", "significado 4");
			System.out.println(d1);
		} catch (DiccionarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
