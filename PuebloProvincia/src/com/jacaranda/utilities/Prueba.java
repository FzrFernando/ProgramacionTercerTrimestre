package com.jacaranda.utilities;

public class Prueba {

	public static void main(String[] args) throws PuebloException {

		try {
			Provincia p1 = new Provincia("Sevilla","41");
			System.out.println(p1);
//			Provincia p2 = new Provincia(null,"41");
//			System.out.println(p2);
//			Provincia p3 = new Provincia("Sevilla",null);
//			System.out.println(p3);
//			Provincia p4 = new Provincia("Sevilla","4");
//			System.out.println(p4);
//			Provincia p5 = new Provincia("Sevilla","477");
//			System.out.println(p5);
			p1.addPueblo("San José de la Rinconada", "300", 31, 2.3, 8.5);
			System.out.println(p1);
//			p1.addPueblo("San José de la Rinconada", "310", 31, 2.3, 8.5);
//			System.out.println(p1);
//			p1.addPueblo("Lora", "440", 31, 2.3, -8.5);
//			System.out.println(p1);
//			p1.addPueblo("Wajo", "430", -31, 2.3, 8.5);
//			System.out.println(p1);
			p1.setNumeroHabitantes("San José de la Rinconada", 15000);
			System.out.println(p1);
			p1.addPueblo("Brenes", "310", 31, 2.3, 8.5);
			System.out.println(p1);
			Pueblo pb1 = new Pueblo("Alcalá","41280",10,5.2,6.9);
			System.out.println(pb1);
		} catch (ProvinciaException e) {
			e.printStackTrace();
			
		}
		
	}

}
