package modelo;

public enum Tema {
	
	Amor(1,"amor"),Accion(2,"accion"),Terror(3,"terror"),Tecnico(4,"tecnico");
	
	private int id;
	private String nombre;
	
	Tema(int id, String nombre){
		
		this.id=id;
		this.nombre=nombre;
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
