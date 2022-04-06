package com.jacaranda.aplicacionmensajes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Persona {

	private String nombre;
	protected int edad;
	protected List<Mensaje> mensajesenviados;
	protected List<Mensaje> mensajesrecibidos;
	
	public Persona(String nombre, int edad) throws PersonaException{
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.mensajesrecibidos = new LinkedList<>();
		this.mensajesenviados = new LinkedList<>();
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad<0) {
			throw new PersonaException("La edad de la persona no puede ser negativa");
		}
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean sendMessage(Persona p, String texto) throws MensajeException, ProfesorException {
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
	
	public boolean delMessageRecibido(int codigo) throws PersonaException {
		boolean encontrado=false;
		Iterator<Mensaje> siguiente=this.mensajesrecibidos.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Mensaje m1=siguiente.next();
			if (m1.getCodigo()==codigo) {
				this.mensajesrecibidos.remove(codigo);
				encontrado=true;
			}
		}
		if (!encontrado) {
			throw new PersonaException("Mensaje no encontrado");
		}
		return encontrado;
	}
	
	public boolean delMessageEnviado(int codigo) throws PersonaException {
		boolean encontrado=false;
		Iterator<Mensaje> siguiente=this.mensajesenviados.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Mensaje m1=siguiente.next();
			if (m1.getCodigo()==codigo) {
				this.mensajesenviados.remove(codigo);
				encontrado=true;
			}
		}
		if (!encontrado) {
			throw new PersonaException("Mensaje no encontrado");
		}
		return encontrado;
	}
	
	public String encontrarMensaje(String frase) throws PersonaException {
		StringBuilder cadena=new StringBuilder("");
		for (Mensaje m:this.mensajesrecibidos) {
			if (m.getTexto().contains(frase)) {
				cadena.append(frase + "\n");
			}else {
				throw new PersonaException("No contiene la palabra");
			}
		}
		return cadena.toString();
	}
}
