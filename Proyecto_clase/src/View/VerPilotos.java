package View;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerPilotos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textEquipo;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Create the frame.
     */
    public VerPilotos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // centra la ventana
        getContentPane().setLayout(null);

        // Crear modelo de la tabla con columnas Nombre, Equipo, Nacionalidad, Habilidad
        String[] columnNames = {"Nombre", "Equipo", "Nacionalidad", "Habilidad", "Consistencia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(102, 126, 585, 300);
        getContentPane().add(scrollPane);
        
     // Centrar el contenido de las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar el renderer a todas las columnas de la tabla
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Cargar todos los pilotos al iniciar la ventana
        cargarPilotos();

        // Botón VER PILOTOS
        JButton btnVerEquipo = new JButton("VER PILOTOS");
        btnVerEquipo.setEnabled(false);
        btnVerEquipo.addActionListener(e -> cargarPilotos());
        btnVerEquipo.setBounds(21, 419, 56, 31);
        getContentPane().add(btnVerEquipo);

        // Campo de texto para búsqueda por nombre
        textNombre = new JTextField();
        textNombre.setBounds(74, 82, 120, 20);
        getContentPane().add(textNombre);
        textNombre.setColumns(10);

        // Botón BUSCAR por nombre
        JButton btnNombre = new JButton("Buscar por Nombre");
        btnNombre.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM piloto WHERE Nombre='" + textNombre.getText() + "'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                // Limpiar tabla
                tableModel.setRowCount(0);
                // Añadir filas a la tabla
                while (resultado.next()) {
                    String nombre = resultado.getString("Nombre");
                    String equipo = resultado.getString("Equipo");
                    String nacionalidad = resultado.getString("Nacionalidad");
                    String habilidad = resultado.getString("Habilidad");
                    tableModel.addRow(new Object[]{nombre, equipo, nacionalidad, habilidad});
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnNombre.setBounds(237, 77, 146, 31);
        getContentPane().add(btnNombre);

        textEquipo = new JTextField();
        textEquipo.setColumns(10);
        textEquipo.setBounds(444, 82, 103, 20);
        getContentPane().add(textEquipo);

        // Botón BUSCAR por equipo
        JButton btnEquipo = new JButton("Buscar por Equipo");
        btnEquipo.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM piloto WHERE Equipo='" + textEquipo.getText() + "'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                // Limpiar tabla
                tableModel.setRowCount(0);
                // Añadir filas a la tabla
                while (resultado.next()) {
                    String nombre = resultado.getString("Nombre");
                    String equipo = resultado.getString("Equipo");
                    String nacionalidad = resultado.getString("Nacionalidad");
                    String habilidad = resultado.getString("Habilidad");
                    tableModel.addRow(new Object[]{nombre, equipo, nacionalidad, habilidad});
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnEquipo.setBounds(570, 77, 146, 31);
        getContentPane().add(btnEquipo);

        JLabel lblNewLabel_3 = new JLabel("VER PILOTOS");
        lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_3.setBounds(231, 25, 261, 31);
        getContentPane().add(lblNewLabel_3);
    }

    // Método para cargar todos los pilotos en la tabla
    private void cargarPilotos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String sentencia = "SELECT * FROM piloto";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            // Limpiar tabla
            tableModel.setRowCount(0);
            // Añadir filas a la tabla
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String equipo = resultado.getString("Equipo");
                String nacionalidad = resultado.getString("Nacionalidad");
                String habilidad = resultado.getString("Habilidad");
                String consistencia =resultado.getString("Consistencia");
                tableModel.addRow(new Object[]{nombre, equipo, nacionalidad, habilidad, consistencia});
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VerPilotos frame = new VerPilotos();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}