package Conexion;
import java.sql.*;
public class Conection {
    public static Connection  getConexion() {
		// Esta clase se utiliza para hacer la conexi�n remota a la BDA.
    	Connection con = null; 
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/almacenitlafinal?useUnicode=true$use "
					+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
					+ "serverTimezone=UTC";
			String usuario = "estuditlafinal";
			String contrase�a = "itla123.";
			
			con = DriverManager.getConnection(url,usuario,contrase�a);
		// Demostraci�n de los errores.
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error --> con la BDA");
			e.printStackTrace();
		}
		return con;
	}
}
