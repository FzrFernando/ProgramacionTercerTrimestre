package com.jacaranda.fichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Principal {

	public static void main(String[] args) {
		String fichero = imprimirFicheroPorLineas("ficheros/prueba2.json");
		System.out.println("************************");
		System.out.println(fichero);

		Gson gson = new Gson();

//		Properties properties = gson.fromJson(fichero, Properties.class);
//		
//		System.out.println(properties.get("nombre"));
//		System.out.println(properties.get("apellidos"));
//		System.out.println(properties.get("edad"));

//		Persona p1 = gson.fromJson(fichero, Persona.class);
//		System.out.println(p1);

		ArrayList<Persona> personas = gson.fromJson(fichero, new TypeToken<ArrayList<Persona>>() {
		}.getType());

		for (Persona p : personas) {
			System.out.println(p.toString());
		}

		Persona p1 = new Persona("Pepe", "Pérez", 20);
		personas.add(p1);
		personas.remove(0);

//		String salida = gson.toJson(personas);
//		System.out.println("Informaciñon del string");
//		System.out.println(salida);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String salida = prettyGson.toJson(personas);
		
		escribirEnFicheroJson("ficheros/prueba3.json", salida);
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

	private static void escribirEnFicheroJson(String nombre, String contenido) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			filtroEscritura.println(contenido);

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
