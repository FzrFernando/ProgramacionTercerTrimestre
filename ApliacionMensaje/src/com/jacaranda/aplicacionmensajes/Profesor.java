package com.jacaranda.aplicacionmensajes;

public class Profesor extends Persona{

	public Profesor(int edad, String nombre) throws PersonaException, AlumnoException {
		super(nombre, edad);
	}
	
	public boolean sendMessage(Persona destinatario,String texto) throws MensajeException, ProfesorException {
		boolean resultado=true;
		super.sendMessage(destinatario, texto);
		return resultado;
	}
 

}
