package com.jacaranda.diccionario;

public class Main {

	public static void main(String[] args) throws Exception {
		Diccionario d1 = new Diccionario();
		System.out.println(d1);
		try {
			d1.annadirPalabra("Ratilla","Javier");
			System.out.println(d1);
			d1.borrarPalabra("Ratilla");
			System.out.println(d1);
		} catch (DiccionarioException | PalabrasEmpiezanException | PalabraException e) {
			e.printStackTrace();
		}
	}
}
