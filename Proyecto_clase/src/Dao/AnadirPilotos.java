package Dao;

import java.awt.EventQueue; // Importa la clase para manejar la cola de eventos de la interfaz gráfica
import java.sql.ResultSet; // Importa ResultSet para manejar resultados de consultas SQL
import java.sql.SQLException; // Importa SQLException para manejar errores de base de datos
import javax.swing.JFrame; // Importa JFrame para crear la ventana principal
import javax.swing.JPanel; // Importa JPanel para el contenedor de componentes
import javax.swing.border.EmptyBorder; // Importa EmptyBorder para márgenes en el panel
import javax.swing.JLabel; // Importa JLabel para etiquetas de texto
import java.awt.Font; // Importa Font para personalizar fuentes
import javax.swing.JTextField; // Importa JTextField para campos de entrada de texto
import javax.swing.JButton; // Importa JButton para botones
import javax.swing.JDialog; // Importa JDialog para ventanas emergentes
import javax.swing.JOptionPane; // Importa JOptionPane para mensajes emergentes
import javax.swing.JScrollPane; // Importa JScrollPane para barras de desplazamiento
import javax.swing.JTable; // Importa JTable para tablas de datos
import javax.swing.table.DefaultTableModel; // Importa DefaultTableModel para el modelo de la tabla

import Util.ConexionMySQL; // Importa la clase personalizada para conexión a MySQL

import java.awt.event.ActionListener; // Importa ActionListener para manejar eventos de acción
import java.awt.event.ActionEvent; // Importa ActionEvent para eventos de botones

public class AnadirPilotos extends JFrame {

    private static final long serialVersionUID = 1L; // ID de serialización para la clase
    private JPanel contentPane; // Panel principal que contiene los componentes
    private JTextField textId; // Campo de texto para el ID del piloto
    private JTextField textNombre; // Campo de texto para el nombre del piloto
    private JTextField textEdad; // Campo de texto para la edad del piloto
    private JTextField textNacionalidad; // Campo de texto para la nacionalidad del piloto
    private JTextField textEquipo; // Campo de texto para el equipo del piloto
    private JTextField textTemporada; // Campo de texto para la temporada del piloto
    private JTextField textHabilidad; // Campo de texto para la habilidad del piloto
    private JTextField textConsistencia; // Campo de texto para la consistencia del piloto
    private JTextField textPuntos; // Campo de texto para los puntos del piloto
    private JTextField textCampeonato; // Campo de texto para el campeonato del piloto

