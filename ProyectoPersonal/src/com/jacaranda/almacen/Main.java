package com.jacaranda.almacen;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	static Almacen al = new Almacen ("13432");
	
	public static void main(String[] args) {

		// al.annadirUsuario("Rafael", "13");
		// System.out.println(al.toString());

		try {
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "programacion", "programacion");
//			System.out.println(al.annadirUsuarioBaseDatos(conexion, "Rafael", "13"));
//			System.out.println(al.consultarUsuarioBaseDatos(conexion));
//			System.out.println(al.actualizarUsuarioBaseDatos(conexion, "Josué", "13"));
//			System.out.println(al.consultarUsuarioBaseDatos(conexion));
//			System.out.println(al.eliminarUsuarioBaseDatos(conexion, "13"));
//			System.out.println(al.consultarUsuarioBaseDatos(conexion));
//			DatabaseMetaData infoBD= conexion.getMetaData();
//			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
//			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
		} catch (SQLException ex) {
			// Tratar el error
			System.out.println(ex.getMessage());
		}
	}

	
}
