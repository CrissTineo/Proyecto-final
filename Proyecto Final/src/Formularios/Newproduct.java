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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Newproduct extends JFrame {
	   
		//Aquí están todas la variables utilizadas. 
		
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField textPrecio;
	private JTextField textCantidad_dis;
	Methods Met = Methods.getInstance(); 
	

	/**
	 * Launch the application.
	 */
	//Clase main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newproduct frame = new Newproduct();
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
	//Este es el Constructor 
	
	public Newproduct() {
		// Inicia el interfaz gráfico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 240));
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(32, 57, 80, 14);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(122, 55, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(32, 105, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 240));
		lblNewLabel_2.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(248, 60, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad disponible");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(248, 105, 125, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Categor\u00EDa");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 240));
		lblNewLabel_4.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(32, 142, 60, 14);
		contentPane.add(lblNewLabel_4);
		//Celda de la Marca.
		txtMarca = new JTextField();
		txtMarca.setBounds(122, 103, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		//Celda de la Categoria
		txtCategoria = new JTextField();
		txtCategoria.setBounds(122, 140, 86, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		//Celda del Precio
		textPrecio = new JTextField();
		textPrecio.setBounds(305, 56, 100, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		//Celda de la Cantidad disponible
		textCantidad_dis = new JTextField();
		textCantidad_dis.setBounds(383, 104, 86, 20);
		contentPane.add(textCantidad_dis);
		textCantidad_dis.setColumns(10);
		
		

	//el botón de agregar
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
		 //Su funcionalidad
			public void actionPerformed(ActionEvent e) {	
				
		//Validación del botón.
			String s="",s1="",s2="",s3="",s4="";
	          
              if(txtNombre.getText().equals("")) {
            	s=",Nombre";  
              }
				if(txtMarca.getText().equals("")) {
					s1=",Marca";
				}
				if(txtCategoria.getText().equals("")) {
					s2=",Categoria";
				}
		        if(textPrecio.getText().equals("")) {
		            s3 = ",Precio"; 	
		        }if(textCantidad_dis.getText().equals("")) {
		        	s4 = ",Cantidad disponible";
		        }if(txtNombre.getText().equals("")|| txtMarca.getText().equals("")|| txtCategoria.getText().equals("")|| textPrecio.getText().equals("") || textCantidad_dis.getText().equals("") ){
    				JOptionPane.showMessageDialog(contentPane,e,"No debes dejar campos vacíos, por favor rellene los siguientes campos: "+s+""+s1+""+s2+""+s3+""+s4+".", JOptionPane.ERROR_MESSAGE);

		        
		        }else {
		        	// En este se agregan los productos.
		        	Met.guardarProdu(txtNombre.getText(),txtMarca.getText(), txtCategoria.getText(), textPrecio.getText(), textCantidad_dis.getText());
	    				JOptionPane.showMessageDialog(contentPane, "Se ha guardado con exito");
	    				Products Pts = new Products();
	    				Pts.setVisible(true);
	    				dispose();
	    				
    			}	
 	
			}
		});
		btnNewButton.setBounds(128, 197, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			//funcionalidad del botón volver.
			
			public void actionPerformed(ActionEvent e) {
			//Te permite volver a la calse productos.
			Products Pst= new Products();
			Pst.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(284, 197, 89, 23);
		contentPane.add(btnNewButton_1);
		// finaliza el interfaz gráfico.		

	}
	
}
