package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simulacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Simulacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 242, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana, centrado, centrar

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECCIONA TEMPORADA");
		lblNewLabel.setBounds(132, 31, 496, 39);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		contentPane.add(lblNewLabel);
		
		JButton btnTemporada2007 = new JButton("Temporada 2007");
		btnTemporada2007.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NuevaTemporada2007 temp =new NuevaTemporada2007();
				temp.setVisible(true);
			}
		});
		btnTemporada2007.setBounds(290, 204, 161, 66);
		contentPane.add(btnTemporada2007);
	}
}
