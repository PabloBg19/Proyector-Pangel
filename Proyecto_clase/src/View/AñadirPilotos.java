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

public class AñadirPilotos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textNacionalidad;
	private JTextField textEquipo;
	private JTextField textHabilidad;
	private JTextField textConsistencia;
	private JTextField textPuntos;
	private JTextField textCampeonatos;
	private JTextField textCampeonato;

	/**
	 * Create the frame.
	 */
	public AñadirPilotos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID ");
		lblNewLabel.setBounds(282, 80, 39, 32);
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AÑADIR PILOTO");
		lblNewLabel_1.setBounds(240, 11, 325, 90);
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(238, 123, 83, 32);
		lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(238, 166, 83, 32);
		lblEdad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblEdad);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(171, 209, 148, 32);
		lblNacionalidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setBounds(234, 252, 74, 32);
		lblEquipo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblEquipo);
		
		JLabel lblHabilidad = new JLabel("HABILIDAD");
		lblHabilidad.setBounds(215, 295, 106, 32);
		lblHabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblHabilidad);
		
		JLabel lblConsistencia = new JLabel("CONSISTENCIA");
		lblConsistencia.setBounds(192, 381, 129, 32);
		lblConsistencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblConsistencia);
		
		JLabel lblPuntos = new JLabel("PUNTOS");
		lblPuntos.setBounds(234, 338, 83, 32);
		lblPuntos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblPuntos);
		
		// Añadido JLabel para Campeonato
		JLabel lblCampeonato = new JLabel("CAMPEONATO");
		lblCampeonato.setBounds(192, 424, 129, 32);
		lblCampeonato.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblCampeonato);
		
		textPuntos = new JTextField();
		textPuntos.setColumns(10);
		textPuntos.setBounds(330, 348, 148, 20);
		contentPane.add(textPuntos);
		
		textId = new JTextField();
		textId.setBounds(329, 90, 149, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(329, 133, 149, 20);
		textNombre.setColumns(10);
		contentPane.add(textNombre);
		
		textEdad = new JTextField();
		textEdad.setBounds(329, 176, 149, 20);
		textEdad.setColumns(10);
		contentPane.add(textEdad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setBounds(329, 219, 149, 20);
		textNacionalidad.setColumns(10);
		contentPane.add(textNacionalidad);
		
		textEquipo = new JTextField();
		textEquipo.setBounds(329, 262, 149, 20);
		textEquipo.setColumns(10);
		contentPane.add(textEquipo);
		
		textHabilidad = new JTextField();
		textHabilidad.setBounds(331, 305, 149, 20);
		textHabilidad.setColumns(10);
		contentPane.add(textHabilidad);
		
		textConsistencia = new JTextField();
		textConsistencia.setBounds(331, 391, 149, 20);
		textConsistencia.setColumns(10);
		contentPane.add(textConsistencia);
		
		textCampeonato = new JTextField();
		textCampeonato.setColumns(10);
		textCampeonato.setBounds(329, 434, 149, 20);
		contentPane.add(textCampeonato);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(597, 228, 89, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //crear la conexion para el boton Enviar
				ConexionMySQL conexion1=new ConexionMySQL("root", "", "formula_1"); //conexion a la base de datos 
				try {
					conexion1.conectar();
					String sentencia = "INSERT INTO piloto (Id, Nombre, Edad, Nacionalidad, Equipo, Habilidad, Consistencia, Puntos, Campeonato) VALUES ('"    //Sentencia SQL corregida
						    + textId.getText() + "', '" 
						    + textNombre.getText() + "', '" 
						    + textEdad.getText() + "', '" 
						    + textNacionalidad.getText() + "', '" 
						    + textEquipo.getText() + "', '" 
						    + textHabilidad.getText() + "', '" 
						    + textConsistencia.getText() + "', '" 
						    + textPuntos.getText() + "', '" 
						    + textCampeonato.getText() + "')";
					
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
		contentPane.add(btnEnviar);
	}
}