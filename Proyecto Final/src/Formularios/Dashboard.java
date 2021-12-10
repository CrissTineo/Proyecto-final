package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame {

	//Aquí están todas las variables utilizadas.
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//Clase main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	//Este es el Constructor y procesos.
	public Dashboard() {
		//Inicia el interfaz grafico.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Usuario");
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/Formularios/los-usuarios-del-grupo.png")));
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del boton Usuario.
			public void actionPerformed(ActionEvent e) {
				//Te lleva a la interfaz de Usuario.
				Principal_Screen Prin = new Principal_Screen();
				Prin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(123, 78, 151, 54);
		contentPane.add(btnNewButton);
		//El botón de los productos.

		JButton btnNewButton_1 = new JButton("Producto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ESte nos lleva a la interfaz del productos.
				Products produ = new Products();
				produ.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Formularios/product.png")));
		btnNewButton_1.setBackground(new Color(218, 165, 32));
		btnNewButton_1.setBounds(123, 164, 151, 54);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(165, 30, 151, 37);
		contentPane.add(lblNewLabel);
	}
	//Finaliza el interfaz gráfico.		

}
