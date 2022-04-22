package com.jacaranda.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {

	public static LinkedList<Alumnado> listaAlumnados = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNota = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc;
		leerFichero("ficheros//alumnado.txt");
		leerFichero("ficheros//modulos.txt");
		leerFichero("ficheros//notas.txt");

		do {
			muestraMenu();

			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1: {
				System.out.println("Dime un nombre");
				String nombre = teclado.nextLine();
				System.out.println("Dime un dni");
				String dni = teclado.nextLine();
				System.out.println("Dime un correo");
				String correo = teclado.nextLine();
				Alumnado a1 = new Alumnado(nombre, dni, correo);
				if (listaAlumnados.contains(a1)) {
					System.out.println("El alumno ya está");
				} else {
					listaAlumnados.add(a1);
					System.out.println("Añadido el alumno correctamente");
				}
				break;
			}
			case 2: {
				System.out.println("Dime un nombre de asignatura");
				String nombre = teclado.nextLine();
				Modulo m1 = new Modulo(nombre);
				if (listaModulos.contains(m1)) {
					System.out.println("El modulo ya está creado");
				} else {
					listaModulos.add(m1);
					System.out.println("Añadida la asignatura correctamente");
				}
				break;
			}
			case 3: {
				System.out.println("Dime la nota del examen");
				double nota = Double.parseDouble(teclado.nextLine());
				System.out.println("Dime un nombre de asignatura");
				String nombre = teclado.nextLine();
				Modulo m1 = new Modulo(nombre);
				System.out.println("Dime un nombre");
				String nombreAlumno = teclado.nextLine();
				System.out.println("Dime un dni");
				String dni = teclado.nextLine();
				Alumnado a1 = new Alumnado(nombreAlumno, dni);
				Nota n1 = new Nota(nota, LocalTime.now(), a1, m1);
				listaNota.add(n1);
				break;
			}
			case 4: {
				for (Nota nota : listaNota) {
					System.out.println(nota);
				}
				break;
			}
			case 5: {
				for (Alumnado alu : listaAlumnados) {
					System.out.println(alu);
				}
				break;
			}
			case 6: {
				// Escribir los datos que hay en memoeria en el fichero correspondiente
				escribirEnFichero("ficheros//alumnado.txt");
				break;
			}
			default:
				System.out.println("Opcion no permitida");
			}
		} while (opc != 6);
	}

	public static void muestraMenu() {
		System.out.println("1. Alta alumnado");
		System.out.println("2. Alta modulo");
		System.out.println("3. Registrar nota");
		System.out.println("4. Listar notas con todos los alumnos");
		System.out.println("5. Listar todos los alumnos");
		System.out.println("6. Salir");
	}

	private static void leerFichero(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// Proceso la linea que acabo de leer

				String[] campos = linea.split(",");
				Alumnado alu = new Alumnado(campos[0], campos[1], campos[2]);
				listaAlumnados.add(alu);

				// Leo otra linea
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFichero(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			//Proceso el fichero
			
			for (Alumnado alu : listaAlumnados) {
			
				filtroEscritura.println(alu.escribeFichero());
			}
			
			//Fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
