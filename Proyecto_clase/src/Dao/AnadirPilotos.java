package Dao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Util.ConexionMySQL;

/**
 * Clase que representa una ventana para añadir un piloto a la base de datos de Fórmula 1.
 * Proporciona una interfaz gráfica para ingresar los detalles del piloto, como ID, nombre, edad,
 * nacionalidad, temporada, equipo, habilidad, consistencia, puntos y campeonato. Además, permite
 * visualizar los registros de inserciones en una tabla de logs.
 * 
 * @author Pangel
 * @version 1.0
 */
public class AnadirPilotos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textId;
    private JTextField textNombre;
    private JTextField textEdad;
    private JTextField textNacionalidad;
    private JTextField textTemporada;
    private JTextField textEquipo;
    private JTextField textHabilidad;
    private JTextField textConsistencia;
    private JTextField textPuntos;
    private JTextField textCampeonato;

    /**
     * Constructor de la clase AnadirPilotos.
     * Inicializa y configura la ventana gráfica para añadir un piloto a la base de datos.
     * Configura el layout, los componentes de la interfaz (etiquetas, campos de texto, botones)
     * y centra la ventana en la pantalla. También inicializa la tabla de logs y el trigger en la base de datos.
     */
    public AnadirPilotos() {
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Establece las dimensiones de la ventana
        setBounds(0, 0, 800, 500);
        // Crea un panel principal con un borde vacío
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);
        // Establece el panel como contenido principal de la ventana
        setContentPane(contentPane);
        // Configura el layout del panel como nulo (posicionamiento absoluto)
        contentPane.setLayout(null);

        // Título principal de la ventana
        JLabel lblNewLabel_1 = new JLabel("AÑADIR PILOTO");
        lblNewLabel_1.setBounds(237, -11, 326, 90);
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        contentPane.add(lblNewLabel_1);

        // Etiqueta para el campo ID
        JLabel lblId = new JLabel("ID ");
        lblId.setBounds(282, 67, 39, 32);
        lblId.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblId);

        // Etiqueta para el campo Nombre
        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(238, 107, 83, 32);
        lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblNombre);

        // Etiqueta para el campo Edad
        JLabel lblEdad = new JLabel("EDAD");
        lblEdad.setBounds(263, 147, 83, 32);
        lblEdad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblEdad);

        // Etiqueta para el campo Nacionalidad
        JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
        lblNacionalidad.setBounds(172, 187, 148, 32);
        lblNacionalidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblNacionalidad);

        // Etiqueta para el campo Temporada
        JLabel lblTemporada = new JLabel("TEMPORADA");
        lblTemporada.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblTemporada.setBounds(197, 227, 129, 32);
        contentPane.add(lblTemporada);

        // Etiqueta para el campo Equipo
        JLabel lblEquipo = new JLabel("EQUIPO");
        lblEquipo.setBounds(243, 267, 74, 32);
        lblEquipo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblEquipo);

        // Etiqueta para el campo Habilidad
        JLabel lblHabilidad = new JLabel("HABILIDAD");
        lblHabilidad.setBounds(215, 307, 106, 32);
        lblHabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblHabilidad);

        // Etiqueta para el campo Consistencia
        JLabel lblConsistencia = new JLabel("CONSISTENCIA");
        lblConsistencia.setBounds(185, 387, 129, 32);
        lblConsistencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblConsistencia);

        // Etiqueta para el campo Puntos
        JLabel lblPuntos = new JLabel("PUNTOS");
        lblPuntos.setBounds(238, 347, 83, 32);
        lblPuntos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblPuntos);

        // Etiqueta para el campo Campeonato
        JLabel lblCampeonato = new JLabel("CAMPEONATO");
        lblCampeonato.setBounds(185, 427, 129, 32);
        lblCampeonato.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblCampeonato);

        // Campo de texto para ingresar el ID del piloto
        textId = new JTextField();
        textId.setBounds(329, 75, 149, 20);
        contentPane.add(textId);
        textId.setColumns(10);

        // Campo de texto para ingresar el Nombre del piloto
        textNombre = new JTextField();
        textNombre.setBounds(331, 117, 149, 20);
        textNombre.setColumns(10);
        contentPane.add(textNombre);

        // Campo de texto para ingresar la Edad del piloto
        textEdad = new JTextField();
        textEdad.setBounds(329, 157, 149, 20);
        textEdad.setColumns(10);
        contentPane.add(textEdad);

        // Campo de texto para ingresar la Nacionalidad del piloto
        textNacionalidad = new JTextField();
        textNacionalidad.setBounds(329, 195, 149, 20);
        textNacionalidad.setColumns(10);
        contentPane.add(textNacionalidad);

        // Campo de texto para ingresar la Temporada del piloto
        textTemporada = new JTextField();
        textTemporada.setBounds(329, 235, 149, 20);
        textTemporada.setColumns(10);
        contentPane.add(textTemporada);

        // Campo de texto para ingresar el Equipo del piloto
        textEquipo = new JTextField();
        textEquipo.setBounds(329, 275, 149, 20);
        textEquipo.setColumns(10);
        contentPane.add(textEquipo);

        // Campo de texto para ingresar la Habilidad del piloto
        textHabilidad = new JTextField();
        textHabilidad.setBounds(329, 315, 149, 20);
        textHabilidad.setColumns(10);
        contentPane.add(textHabilidad);

        // Campo de texto para ingresar la Consistencia del piloto
        textConsistencia = new JTextField();
        textConsistencia.setBounds(329, 395, 149, 20);
        textConsistencia.setColumns(10);
        contentPane.add(textConsistencia);

        // Campo de texto para ingresar los Puntos del piloto
        textPuntos = new JTextField();
        textPuntos.setBounds(329, 355, 149, 20);
        textPuntos.setColumns(10);
        contentPane.add(textPuntos);

        // Campo de texto para ingresar el Campeonato del piloto
        textCampeonato = new JTextField();
        textCampeonato.setBounds(329, 435, 149, 20);
        textCampeonato.setColumns(10);
        contentPane.add(textCampeonato);

        /**
         * Botón para enviar los datos del piloto a la base de datos.
         * Valida los datos, se conecta a la base de datos, inserta el piloto y muestra un mensaje de éxito o error.
         */
        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.setBounds(579, 224, 106, 37);
        btnEnviar.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Enviar".
             * Inserta los datos del piloto en la base de datos y muestra un mensaje de confirmación o error.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    // Validación de campos numéricos
                    try {
                        Integer.parseInt(textEdad.getText());
                        Integer.parseInt(textHabilidad.getText());
                        Integer.parseInt(textConsistencia.getText());
                        Integer.parseInt(textPuntos.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(AnadirPilotos.this, 
                            "Los campos Edad, Habilidad, Consistencia y Puntos deben ser números válidos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String sentencia = "INSERT INTO piloto (Id, Nombre, Edad, Nacionalidad, Temporada, Equipo, Habilidad, Consistencia, Puntos, Campeonato) VALUES ('"
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
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(AnadirPilotos.this, 
                            "Piloto añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(AnadirPilotos.this, 
                            "No se pudo añadir el piloto.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.desconectar();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(AnadirPilotos.this, 
                        "Error al añadir piloto: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    try {
                        conexion.desconectar();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        contentPane.add(btnEnviar);

        /**
         * Botón para visualizar los logs de inserciones de pilotos.
         * Abre un diálogo que muestra una tabla con los registros de la tabla piloto_log.
         */
        JButton btnVerLogs = new JButton("VER LOGS");
        btnVerLogs.setBounds(579, 270, 106, 37);
        btnVerLogs.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Ver Logs".
             * Llama al método para mostrar los logs en un diálogo.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            public void actionPerformed(ActionEvent e) {
                mostrarLogs();
            }
        });
        contentPane.add(btnVerLogs);

        // Configura la tabla de logs y el trigger al iniciar la ventana
        setupPilotLogAndTrigger();
    }

    /**
     * Configura la tabla piloto_log y el trigger en la base de datos.
     * Crea la tabla piloto_log si no existe y define un trigger para registrar
     * cada inserción en la tabla piloto.
     */
    private void setupPilotLogAndTrigger() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            // Crear la tabla piloto_log si no existe
            String createTableSQL = 
                "CREATE TABLE IF NOT EXISTS piloto_log (" +
                "    log_id INT AUTO_INCREMENT PRIMARY KEY," +
                "    piloto_id VARCHAR(255)," +
                "    nombre VARCHAR(255)," +
                "    edad INT," +
                "    nacionalidad VARCHAR(255)," +
                "    temporada VARCHAR(255)," +
                "    equipo VARCHAR(255)," +
                "    habilidad INT," +
                "    consistencia INT," +
                "    puntos INT," +
                "    campeonato VARCHAR(255)," +
                "    log_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP" +
                ");";

            // Crear el trigger para registrar inserciones
            String createTriggerSQL = 
                "CREATE OR REPLACE TRIGGER after_piloto_insert " +
                "AFTER INSERT ON piloto " +
                "FOR EACH ROW " +
                "BEGIN " +
                "    INSERT INTO piloto_log (" +
                "        piloto_id, nombre, edad, nacionalidad, temporada, " +
                "        equipo, habilidad, consistencia, puntos, campeonato" +
                "    ) " +
                "    VALUES (" +
                "        NEW.Id, NEW.Nombre, NEW.Edad, NEW.Nacionalidad, NEW.Temporada, " +
                "        NEW.Equipo, NEW.Habilidad, NEW.Consistencia, NEW.Puntos, NEW.Campeonato" +
                "    );" +
                "END;";

            conexion.ejecutarInsertDeleteUpdate(createTableSQL);
            conexion.ejecutarInsertDeleteUpdate(createTriggerSQL);
            System.out.println("Tabla de log y trigger creados con éxito.");
            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Muestra un diálogo con una tabla que contiene los registros de la tabla piloto_log.
     * Recupera los datos de la tabla piloto_log y los presenta en un JDialog con una JTable.
     */
    private void mostrarLogs() {
        // Crear el diálogo modal
        JDialog dialog = new JDialog(this, "Registros de Pilotos", true);
        dialog.setBounds(100, 100, 800, 400);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setLayout(null);

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Log ID");
        model.addColumn("Piloto ID");
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Nacionalidad");
        model.addColumn("Temporada");
        model.addColumn("Equipo");
        model.addColumn("Habilidad");
        model.addColumn("Consistencia");
        model.addColumn("Puntos");
        model.addColumn("Campeonato");
        model.addColumn("Fecha y Hora");

        // Consultar los datos de piloto_log
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String consulta = "SELECT * FROM piloto_log";
            ResultSet rs = conexion.ejecutarSelect(consulta);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("log_id"),
                    rs.getString("piloto_id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("nacionalidad"),
                    rs.getString("temporada"),
                    rs.getString("equipo"),
                    rs.getInt("habilidad"),
                    rs.getInt("consistencia"),
                    rs.getInt("puntos"),
                    rs.getString("campeonato"),
                    rs.getTimestamp("log_timestamp")
                });
            }
            rs.close();
            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        // Crear la tabla y añadirla a un JScrollPane
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 760, 300);
        dialog.getContentPane().add(scrollPane);

        // Botón para cerrar el diálogo
        JButton btnCerrar = new JButton("CERRAR");
        btnCerrar.setBounds(350, 320, 100, 30);
        btnCerrar.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Cerrar".
             * Cierra el diálogo de logs.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.getContentPane().add(btnCerrar);

        // Mostrar el diálogo
        dialog.setVisible(true);
    }
}