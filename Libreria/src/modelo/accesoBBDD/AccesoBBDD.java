package modelo.accesoBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBBDD {
	
	private   String usuario=null;
	private   String password=null;
	private    String nombreDB=null;
	
	
	private  final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection miConexion=null;
	private String URL="jdbc:mysql://localhost:3306/model?userInformationSchema=true&serveTimezone=EST5EDT";
	private static AccesoBBDD accessBBDD=null;
	
	public static AccesoBBDD getinstance() throws ClassNotFoundException, SQLException {
		if (accessBBDD==null) {
			accessBBDD=new AccesoBBDD();
			return accessBBDD;
		}
		return accessBBDD;
	}
	
	private AccesoBBDD() throws ClassNotFoundException, SQLException {
		super();
		nombreDB="libreria";
		usuario="root";
		password="";
		this.URL=this.URL.replace("model", nombreDB);
		Class.forName(this.DRIVER);
		miConexion=DriverManager.getConnection(this.URL,this.usuario,this.password);
		
	}

	public Connection getMiConexion() {
		return miConexion;
	}
	
}
