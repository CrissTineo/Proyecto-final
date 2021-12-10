package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionU.gestionUser;
import Tramite.Username;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

		//Aquí están todas las variables utilizadas.
		
		
	private JPanel contentPane;
	private JTextField textusuario;
	private JPasswordField passContra;

	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases.  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	public Login() {
		//Inicia el interfaz gráfico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(48, 84, 147, 35);
		contentPane.add(lblNewLabel);
		//Celda del usuario. 
		textusuario = new JTextField();
		textusuario.setBounds(144, 87, 153, 28);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		//Celda de la Contraseña
		passContra = new JPasswordField();
		passContra.setBounds(162, 156, 175, 33);
		contentPane.add(passContra);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(47, 156, 148, 35);
		contentPane.add(lblNewLabel_1);

		//El botón Enter.
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(128, 128, 128));
		btnEnter.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		btnEnter.addActionListener(new ActionListener() {
			//Función del botón.
			public void actionPerformed(ActionEvent e) {
			Enter();
			}
		});
		btnEnter.setBounds(78, 221, 89, 23);
		contentPane.add(btnEnter);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			//La función del botón que te dirige a registrar. 

			public void actionPerformed(ActionEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(243, 221, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setBounds(170, 37, 111, 28);
		contentPane.add(lblNewLabel_2);
		// Finaliza el interfaz gráfico.		

	}
	//Esta es la funcion de Enter
	protected void Enter() {
		//ESte busca en la BDA al usuario para ver si está correcto.
		String usuario = textusuario.getText();
		String Contraseña = String.valueOf(passContra.getPassword());
		gestionUser gestionUsuario = new gestionUser();
		
		Username usuario2 = new Username();
		usuario2.setUsuario(usuario);
		usuario2.setContraseña(Contraseña);
		
		
		Username usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			Dashboard Menu = new Dashboard();
			Menu.setVisible(true);
			dispose();
			
		 }else {
			 JOptionPane.showMessageDialog(contentPane,"Debe ingresar su usuario \r\n"
			 		+ "y contraseña, si no está registrado; Por favor registrarse." ,"Error", JOptionPane.ERROR_MESSAGE);
		 }	
		

	}
}
