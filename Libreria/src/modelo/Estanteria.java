package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import controlador.AlmacenUnico;

public class Estanteria implements Estanterizable {
	
	
	private HashMap<String, Libro> hashMapLibros;

	private AlmacenUnico almacen;

	public Estanteria() {
		super();
		this.almacen = new AlmacenUnico("data.libros");
		iniciarFichero();

	}

	private void iniciarFichero() {
		try {
			leerEstanteria();
		} catch (Exception e) {
		}
		if (null == this.hashMapLibros) {
			this.hashMapLibros = new HashMap<String, Libro>();
			guardarEstanteria();
		}
	}

	public void leerEstanteria() {
		this.hashMapLibros = (HashMap<String, Libro>) almacen.recuperar();
	}

	@Override
	public boolean insertarLibro(Libro libro) {
		leerEstanteria();
		System.out.println(this.hashMapLibros);
		this.hashMapLibros.put(libro.getISBN(), libro);

		guardarEstanteria();

		return true;
	}

	public boolean guardarEstanteria() {
		return almacen.almacena(this.hashMapLibros);
	}

	public void cambiarEstadoLibro(String isbn) {
		leerEstanteria();
		hashMapLibros.get(isbn).setBorrado(!hashMapLibros.get(isbn).isBorrado());
		guardarEstanteria();

	}

	@Override
	public boolean borrarLibro(String isbn) {
		leerEstanteria();
		hashMapLibros.remove(isbn);

		guardarEstanteria();

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

	@Override
	public Libro buscarLibro(Integer index) {
		// TODO Auto-generated method stub
		return null;
	}

}