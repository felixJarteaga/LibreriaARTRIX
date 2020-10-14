package modelo;


import java.util.HashMap;
import java.util.Set;

public class Estanteria {
	HashMap<String, Libro> hashMapLibros = new HashMap<String, Libro>();

	public HashMap<String, Libro> getHashMapLibro() {
		return hashMapLibros;
	}

	public Estanteria() {
		super();
		this.hashMapLibros = new HashMap<String, Libro>();
	}

	public void guardar(Libro libro) {
		this.hashMapLibros.put(libro.getISBN(),libro);
	}


	public void borrarLibros(int indice) {
		String isbn= ISBNconcreto(indice);
		hashMapLibros.remove(isbn);
	}

	public Libro obtenerLibro(String ISBN) {
		return this.hashMapLibros.get(ISBN);
	}
	public Libro getLibro(int index) {
		String ISBN = ISBNconcreto(index);
		return obtenerLibro(ISBN);
	}
	public String ISBNconcreto(int index) {
		Set<String> grupo = this.hashMapLibros.keySet();
		Object [] array = grupo.toArray();
		String ISBN=(String) array[index];
	
		return ISBN;
	}

}
