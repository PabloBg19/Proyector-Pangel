package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AnadirEquipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textMotor;
	private JTextField textPais;
	private JTextField textPiloto_1;
	private JTextField textPiloto_2;
	private JTextField textField_Potencia;
	private JTextField textField_Aerodinamica;
	private JTextField textField_Fiabilidad;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AnadirEquipo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centra la ventana


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Id = new JLabel("ID ");
		lbl_Id.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lbl_Id.setBounds(280, 77, 39, 32);
		contentPane.add(lbl_Id);
		
		JLabel lblNewLabel_1 = new JLabel("AÑADIR EQUIPOS");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(227, 0, 338, 90);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(227, 120, 83, 32);
		contentPane.add(lblNombre);
		
		JLabel lblMotor = new JLabel("MOTOR");
		lblMotor.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblMotor.setBounds(236, 163, 83, 32);
		contentPane.add(lblMotor);
		
		JLabel lblPais = new JLabel("PAIS");
		lblPais.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblPais.setBounds(259, 206, 50, 32);
		contentPane.add(lblPais);
		
		JLabel lblPiloto1 = new JLabel("PILOTO 1");
		lblPiloto1.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblPiloto1.setBounds(217, 249, 102, 32);
		contentPane.add(lblPiloto1);
		
		JLabel lblPiloto2 = new JLabel("PILOTO 2");
		lblPiloto2.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblPiloto2.setBounds(213, 292, 106, 32);
		contentPane.add(lblPiloto2);
		
		JLabel lblFiabilidad = new JLabel("FIABILIDAD");
		lblFiabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblFiabilidad.setBounds(197, 418, 102, 32);
		contentPane.add(lblFiabilidad);
		


		
		textId = new JTextField();
		textId.setBounds(345, 87, 148, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(345, 130, 148, 20);
		contentPane.add(textNombre);
		
		textMotor = new JTextField();
		textMotor.setColumns(10);
		textMotor.setBounds(345, 173, 148, 20);
		contentPane.add(textMotor);
		
		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(345, 216, 148, 20);
		contentPane.add(textPais);
		
		textPiloto_1 = new JTextField();
		textPiloto_1.setColumns(10);
		textPiloto_1.setBounds(345, 259, 148, 20);
		contentPane.add(textPiloto_1);
		
		textPiloto_2 = new JTextField();
		textPiloto_2.setColumns(10);
		textPiloto_2.setBounds(345, 302, 148, 20);
		contentPane.add(textPiloto_2);

		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //crear la conexion para el boton Enviar
				ConexionMySQL conexion2=new ConexionMySQL("root", "", "formula_1"); //conexion a la base de datos 
				try {
					conexion2.conectar();
					String sentencia = "INSERT INTO equipo (Id, Nombre, Motor, Pais, Piloto_1, Piloto_2, Fiabilidad, Puntos, Campeonatos) VALUES ('"    //Sentencia SQL
						    + textId.getText() + "', '" 
						    + textNombre.getText() + "', '" 
						    + textMotor.getText() + "', '" 
						    + textPais.getText() + "', '" 
						    + textPiloto_1.getText() + "', '" 
						    + textPiloto_2.getText() + "', '" 
						    + textField_Fiabilidad.getText() + "')";
					conexion2.ejecutarInsertDeleteUpdate(sentencia);
					conexion2.desconectar();
					dispose();
				} catch (SQLException e1) {
					try {
						conexion2.desconectar();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					e1.printStackTrace();
				}
				
			}
		});
		btnEnviar.setBounds(596, 228, 102, 39);
		contentPane.add(btnEnviar);
		
		JLabel lblPotencia = new JLabel("POTENCIA");
		lblPotencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblPotencia.setBounds(208, 335, 102, 32);
		contentPane.add(lblPotencia);
	
		JLabel lblAerodinmica = new JLabel("AERODINÁMICA");
		lblAerodinmica.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
		lblAerodinmica.setBounds(155, 378, 155, 32);
		contentPane.add(lblAerodinmica);
		
		textField_Potencia = new JTextField();
		textField_Potencia.setBounds(345, 345, 148, 22);
		contentPane.add(textField_Potencia);
		textField_Potencia.setColumns(10);
		
		textField_Aerodinamica = new JTextField();
		textField_Aerodinamica.setBounds(345, 387, 148, 22);
		contentPane.add(textField_Aerodinamica);
		textField_Aerodinamica.setColumns(10);
		
		textField_Fiabilidad = new JTextField();
		textField_Fiabilidad.setBounds(345, 427, 148, 22);
		contentPane.add(textField_Fiabilidad);
		textField_Fiabilidad.setColumns(10);
		
		
		
		
		
		
	}
	}


