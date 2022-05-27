package com.jacaranda.almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		// Almacen al = new Almacen ("13432");
		// al.annadirUsuario("Rafael", "13");
		// System.out.println(al.toString());

		try {
			Connection conexion = DriverManager.getConnection("localhost:1521/ORCLCDB.localdomain", "programacion", "programacion");
		} catch (SQLException ex) {
			// Tratar el error
		}
	}

	
}
