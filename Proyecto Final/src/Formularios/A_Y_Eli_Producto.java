package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conection;
import Conexion.Methods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class A_Y_Eli_Producto extends JFrame {
   
	
	//Aquí estan todas la variabes utilizadas.
	
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textCategoria;
	private JTextField textPrecio;
	private JTextField textCant_disponible;
	Methods Met =Methods.getInstance();
	DefaultTableModel Model = new DefaultTableModel();
	public String id = "0";
	
		public String Nombre;
		public String Marca;
		public String Categoria;
		public String Precio;
		public String Cantid_ds;
	Statement st;
	/**
	 * Launch the application.
	 */
	//Clase main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Y_Eli_Producto frame = new A_Y_Eli_Producto("a");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//Este es el Constructor y tenemos los procesos.
	
	public A_Y_Eli_Producto(String a) {
		id = a;
		// Inicia  el interfaz gráfico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 50, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(10, 70, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(10, 107, 138, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categor\u00EDa");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(10, 150, 138, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(281, 73, 138, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad disponible");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_4.setBounds(281, 119, 138, 14);
		contentPane.add(lblNewLabel_4);
		if (a != "a") {info();}
		//Celda del Nombre. 
		textNombre = new JTextField();
		textNombre.setText(Nombre);
		textNombre.setBounds(89, 67, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		//Celda de la Marca.
		textMarca = new JTextField();
		textMarca.setText(Marca);
		textMarca.setColumns(10);
		textMarca.setBounds(89, 104, 86, 20);
		contentPane.add(textMarca);
		//Celda de la Categoria.
		textCategoria = new JTextField();
		textCategoria.setText(Categoria);
     	textCategoria.setColumns(10);
		textCategoria.setBounds(112, 147, 86, 20);
		contentPane.add(textCategoria);
		//Celda del Precio.
		textPrecio = new JTextField();
		textPrecio.setText(Precio);
		textPrecio.setColumns(10);
		textPrecio.setBounds(360, 70, 86, 20);
		contentPane.add(textPrecio);
		//Celda de la Cantidad disponible.
		textCant_disponible = new JTextField();
		textCant_disponible.setText(Cantid_ds);
		textCant_disponible.setColumns(10);
		textCant_disponible.setBounds(398, 117, 86, 20);
		contentPane.add(textCant_disponible);
				   

      //botòn Actualizar.			
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
			//aqui esta la fucionalidad del boton actualizar.
			public void actionPerformed(ActionEvent e) {
				//Valida el botón de actualizar.
				String s="",s1="",s2="",s3="",s4="";
				
				if(textNombre.getText().equals("")) {
	            	s="Nombre";  
	              }
					if(textMarca.getText().equals("")) {
						s1=",Marca";
					}
					if(textCategoria.getText().equals("")) {
						s2=",Categoria";
					}
			        if(textPrecio.getText().equals("")) {
			            s3 = ",Precio"; 	
			        }if(textCant_disponible.getText().equals("")) {
			        	s4 = ",Cantidad disponible";
			        }if(textNombre.getText().equals("")|| textMarca.getText().equals("")|| textCategoria.getText().equals("")|| textPrecio.getText().equals("") || textCant_disponible.getText().equals("") ){
			        	JOptionPane.showMessageDialog(contentPane,e,"Campos vacíos, por favor llenar: "+s+""+s1+""+s2+""+s3+""+s4+".", JOptionPane.ERROR_MESSAGE);
			        
			        
			        }else {
			        	//Este Actualizanlos productos. 
			        	
			        	Met.ActualizarProdu(id,textNombre.getText(),textMarca.getText(), textCategoria.getText(),textPrecio.getText(),textCant_disponible.getText());
		    				JOptionPane.showMessageDialog(contentPane, "Se ha Actualizo exitosamente");
		    				Products Prod = new Products();

		    				Prod.setVisible(true);
		    				dispose();
		    				
	    			}	
	 
					
			}
		});
		btnNewButton.setBounds(112, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del boton Eliminar.
			public void actionPerformed(ActionEvent e) {
				//valida la celda de eliminar.
                String s="",s1="",s2="",s3="",s4="";
				
				if(textNombre.getText().equals("")) {
	            	s="Nombre";  
	              }
					if(textMarca.getText().equals("")) {
						s1=",Marca";
					}
					if(textCategoria.getText().equals("")) {
						s2=",Categoria";
					}
			        if(textPrecio.getText().equals("")) {
			            s3 = ",Precio"; 	
			        }if(textCant_disponible.getText().equals("")) {
			        	s4 = ",Cantidad disponible";
			        }if(textNombre.getText().equals("")|| textMarca.getText().equals("")|| textCategoria.getText().equals("")|| textPrecio.getText().equals("") || textCant_disponible.getText().equals("") ){
			        	JOptionPane.showMessageDialog(contentPane,e,"Campos vacíos, por favor llenar: "+s+""+s1+""+s2+""+s3+""+s4+".", JOptionPane.ERROR_MESSAGE);
			        
			        
			        }else {
			        	Met.eliminalProd(id);
		    				JOptionPane.showMessageDialog(contentPane, "Se ha eliminado exitosamente");
		    				Products Prod = new Products();
		    				Prod.setVisible(true);
		    				dispose();
		    			}	
		    
			}
		});
		btnNewButton_1.setBounds(314, 212, 89, 23);
		contentPane.add(btnNewButton_1);
// Finaliza el interfaz grafico.		
		
	}
	//esta es la funcion de info
	public void info() {
	// Esta clase busca los productos según su id.
		String sql = "select * from productos where idProducto = "+id;
		
		
		Connection meer = Conection.getConexion();
		try {
			st =   meer.createStatement();
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Nombre = result.getString(2);
				Marca = result.getString(3);
				Categoria = result.getString(4);
				Precio = result.getString(5);
				Cantid_ds = result.getString(6);
			}
					
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
 
	
}

