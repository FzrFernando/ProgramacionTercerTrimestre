package com.jacaranda.almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	static Almacen al = new Almacen ("13432");
	
	public static void main(String[] args) {

		// al.annadirUsuario("Rafael", "13");
		// System.out.println(al.toString());

		try {
			Connection conexion = DriverManager.getConnection("localhost:1521/ORCLCDB.localdomain", "programacion", "programacion");
			System.out.println(al.annadirUsuarioBaseDatos(conexion, "Rafael", "13"));
		} catch (SQLException ex) {
			// Tratar el error
		}
	}

	
}
