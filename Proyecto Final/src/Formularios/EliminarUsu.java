package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Methods;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EliminarUsu extends JFrame {
 
	 
	
		//Aquí están todas la variables utilizads. 
	
	private JPanel contentPane;
	private JTextField txtEliminar;
	Methods mosw = Methods.getInstance();

	/**
	 * Launch the application.
	 */
	//Clase main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarUsu frame = new EliminarUsu();
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
	//Este es el Constructor y los procesos.
		
	public EliminarUsu() {
		//Inicia el interfaz gráfico.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 260);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      	//celda Eliminar. 
		txtEliminar = new JTextField();
		txtEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		txtEliminar.setFont(new Font("Onyx", Font.PLAIN, 16));
		txtEliminar.setBounds(41, 90, 221, 24);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		//Botón para Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(128, 128, 128));
		btnEliminar.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnEliminar.addActionListener(new ActionListener() {
			//Función del botón.
			public void actionPerformed(ActionEvent e) {
				//Validación de la celda eliminar.
				mosw.eliminal(txtEliminar.getText());		
			    JOptionPane.showMessageDialog(contentPane, "Se ha eliminado con exitosamente");			    
				Principal_Screen prin = new Principal_Screen();	
			    prin.setVisible(true); 				
			    dispose();
			    //System.out.println(prin.h);
			    
			}
		});
		btnEliminar.setBounds(22, 172, 119, 23);
		contentPane.add(btnEliminar);
		//El botón para salir.
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(128, 128, 128));
		btnSalir.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnSalir.addActionListener(new ActionListener() {
			//Función del botón.

			public void actionPerformed(ActionEvent e) {
				Principal_Screen prin = new Principal_Screen();	
				prin.setVisible(true);	
				dispose();

			}
		});
		btnSalir.setBounds(174, 172, 119, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(120, 42, 94, 20);
		contentPane.add(lblNewLabel);
		// Finaliza el interfaz gráfico.		

	}

}
