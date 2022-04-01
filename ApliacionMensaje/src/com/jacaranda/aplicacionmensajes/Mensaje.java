package com.jacaranda.aplicacionmensajes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje {

	private String remitente;
	private String destinatario;
	private String texto;
	private LocalDateTime fechayhora;
	private int codigo;
	private static int codigoSiguiente = 1;
	
	public Mensaje(String remitente, String destinatario, String texto) {
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

	public String getTexto() {
		return texto;
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
	
	
}
