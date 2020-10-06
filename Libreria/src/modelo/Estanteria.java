package modelo;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Estanteria {
	private ArrayList<Libro> arrayLibro;

	public ArrayList<Libro> getArrayLibro() {
		return arrayLibro;
	}

	public Estanteria() {
		super();
		this.arrayLibro = new ArrayList<Libro>();
	}

	public void guardar(Libro libro) {
		arrayLibro.add(libro);
	}

//	public int obtenerIdSeleccionado(JTable tablaLibros) {
//		
//		for (int i = 0; i < arrayLibro.size(); i++) {
//			if (tablaLibros.getSelectedRow()==i) {
//				return i;
//			}
//		}
//		return -1;
//		
//	}

	public void borrarLibros(int indice) {
		arrayLibro.remove(indice);
	}

	public Libro obtenerLibro(String ISBN) {
		for (int i = 0; i < arrayLibro.size(); i++) {
			if (arrayLibro.get(i).getISBN().equals(ISBN)) {
				return arrayLibro.get(i);
			}
		}
		return null;
	}

}
