package modelo.accesoBBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class AccesoBBDDLibreria {
	private AccesoBBDD acceso;
	protected Connection miConnection=null;
	
	protected AccesoBBDDLibreria() throws ClassNotFoundException, SQLException {
		acceso=AccesoBBDD.getinstance();
		miConnection=acceso.getMiConexion();
	}
}
