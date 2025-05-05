package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarPilotos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public GestionarPilotos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIONAR PILOTO");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblNewLabel.setBounds(203, 33, 381, 52);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("AÑADIR PILOTO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirPilotos temp=new AñadirPilotos();
				temp.setVisible(true);
			}
		});
		btnNewButton.setBounds(61, 190, 122, 31);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VER PILOTOS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPilotos temp=new VerPilotos();
				temp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(239, 190, 122, 31);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ELIMINAR PILOTO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(417, 190, 122, 31);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("MODIFICAR PILOTO");
		btnNewButton_2_1.setBounds(596, 190, 131, 31);
		getContentPane().add(btnNewButton_2_1);
		
		
		
	}
}
