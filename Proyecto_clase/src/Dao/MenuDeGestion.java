package Dao;

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
	 * Crea el frame.
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
		
		JButton btnGestionarPilotos = new JButton("Gestionar Pilotos");
		btnGestionarPilotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPilotos temp=new VerPilotos();
				temp.setVisible(true);
			}
		});
		btnGestionarPilotos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarPilotos.setBounds(113, 180, 272, 54);
		contentPane.add(btnGestionarPilotos);
		
		JLabel lblMenuGestion = new JLabel("MENÚ DE GESTIÓN");
		lblMenuGestion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblMenuGestion.setBounds(200, 32, 394, 63);
		contentPane.add(lblMenuGestion);
		
		JButton btnGestionarEquipos = new JButton("Gestionar Equipos");
		btnGestionarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarEquipos temp=new GestionarEquipos();
				temp.setVisible(true);
			}
		});
		btnGestionarEquipos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarEquipos.setBounds(113, 277, 272, 54);
		contentPane.add(btnGestionarEquipos);
		
		JLabel label_casco = new JLabel("");
		label_casco.setBounds(483, 180, 69, 54);
		contentPane.add(label_casco);

		// Código para poner la imagen que se adapta de forma dinámica
		ImageIcon icon = new ImageIcon(MenuDeGestion.class.getResource("/image/Casco.png"));
		Image img = icon.getImage().getScaledInstance(label_casco.getWidth(), label_casco.getHeight(), Image.SCALE_SMOOTH);
		label_casco.setIcon(new ImageIcon(img));
		
		JLabel label_coche = new JLabel("");
		label_coche.setBounds(468, 269, 103, 77);
		contentPane.add(label_coche);
		
		// Código para poner la imagen que se adapta de forma dinámica

		ImageIcon icon2 = new ImageIcon(MenuDeGestion.class.getResource("/image/Coche.png"));
		Image img2 = icon2.getImage().getScaledInstance(label_coche.getWidth(), label_coche.getHeight(), Image.SCALE_SMOOTH);
		label_coche.setIcon(new ImageIcon(img2));
		
		ImageIcon icon3 = new ImageIcon(MenuDeGestion.class.getResource("/image/Track.png"));

	}
}
