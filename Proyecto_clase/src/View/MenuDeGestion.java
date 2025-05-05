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
import java.awt.Color;

public class MenuDeGestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuDeGestion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 242, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana, centrado, centrar


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestionar Pilotos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirPilotos temp=new AñadirPilotos();
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
				AnadirEquipo temp=new AnadirEquipo();
				temp.setVisible(true);
			}
		});
		btnGestionarEquipos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarEquipos.setBounds(113, 220, 272, 54);
		contentPane.add(btnGestionarEquipos);
		
		JButton btnGestionarTemporadas = new JButton("Gestionar Temporadas");
		btnGestionarTemporadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GestionarTemporada temp=new GestionarTemporada(); //construir nueva ventana
				temp.setVisible(true); //hacer visible la ventana
			}
		});
		btnGestionarTemporadas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarTemporadas.setBounds(113, 307, 272, 54);
		contentPane.add(btnGestionarTemporadas);
		
		JLabel label_casco = new JLabel("");
		label_casco.setBounds(483, 137, 69, 54);
		contentPane.add(label_casco);

		// Código para poner la imagen que se adapta de forma dinámica
		ImageIcon icon = new ImageIcon(MenuDeGestion.class.getResource("/image/Casco.png"));
		Image img = icon.getImage().getScaledInstance(label_casco.getWidth(), label_casco.getHeight(), Image.SCALE_SMOOTH);
		label_casco.setIcon(new ImageIcon(img));
		
		JLabel label_coche = new JLabel("");
		label_coche.setBounds(468, 212, 103, 77);
		contentPane.add(label_coche);
		
		// Código para poner la imagen que se adapta de forma dinámica

		ImageIcon icon2 = new ImageIcon(MenuDeGestion.class.getResource("/image/Coche.png"));
		Image img2 = icon2.getImage().getScaledInstance(label_coche.getWidth(), label_coche.getHeight(), Image.SCALE_SMOOTH);
		label_coche.setIcon(new ImageIcon(img2));
		
		
		JLabel label_track = new JLabel("");
		label_track.setBounds(468, 300, 103, 77);
		contentPane.add(label_track);
		
		ImageIcon icon3 = new ImageIcon(MenuDeGestion.class.getResource("/image/Track.png"));
		Image img3 = icon3.getImage().getScaledInstance(label_track.getWidth(), label_track.getHeight(), Image.SCALE_SMOOTH);
		label_track.setIcon(new ImageIcon(img3));

	}
}
