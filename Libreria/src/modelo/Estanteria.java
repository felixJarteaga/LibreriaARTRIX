package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import controlador.LibreriaCaller;

public class Estanteria {

	private HashMap<String, Libro> hashMapLibros;

	private LibreriaCaller callerLibreria;
	
//	private AlmacenUnico almacen;

	public Estanteria() {
		super();
		try {
			this.callerLibreria = new LibreriaCaller();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		leerEstanteria();
		
		
	}

	public void leerEstanteria() {
		this.hashMapLibros =callerLibreria.getLibros();
		
	}

	public boolean insertarLibro(Libro libro) {
		leerEstanteria();
		this.hashMapLibros.put(libro.getISBN(), libro);
		guardarEstanteria(libro);

		return true;
	}

	public void guardarEstanteria(Libro libro) {

		try {
			callerLibreria.insertarLibro(libro);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cambiarEstadoLibro(String isbn) {
		leerEstanteria();
		hashMapLibros.get(isbn).setBorrado(!hashMapLibros.get(isbn).isBorrado());
		try {
			callerLibreria.actualizarLibro(hashMapLibros.get(isbn));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean borrarLibro(String isbn) {
		leerEstanteria();
		hashMapLibros.remove(isbn);
		try {
			callerLibreria.borrarLibro(isbn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
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
		Object[] array = grupo.toArray();
		String ISBN = (String) array[index];
		
		return ISBN;
	}

	public HashMap<String, Libro> getHashMapLibro() {
		return hashMapLibros;
	}

	public void actualizarInfoLibros(Libro libro) {
		try {
			callerLibreria.actualizarLibro(libro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
