package clases;

import java.util.ArrayList;

public class GestionAbonado {

	public static ArrayList<Abonado> lista = Fichero.leer();
	
	public static boolean addAbonado(Abonado a) {
		boolean res = false;
		if(!lista.contains(a)) {
			lista.add(a);
			res = true;
		}
		return res;
	}
	
	public static void listar() {
		for(Abonado a : lista) {
			System.out.println(a);
		}
	}
	
	public static boolean delete(Abonado a) {
		boolean res = false;
		if(lista.contains(a)) {
			lista.remove(a);
		}
		return res;
	}
	
	public static boolean modAbonado(Abonado a) {
		
	}
}
