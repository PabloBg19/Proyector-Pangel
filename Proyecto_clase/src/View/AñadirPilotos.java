package View;

import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
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
        lblNewLabel_1.setBounds(238, -11, 325, 90);
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
                    dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    try {
                        conexion.desconectar();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        contentPane.add(btnEnviar);

        // Crear la tabla piloto_log y el trigger al iniciar la ventana
        setupPilotLogAndTrigger();
    }

    
    //Método para crear la tabla de log y el trigger en la base de datos
    private void setupPilotLogAndTrigger() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            //Crear la tabla piloto_log
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
            String dropTriggerSQL = "DROP TRIGGER IF EXISTS after_piloto_insert;";

            // TRIGGER
            String createTriggerSQL = 
                "CREATE TRIGGER after_piloto_insert " +
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

            //Ejecutar las sentencias
            conexion.ejecutarInsertDeleteUpdate(createTableSQL);
            conexion.ejecutarInsertDeleteUpdate(dropTriggerSQL);
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
     * Método principal para probar la ventana
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AñadirPilotos frame = new AñadirPilotos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

/*
### Cambios Realizados

1. **Corrección de `contentNombre`**:
   - El error `contentNombre cannot be resolved` se debía a un error tipográfico en el código anterior, donde se usaba `contentNombre` en lugar de `textNombre`. Esto se corrigió en la línea correspondiente a la configuración del campo de texto `textNombre`:
     ```java
     textNombre.setBounds(331, 117, 149, 20);
     textNombre.setColumns(10);
     contentPane.add(textNombre);
     ```

2. **Restauración de la Conexión Original**:
   - Revertí el código del botón `ENVIAR` para usar tu implementación original con `ejecutarInsertDeleteUpdate` y la concatenación de cadenas para la consulta SQL, exactamente como estaba en tu código inicial:
     ```java
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
     ```
   - Esto respeta tu preferencia de no cambiar la conexión.

3. **Mantenimiento del Trigger**:
   - El método `setupPilotLogAndTrigger()` sigue igual, creando la tabla `piloto_log` y el trigger `after_piloto_insert` para registrar cada inserción en la tabla `piloto`.

### Notas Importantes
- **Inyección SQL**: Como mantuve tu método original de concatenación de cadenas, el código sigue siendo vulnerable a inyección SQL. Por ejemplo, si un usuario ingresa comillas simples (`'`) en los campos de texto, la consulta SQL podría fallar o ser manipulada. Recomiendo encarecidamente usar `PreparedStatement` en el futuro para mayor seguridad, pero respeté tu instrucción de no cambiar la conexión.
- **Validación de Entrada**: El código no valida los datos ingresados (por ejemplo, si `Edad`, `Habilidad`, `Consistencia` o `Puntos` no son números, MySQL puede rechazar la inserción). Considera añadir validaciones en la interfaz gráfica.
- **Esquema de la Base de Datos**: Asegúrate de que la tabla `piloto` existe en la base de datos `formula_1` con las columnas `Id`, `Nombre`, `Edad`, `Nacionalidad`, `Temporada`, `Equipo`, `Habilidad`, `Consistencia`, `Puntos`, `Campeonato`, y que los tipos de datos son compatibles (por ejemplo, `Edad`, `Habilidad`, `Consistencia`, `Puntos` como `INT`, y los demás como `VARCHAR`).
- **Driver de MySQL**: Asegúrate de que el driver de MySQL (`com.mysql.cj.jdbc.Driver`) esté en el classpath de tu proyecto, ya que tu clase `ConexionMySQL` lo requiere.

### Cómo Probar
1. **Configura tu Entorno**:
   - Verifica que la base de datos `formula_1` esté creada en MySQL y que la tabla `piloto` exista con las columnas correctas.
   - Asegúrate de que el usuario `root` sin contraseña tenga acceso a la base de datos.
   - Confirma que el driver de MySQL esté incluido en tu proyecto (por ejemplo, en `pom.xml` si usas Maven, o como librería en tu IDE).

2. **Ejecuta el Programa**:
   - Compila y ejecuta la clase `AñadirPilotos`. La ventana debería abrirse sin errores, y la tabla `piloto_log` y el trigger se crearán automáticamente al iniciar.
   - Rellena los campos en la interfaz gráfica y haz clic en "ENVIAR" para añadir un piloto. Esto insertará el registro en la tabla `piloto` y el trigger registrará los datos en `piloto_log`.

3. **Verifica el Log**:
   - Usa una consulta como `SELECT * FROM piloto_log;` en MySQL para confirmar que los datos de los pilotos añadidos se registran con la marca de tiempo.

Si encuentras más errores o necesitas añadir funcionalidades adicionales (como validaciones de entrada, una interfaz para ver los logs, o ajustes en el esquema), por favor, indícalos y te ayudaré a resolverlos.
*/