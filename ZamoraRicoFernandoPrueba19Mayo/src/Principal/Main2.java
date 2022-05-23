package Principal;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main2 {

	public static void main(String[] args) {
		//Main para probar a añadir capitulos
		Temporada t1 = new Temporada("Empezamos");
		t1.annadirCapitulo("Capitulo 1");
		t1.annadirCapitulo("Capitulo 2");
		try {
			t1.anadirCapituloDespues("Capitulo 1 bis","Capitulo 1");
		} catch (SerieException e) {
			e.printStackTrace();
		}
		System.out.println(t1.toString());
	}

}
