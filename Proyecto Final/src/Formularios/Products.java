package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import Conexion.Conection;
import Conexion.Methods;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Products extends JFrame {

	
	
	//Aquí están todas la variabes utilizadas
	
		
	
	private JPanel contentPane;
	private JTable table;
	String[] datos = new String[6];	
 DefaultTableModel Model = new DefaultTableModel(); 
 Statement st;
	Resultset rs;
	
	Methods meg = Methods.getInstance();
	


	/**
	 * Launch the application.
	 */
	//Clase main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products frame = new Products();
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
	//Este es el Constructor y procesos
		
		
	public Products() {
		// Inicia el interfaz gráfico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 50, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 38, 487, 228);
		contentPane.add(scrollPane);
		table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {			@Override
			// estos es un eventos de click
			// Te proporciona a travez del id la persona que estás seleccionando.
			public void mouseClicked(MouseEvent e) {
					
			if(e.getClickCount()==1) {
				String b = (String) table.getValueAt(table.getSelectedRow(), 0).toString();
				A_Y_Eli_Producto  AcPr= new A_Y_Eli_Producto(b);
				AcPr.setVisible(true);
				
				dispose();

			}
}});
		scrollPane.setViewportView(table);
		//El botón nuevo.
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setFont(new Font("Onyx", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			// la fucionalidad del botón Nuevo.
			public void actionPerformed(ActionEvent e) {
			// te permite regresar a newproducts.
			Newproduct Nuevo = new Newproduct();	
			Nuevo.setVisible(true);
			dispose();
			}
		});
		btnNewButton.setBounds(66, 291, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			//Este te regresa al menú.
			public void actionPerformed(ActionEvent e) {
				Dashboard Menu = new Dashboard();
				Menu.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Onyx", Font.PLAIN, 18));
		btnVolver.setBounds(199, 293, 89, 23);
		contentPane.add(btnVolver);
		
		//aquí está la funcionalidad del botón cerrar sessión.
		JButton btnCerrarSeccion = new JButton("CERRAR SECCION");
        btnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Te regresa al login nuevamente.			
			Login lo= new Login();
			lo.setVisible(true);
			dispose();
			
			}
		});
		btnCerrarSeccion.setFont(new Font("Onyx", Font.PLAIN, 18));
		btnCerrarSeccion.setBounds(332, 293, 182, 23);
		contentPane.add(btnCerrarSeccion);

		// Te moestra la columna de datos.
		Model.addColumn("Id de producto");
		Model.addColumn("Nombre Producto");
		Model.addColumn("Marca Producto");
		Model.addColumn("Categoria Producto");
		Model.addColumn("Precio Producto");
		Model.addColumn("Stock Producto");
		//Muestra los datos almacenados.

		mostrar();
		
				
		
     
		
		
	}
    
	// Función de mostrar.
				
		public void mostrar() {
			// Extrae los datos de los usuarios
			A_Y_Eli_Producto  AcP= new A_Y_Eli_Producto("a");

			Model.setRowCount(0);
			String sql = "select * from productos";
			Connection meer = Conection.getConexion();
			try {
				st =  meer.createStatement();
				ResultSet result = st.executeQuery(sql);
				while(result.next()){
				System.out.println(result.getString(1));
				datos[0] = result.getString(1);
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				datos[3] = result.getString(4);
				datos[4] = result.getString(5);
				datos[5] = result.getString(6);
				
				
				Model.addRow(datos);				
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		
}

