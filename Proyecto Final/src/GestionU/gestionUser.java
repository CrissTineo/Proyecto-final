package GestionU;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.Conection;
import Tramite.Username;


public class gestionUser {
	
	// Se utiliza para obtener las informaciones d elos usuarios.
	public Username obtenerUsuario(Username usu) { 
		Username usuario = null;
		Connection con = null; 
		PreparedStatement pst = null;
		ResultSet rs = null;
		//Se comprueban  las funciones.
		try {
			//Aqui se utiliza la conexion a la base de datos creada en la clase Conexion.
			con = Conection.getConexion();
			//se utiliza query para validar usuario.
			String Sql = "select UserName,Password From usuarios where UserName = ? and Password = ?";
			pst = con.prepareStatement(Sql);
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			
			
			rs = pst.executeQuery();
			while(rs.next()) {
				usuario = new Username(rs.getString(1),rs.getString(2));
			}
		//Demostraciones de error.
		}catch(Exception e) {
		 System.out.println("Error en obtener usuario");	
		}
		return usuario;
		
	}


}
  
