package modelo;

public class Libro {

	private String ISBN, Titulo, Autor, Editorial;
	private Float Precio;

	public Libro(String ISBN, String titulo, String autor, String editorial, Float precio) {
		super();
		assert ISBN.isEmpty() || titulo.isEmpty() || editorial.isEmpty();
		this.ISBN = ISBN;
		this.Titulo = titulo;
		this.Autor = autor;
		this.Editorial = editorial;
		this.Precio = precio;
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

	@Override
	public String toString() {

		return "ISBN: " + getISBN() + "\nTitulo: " + getTitulo() + "\nAutor: " + getTitulo() + "\nEditorial: "
				+ getEditorial() + "\nPrecio: " + getPrecio();
	}

}
