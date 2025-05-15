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
	private JTextField textTemporada;
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
		
		JLabel lblNewLabel_1 = new JLabel("AÑADIR PILOTO");
		lblNewLabel_1.setBounds(238, -11, 325, 90);
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID ");
		lblId.setBounds(282, 67, 39, 32);
		lblId.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(238, 107, 83, 32);
		lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(263, 147, 83, 32);
		lblEdad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblEdad);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(172, 187, 148, 32);
		lblNacionalidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel lblTemporada = new JLabel("TEMPORADA");
		lblTemporada.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblTemporada.setBounds(197, 227, 129, 32);
		contentPane.add(lblTemporada);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setBounds(243, 267, 74, 32);
		lblEquipo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblEquipo);
		
		JLabel lblHabilidad = new JLabel("HABILIDAD");
		lblHabilidad.setBounds(215, 307, 106, 32);
		lblHabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblHabilidad);
		
		JLabel lblConsistencia = new JLabel("CONSISTENCIA");
		lblConsistencia.setBounds(185, 387, 129, 32);
		lblConsistencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblConsistencia);
		
		JLabel lblPuntos = new JLabel("PUNTOS");
		lblPuntos.setBounds(238, 347, 83, 32);
		lblPuntos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblPuntos);
		
		// Añadido JLabel para Campeonato
		JLabel lblCampeonato = new JLabel("CAMPEONATO");
		lblCampeonato.setBounds(185, 427, 129, 32);
		lblCampeonato.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblCampeonato);
		
		
		
		textId = new JTextField();
		textId.setBounds(329, 75, 149, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(331, 117, 149, 20);
		textNombre.setColumns(10);
		contentPane.add(textNombre);
		
		textEdad = new JTextField();
		textEdad.setBounds(329, 157, 149, 20);
		textEdad.setColumns(10);
		contentPane.add(textEdad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setBounds(329, 195, 149, 20);
		textNacionalidad.setColumns(10);
		contentPane.add(textNacionalidad);
		
		textTemporada = new JTextField();
		textTemporada.setBounds(329, 235, 149, 20);
		contentPane.add(textTemporada);
		textTemporada.setColumns(10);
		
		textEquipo = new JTextField();
		textEquipo.setBounds(329, 275, 149, 20);
		textEquipo.setColumns(10);
		contentPane.add(textEquipo);
		
		textHabilidad = new JTextField();
		textHabilidad.setBounds(329, 315, 149, 20);
		textHabilidad.setColumns(10);
		contentPane.add(textHabilidad);
		
		textConsistencia = new JTextField();
		textConsistencia.setBounds(329, 395, 149, 20);
		textConsistencia.setColumns(10);
		contentPane.add(textConsistencia);
		
		textPuntos = new JTextField();
		textPuntos.setColumns(10);
		textPuntos.setBounds(329, 355, 149, 20);
		contentPane.add(textPuntos);
		
		textCampeonato = new JTextField();
		textCampeonato.setColumns(10);
		textCampeonato.setBounds(329, 435, 149, 20);
		contentPane.add(textCampeonato);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(579, 224, 106, 37);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //crear la conexion para el boton Enviar
				ConexionMySQL conexion1=new ConexionMySQL("root", "", "formula_1"); //conexion a la base de datos 
				try {
					conexion1.conectar();
					String sentencia = "INSERT INTO piloto (Id, Nombre, Edad, Nacionalidad, Temporada, Equipo, Habilidad, Consistencia, Puntos, Campeonato) VALUES ('"    //Sentencia SQL corregida
						    + textId.getText() + "', '" 
						    + textNombre.getText() + "', '" 
						    + textEdad.getText() + "', '" 
						    + textNacionalidad.getText() + "', '" 
						    + textTemporada.getText() + "', '" 
						    + textEquipo.getText() + "', '" 
						    + textHabilidad.getText() + "', '" 
						    + textConsistencia.getText() + "', '" 
						    + textPuntos.getText() + "', '" 
						    + textCampeonato.getText() + "')";
					
					conexion1.ejecutarInsertDeleteUpdate(sentencia);
					conexion1.desconectar();//Añadir un FInally
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