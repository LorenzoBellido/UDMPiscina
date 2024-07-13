package clases;

public class Abonado {
	
	enum tipo{
		QUINCENAL, MENSUAL, TEMPORADA
	}

	private String nombre = "";
	private String apellidos = "";
	private tipo duracion;
	private String fecha = "";
	private boolean vigente = true;
	
	public Abonado(String nombre, String apellidos) {
		if(!nombre.equals("") && nombre != null) {
			this.nombre = nombre;
		}
		
		if(!apellidos.equals("") && apellidos != null) {
			this.apellidos = apellidos;
		}
	}

	public Abonado(String nombre, String apellidos, String duracion, String fecha, boolean vigente) {
		this(nombre,apellidos);
		comprobarDuracion(duracion);
		if(comprobarFecha(fecha)) {
			this.fecha = fecha;
		}
		this.vigente = vigente;
	}
	
	private void comprobarDuracion(String duracion) {
		try {
			this.duracion = tipo.valueOf(duracion);
		}catch (IllegalArgumentException e){
			this.duracion = tipo.QUINCENAL;
		}
	}
	
	private boolean comprobarFecha(String fecha) {
		boolean res = false;
		String[] cifras = new String[3];
		cifras = fecha.split("/");
		int dia = Integer.parseInt(cifras[0]);
		int mes = Integer.parseInt(cifras[1]);
		int anyo = Integer.parseInt(cifras[2]);
		
		if (dia > 0 && dia <= 31) {
			res = true;
		}

		if (mes > 0 && mes < 13) {
			res = true;
		}

		if (anyo > 0) {
			res = true;
		}
		
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		Abonado a = (Abonado) obj;
		if(this.nombre.equals(a.nombre)) {
			if(this.apellidos.equals(a.apellidos)) {
				res = true;
			}
		}
		return res;
	}

	@Override
	public String toString() {
		String res = "";
		res += "Nombre: " + this.nombre + "\n" +
				"Apellidos: " + this.apellidos + "\n" + 
				"Duración: " + this.duracion + "\n" +
				"Fecha: " + this.fecha + "\n" + 
				"Vigente: " + (this.vigente? "Sí" : "No") + "\n";
		return res;
	}
	
	
}
