package View;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
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
    private JTextField textCampeonato;

    /**
     * Constructor de la clase
     */
    public AñadirPilotos() {
        // Configurar la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // Centra la ventana
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título
        JLabel lblNewLabel_1 = new JLabel("AÑADIR PILOTO");
        lblNewLabel_1.setBounds(237, -11, 326, 90);
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        contentPane.add(lblNewLabel_1);

        // Etiquetas
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

        JLabel lblCampeonato = new JLabel("CAMPEONATO");
        lblCampeonato.setBounds(185, 427, 129, 32);
        lblCampeonato.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblCampeonato);

        // Campos de texto
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

        // Botón Enviar
        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.setBounds(579, 224, 106, 37);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
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

                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                    conexion.desconectar();
                    // Mostrar pop-up de éxito
                    JOptionPane.showMessageDialog(AñadirPilotos.this, "Piloto añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(AñadirPilotos.this, "Error al añadir piloto: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    try {
                        conexion.desconectar();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        contentPane.add(btnEnviar);

        // Botón Ver Logs
        JButton btnVerLogs = new JButton("VER LOGS");
        btnVerLogs.setBounds(579, 270, 106, 37);
        btnVerLogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarLogs();
            }
        });
        contentPane.add(btnVerLogs);

        // Crear la tabla piloto_log y el trigger al iniciar la ventana
        setupPilotLogAndTrigger();
    }

    /**
     * Método para crear la tabla de log y el trigger en la base de datos
     */
    private void setupPilotLogAndTrigger() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            // Crear la tabla piloto_log
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

            // Eliminar el trigger si ya existe
            /*String dropTriggerSQL = "DROP TRIGGER IF EXISTS after_piloto_insert;"; */

            // Crear el trigger
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
            conexion.ejecutarInsertDeleteUpdate(createTableSQL);
            /*conexion.ejecutarInsertDeleteUpdate(dropTriggerSQL);*/
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
     * Método para mostrar los logs en un pop-up
     */
    private void mostrarLogs() {
        // Crear el diálogo (pop-up)
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

            // Llenar el modelo con los datos
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
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.getContentPane().add(btnCerrar);

        // Mostrar el diálogo
        dialog.setVisible(true);
    }

   
}

/*### Cambios Realizados
1. **Pop-up de Éxito**:
   - Añadí un `JOptionPane` en el `ActionListener` del botón `ENVIAR` para mostrar el mensaje "Piloto añadido con éxito" después de que la inserción en la base de datos sea exitosa:
     ```java
     JOptionPane.showMessageDialog(AñadirPilotos.this, "Piloto añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
     ```
   - Este pop-up aparece justo antes de cerrar la ventana con `dispose()`.

2. **Manejo de Errores**:
   - Añadí un `JOptionPane` en el bloque `catch` para mostrar un mensaje de error si la inserción falla (por ejemplo, debido a un problema en la base de datos o datos inválidos):
     ```java
     JOptionPane.showMessageDialog(AñadirPilotos.this, "Error al añadir piloto: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     ```

3. **Mantenimiento de Funcionalidad Existente**:
   - El código de la interfaz, el botón `ENVIAR`, el método `setupPilotLogAndTrigger`, y el botón `VER LOGS` con su pop-up de tabla permanecen sin cambios.
   - La conexión sigue usando tu clase `ConexionMySQL` con `ejecutarInsertDeleteUpdate` y la concatenación de cadenas, como solicitaste.
   - El trigger `after_piloto_insert` y la tabla `piloto_log` siguen funcionando para registrar las inserciones.

### Notas Importantes
- **Importación de JOptionPane**: Añadí `import javax.swing.JOptionPane;` para usar el pop-up. Esto ya está incluido en el código.
- **Inyección SQL**: El código sigue usando concatenación de cadenas para la consulta SQL, lo que lo hace vulnerable a inyección SQL. Por ejemplo, si un usuario ingresa comillas simples (`'`) en los campos, la consulta puede fallar. Considera usar `PreparedStatement` en el futuro para mayor seguridad.
- **Validación de Entrada**: No se valida si los campos numéricos (`Edad`, `Habilidad`, `Consistencia`, `Puntos`) contienen valores válidos. Si se ingresan valores no numéricos, la inserción fallará y se mostrará el pop-up de error. Podrías añadir validaciones para mejorar la experiencia.
- **MariaDB**: El código es compatible con MariaDB (como indicaste en errores anteriores). Asegúrate de que la tabla `piloto` existe con las columnas `Id`, `Nombre`, `Edad`, `Nacionalidad`, `Temporada`, `Equipo`, `Habilidad`, `Consistencia`, `Puntos`, `Campeonato`, y que `piloto_log` tiene las columnas correspondientes.

### Cómo Probar
1. **Configura tu Entorno**:
   - Verifica que la base de datos `formula_1` esté creada en MariaDB y que la tabla `piloto` exista con las columnas correctas.
   - Asegúrate de que el usuario `root` sin contraseña tenga acceso a la base de datos.
   - Confirma que el driver MySQL (`com.mysql.cj.jdbc.Driver`) esté en el classpath de tu proyecto.

2. **Ejecuta el Programa**:
   - Compila y ejecuta la clase `AñadirPilotos`. La ventana se abrirá, y la tabla `piloto_log` y el trigger se crearán automáticamente.
   - Rellena los campos (asegúrate de usar números válidos para `Edad`, `Habilidad`, `Consistencia`, `Puntos`) y haz clic en "ENVIAR". Deberías ver un pop-up que dice "Piloto añadido con éxito", y la ventana se cerrará.
   - Si hay un error (por ejemplo, datos inválidos), verás un pop-up con el mensaje de error.
   - Haz clic en "VER LOGS" para abrir el pop-up con la tabla de logs y confirmar que el piloto añadido está registrado en `piloto_log`.

3. **Verifica el Comportamiento**:
   - Añade varios pilotos y verifica que el pop-up de éxito aparece cada vez.
   - Usa el botón "VER LOGS" para confirmar que los registros se guardan en `piloto_log` con la marca de tiempo.
   - Si introduces datos inválidos (por ejemplo, letras en `Edad`), deberías ver el pop-up de error con el mensaje de la excepción.

Si necesitas ajustes (como personalizar el diseño del pop-up, añadir validaciones de entrada, o más funcionalidades), o si encuentras algún error, házmelo saber y lo resolveremos. ¡Espero que el nuevo pop-up sea justo lo que necesitas!
*/