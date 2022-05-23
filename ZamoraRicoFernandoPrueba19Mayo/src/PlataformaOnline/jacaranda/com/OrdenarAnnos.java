package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenarAnnos implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		int annoAnterior= o1.getAnno() - o2.getAnno();
		return annoAnterior;
	}

}
