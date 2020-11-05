package modelo;

public class Libro {

	private String ISBN, titulo, autor, editorial, formato, estado, tema;
	private Float Precio;
	private int cantidad;
	private boolean borrado;

	public Libro(String ISBN, String titulo, String autor, String editorial, int cantidad, Float precio, String formato,
			String estado, String tema) {
		super();
		assert ISBN.isEmpty() || titulo.isEmpty() || editorial.isEmpty();
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.Precio = precio;
		this.formato = formato;
		this.estado = estado;
		this.tema = tema;
		this.borrado = false;

	}

	public String getFormato() {
		return formato;
	}

	public String getEstado() {
		return estado;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public Float getPrecio() {
		return Precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getTema() {
		return tema;
	}

	public void restarCantidad(int cantidad) {
		this.cantidad = this.cantidad - cantidad;
		if (this.cantidad < 0) {
			this.cantidad = 0;
		}

	}

	public void sumarCantidad(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
	}

	public void comprobarISBNExistente(String iSBN) {
		this.ISBN = iSBN;
	}

	@Override
	public String toString() {

		return "ISBN: " + getISBN() + "\nTitulo: " + getTitulo() + "\nAutor: " + getTitulo() + "\nEditorial: "
				+ getEditorial() + "\nPrecio: " + getPrecio();
	}

}
