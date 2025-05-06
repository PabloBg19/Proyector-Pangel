package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIONAR EQUIPOS");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblNewLabel.setBounds(178, 32, 422, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Equipos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(60, 226, 108, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Equipo");
		btnNewButton_1.setBounds(216, 226, 130, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Añadir Equipo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(400, 226, 117, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar Equipo");
		btnNewButton_3.setBounds(580, 226, 123, 33);
		contentPane.add(btnNewButton_3);
		
		JLabel lblimgVerEquipo = new JLabel("New label");
		lblimgVerEquipo.setIcon(new ImageIcon(GestionarEquipos.class.getResource("/image/VerEquipo.png")));
		lblimgVerEquipo.setBounds(80, 159, 68, 56);
		contentPane.add(lblimgVerEquipo);
		
		//Adaptar imagen dinámicamente
		ImageIcon icon = new ImageIcon(MenuDeGestion.class.getResource("/image/VerEquipo.png"));
		Image img = icon.getImage().getScaledInstance(lblimgVerEquipo.getWidth(), lblimgVerEquipo.getHeight(), Image.SCALE_SMOOTH);
		lblimgVerEquipo.setIcon(new ImageIcon(img));
		
		JLabel lblimgModificarEquipo = new JLabel("New label");
		lblimgModificarEquipo.setIcon(new ImageIcon(GestionarEquipos.class.getResource("/image/ModificarEquipo.png")));
		lblimgModificarEquipo.setBounds(252, 162, 55, 50);
		contentPane.add(lblimgModificarEquipo);
		
		//Adaptar imagen dinámicamente
				ImageIcon icon2 = new ImageIcon(MenuDeGestion.class.getResource("/image/ModificarEquipo.png"));
				Image img2 = icon2.getImage().getScaledInstance(lblimgModificarEquipo.getWidth(), lblimgModificarEquipo.getHeight(), Image.SCALE_SMOOTH);
				lblimgModificarEquipo.setIcon(new ImageIcon(img2));
		
		JLabel lblimgAnadirEquipo = new JLabel("New label");
		lblimgAnadirEquipo.setIcon(new ImageIcon(GestionarEquipos.class.getResource("/image/AnadirEquipo.png")));
		lblimgAnadirEquipo.setBounds(426, 159, 61, 56);
		contentPane.add(lblimgAnadirEquipo);
		
		//Adaptar imagen dinámicamente
				ImageIcon icon3 = new ImageIcon(MenuDeGestion.class.getResource("/image/anadirEquipo.png"));
				Image img3 = icon3.getImage().getScaledInstance(lblimgAnadirEquipo.getWidth(), lblimgAnadirEquipo.getHeight(), Image.SCALE_SMOOTH);
				lblimgAnadirEquipo.setIcon(new ImageIcon(img3));
		
		JLabel lblimgEliminarEquipo = new JLabel("New label");
		lblimgEliminarEquipo.setIcon(new ImageIcon(GestionarEquipos.class.getResource("/image/EliminarEquipo.png")));
		lblimgEliminarEquipo.setBounds(612, 162, 55, 50);
		contentPane.add(lblimgEliminarEquipo);
		
		//Adaptar imagen dinámicamente
				ImageIcon icon4 = new ImageIcon(MenuDeGestion.class.getResource("/image/EliminarEquipo.png"));
				Image img4 = icon4.getImage().getScaledInstance(lblimgEliminarEquipo.getWidth(), lblimgEliminarEquipo.getHeight(), Image.SCALE_SMOOTH);
				lblimgEliminarEquipo.setIcon(new ImageIcon(img4));
	}
}
