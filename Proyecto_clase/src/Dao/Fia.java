package Dao; // Paquete donde se encuentra la clase

import java.awt.Font; // Importa Font para personalizar fuentes
import java.awt.event.ActionEvent; // Importa ActionEvent para eventos de botones
import java.awt.event.ActionListener; // Importa ActionListener para manejar eventos de acción
import java.sql.ResultSet; // Importa ResultSet para manejar resultados de consultas SQL
import java.sql.SQLException; // Importa SQLException para manejar errores de base de datos
import javax.swing.JButton; // Importa JButton para botones
import javax.swing.JDialog; // Importa JDialog para ventanas emergentes
import javax.swing.JFrame; // Importa JFrame para crear la ventana principal
import javax.swing.JLabel; // Importa JLabel para etiquetas de texto
import javax.swing.JOptionPane; // Importa JOptionPane para mensajes emergentes
import javax.swing.JPanel; // Importa JPanel para el contenedor de componentes
import javax.swing.JTextField; // Importa JTextField para campos de entrada de texto
import javax.swing.border.EmptyBorder; // Importa EmptyBorder para márgenes en el panel

import Util.ConexionMySQL; // Importa la clase personalizada para conexión a MySQL

public class Fia extends JFrame {

    private static final long serialVersionUID = 1L; // ID de serialización para la clase
    private JPanel contentPane; // Panel principal que contiene los componentes
    private int currentRaceIndex = -1; // Índice de la carrera actual, inicializado en -1
    private NuevaTemporada2007 parentWindow; // Referencia a la ventana padre (NuevaTemporada2007)

