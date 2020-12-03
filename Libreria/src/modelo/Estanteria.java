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
		this.almacen = new AlmacenUnico();
		iniciarFichero();

	}

	private void iniciarFichero() {
		try {
			leerEstanteria();
		} catch (Exception e) {
		}
		if (null == this.hashMapLibros) {
			this.hashMapLibros = new HashMap<String, Libro>();
		}
	}


	public void leerEstanteria() {
		this.hashMapLibros = (HashMap<String, Libro>) almacen.recuperar();
	}


	@Override
	public boolean insertarLibro(Libro libro) {
		leerEstanteria();
		this.hashMapLibros.put(libro.getISBN(), libro);

		guardarEstanteria(libro);

		return true;
	}

	public boolean guardarEstanteria(Libro libro) {
		return almacen.almacena(libro);
	}
	

	public void cambiarEstadoLibro(String isbn) {
		leerEstanteria();
		hashMapLibros.get(isbn).setBorrado(!hashMapLibros.get(isbn).isBorrado());
		almacen.actualizarFichero(hashMapLibros);

	}

	@Override
	public boolean borrarLibro(String isbn) {
		leerEstanteria();
		hashMapLibros.remove(isbn);
		almacen.actualizarFichero(hashMapLibros);


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




