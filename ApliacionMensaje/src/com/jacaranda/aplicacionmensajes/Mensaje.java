package com.jacaranda.aplicacionmensajes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje implements Comparable<Mensaje> {

	private String remitente;
	private String destinatario;
	private String texto;
	private LocalDateTime fechayhora;
	private int codigo;
	private static int codigoSiguiente = 1;
	
	public Mensaje(String remitente, String destinatario, String texto)  throws MensajeException{
		super();
		this.codigo = Mensaje.codigoSiguiente++;
		this.fechayhora = LocalDateTime.now();
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.texto = texto;
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
		Mensaje other = (Mensaje) obj;
		return codigo == other.codigo;
	}

	public String getRemitente() {
		return remitente;
	}
	
	public void setRemitente(String remitente) throws MensajeException {
		if (remitente == null) {
			throw new MensajeException("El remitente no puede ser nulo");
		} else {
			this.remitente = remitente;
		}
	}

	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) throws MensajeException {
		if (texto == null) {
			throw new MensajeException("El texto no puede ser nulo");
		}else {
			this.texto = texto;
		}
	}

	public LocalDateTime getFechayhora() {
		return fechayhora;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Mensaje [remitente=" + remitente + ", texto=" + texto + ", fechayhora=" + fechayhora + ", codigo="
				+ codigo + "]";
	}
	
	@Override
	public int compareTo(Mensaje o) {
		int resultado=0;
		if (o==null) {
			resultado=-1;
		}else {
			resultado=this.remitente.compareToIgnoreCase(o.getRemitente());
		}
		return resultado;
	}
	
	
}
