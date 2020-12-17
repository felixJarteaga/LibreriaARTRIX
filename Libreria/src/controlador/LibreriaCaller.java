package controlador;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;

import modelo.Estado;
import modelo.Formato;
import modelo.Libro;
import modelo.Operable;
import modelo.Tema;
import modelo.accesoBBDD.AccesoBBDDLibreria;

public class LibreriaCaller extends AccesoBBDDLibreria implements Operable {

	public LibreriaCaller() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertarLibro(Libro libro) throws SQLException {
		CallableStatement cstmt = miConnection.prepareCall("{call insertarLibro(?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, libro.getISBN());
		cstmt.setString(2, libro.getAutor());
		cstmt.setString(3, libro.getTitulo());
		cstmt.setString(4, libro.getEditorial());
		cstmt.setInt(5, libro.getTema().getId());
		cstmt.setInt(6, libro.getEstadoEnum());
		cstmt.setInt(7, libro.getFormatoEnum());
		cstmt.setInt(8, libro.getCantidad());
		cstmt.setFloat(9, libro.getPrecio());
		cstmt.registerOutParameter(10, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(10);
	}

	@Override
	public boolean borrarLibro(String isbn) throws SQLException {
		PreparedStatement miEstament = miConnection.prepareStatement("DELETE FROM `libro` WHERE `isbn`=?");
		miEstament.setString(1, isbn);
		miEstament.executeUpdate();
//		CallableStatement cstmt = miConnection.prepareCall("{call borrarLibro(?,?)}");
//		cstmt.setString(1, isbn);
//		cstmt.registerOutParameter(2, Types.BOOLEAN);
//		cstmt.execute();
//		return cstmt.getBoolean(2);
		return true;
	}

	@Override
	public HashMap<String, Libro> getLibros() {
		HashMap<String, Libro> hashmaplibros = new HashMap<String, Libro>();
		try (Statement miStatement = miConnection.createStatement();
				ResultSet miResulSet = miStatement.executeQuery("SELECT * FROM libro");) {

			while (miResulSet.next()) {

				String formato = getFormato(miResulSet.getInt("formato"));
				String estado = getEstado(miResulSet.getInt("estado"));
				Tema tema = getTematica(miResulSet.getInt("tematica"));
				Libro libro = new Libro(miResulSet.getString("isbn"), miResulSet.getString("titulo"),
						miResulSet.getString("autor"), miResulSet.getString("editorial"),
						miResulSet.getInt("cantidad"), miResulSet.getFloat("precio"), formato, estado,miResulSet.getBoolean("borrado"),tema);
                hashmaplibros.put(libro.getISBN(), libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hashmaplibros;
	}

	private Tema getTematica(int int1) {
		for (Tema tema : Tema.values()) {
			if (tema.getId()==int1) {
				return tema;
			}
		}
		return null;
	}

	private String getEstado(int int1) {
		for (Estado estado : Estado.values()) {
			if (estado.getId()==int1) {
				return estado.getNombre();
			}
		}
		return null;
	}

	private String getFormato(int int1) {
		for (Formato formato : Formato.values()) {
			if (formato.getId() == int1) {
				return formato.getNombre();
			}
		}
		return null;
	}

	public boolean actualizarLibro(Libro libro) throws SQLException {
		CallableStatement cstmt = miConnection.prepareCall("{call actualizarLibro(?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, libro.getISBN());
		cstmt.setString(2, libro.getAutor());
		cstmt.setString(3, libro.getTitulo());
		cstmt.setString(4, libro.getEditorial());
		cstmt.setInt(5, libro.getTema().getId());
		cstmt.setInt(6, libro.getEstadoEnum());
		cstmt.setInt(7, libro.getFormatoEnum());
		cstmt.setInt(8, libro.getCantidad());
		cstmt.setFloat(9, libro.getPrecio());
		cstmt.setBoolean(10, libro.isBorrado());
		cstmt.registerOutParameter(11, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(11);

	}

}
