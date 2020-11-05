package modelo;

public class Libro {

<<<<<<< Updated upstream
	private String ISBN, Titulo, Autor, Editorial;
	private Float Precio;

	public Libro(String ISBN, String titulo, String autor, String editorial, Float precio) {
=======
	private String ISBN, titulo, autor, editorial, formato, estado,tema;
	private Float Precio;
	private int cantidad;
	private boolean borrado;

	public Libro(String ISBN, String titulo, String autor, String editorial, int cantidad, Float precio, String formato, String estado,String tema) {
>>>>>>> Stashed changes
		super();
		assert ISBN.isEmpty() || titulo.isEmpty() || editorial.isEmpty();
		this.ISBN = ISBN;
		this.Titulo = titulo;
		this.Autor = autor;
		this.Editorial = editorial;
		this.Precio = precio;
<<<<<<< Updated upstream
=======
		this.formato = formato;
		this.estado = estado;
		this.tema=tema;
		this.borrado=false;
		

	}


	public boolean isBorrado() {
		return borrado;
	}


	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
>>>>>>> Stashed changes
	}


	public String getISBN() {
		return ISBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public String getEditorial() {
		return Editorial;
	}

	public Float getPrecio() {
		return Precio;
	}

<<<<<<< Updated upstream
=======
	public int getCantidad() {
		return cantidad;
	}
	
	public String getTema() {
		return tema;
	}

	public void restarCantidad(int cantidad) {
		this.cantidad = this.cantidad - cantidad;
		if (this.cantidad<0) {
			this.cantidad=0;
		}
		
	}
	

	public void sumarCantidad(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
	}

	public void comprobarISBNExistente(String iSBN) {
		this.ISBN = iSBN;
	}

>>>>>>> Stashed changes
	@Override
	public String toString() {

		return "ISBN: " + getISBN() + "\nTitulo: " + getTitulo() + "\nAutor: " + getTitulo() + "\nEditorial: "
				+ getEditorial() + "\nPrecio: " + getPrecio();
	}

}