    /**
     * Create the frame with a reference to the parent window.
     */
    public Fia(NuevaTemporada2007 parent) {
        this.parentWindow = parent; // Asigna la ventana padre para comunicación
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al hacer clic en cerrar
        setBounds(0, 0, 900, 600); // Establece las dimensiones y posición inicial (x, y, ancho, alto)
        contentPane = new JPanel(); // Crea el panel principal
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Añade márgenes de 5 píxeles alrededor del panel
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        contentPane.setLayout(null); // Usa un layout nulo para posicionamiento manual
        setContentPane(contentPane); // Asigna el panel como contenido de la ventana

        // Título en la ventana de gestión
        JLabel lblGestionar = new JLabel("GESTIONAR LA TEMPORADA");
        lblGestionar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38)); // Establece fuente y tamaño
        lblGestionar.setBounds(171, 72, 564, 79); // Posiciona el título (x, y, ancho, alto)
        contentPane.add(lblGestionar); // Añade el título al panel

        // Botón para reiniciar todo
        JButton btnReiniciarTodo = new JButton("REINICIAR TODO");
        btnReiniciarTodo.setBounds(354, 257, 200, 50); // Posiciona el botón
        btnReiniciarTodo.setFont(new Font("Dialog", Font.BOLD, 14)); // Establece fuente y estilo
        btnReiniciarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Muestra un mensaje de confirmación antes de reiniciar
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de reiniciar la temporada y los puntos?", "Confirmar Reinicio", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) { // Si el usuario confirma
                    ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1"); // Conexión a la base de datos
                    try {
                        System.out.println("Intentando conectar a la base de datos...");
                        conexion.conectar(); // Establece la conexión
                        System.out.println("Conexión exitosa.");

                        // Reiniciar puntos de pilotos
                        System.out.println("Ejecutando: UPDATE piloto SET Puntos = 0");
                        String sentenciaPilotos = "UPDATE piloto SET Puntos = 0"; // Sentencia SQL para reiniciar puntos
                        int filasPilotos = conexion.ejecutarInsertDeleteUpdate(sentenciaPilotos); // Ejecuta la actualización
                        System.out.println("Filas afectadas (pilotos): " + filasPilotos);

                        // Reiniciar índice de carreras para el año 2007
                        System.out.println("Ejecutando: UPDATE carreras SET indice_actual = -1 WHERE Año = 2007");
                        String sentenciaCarreras = "UPDATE carreras SET indice_actual = -1 WHERE Año = 2007"; // Sentencia SQL para reiniciar índice
                        int filasCarreras = conexion.ejecutarInsertDeleteUpdate(sentenciaCarreras); // Ejecuta la actualización
                        System.out.println("Filas afectadas (carreras): " + filasCarreras);

                        conexion.desconectar(); // Cierra la conexión
                        System.out.println("Desconexión exitosa.");

                        currentRaceIndex = -1; // Restablece el índice de carrera local

                        // Recargar el estado en la ventana principal
                        if (parentWindow != null) {
                            parentWindow.refreshSeasonState(); // Llama al método de la ventana padre para actualizar su estado
                        }

                        // Muestra un mensaje con el resultado del reinicio
                        JOptionPane.showMessageDialog(null, "¡Puntos y temporada reiniciados correctamente!\n" +
                            "Filas afectadas (pilotos): " + filasPilotos + "\n" +
                            "Filas afectadas (carreras): " + filasCarreras);
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Imprime el error en la consola
                        JOptionPane.showMessageDialog(null, "Error al reiniciar: " + ex.getMessage()); // Muestra mensaje de error
                    }
                }
            }
        });
        contentPane.add(btnReiniciarTodo); // Añade el botón al panel

        // Botón para modificar puntos
        JButton btnModificarPuntos = new JButton("MODIFICAR PUNTOS");
        btnModificarPuntos.setFont(new Font("Dialog", Font.BOLD, 14)); // Establece fuente y estilo
        btnModificarPuntos.setBounds(354, 374, 200, 50); // Posiciona el botón
        btnModificarPuntos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicita al usuario el ID del piloto
                String idPiloto = JOptionPane.showInputDialog(Fia.this, "Ingrese el ID del piloto a modificar (ej. P1, P2, etc.):");
                if (idPiloto != null && !idPiloto.trim().isEmpty()) { // Verifica que el ID no esté vacío
                    // Consulta los datos del piloto en la base de datos
                    ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                    try {
                        conexion.conectar(); // Establece la conexión
                        String query = "SELECT Id, Nombre, Puntos FROM piloto WHERE Id = '" + idPiloto + "'"; // Consulta SQL
                        ResultSet rs = conexion.ejecutarSelect(query); // Ejecuta la consulta
                        if (rs.next()) {
                            // Obtiene los datos del piloto
                            String id = rs.getString("Id");
                            String nombre = rs.getString("Nombre");
                            int puntos = rs.getInt("Puntos");

                            // Abre la ventana de modificación solo para puntos
                            abrirVentanaModificacion(id, nombre, puntos);
                        } else {
                            JOptionPane.showMessageDialog(Fia.this, "No se encontró un piloto con el ID: " + idPiloto); // Mensaje si no se encuentra el piloto
                        }
                        rs.close(); // Cierra el ResultSet
                        conexion.desconectar(); // Cierra la conexión
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Imprime el error en la consola
                        JOptionPane.showMessageDialog(Fia.this, "Error al consultar el piloto: " + ex.getMessage()); // Muestra mensaje de error
                    }
                } else {
                    JOptionPane.showMessageDialog(Fia.this, "Debe ingresar un ID válido."); // Mensaje si el ID está vacío
                }
            }
        });
        contentPane.add(btnModificarPuntos); // Añade el botón al panel

        setVisible(true); // Hace visible la ventana principal
    }

    /**
     * Abre una ventana para modificar los puntos de un piloto.
     */
    private void abrirVentanaModificacion(String id, String nombre, int puntos) {
        JDialog dialog = new JDialog(Fia.this, "Modificar Puntos del Piloto", true); // Crea un diálogo modal
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra el diálogo al hacer clic en cerrar
        dialog.setBounds(0, 0, 400, 300); // Establece las dimensiones y posición inicial
        dialog.setLocationRelativeTo(this); // Centra el diálogo respecto a la ventana padre
        JPanel contentPane = new JPanel(); // Crea el panel del diálogo
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Añade márgenes
        dialog.setContentPane(contentPane); // Asigna el panel como contenido del diálogo
        contentPane.setLayout(null); // Usa un layout nulo

        // Título
        JLabel lblTitulo = new JLabel("MODIFICAR PUNTOS");
        lblTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24)); // Establece fuente y tamaño
        lblTitulo.setBounds(100, 10, 200, 40); // Posiciona el título
        contentPane.add(lblTitulo); // Añade el título al panel

        // Etiqueta y campo para ID (no editable)
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 16)); // Establece fuente y estilo
        lblId.setBounds(50, 60, 50, 30); // Posiciona la etiqueta
        contentPane.add(lblId);

        JTextField textId = new JTextField(id); // Campo de texto con el ID
        textId.setBounds(150, 60, 150, 25); // Posiciona el campo
        textId.setEditable(false); // No editable
        contentPane.add(textId);

        // Etiqueta y campo para Nombre (no editable)
        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 16));
        lblNombre.setBounds(50, 100, 100, 30);
        contentPane.add(lblNombre);

        JTextField textNombre = new JTextField(nombre);
        textNombre.setBounds(150, 100, 150, 25);
        textNombre.setEditable(false);
        contentPane.add(textNombre);

        // Etiqueta y campo para Puntos
        JLabel lblPuntos = new JLabel("PUNTOS");
        lblPuntos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 16));
        lblPuntos.setBounds(50, 140, 100, 30);
        contentPane.add(lblPuntos);

        JTextField textPuntos = new JTextField(String.valueOf(puntos));
        textPuntos.setBounds(150, 140, 150, 25);
        contentPane.add(textPuntos);

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 190, 100, 30); // Posiciona el botón
        btnGuardar.addActionListener(e -> {
            try {
                int nuevosPuntos = Integer.parseInt(textPuntos.getText()); // Convierte el texto a número
                if (nuevosPuntos < 0) { // Valida que los puntos no sean negativos
                    JOptionPane.showMessageDialog(dialog, "Los puntos no pueden ser negativos.");
                    return;
                }

                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                conexion.conectar(); // Establece la conexión
                String sentencia = "UPDATE piloto SET Puntos = " + nuevosPuntos + " WHERE Id = '" + textId.getText() + "'"; // Sentencia SQL para actualizar puntos
                int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia); // Ejecuta la actualización
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(dialog, "Puntos modificados con éxito."); // Mensaje de éxito
                    dialog.dispose(); // Cierra el diálogo
                } else {
                    JOptionPane.showMessageDialog(dialog, "No se pudo modificar los puntos."); // Mensaje de fallo
                }
                conexion.desconectar(); // Cierra la conexión
            } catch (SQLException ex) {
                ex.printStackTrace(); // Imprime el error en la consola
                JOptionPane.showMessageDialog(dialog, "Error al modificar los puntos: " + ex.getMessage()); // Muestra mensaje de error
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un valor numérico válido para los puntos."); // Mensaje si el formato no es válido
            }
        });
        contentPane.add(btnGuardar);

        dialog.setVisible(true); // Hace visible el diálogo
    }

    /**
     * Método para reiniciar la temporada (pendiente de implementación)
     */
    public void reiniciarTemporada() {
        // TODO Auto-generated method stub
        // Este método está vacío y pendiente de implementación
    }
}