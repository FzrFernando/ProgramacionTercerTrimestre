package com.jacaranda.aplicacionmensajes;

import java.util.LinkedList;
import java.util.List;

public abstract class Persona {

	private String nombre;
	private String dni;
	protected int edad;
	protected List<Mensaje> mensajesenviados;
	protected List<Mensaje> mensajesrecibidos;
	
	public Persona(String nombre, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.mensajesrecibidos = new LinkedList<>();
		this.mensajesenviados = new LinkedList<>();
	}
	
	public boolean sendMessage(Persona p, String texto) {
		boolean resultado = true;
		//Creo el mensaje
		Mensaje aux = new Mensaje(this.nombre,p.nombre,texto);
		//Se lo añado a la lista de los que ha enviado este usuario
		this.mensajesenviados.add(aux);
		//Se lo añado a la lista del usuario que se lo he enviado
		p.mensajesrecibidos.add(aux);
		return resultado;
	}
	
	public String readSentMessage() {
		return this.mensajesenviados.toString();
	}
	
	public String readReceivedMessages() {
		return this.mensajesrecibidos.toString();
	}
	
	
}
