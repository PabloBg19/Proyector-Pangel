package Formula_Sim;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1980, 1080);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JButton btnFORMULA1 = new JButton("F1");
		btnFORMULA1.setIcon(new ImageIcon(App.class.getResource("/image/F1_button.png")));
		btnFORMULA1.setFont(new Font("Verdana Pro", Font.PLAIN, 27));
		btnFORMULA1.setBackground(new Color(0, 0, 0));
		btnFORMULA1.setForeground(new Color(128, 0, 0));
		btnFORMULA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFORMULA1.setBounds(92, 23, 439, 163);
		getContentPane().add(btnFORMULA1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(App.class.getResource("/image/F2_button.png")));
		btnNewButton.setBounds(709, 23, 494, 163);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon(App.class.getResource("/image/F3_Button.png")));
		btnNewButton_1.setSelectedIcon(new ImageIcon(App.class.getResource("/image/F3_Button.png")));
		btnNewButton_1.setBounds(1436, 23, 422, 163);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 197, 1964, 10);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(616, 0, 10, 207);
		getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(128, 0, 0));
		panel_1_1.setBounds(1315, 0, 10, 207);
		getContentPane().add(panel_1_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(80, 314, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(114, 380, 89, 23);
		getContentPane().add(btnNewButton_3);
	}
}
