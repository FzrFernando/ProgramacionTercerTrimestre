package com.jacaranda.almacen;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Almacen {
	
	public String codigo;
	public ArrayList<Mercancia> mercancia;
	public ArrayList<Usuario> usuario;

	public Almacen(String codigo) {
		super();
		this.codigo = codigo;
		this.mercancia = new ArrayList<>();
		this.usuario = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public boolean addTornillo(String codigo, String descripcion, double precio, double diametro) {
		Tornillo t = new Tornillo(descripcion, descripcion, precio, diametro);
		boolean annadido = false;
		int pos = this.mercancia.indexOf(t);
		if (pos == -1) {
			this.mercancia.add(t);
			annadido = true;
		}
		return annadido;
	}
	
	public boolean addElementoElectrico(String codigo, String descripcion, double precio, int bateria) {
		ElementosElectricos e = new ElementosElectricos(codigo, codigo, precio, bateria);
		boolean annadido = false;
		int pos = this.mercancia.indexOf(e);
		if (pos == -1) {
			this.mercancia.add(e);
			annadido = true;
		}
		return annadido;
	}
	
	public int getNumTotalMercancia() {
		return mercancia.size();
	}
	
	public boolean annadirUsuario(String nombre,String codigo) {
		boolean annadido = false;
		Usuario usu = new Usuario(nombre, codigo);
		int pos = this.usuario.indexOf(usu);
		if (pos == -1) {
			this.usuario.add(usu);
			annadido = true;
		}
		return annadido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Almacen other = (Almacen) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Almacen [codigo=" + codigo + ", mercancia=" + mercancia + ", usuario=" + usuario + "]";
	}
	
	public String annadirUsuarioBaseDatos(Connection c, String nombre, String codigo) {
		String cadenafinal = "";
		try {
			Statement instruccion = c.createStatement();
			String query = "INSERT INTO USUARIO VALUES ('"+nombre+"','"+codigo + "')";
			instruccion.executeUpdate(query);
			cadenafinal = query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cadenafinal;
	}
}
