package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenarDeMayorAMenor implements Comparator<Temporada> {

	//Clase creada para ordenar de Mayor a Menor por su nota media
	
	@Override
	public int compare(Temporada o1, Temporada o2) {
		int notaMedia = (int) ((int) o1.getNotaMedia()-o2.getNotaMedia());
		return notaMedia;
	}

}
