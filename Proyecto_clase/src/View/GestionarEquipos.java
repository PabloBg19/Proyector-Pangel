package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class GestionarEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GestionarEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIONAR EQUIPOS");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblNewLabel.setBounds(158, 30, 422, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Pilotos");
		btnNewButton.setBounds(77, 193, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Pilotos");
		btnNewButton_1.setBounds(258, 193, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(437, 193, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(600, 193, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
