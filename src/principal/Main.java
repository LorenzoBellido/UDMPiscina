package principal;

import java.util.Calendar;
import java.util.Scanner;

import clases.Abonado;
import clases.Fichero;
import clases.GestionAbonado;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		GestionAbonado.lista = Fichero.leer();
		GestionAbonado.vigencia();

		String duracion = "";
		int opc;

		do {
			menu();
			System.out.println("Introduzca una opción: ");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1 -> {
				Abonado a = crearAbonado();
				if(GestionAbonado.addAbonado(a)) {
					System.out.println("Abonado añadido correctamente");
				}
			}
			case 2 -> {
				GestionAbonado.listar();
			}
			case 3 -> {
				Abonado a = buscarAbonado();
				if(GestionAbonado.delete(a)) {
					System.out.println("Abonado eliminado correctamente");
				}
			}
			case 4 ->{
				Abonado a = buscarAbonado();
				if(GestionAbonado.lista.contains(a)) {
					System.out.println("Introduzca la nueva duración: ");
					duracion = sc.nextLine();
					duracion = duracion.toUpperCase();
					if(GestionAbonado.modAbonado(a, duracion)) {
						System.out.println("Duración modificada");
					}else {
						System.out.println("Error en la duración");
					}
				}else {
					System.out.println("Abonado no encontrado");
				}
			}
			case 5 -> {
				GestionAbonado.save();
			}
			case 6 ->{
				System.out.println("Saliendo...");
			}
			default ->{
				System.out.println("Opción errónea");
			}
			}
		} while (opc != 6);

	}

	private static void menu() {
		System.out.println("->Piscina Municipal<-");
		System.out.println("Valverde de Burguillos");
		System.out.println("========================");
		System.out.println("1. Añadir Abonado");
		System.out.println("2. Listar Abonados");
		System.out.println("3. Borrar Abonado");
		System.out.println("4. Modificar Duración");
		System.out.println("5. Guardar Cambios");
		System.out.println("6. Salir");
	}

	public static String fechaActual() {
		String fechaA = "";
		
		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
		String annio = Integer.toString(c.get(Calendar.YEAR));
		
		fechaA = dia + "/" + mes + "/" + annio;
		
		return fechaA;
	}
	
	private static Abonado crearAbonado() {
		String nombre = "";
		String apellidos = "";
		String duracion = "";
		String fecha = fechaActual();
		boolean vigente = true;
		System.out.println("Introduzca el nombre: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca los apellidos: ");
		apellidos = sc.nextLine();
		System.out.println("Introduzca la duracion: ");
		duracion = sc.nextLine();
		duracion = duracion.toUpperCase();
		Abonado a = new Abonado(nombre,apellidos,duracion,fecha,vigente);
		return a;
	}
	
	private static Abonado buscarAbonado() {
		String nombre = "";
		String apellidos = "";
		
		System.out.println("Introduzca el nombre: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca los apellidos: ");
		apellidos = sc.nextLine();
		
		Abonado a = new Abonado(nombre, apellidos);
		return a;
	}
}
