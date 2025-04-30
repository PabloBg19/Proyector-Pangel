package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class F1View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public F1View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestionar Pilotos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarPilotos temp=new GestionarPilotos();
				temp.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(113, 137, 272, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("MENÚ DE GESTIÓN");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblNewLabel.setBounds(200, 24, 394, 63);
		contentPane.add(lblNewLabel);
		
		JButton btnGestionarEquipos = new JButton("Gestionar Equipos");
		btnGestionarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarEquipo temp=new GestionarEquipo();
				temp.setVisible(true);
			}
		});
		btnGestionarEquipos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarEquipos.setBounds(113, 220, 272, 54);
		contentPane.add(btnGestionarEquipos);
		
		JButton btnGestionarTemporadas = new JButton("Gestionar Temporadas");
		btnGestionarTemporadas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarTemporadas.setBounds(113, 307, 272, 54);
		contentPane.add(btnGestionarTemporadas);
		
		JLabel label = new JLabel("");
		label.setBounds(483, 137, 69, 54);
		contentPane.add(label);

		// Código para poner la imagen que se adapta de forma dinámica
		ImageIcon icon = new ImageIcon(F1View.class.getResource("/image/Casco.png"));
		Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(img));


	}
}
