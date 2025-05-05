package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerTemporada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * Create the frame.
	 */
	public VerTemporada() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana
		getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(777, 0, 7, 461);
		getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setBounds(516, 44, 206, 373);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(718, 44, 17, 373);
		getContentPane().add(scrollBar);
		
		JButton btnNewButton = new JButton("CAMPEONATO DE CONSTRUCTORES");
		btnNewButton.setBounds(108, 81, 222, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnCampeonatoDePilotos = new JButton("CAMPEONATO DE PILOTOS");
		btnCampeonatoDePilotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCampeonatoDePilotos.setBounds(108, 198, 222, 35);
		getContentPane().add(btnCampeonatoDePilotos);
		
		JButton btnAnteriorCarrera = new JButton("ANTERIOR CARRERA");
		btnAnteriorCarrera.setBounds(108, 313, 222, 35);
		getContentPane().add(btnAnteriorCarrera);
	}
}
