package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GestionarTemporada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public GestionarTemporada() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana, centrado, centrar


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestionar Temporada");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(201, 24, 325, 90);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEnviar_1 = new JButton("Añadir Temporada");
		btnEnviar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AnadirTemporada temp=new AnadirTemporada(); //construir nueva ventana
				temp.setVisible(true); //hacer visible la ventana
				
			}
		});
		btnEnviar_1.setBounds(74, 268, 169, 52);
		contentPane.add(btnEnviar_1);
		
		JButton btnEnviar_2 = new JButton("Modificar Temporada");
		btnEnviar_2.setBounds(267, 268, 160, 52);
		contentPane.add(btnEnviar_2);
		
		JButton btnEnviar_3 = new JButton("Eliminar Temporada");
		btnEnviar_3.setBounds(451, 268, 160, 52);
		contentPane.add(btnEnviar_3);
	}
}
