package com.jacaranda.principal;

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

		do {
			muestraMenu();

			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1: {

				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			case 4: {
				for (Nota nota: listaNota) {
					System.out.println(nota);
				}
				break;
			}
			case 5: {
				for (Alumnado alu: listaAlumnados) {
					System.out.println(alu);
				}
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
}
