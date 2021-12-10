package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Methods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Registration extends JFrame {

	 // Aquí se registran los usuarios para agregar a la BDA.
	
	
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField texNumero;
	private JTextField textCorreo;
	private JPasswordField passContra;
	private JTextField textUsauario;
	private JPasswordField passwordField;
	Methods metodos = Methods.getInstance();
	
	
	/**
	 * Launch the application.
	 */
	//Clases main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	//Constructor y procesos
	
	public Registration() {
		// Desde este punto comienza el diseño de nuestra interfaz gráfica.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(38, 127, 399, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(38, 173, 399, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de tel\u00E9fono:");
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(38, 225, 277, 27);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_2_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_2_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2_1.setBounds(287, 83, 150, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2_2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2_2.setBounds(287, 140, 150, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Confirmar contrase\u00F1a:");
		lblNewLabel_2_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_2_3.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2_3.setBounds(287, 187, 150, 27);
		contentPane.add(lblNewLabel_2_3);
		
		//Textbox para la celda nombre.
		textNombre = new JTextField();
		textNombre.setBounds(116, 130, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(116, 176, 86, 20);
		contentPane.add(textApellido);
		//Textbox para la celda del Apellido.
		
		texNumero = new JTextField();
		texNumero.setColumns(10);
		texNumero.setBounds(149, 227, 114, 20);
		contentPane.add(texNumero);
		
		//Textbox para la celda del correo electrónico
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(405, 86, 107, 20);
		contentPane.add(textCorreo);
		
		//Textbox para la celda de la contraseña.
		passContra = new JPasswordField();
		passContra.setBounds(389, 143, 123, 20);
		contentPane.add(passContra);
		
		JButton btnRegistral = new JButton("Registrar");
		btnRegistral.setBackground(new Color(128, 128, 128));
		btnRegistral.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnRegistral.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			 //Por aquí tenemos la función de botón para registrar.
			
			public void actionPerformed(ActionEvent e) {
				//En esta parte validamoos  el botón de registrar.
				String s =passContra.getText();
				String x = passwordField.getText();
				
              String v="",v1="",v2="",v3="",v4="",v5="",v6="";
              
              if(textUsauario.getText().equals("")) {
            	v="Usauario";  
              }
           
              //Esta es la celda de la contraseña.
				if(passContra.getText().equals("")) {
					v1=",Contraseña";
				}
				if(textNombre.getText().equals("")) {
					v2=",Nombre";
				}
		        if(textApellido.getText().equals("")) {
		            v3 = ",Apellido"; 	
		        }if(texNumero.getText().equals("")) {
		        	v4 = ",Numero de telefono";
		        }if(textCorreo.getText().equals("")) {
		        	v5 = ",Correo Eletronico";
		        	
		        }if(passwordField.getText().equals("")) {
		        	v6 = ",Confirmacion de contraseña";
		        }if(textUsauario.getText().equals("")|| passContra.getText().equals("")|| textNombre.getText().equals("")|| textApellido.getText().equals("") || texNumero.getText().equals("") || (textCorreo.getText().equals("") || passwordField.getText().equals(""))){
		 			JOptionPane.showMessageDialog(null, "No debes dejar campos vacíos, por favor rellene los siguientes campos: "+v+""+v1+""+v2+""+v3+""+v4+""+v5+""+v6+"." );
		        
		        
		        }else {
		        	
            	if(s.equals(x)) {
            		//En este botón logramos agregar los usuarios a la BDA.
    				metodos.guardar(textUsauario.getText(),textNombre.getText(),textApellido.getText(),texNumero.getText(),textCorreo.getText(),passContra.getText());
    				JOptionPane.showMessageDialog(contentPane, "Se ha registrado exitosamente");
   
    				Login Log = new Login();
    				Log.setVisible(true);
    				dispose();
 
    			}else {
    				JOptionPane.showMessageDialog(contentPane, "La contraseña es incorrecta");
    				
    			}	
 
            }		
 			
			}
			});
		btnRegistral.setBounds(144, 297, 89, 23);
		contentPane.add(btnRegistral);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			 //Este bontón tiene la función de regresar (Volver).

			public void actionPerformed(ActionEvent e) {
			//Con este botón puedes regresar al login.
			
			Login Log = new Login();	
			Log.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBounds(376, 297, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(38, 86, 399, 14);
		contentPane.add(lblNewLabel_3);
		
		//Celda usuario.
		textUsauario = new JTextField();
		textUsauario.setBounds(116, 83, 86, 20);
		contentPane.add(textUsauario);
		textUsauario.setColumns(10);
		
		//Celda donde alamacenamos la confirmación de la contraseña.
		passwordField = new JPasswordField();
		passwordField.setBounds(420, 190, 128, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Registro");
		lblNewLabel_4.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(252, 25, 128, 27);
		contentPane.add(lblNewLabel_4);
	}
}
