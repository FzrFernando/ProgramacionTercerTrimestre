package com.jacaranda.diccionario;

import java.util.Scanner;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		String palabra = leerCadena("Introduce la palabra: ");
		String significado = leerCadena("Introduce el significado: ");
		Diccionario diccionario = new Diccionario();
		diccionario.addPalabra(palabra, significado);
		System.out.println(diccionario.toString());
	}
	
	public static String leerCadena(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
}
