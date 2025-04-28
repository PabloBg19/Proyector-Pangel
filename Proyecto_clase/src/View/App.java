package View;
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
import java.awt.Graphics;
import java.awt.Image;

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
		JPanel contentPane = new JPanel() {
            private Image backgroundImage = new ImageIcon(App.class.getResource("/image/BG-1.jpeg")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        setContentPane(contentPane);
        contentPane.setLayout(null); // Usamos layout libre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1900, 1000); // Posición y tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana
		JButton btnFORMULA1 = new JButton("F1");
		btnFORMULA1.setIcon(new ImageIcon(App.class.getResource("/image/F1_button.png")));
		btnFORMULA1.setFont(new Font("Verdana Pro", Font.PLAIN, 27));
		btnFORMULA1.setBackground(new Color(0, 0, 0));
		btnFORMULA1.setForeground(new Color(128, 0, 0));
		btnFORMULA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				F1View temp=new F1View(); //construir nueva ventana
				temp.setVisible(true); //hacer visible la ventana
				
			}
		});
		btnFORMULA1.setBounds(76, 23, 439, 163);
		getContentPane().add(btnFORMULA1);
		
		JButton btnNewButton = new JButton("F2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(App.class.getResource("/image/F2_button.png")));
		btnNewButton.setBounds(724, 23, 494, 163);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("F3");
		btnNewButton_1.setIcon(new ImageIcon(App.class.getResource("/image/F3_Button.png")));
		btnNewButton_1.setSelectedIcon(new ImageIcon(App.class.getResource("/image/F3_Button.png")));
		btnNewButton_1.setBounds(1412, 23, 422, 163);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(0, 197, 1964, 10);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 64, 128));
		panel_1.setBounds(616, 0, 10, 207);
		getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 64, 128));
		panel_1_1.setBounds(1315, 0, 10, 207);
		getContentPane().add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(-51, 740, 1950, 10);
		getContentPane().add(panel_2);
		
		JButton btnSIMCARRERA = new JButton("New button");
		btnSIMCARRERA.setIcon(new ImageIcon(App.class.getResource("/image/StartButton (2).png")));
		btnSIMCARRERA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSIMCARRERA.setBounds(631, 761, 694, 178);
		getContentPane().add(btnSIMCARRERA);
		
	}
}
