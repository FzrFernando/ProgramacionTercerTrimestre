package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		ArrayList<Comunidad> comunidad = gson.fromJson("tamanoMunicipioComunidades.json", new TypeToken<ArrayList<Comunidad>>() {
		}.getType());
		TamanoMunicipioComunidad tmc1 = new TamanoMunicipioComunidad();
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String salida = prettyGson.toJson(comunidad);
		escribirEnFicheroJson("tamanoMunicipioComunidades.json", null);
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
