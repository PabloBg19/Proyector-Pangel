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
            private Image backgroundImage = new ImageIcon(App.class.getResource("/image/fondo.jpg")).getImage();

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
		JButton btnNuevaSimulacion = new JButton("Menú de Gestión");
		btnNuevaSimulacion.setIcon(null);
		btnNuevaSimulacion.setFont(new Font("Verdana Pro", Font.PLAIN, 27));
		btnNuevaSimulacion.setBackground(new Color(0, 0, 0));
		btnNuevaSimulacion.setForeground(new Color(255, 255, 255));
		btnNuevaSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MenuDeGestion temp=new MenuDeGestion(); //construir nueva ventana
				temp.setVisible(true); //hacer visible la ventana
				
			}
		});
		btnNuevaSimulacion.setBounds(827, 612, 313, 108);
		getContentPane().add(btnNuevaSimulacion);
		
		JButton btnSIMCARRERA = new JButton("New button");
		btnSIMCARRERA.setIcon(new ImageIcon(App.class.getResource("/image/StartButton (2).png")));
		btnSIMCARRERA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSIMCARRERA.setBounds(663, 731, 694, 178);
		getContentPane().add(btnSIMCARRERA);
		
		JButton btnMenuDeGestion = new JButton("Nueva Simulación");
		btnMenuDeGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Simulacion temp =new Simulacion();
				temp.setVisible(true);

			}
		});
		btnMenuDeGestion.setForeground(new Color(255, 255, 255));
		btnMenuDeGestion.setFont(new Font("Dialog", Font.PLAIN, 27));
		btnMenuDeGestion.setBackground(new Color(0, 0, 0));
		btnMenuDeGestion.setBounds(827, 194, 313, 108);
		contentPane.add(btnMenuDeGestion);
		
	}
}
