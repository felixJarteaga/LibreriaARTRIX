package modelo;

import java.util.HashMap;

public enum Formato {

	cartone(1, "Carton�"),rustica(2,"R�stica"),grapada(3,"Grapada"),espiral(4,"Espiral");
	
	
	private int id;
	private String nombre;

	Formato(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
