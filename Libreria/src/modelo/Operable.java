package modelo;

import java.sql.SQLException;
import java.util.HashMap;

public interface Operable {

	public boolean insertarLibro(Libro libro) throws SQLException;

	public boolean borrarLibro(String isbn) throws SQLException;

	public HashMap<String, Libro> getLibros();

}
