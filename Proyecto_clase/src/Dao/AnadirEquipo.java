package Dao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Util.ConexionMySQL;

/**
 * Clase que representa una ventana para añadir un equipo a la base de datos de Fórmula 1.
 * Proporciona una interfaz gráfica para ingresar los detalles del equipo, como ID, nombre, motor,
 * país, potencia, aerodinámica y fiabilidad, y los guarda en la base de datos al hacer clic en el botón "Enviar".
 * 
 * @author Pangel
 * @version 1.0
 */
public class AnadirEquipo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textId;
    private JTextField textNombre;
    private JTextField textMotor;
    private JTextField textPais;
    private JTextField textPotencia;
    private JTextField textField_Aerodinamica;
    private JTextField textField_Fiabilidad;

    /**
     * Constructor de la clase AnadirEquipo.
     * Inicializa y configura la ventana gráfica para añadir un equipo a la base de datos.
     * Configura el layout, los componentes de la interfaz (etiquetas, campos de texto, botón) y
     * centra la ventana en la pantalla.
     */
    public AnadirEquipo() {
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Establece las dimensiones de la ventana
        setBounds(0, 0, 800, 531);
        // Crea un panel principal con un borde vacío
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Establece el panel como contenido principal de la ventana
        setContentPane(contentPane);
        // Configura el layout del panel como nulo (posicionamiento absoluto)
        contentPane.setLayout(null);

        // Etiqueta para el campo ID
        JLabel lbl_Id = new JLabel("ID");
        lbl_Id.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lbl_Id.setBounds(283, 105, 39, 32);
        contentPane.add(lbl_Id);

        // Título principal de la ventana
        JLabel lblNewLabel_1 = new JLabel("               AÑADIR EQUIPOS");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_1.setBounds(77, 11, 621, 54);
        contentPane.add(lblNewLabel_1);

        // Etiqueta para el campo Nombre
        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblNombre.setBounds(239, 148, 83, 32);
        contentPane.add(lblNombre);

        // Etiqueta para el campo Motor
        JLabel lblMotor = new JLabel("MOTOR");
        lblMotor.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblMotor.setBounds(239, 191, 83, 32);
        contentPane.add(lblMotor);

        // Etiqueta para el campo País
        JLabel lblPais = new JLabel("PAIS");
        lblPais.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPais.setBounds(265, 234, 50, 32);
        contentPane.add(lblPais);

        // Etiqueta para el campo Potencia
        JLabel lblPotencia = new JLabel("POTENCIA");
        lblPotencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPotencia.setBounds(220, 277, 102, 32);
        contentPane.add(lblPotencia);

        // Etiqueta para el campo Aerodinámica
        JLabel lblAerodinamica = new JLabel("AERODINÁMICA");
        lblAerodinamica.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblAerodinamica.setBounds(180, 320, 155, 32);
        contentPane.add(lblAerodinamica);

        // Etiqueta para el campo Fiabilidad
        JLabel lblFiabilidad = new JLabel("FIABILIDAD");
        lblFiabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblFiabilidad.setBounds(220, 363, 102, 32);
        contentPane.add(lblFiabilidad);

        // Campo de texto para ingresar el ID del equipo
        textId = new JTextField();
        textId.setBounds(345, 115, 148, 20);
        contentPane.add(textId);
        textId.setColumns(10);

        // Campo de texto para ingresar el Nombre del equipo
        textNombre = new JTextField();
        textNombre.setColumns(10);
        textNombre.setBounds(345, 155, 148, 20);
        contentPane.add(textNombre);

        // Campo de texto para ingresar el Motor del equipo
        textMotor = new JTextField();
        textMotor.setColumns(10);
        textMotor.setBounds(345, 195, 148, 20);
        contentPane.add(textMotor);

        // Campo de texto para ingresar el País del equipo
        textPais = new JTextField();
        textPais.setColumns(10);
        textPais.setBounds(345, 235, 148, 20);
        contentPane.add(textPais);

        // Campo de texto para ingresar la Potencia del equipo
        textPotencia = new JTextField();
        textPotencia.setColumns(10);
        textPotencia.setBounds(345, 285, 148, 20);
        contentPane.add(textPotencia);

        // Campo de texto para ingresar la Aerodinámica del equipo
        textField_Aerodinamica = new JTextField();
        textField_Aerodinamica.setColumns(10);
        textField_Aerodinamica.setBounds(345, 325, 148, 20);
        contentPane.add(textField_Aerodinamica);

        // Campo de texto para ingresar la Fiabilidad del equipo
        textField_Fiabilidad = new JTextField();
        textField_Fiabilidad.setColumns(10);
        textField_Fiabilidad.setBounds(345, 365, 148, 20);
        contentPane.add(textField_Fiabilidad);

        /**
         * Botón para enviar los datos del equipo a la base de datos.
         * Al hacer clic, valida los campos numéricos, crea una conexión a la base de datos,
         * ejecuta una sentencia SQL para insertar el equipo y muestra un mensaje de éxito o error.
         */
        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Enviar".
             * Valida los datos ingresados, se conecta a la base de datos e inserta un nuevo equipo.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            public void actionPerformed(ActionEvent e) {
                // Crea una conexión a la base de datos MySQL
                ConexionMySQL conexion2 = new ConexionMySQL("root", "", "formula_1");
                try {
                    // Intenta conectar a la base de datos
                    conexion2.conectar();
                    // Validación de campos numéricos
                    try {
                        Integer.parseInt(textPotencia.getText());
                        Integer.parseInt(textField_Aerodinamica.getText());
                        Integer.parseInt(textField_Fiabilidad.getText());
                    } catch (NumberFormatException ex) {
                        // Muestra un mensaje de error si los campos numéricos no son válidos
                        JOptionPane.showMessageDialog(AnadirEquipo.this, "Los campos Potencia, Aerodinámica y Fiabilidad deben ser números válidos.");
                        return;
                    }
                    // Inserta un nuevo equipo
                    String sentencia = "INSERT INTO equipo (Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad) VALUES (" +
                            "'" + textId.getText() + "', " +
                            "'" + textNombre.getText() + "', " +
                            "'" + textMotor.getText() + "', " +
                            "'" + textPais.getText() + "', " +
                            textPotencia.getText() + ", " +
                            textField_Aerodinamica.getText() + ", " +
                            textField_Fiabilidad.getText() + ")";
                    // Ejecuta la sentencia SQL y obtiene el número de filas afectadas
                    int rowsAffected = conexion2.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        // Muestra un mensaje de éxito si el equipo se añadió correctamente
                        JOptionPane.showMessageDialog(AnadirEquipo.this, "Equipo añadido con éxito.");
                        // Cierra la ventana
                        dispose();
                    } else {
                        // Muestra un mensaje de error si no se pudo añadir el equipo
                        JOptionPane.showMessageDialog(AnadirEquipo.this, "No se pudo añadir el equipo.");
                    }
                    // Cierra la conexión a la base de datos
                    conexion2.desconectar();
                } catch (SQLException e1) {
                    // Muestra un mensaje de error si ocurre una excepción SQL
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(AnadirEquipo.this, "Error al añadir el equipo: " + e1.getMessage());
                    try {
                        // Intenta cerrar la conexión en caso de error
                        conexion2.desconectar();
                    } catch (SQLException e2) {
                        // Maneja cualquier error al cerrar la conexión
                        e2.printStackTrace();
                    }
                }
            }
        });
        // Configura la posición y tamaño del botón
        btnEnviar.setBounds(596, 283, 102, 39);
        contentPane.add(btnEnviar);
    }
}