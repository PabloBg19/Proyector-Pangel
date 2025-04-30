package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GestionarPilotos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textNacionalidad;
	private JTextField textEquipo;
	private JTextField textHabilidad;
	private JTextField textConsistencia;

	

	/**
	 * Create the frame.
	 */
	public GestionarPilotos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID ");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(280, 90, 39, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GESTIONAR PILOTOS");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(234, 11, 325, 90);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(236, 133, 83, 32);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblEdad.setBounds(236, 176, 83, 32);
		contentPane.add(lblEdad);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblNacionalidad.setBounds(171, 219, 148, 32);
		contentPane.add(lblNacionalidad);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblEquipo.setBounds(245, 273, 74, 32);
		contentPane.add(lblEquipo);
		
		JLabel lblHabilidad = new JLabel("HABILIDAD");
		lblHabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblHabilidad.setBounds(217, 329, 106, 32);
		contentPane.add(lblHabilidad);
		
		JLabel lblConsistencia = new JLabel("CONSISTENCIA");
		lblConsistencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblConsistencia.setBounds(182, 386, 141, 32);
		contentPane.add(lblConsistencia);
		
		textId = new JTextField();
		textId.setBounds(329, 100, 149, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(329, 143, 149, 20);
		contentPane.add(textNombre);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(329, 186, 149, 20);
		contentPane.add(textEdad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setColumns(10);
		textNacionalidad.setBounds(329, 229, 149, 20);
		contentPane.add(textNacionalidad);
		
		textEquipo = new JTextField();
		textEquipo.setColumns(10);
		textEquipo.setBounds(329, 283, 149, 20);
		contentPane.add(textEquipo);
		
		textHabilidad = new JTextField();
		textHabilidad.setColumns(10);
		textHabilidad.setBounds(329, 339, 149, 20);
		contentPane.add(textHabilidad);
		
		textConsistencia = new JTextField();
		textConsistencia.setColumns(10);
		textConsistencia.setBounds(329, 396, 149, 20);
		contentPane.add(textConsistencia);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //crear la conexion para el boton Enviar
				ConexionMySQL conexion1=new ConexionMySQL("root", "", "formula_1"); //conexion a la base de datos 
				try {
					conexion1.conectar();
					String sentencia = "INSERT INTO piloto (Id, Nombre, Edad, Nacionalidad, Equipo, Habilidad, Consistencia) VALUES ('"    //Sentencia SQL
						    + textId.getText() + "', '" 
						    + textNombre.getText() + "', '" 
						    + textEdad.getText() + "', '" 
						    + textNacionalidad.getText() + "', '" 
						    + textEquipo.getText() + "', '" 
						    + textHabilidad.getText() + "', '" 
						    + textConsistencia.getText() + "')";
					
					conexion1.ejecutarInsertDeleteUpdate(sentencia);
					conexion1.desconectar();
					dispose();
				} catch (SQLException e1) {
					try {
						conexion1.desconectar();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					e1.printStackTrace();
				}
				
			}
		});
		btnEnviar.setBounds(597, 228, 89, 23);
		contentPane.add(btnEnviar);
	}
}
