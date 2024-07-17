package clases;

import java.util.ArrayList;

import principal.Main;

public class GestionAbonado {

	public static ArrayList<Abonado> lista = new ArrayList<Abonado>();
	
	public static boolean addAbonado(Abonado a) {
		boolean res = false;
		if(!lista.contains(a)) {
			lista.add(a);
			res = true;
		}
		return res;
	}
	
	public static void listar() {
		int contador = 0;
		for(Abonado a : lista) {
			System.out.println(a);
			contador++;
		}
		System.out.println("Hay " + contador + " abonados.");
	}
	
	public static boolean delete(Abonado a) {
		boolean res = false;
		if(lista.contains(a)) {
			lista.remove(a);
		}
		return res;
	}
	
	public static boolean modAbonado(Abonado a, String duracion) {
		boolean res = false;
		
		for(Abonado abon : lista) {
			if(abon.equals(a)) {
				abon.setDuracion(duracion);
				res = true;
			}
		}
		return res;
	}
	
	public static void vigencia() {
		String fecha = Main.fechaActual();
		String actual[];
		int diaA;
		int mesA;
		int annioA;
		actual = fecha.split("/");
		diaA = Integer.parseInt(actual[0]);
		mesA = Integer.parseInt(actual[1]);
		annioA = Integer.parseInt(actual[2]);
		for(Abonado a : lista) {
			String cifras[];
			int dia;
			int mes;
			int annio;
			cifras = a.getFecha().split("/");
			dia = Integer.parseInt(cifras[0]);
			mes = Integer.parseInt(cifras[1]);
			annio = Integer.parseInt(cifras[2]);
			switch(a.getDuracion()) {
			case TEMPORADA ->{				
				if(dia > 1 && mes >= 9 && annio >= annioA) {
					a.setVigente(false);
				}
			}
			case MENSUAL -> {
				if(dia < diaA && mes <= mes - 1 && annio <= annioA) {
					a.setVigente(false);
				}
			}
			case QUINCENAL -> {
				if(dia + 1 == diaA - 15 && annio == annioA) {
					a.setVigente(false);
				}
			}
			}
		}
	}
	
	public static void save() {
		Fichero.escribir(lista);
	}
}
