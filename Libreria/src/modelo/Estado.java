package modelo;

public enum Estado {
	
	reedicion(1,"Reedición"),novedad(2,"Novedad");
	
	private int id;
	private String nombre;
	
	Estado(int id, String nombre){
		
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
