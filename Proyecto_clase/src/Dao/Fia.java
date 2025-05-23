package Dao;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Util.ConexionMySQL;

/**
 * Clase que representa una ventana para gestionar la temporada de Fórmula 1.
 * Permite reiniciar los puntos de los pilotos y el índice de carreras, así como modificar los puntos de un piloto específico.
 * La ventana se comunica con la ventana padre (NuevaTemporada2007) para actualizar su estado tras ciertas operaciones.
 * 
 * @author Pangel
 * @version 1.0
 */
public class Fia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int currentRaceIndex = -1;
    private NuevaTemporada2007 parentWindow;

    /**
     * Constructor de la clase Fia.
     * Inicializa la ventana de gestión de temporada, configurando el layout, los componentes
     * (etiquetas, botones) y estableciendo una referencia a la ventana padre para comunicación.
     * 
     * @param parent La ventana padre de tipo NuevaTemporada2007.
     */
    public Fia(NuevaTemporada2007 parent) {
        this.parentWindow = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Título de la ventana
        JLabel lblGestionar = new JLabel("GESTIONAR LA TEMPORADA");
        lblGestionar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblGestionar.setBounds(171, 72, 564, 79);
        contentPane.add(lblGestionar);

        /**
         * Botón para reiniciar los puntos de los pilotos y el índice de carreras.
         * Al hacer clic, solicita confirmación al usuario y ejecuta las actualizaciones en la base de datos.
         */
        JButton btnReiniciarTodo = new JButton("REINICIAR TODO");
        btnReiniciarTodo.setBounds(354, 257, 200, 50);
        btnReiniciarTodo.setFont(new Font("Dialog", Font.BOLD, 14));
        btnReiniciarTodo.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Reiniciar Todo".
             * Reinicia los puntos de los pilotos y el índice de carreras para el año 2007 en la base de datos.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, 
                    "¿Estás seguro de reiniciar la temporada y los puntos?", 
                    "Confirmar Reinicio", 
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                    try {
                        conexion.conectar();
                        // Reiniciar puntos de pilotos
                        String sentenciaPilotos = "UPDATE piloto SET Puntos = 0";
                        int filasPilotos = conexion.ejecutarInsertDeleteUpdate(sentenciaPilotos);
                        // Reiniciar índice de carreras para el año 2007
                        String sentenciaCarreras = "UPDATE carreras SET indice_actual = -1 WHERE Año = 2007";
                        int filasCarreras = conexion.ejecutarInsertDeleteUpdate(sentenciaCarreras);
                        conexion.desconectar();
                        currentRaceIndex = -1;
                        // Actualizar el estado en la ventana principal
                        if (parentWindow != null) {
                            parentWindow.refreshSeasonState();
                        }
                        JOptionPane.showMessageDialog(null, 
                            "¡Puntos y temporada reiniciados correctamente!\n" +
                            "Filas afectadas (pilotos): " + filasPilotos + "\n" +
                            "Filas afectadas (carreras): " + filasCarreras,
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, 
                            "Error al reiniciar: " + ex.getMessage(), 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        try {
                            conexion.desconectar();
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        });
        contentPane.add(btnReiniciarTodo);

        /**
         * Botón para modificar los puntos de un piloto.
         * Al hacer clic, solicita el ID del piloto y abre un diálogo para editar sus puntos.
         */
        JButton btnModificarPuntos = new JButton("MODIFICAR PUNTOS");
        btnModificarPuntos.setFont(new Font("Dialog", Font.BOLD, 14));
        btnModificarPuntos.setBounds(354, 374, 200, 50);
        btnModificarPuntos.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Modificar Puntos".
             * Solicita el ID del piloto y abre un diálogo para modificar sus puntos.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPiloto = JOptionPane.showInputDialog(Fia.this, 
                    "Ingrese el ID del piloto a modificar (ej. P1, P2, etc.):");
                if (idPiloto != null && !idPiloto.trim().isEmpty()) {
                    ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                    try {
                        conexion.conectar();
                        String query = "SELECT Id, Nombre, Puntos FROM piloto WHERE Id = '" + idPiloto + "'";
                        ResultSet rs = conexion.ejecutarSelect(query);
                        if (rs.next()) {
                            String id = rs.getString("Id");
                            String nombre = rs.getString("Nombre");
                            int puntos = rs.getInt("Puntos");
                            abrirVentanaModificacion(id, nombre, puntos);
                        } else {
                            JOptionPane.showMessageDialog(Fia.this, 
                                "No se encontró un piloto con el ID: " + idPiloto,
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                        rs.close();
                        conexion.desconectar();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(Fia.this, 
                            "Error al consultar el piloto: " + ex.getMessage(),
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        try {
                            conexion.desconectar();
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Fia.this, 
                        "Debe ingresar un ID válido.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(btnModificarPuntos);

        setVisible(true);
    }

    /**
     * Abre un diálogo para modificar los puntos de un piloto específico.
     * Muestra el ID y nombre del piloto (no editables) y permite actualizar los puntos.
     * 
     * @param id     El ID del piloto.
     * @param nombre El nombre del piloto.
     * @param puntos Los puntos actuales del piloto.
     */
    private void abrirVentanaModificacion(String id, String nombre, int puntos) {
        JDialog dialog = new JDialog(Fia.this, "Modificar Puntos del Piloto", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(0, 0, 400, 300);
        dialog.setLocationRelativeTo(this);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        dialog.setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título del diálogo
        JLabel lblTitulo = new JLabel("MODIFICAR PUNTOS");
        lblTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24));
        lblTitulo.setBounds(100, 10, 200, 40);
        contentPane.add(lblTitulo);

        // Etiqueta y campo para ID (no editable)
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 16));
        lblId.setBounds(50, 60, 50, 30);
        contentPane.add(lblId);

        JTextField textId = new JTextField(id);
        textId.setBounds(150, 60, 150, 25);
        textId.setEditable(false);
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

        /**
         * Botón para guardar los cambios en los puntos del piloto.
         * Valida los datos y actualiza los puntos en la base de datos.
         */
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 190, 100, 30);
        btnGuardar.addActionListener(e -> {
            try {
                int nuevosPuntos = Integer.parseInt(textPuntos.getText());
                if (nuevosPuntos < 0) {
                    JOptionPane.showMessageDialog(dialog, 
                        "Los puntos no pueden ser negativos.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "UPDATE piloto SET Puntos = " + nuevosPuntos + 
                                      " WHERE Id = '" + textId.getText() + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(dialog, 
                            "Puntos modificados con éxito.", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                        // Actualizar el estado en la ventana principal
                        if (parentWindow != null) {
                            parentWindow.refreshSeasonState();
                        }
                    } else {
                        JOptionPane.showMessageDialog(dialog, 
                            "No se pudo modificar los puntos.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dialog, 
                        "Error al modificar los puntos: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    try {
                        conexion.desconectar();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, 
                    "Por favor, ingrese un valor numérico válido para los puntos.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btnGuardar);

        dialog.setVisible(true);
    }

    /**
     * Método para reiniciar la temporada.
     * Actualmente está vacío y pendiente de implementación.
     */
    public void reiniciarTemporada() {
        // TODO: Implementar la lógica para reiniciar la temporada
    }
}