package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import Conexion.Conection;
import Conexion.Methods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ActualizarUsu extends JFrame {

	
	
		//Aquí están todas las variables utilizadas.
		
	Conection con = new Conection();

	Conection cn; 
	Statement st;
	Resultset rs;

	
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNumero;
	private JTextField textCorreo;
	private JPasswordField passContra;
	private JPasswordField passConf;
	private JTextField textActualizar;

	/**
	 * Launch the application.
	 */
	//clase main

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarUsu frame = new ActualizarUsu();
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
	
	
     	//Este es el Constructor y  procesos.
		

	public ActualizarUsu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 334);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 250, 250));
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(10, 58, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblContrasea.setForeground(new Color(255, 250, 250));
		lblContrasea.setBounds(215, 97, 110, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setForeground(new Color(255, 250, 250));
		lblNombre.setBounds(10, 100, 84, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblApellido.setForeground(new Color(255, 250, 250));
		lblApellido.setBounds(10, 137, 84, 14);
		contentPane.add(lblApellido);
		
		JLabel lblNumeroTelefonico = new JLabel("N\u00FAmero Tel\u00E9fonico:");
		lblNumeroTelefonico.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNumeroTelefonico.setForeground(new Color(255, 250, 250));
		lblNumeroTelefonico.setBounds(10, 182, 147, 14);
		contentPane.add(lblNumeroTelefonico);
		
		JLabel lblConfimacionDeContrasea = new JLabel("Confirmar contrase\u00F1a:");
		lblConfimacionDeContrasea.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblConfimacionDeContrasea.setForeground(new Color(255, 250, 250));
		lblConfimacionDeContrasea.setBounds(215, 137, 175, 14);
		contentPane.add(lblConfimacionDeContrasea);
		
		JLabel lblActualizar = new JLabel("Actualizar:");
		lblActualizar.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblActualizar.setForeground(new Color(255, 250, 250));
		lblActualizar.setBounds(267, 182, 98, 14);
		contentPane.add(lblActualizar);
		//celda del Usuario
		textUsuario = new JTextField();
		textUsuario.setBounds(93, 55, 86, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		//celda del Nombre
		textNombre = new JTextField();
		textNombre.setBounds(93, 97, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		//celda del Apellido
		textApellido = new JTextField();
		textApellido.setBounds(93, 134, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		//celda del Número
		textNumero = new JTextField();
		textNumero.setBounds(146, 179, 86, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Correo Eletr\u00F3nico:");
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(215, 61, 138, 14);
		contentPane.add(lblNewLabel_1);
		//celda del  Correo.
		textCorreo = new JTextField();
		textCorreo.setBounds(342, 58, 138, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		//celda de la Contraseña.
		passContra = new JPasswordField();
		passContra.setBounds(322, 94, 158, 20);
		contentPane.add(passContra);
		//celda de la Confirmación de Contraseña.
		passConf = new JPasswordField();
		passConf.setBounds(369, 136, 158, 20);
		contentPane.add(passConf);
		//celda de Actualizar.
		textActualizar = new JTextField();
		textActualizar.setBounds(350, 181, 130, 20);
		contentPane.add(textActualizar);
		textActualizar.setColumns(10);
		//El botón para actualizar.
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(128, 128, 128));
		btnActualizar.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnActualizar.addActionListener(new ActionListener() {
			//aqui esta la fucionalidad del boton actualizar.

			public void actionPerformed(ActionEvent e) {
				// validador de as celdas del botón actualizar.
			
			Methods ds = Methods.getInstance();
			String i =passContra.getText();
			String v = passContra.getText();
          String s="",s1="",s2="",s3="",s4="",s5="",s6="";
          if(textActualizar.getText().equals("")) {
        	  JOptionPane.showMessageDialog(null, "Insertar el usuario que desea");  
          }else {
          if(textUsuario.getText().equals("")) {
        	s="Usauario";  
          }
			if(passContra.getText().equals("")) {
				s1=",Contraseña";
			}
			if(textNombre.getText().equals("")) {
				s2=",Nombre";
			}
	        if(textApellido.getText().equals("")) {
	            s3 = ",Apellido"; 	
	        }if(textNumero.getText().equals("")) {
	        	s4 = ",Número de teléfono";
	        }if(textCorreo.getText().equals("")) {
	        	s5 = ",Correo Eletrónico";
	        	
	        }if(passConf.getText().equals("")) {
	        	s6 = ",Confirmacion de contraseña";
	        }if(textUsuario.getText().equals("")|| passContra.getText().equals("")|| textNombre.getText().equals("")|| textApellido.getText().equals("") || textNumero.getText().equals("") || (textCorreo.getText().equals("") || passConf.getText().equals(""))){
	 			JOptionPane.showMessageDialog(null, " Campos vacios, por favor deben ser llenados: "+s+""+s1+""+s2+""+s3+""+s4+""+s5+""+s6+"." );
	        
	        
	        }else {
        	if(i.equals(v)) {
	        	// Se actualizan los usuario. 	
        		ds.Actualizar(textUsuario.getText(), passContra.getText(), textNombre.getText(), textApellido.getText(), textNumero.getText(), textCorreo.getText(), textActualizar.getText());
    			Principal_Screen prin = new Principal_Screen();
    			prin.setVisible(true);
    			
    						JOptionPane.showMessageDialog(contentPane, "Se ha Actualizado exitosamente");

				dispose();

			}else {
				JOptionPane.showMessageDialog(contentPane, "La contraseña no es correcta");
				
			}	

			}
          }
          }});
		btnActualizar.setBounds(132, 247, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(128, 128, 128));
		btnVolver.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnVolver.addActionListener(new ActionListener() {
			//Aquí el botón para retroceder.

			public void actionPerformed(ActionEvent e) {
				//Valida la celda volver.

				Principal_Screen prin1 = new Principal_Screen();
				prin1.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(332, 247, 89, 23);
		contentPane.add(btnVolver);
		//Finaliza el interfaz gráfico.		

	}

	
	}


