package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.EventTarget;

import com.mysql.cj.protocol.Resultset;

import Conexion.Conection;
import Conexion.Methods;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal_Screen extends JFrame {

	// Esta es la clase que le permite ver los usuarios por pantalla, además tenemos las variables utilizadas.
			
	Conection con = new Conection();
	String[] datos = new String[5];
	public int h;
		
	Conection cn; 
	Statement st;
	Resultset rs;
	DefaultTableModel Model = new DefaultTableModel(); 
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	//Clase main 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Screen frame = new Principal_Screen();
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
	//Este es el Constructor y los procesos
		
	public Principal_Screen() {
		// Inicia el interfaz gráfico

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setBackground(new Color(128, 128, 128));
		btnEliminar.addActionListener(new ActionListener() {
			// la fucionalidad del botón Eliminar.
			public void actionPerformed(ActionEvent e) {
				// te perminte al hacer clik en el botón pasar a la clase Eliminar.
				EliminarUsu eli = new EliminarUsu();
				dispose();
				eli.setVisible(true);

           }
		});
		btnEliminar.setBounds(570, 124, 157, 30);
		contentPane.add(btnEliminar);
		
		JButton btnSalir = new JButton("Cerrar secci\u00F3n");
		btnSalir.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		btnSalir.setBackground(new Color(128, 128, 128));
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setBounds(567, 275, 160, 30);
		btnSalir.addActionListener(new ActionListener() {

			//Aquí está la funcionalidad del botón Cerra sesión.

	    public void actionPerformed(ActionEvent e) {
	    	// este botón te permite pasa la clase logeo donde tendrá que inicial sección nuevamente.
	    	    Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
	
		// muestra el nombre las columnas.
		
		Model.addColumn("Usuario");
		Model.addColumn("Nombre");
		Model.addColumn("Apellido");
		Model.addColumn("Telefono");
		Model.addColumn("Email");
		//Muestra los datos almacenados.
		
        mostrar();
						
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
				}
		);
		scrollPane_1.setBounds(34, 38, 490, 279);
		contentPane.add(scrollPane_1);
		
		table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {
				});
		scrollPane_1.setViewportView(table);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		btnActualizar.setForeground(new Color(0, 0, 0));
		btnActualizar.setBackground(new Color(128, 128, 128));
		btnActualizar.addActionListener(new ActionListener() {
			//Funcionalidad del botón.
			public void actionPerformed(ActionEvent e) {
			// te permite entrar a la clase actualizar
				ActualizarUsu act= new ActualizarUsu();
				act.setVisible(true);
				dispose();
			}
		});
		btnActualizar.setBounds(573, 61, 154, 30);
		contentPane.add(btnActualizar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			//Te regresa al menú.
			public void actionPerformed(ActionEvent e) {
				Dashboard Menu = new Dashboard();
				Menu.setVisible(true);
				dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		btnVolver.setBackground(new Color(128, 128, 128));
		btnVolver.setBounds(567, 202, 160, 30);
		contentPane.add(btnVolver);
		//Finaliza el interfaz gráfico.			
	}
	
	//Función mostrar.
	public void mostrar() {
		// Saca las info. del usuario.

		Model.setRowCount(0);
		String sql = "select * from usuarios";
		Connection meer = Conection.getConexion();
		try {
			st =  meer.createStatement();
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
			System.out.println(result.getString(1));
			datos[0] = result.getString(2);
			datos[1] = result.getString(3);
			datos[2] = result.getString(4);
			datos[3] = result.getString(5);
			datos[4] = result.getString(6);
			Model.addRow(datos);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}	
}