    /**
     * Constructor de la clase
     */
    public AnadirPilotos() {
        // Configurar la ventana principal
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al hacer clic en cerrar
        setBounds(0, 0, 800, 500); // Establece las dimensiones y posición inicial de la ventana (x, y, ancho, alto)
        contentPane = new JPanel(); // Crea el panel principal
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Añade márgenes de 5 píxeles alrededor del panel
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setContentPane(contentPane); // Asigna el panel como contenido de la ventana
        contentPane.setLayout(null); // Usa un layout nulo para posicionamiento manual

        // Título de la ventana
        JLabel lblNewLabel_1 = new JLabel("AÑADIR PILOTO");
        lblNewLabel_1.setBounds(237, -11, 326, 90); // Posiciona el título (x, y, ancho, alto)
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38)); // Establece fuente y tamaño
        contentPane.add(lblNewLabel_1); // Añade el título al panel

        // Etiquetas para los campos de entrada
        JLabel lblId = new JLabel("ID ");
        lblId.setBounds(282, 67, 39, 32); // Posiciona la etiqueta
        lblId.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18)); // Establece fuente
        contentPane.add(lblId); // Añade la etiqueta al panel

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

        JLabel lblCampeonato = new JLabel("CAMPEONATO");
        lblCampeonato.setBounds(185, 427, 129, 32);
        lblCampeonato.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblCampeonato);

        // Campos de texto para la entrada de datos
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
        textTemporada.setColumns(10);
        contentPane.add(textTemporada);

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
        textPuntos.setBounds(329, 355, 149, 20);
        textPuntos.setColumns(10);
        contentPane.add(textPuntos);

        textCampeonato = new JTextField();
        textCampeonato.setBounds(329, 435, 149, 20);
        textCampeonato.setColumns(10);
        contentPane.add(textCampeonato);

        // Botón para enviar los datos
        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.setBounds(579, 224, 106, 37);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1"); // Conexión a la base de datos
                try {
                    conexion.conectar(); // Establece la conexión
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
                            + textCampeonato.getText() + "')"; // Construye la sentencia SQL

                    conexion.ejecutarInsertDeleteUpdate(sentencia); // Ejecuta la inserción
                    conexion.desconectar(); // Cierra la conexión
                    JOptionPane.showMessageDialog(AnadirPilotos.this, "Piloto añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE); // Muestra mensaje de éxito
                    dispose(); // Cierra la ventana
                } catch (SQLException e1) {
                    e1.printStackTrace(); // Imprime el error en la consola
                    JOptionPane.showMessageDialog(AnadirPilotos.this, "Error al añadir piloto: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Muestra mensaje de error
                    try {
                        conexion.desconectar(); // Intenta cerrar la conexión en caso de error
                    } catch (SQLException e2) {
                        e2.printStackTrace(); // Imprime error al cerrar la conexión
                    }
                }
            }
        });
        contentPane.add(btnEnviar);

        // Botón para ver los logs
        JButton btnVerLogs = new JButton("VER LOGS");
        btnVerLogs.setBounds(579, 270, 106, 37);
        btnVerLogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarLogs(); // Llama al método para mostrar los logs
            }
        });
        contentPane.add(btnVerLogs);

        // Crear la tabla piloto_log y el trigger al iniciar la ventana
        setupPilotLogAndTrigger(); // Llama al método para configurar la tabla y el trigger
    }

    /**
     * Método para crear la tabla de log y el trigger en la base de datos
     */
    private void setupPilotLogAndTrigger() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1"); // Conexión a la base de datos
        try {
            conexion.conectar(); // Establece la conexión
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

            // Ejecutar las sentencias
            conexion.ejecutarInsertDeleteUpdate(createTableSQL); // Crea la tabla
            conexion.ejecutarInsertDeleteUpdate(createTriggerSQL); // Crea el trigger

            System.out.println("Tabla de log y trigger creados con éxito."); // Mensaje de confirmación
            conexion.desconectar(); // Cierra la conexión
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error en la consola
            try {
                conexion.desconectar(); // Intenta cerrar la conexión en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace(); // Imprime error al cerrar la conexión
            }
        }
    }

    /**
     * Método para mostrar los logs en un pop-up
     */
    private void mostrarLogs() {
        // Crear el diálogo (pop-up)
        JDialog dialog = new JDialog(this, "Registros de Pilotos", true); // Diálogo modal
        dialog.setBounds(100, 100, 800, 400); // Dimensiones y posición
        dialog.setLocationRelativeTo(this); // Centra el diálogo
        dialog.getContentPane().setLayout(null); // Layout nulo

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Log ID"); // Añade columna para ID del log
        model.addColumn("Piloto ID"); // Añade columna para ID del piloto
        model.addColumn("Nombre"); // Añade columna para nombre
        model.addColumn("Edad"); // Añade columna para edad
        model.addColumn("Nacionalidad"); // Añade columna para nacionalidad
        model.addColumn("Temporada"); // Añade columna para temporada
        model.addColumn("Equipo"); // Añade columna para equipo
        model.addColumn("Habilidad"); // Añade columna para habilidad
        model.addColumn("Consistencia"); // Añade columna para consistencia
        model.addColumn("Puntos"); // Añade columna para puntos
        model.addColumn("Campeonato"); // Añade columna para campeonato
        model.addColumn("Fecha y Hora"); // Añade columna para timestamp

        // Consultar los datos de piloto_log
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar(); // Establece la conexión
            String consulta = "SELECT * FROM piloto_log"; // Consulta SQL
            ResultSet rs = conexion.ejecutarSelect(consulta); // Ejecuta la consulta

            // Llenar el modelo con los datos
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("log_id"), // Añade ID del log
                    rs.getString("piloto_id"), // Añade ID del piloto
                    rs.getString("nombre"), // Añade nombre
                    rs.getInt("edad"), // Añade edad
                    rs.getString("nacionalidad"), // Añade nacionalidad
                    rs.getString("temporada"), // Añade temporada
                    rs.getString("equipo"), // Añade equipo
                    rs.getInt("habilidad"), // Añade habilidad
                    rs.getInt("consistencia"), // Añade consistencia
                    rs.getInt("puntos"), // Añade puntos
                    rs.getString("campeonato"), // Añade campeonato
                    rs.getTimestamp("log_timestamp") // Añade timestamp
                });
            }
            rs.close(); // Cierra el ResultSet
            conexion.desconectar(); // Cierra la conexión
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error en la consola
            try {
                conexion.desconectar(); // Intenta cerrar la conexión en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace(); // Imprime error al cerrar la conexión
            }
        }

        // Crear la tabla y añadirla a un JScrollPane
        JTable table = new JTable(model); // Crea la tabla con el modelo
        JScrollPane scrollPane = new JScrollPane(table); // Añade barras de desplazamiento
        scrollPane.setBounds(10, 10, 760, 300); // Posiciona el scrollpane
        dialog.getContentPane().add(scrollPane); // Añade el scrollpane al diálogo

        // Botón para cerrar el diálogo
        JButton btnCerrar = new JButton("CERRAR");
        btnCerrar.setBounds(350, 320, 100, 30); // Posiciona el botón
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Cierra el diálogo
            }
        });
        dialog.getContentPane().add(btnCerrar); // Añade el botón al diálogo

        // Mostrar el diálogo
        dialog.setVisible(true); // Hace visible el diálogo
    }
}