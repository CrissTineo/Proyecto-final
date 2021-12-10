package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;


public class Methods {
	// Estos metódos se utlizan para los de la BDA y podemos ver una pequeña desmotración del patrón de diseño Singelton.
	
	String[] datos = new String[4];
	DefaultTableModel Model = new DefaultTableModel(); 
	private static Methods Metodo;
	public static Conection Conexion = new Conection();
	Conection con = new Conection();
	Connection cn; 
	Statement st;
	Resultset rs;
	
	
	public static PreparedStatement sentencia_preparada;
	public static String sql;
	public static int resultado_numero = 0;
	
	//POdemos ver el constructor de la clase que es privado para demostrar el Singelton.
	private Methods(){
		
	}
	//Creamos el GetInstance.
	public static Methods getInstance() {
		if( Metodo == null ) {
			Metodo = new Methods();	
		}
		return Metodo;
	}
	//Este se utiliza para guardar los usuarios insertados por pantalla.
	public int guardar(String Usuario,String Nombre,String Apellido,String número_de_teléfono,String correo_eletrónico,String Contraseña) {
		
		int resultado = 0; 
		
		Connection conexion = null;
		
		String sentencia_guard = ("insert into usuarios(UserName, Nombre, Apellido, Telefono, Email, Password)VAlUES(?,?,?,?,?,?)");
		try {
			
			conexion = Conection.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_guard);
			sentencia_preparada.setString(1, Usuario);
			sentencia_preparada.setString(2, Nombre);
			sentencia_preparada.setString(3, Apellido);
			sentencia_preparada.setString(4, número_de_teléfono);
			sentencia_preparada.setString(5, correo_eletrónico);
			sentencia_preparada.setString(6, Contraseña);
			resultado = sentencia_preparada.executeUpdate();
			
			
			sentencia_preparada.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return resultado;		
	}
	
	
	// Este metódo se utiliza para eliminar los usuarios.  
	public int eliminal(String Usuario) {
		int resultado = 0; 
				
		Connection conexion = null;
		String sentencia_Eliminal = ("delete from usuarios where UserName = ?");
		try {
			conexion = Conection.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Eliminal);
			sentencia_preparada.setString(1, Usuario);
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return resultado;
    }
	//Este metódo se utiliza para eliminar los productos.
	public int eliminalProd(String id_productp) {
		int resultado = 0; 
		
		Connection conexion = null;
		String sentencia_Eliminal = ("delete from productos where idProducto = ?");
		try {
			conexion = Conection.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Eliminal);
			sentencia_preparada.setString(1, id_productp);
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return resultado;


    }

	
	
	//Este metodo se utiliza para Actualizar los datos de los usuarios que estan en la base de datos.
     public int Actualizar(String Usuario,String Nombre,String Apellido,String número_de_teléfono,String correo_eletrónico,String Contraceña,String Actualizar ) {
     
    	 int resultado = 0; 
    	 Connection conexion = null; 			 
     
    	 
     String sentencia_Actualizar = ("UPDATE usuarios SET UserName = ? , Nombre= ?, Apellido = ?, Telefono = ?, Email = ?,Password = ? WHERE UserName = ?");
		try {
			conexion = Conection.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Actualizar);
			sentencia_preparada.setString(1, Usuario);
			sentencia_preparada.setString(2, Contraceña);
			sentencia_preparada.setString(3, Nombre);
			sentencia_preparada.setString(4, Apellido);
			sentencia_preparada.setString(5, número_de_teléfono);
			sentencia_preparada.setString(6, correo_eletrónico);
			sentencia_preparada.setString(7, Actualizar);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();}catch (Exception e) {
		System.out.println(e);
		}
		return resultado;

     }
     // Se utiliza para Actualizar los datos de los productos.
     public int ActualizarProdu(String id_pro,String Nombre,String Marca,String categoría,String precio,String cantidad_disponible) {
         
    	 int resultado = 0; 
    	 Connection conexion = null; 			 
    	 int Id = Integer.parseInt(id_pro);
    	 
    	 
     String sentencia_Actualizar = ("UPDATE productos SET NombreProducto = ? ,MarcaProducto = ?, CategoriaProducto= ?, PrecioProducto = ?, StockProducto = ? WHERE idProducto = ?");
		try {
			conexion = Conection.getConexion();
			sentencia_preparada = conexion.prepareStatement(sentencia_Actualizar);
			sentencia_preparada.setString(1, Nombre);
			sentencia_preparada.setString(2, Marca);
			sentencia_preparada.setString(3, categoría);
			sentencia_preparada.setString(4, precio);
			sentencia_preparada.setString(5, cantidad_disponible);
			sentencia_preparada.setInt(6, Id);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();}catch (Exception e) {
		System.out.println(e);
		}
		return resultado;

     }
   //Este metódo se utiliza para guardar en la base de datos los productos en la BDA.
     public int guardarProdu(String Nombre,String Marca,String categoría,String precio,String cantidad_disponible) {
    	 int resultado = 0; 
  		Connection conexion = null;
  		
		
  		String sentencia_guard = ("insert into productos(NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, StockProducto)VAlUES(?,?,?,?,?)");
  		try {
  			conexion = Conection.getConexion();
  			sentencia_preparada = conexion.prepareStatement(sentencia_guard);
			sentencia_preparada.setString(1, Nombre);
			sentencia_preparada.setString(2, Marca);
			sentencia_preparada.setString(3, categoría);
			sentencia_preparada.setString(4, precio);
			sentencia_preparada.setString(5, cantidad_disponible);
			
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();

          }catch(Exception e) {
  			System.out.println(e);
  		}
  		
  		return resultado;
  		
  	}


 }	
	






		
	