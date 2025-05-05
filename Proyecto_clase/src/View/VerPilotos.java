package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class VerPilotos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textEquipo;

	/**
	 * Create the frame.
	 */
	public VerPilotos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana
		getContentPane().setLayout(null);
		
		JTextArea textMostrar = new JTextArea();
		textMostrar.setBounds(486, 21, 209, 401);
		getContentPane().add(textMostrar);
		
		JButton btnVerEquipo = new JButton("VER PILOTOS");
		btnVerEquipo.setBounds(208, 126, 120, 31);
		getContentPane().add(btnVerEquipo);
		
		textNombre = new JTextField();
		textNombre.setBounds(100, 267, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("BUSQUEDA POR NOMBRE:");
		lblNewLabel.setBounds(31, 211, 149, 36);
		getContentPane().add(lblNewLabel);
		
		JButton btnNombre = new JButton("BUSCAR");
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion=new ConexionMySQL("root","","formula_1");
				try {
					conexion.conectar();
					String sentencia="SELECT * FROM piloto WHERE Nombre='"+textNombre.getText()+"'";
					ResultSet resultado=conexion.ejecutarSelect(sentencia);
					while(resultado.next()) {
						String temp_Name=resultado.getString("Nombre");
						int temp_Age=resultado.getInt("Edad");
						
						textMostrar.setText(textMostrar.getText()+ "\n"
																+"Nombre: "+ temp_Name+"           Edad: " + temp_Age);
					}
					conexion.desconectar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNombre.setBounds(208, 262, 120, 31);
		getContentPane().add(btnNombre);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE: ");
		lblNewLabel_1.setBounds(31, 270, 59, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BUSQUEDA POR EQUIPO:");
		lblNewLabel_2.setBounds(31, 321, 131, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("EQUIPO: ");
		lblNewLabel_1_1.setBounds(31, 370, 59, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textEquipo = new JTextField();
		textEquipo.setColumns(10);
		textEquipo.setBounds(100, 367, 86, 20);
		getContentPane().add(textEquipo);
		
		JButton btnEquipo = new JButton("BUSCAR");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion=new ConexionMySQL("root","","formula_1");
				try {
					conexion.conectar();
					String sentencia="SELECT * FROM piloto WHERE Equipo='"+textEquipo.getText()+"'";
					ResultSet resultado=conexion.ejecutarSelect(sentencia);
					while(resultado.next()) {
						String temp_Name=resultado.getString("Nombre");
						String temp_Equipo=resultado.getString("Equipo");
						
						textMostrar.setText(textMostrar.getText()+ "\n"
																+"Nombre: "+ temp_Name+" Equipo: " + temp_Equipo);
					}
					conexion.desconectar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEquipo.setBounds(208, 366, 120, 31);
		getContentPane().add(btnEquipo);
		
		JLabel lblNewLabel_3 = new JLabel("VER PILOTOS");
		lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblNewLabel_3.setBounds(123, 57, 261, 31);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("(AÑADIR NOMBRE Y APELLIDO)");
		lblNewLabel_4.setBounds(31, 298, 155, 14);
		getContentPane().add(lblNewLabel_4);
	}
}
