package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichero {
	
	private static final String RUTA = "src/fichero/abonados.txt";
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	
	public static ArrayList leer() {
		ArrayList lista = new ArrayList<Abonado>();
		try {
			br = new BufferedReader(new FileReader(RUTA));
			String linea = "";
			String[] valores;
			Abonado a;
			while((linea = br.readLine()) != null) {
				valores = linea.split(";");
				a = new Abonado(valores[0], valores[1], valores[2], valores[3], Boolean.parseBoolean(valores[4]));
				lista.add(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static void escribir(ArrayList<Abonado> abonados) {
		try {
			bw = new BufferedWriter(new FileWriter(RUTA));
			for(Abonado a : abonados) {
				bw.write(a.getNombre() + ";" + a.getApellidos() + ";" + a.getDuracion() + ";" + a.getFecha() + ";" + (a.isVigente() ? "Sí" : "No"));
				bw.newLine();
			}
			} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
