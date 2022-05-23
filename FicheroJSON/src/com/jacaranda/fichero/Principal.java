package com.jacaranda.fichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;

public class Principal {

	public static void main(String[] args) {
		String fichero = imprimirFicheroPorLineas("ficheros/prueba1.json");
		System.out.println("************************");
		System.out.println(fichero);
		
		Gson gson = new Gson();
		
		Properties properties = gson.fromJson(fichero, Properties.class);
		
		System.out.println(properties.get("nombre"));
		System.out.println(properties.get("apellidos"));
		System.out.println(properties.get("edad"));
		
	}

	private static String imprimirFicheroPorLineas(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				resultado.append(linea);
				System.out.println(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado.toString();
	}

}
