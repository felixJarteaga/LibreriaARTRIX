package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Libro;
import modelo.MyObjectOutputStream;

public class AlmacenUnico<T> {

	private File file;
	private FileOutputStream flujoW;
	private FileInputStream flujoR;
	private ObjectInputStream adaptadorR;
	private ObjectOutputStream adaptadorW;
	private boolean estado = false;
	private final String PATH = "data.libros";

	public AlmacenUnico() {
		super();
		createFile();
	}

	private void createFile() {
		file = new File(PATH);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean almacena(T obj) {
		try {
			flujoW = new FileOutputStream(file, true);
			if (!this.file.exists() || this.file.length() == 0) {
				createFile();
				adaptadorW = new ObjectOutputStream(flujoW);
			} else {
				adaptadorW = new MyObjectOutputStream(flujoW);
			}
			adaptadorW.writeObject((T) obj);
			
		} catch (IOException e) {
			estado = false;
			e.printStackTrace();
		}
		try {
			adaptadorW.close();
			flujoW.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return estado;
	}
	


	public HashMap<String, Libro> recuperar() {
		HashMap<String, Libro> obj = new HashMap<String, Libro>();
		try {
			flujoR = new FileInputStream(file);
			adaptadorR = new ObjectInputStream(flujoR);
			Object libreo = adaptadorR.readObject();
			while (libreo != null) {
				obj.put(((Libro) libreo).getISBN(), (Libro) libreo);
				libreo = adaptadorR.readObject();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			estado = false;
//			e.printStackTrace();
		}
		try {
			adaptadorR.close();
			flujoR.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}
	
	public boolean actualizarFichero(Object obj) throws SecurityException {
		HashMap<String, Libro> libros = (HashMap<String, Libro>) obj;
		borrarFichero();
		for (HashMap.Entry<String, Libro> entry : libros.entrySet()) {
				almacena((T) entry.getValue());	
		}
		return false;
	}
	
	private void borrarFichero() {
		try {
			
			file.delete();
			file.createNewFile();
		} catch (Exception e) {
			
		}
	}

	public boolean isEstado() {
		return estado;
	}
}
