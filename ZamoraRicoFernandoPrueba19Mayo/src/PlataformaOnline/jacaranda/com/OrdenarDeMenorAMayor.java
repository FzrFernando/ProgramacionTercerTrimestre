package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenarDeMenorAMayor implements Comparator<Temporada> {

	//Clase creada para ordenar de Menor a Mayor por su numero de Capitulos
	
	@Override
	public int compare(Temporada o1, Temporada o2) {
		int numerosCapitulos = o1.contarNumerosCapitulos() - o2.contarNumerosCapitulos();
		return numerosCapitulos;
	}

}
