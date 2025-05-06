package View;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        // Crear modelo de la tabla con columnas Id, Nombre, Equipo, Nacionalidad, Habilidad, Consistencia
        String[] columnNames = {"Id", "Nombre", "Equipo", "Nacionalidad", "Habilidad", "Consistencia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 120, 652, 293);
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
        btnVerEquipo.setBounds(33, 439, 0, 11);
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
                    String Id = resultado.getString("Id");
                    String nombre = resultado.getString("Nombre");
                    String equipo = resultado.getString("Equipo");
                    String nacionalidad = resultado.getString("Nacionalidad");
                    String habilidad = resultado.getString("Habilidad");
                    String consistencia = resultado.getString("Consistencia");
                    tableModel.addRow(new Object[]{Id, nombre, equipo, nacionalidad, habilidad, consistencia});
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
                    String Id = resultado.getString("Id");
                    String nombre = resultado.getString("Nombre");
                    String equipo = resultado.getString("Equipo");
                    String nacionalidad = resultado.getString("Nacionalidad");
                    String habilidad = resultado.getString("Habilidad");
                    String consistencia = resultado.getString("Consistencia");
                    tableModel.addRow(new Object[]{Id, nombre, equipo, nacionalidad, habilidad, consistencia});
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
        lblNewLabel_3.setBounds(264, 25, 261, 31);
        getContentPane().add(lblNewLabel_3);

        // Botón ELIMINAR PILOTO
        JButton btnEliminar = new JButton("Eliminar Piloto");
        btnEliminar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String idPiloto = (String) tableModel.getValueAt(selectedRow, 0); // Columna Id
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "DELETE FROM piloto WHERE Id='" + idPiloto + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        tableModel.removeRow(selectedRow); // Eliminar fila de la tabla
                        JOptionPane.showMessageDialog(this, "Piloto eliminado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el piloto.");
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al eliminar el piloto.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un piloto para eliminar.");
            }
        });
        btnEliminar.setBounds(474, 424, 150, 26);
        getContentPane().add(btnEliminar);

        // Detectar selección en la tabla
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                btnEliminar.setEnabled(true);
            } else {
                btnEliminar.setEnabled(false);
            }
        });

        JButton btnNewButton = new JButton("Añadir Piloto");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AñadirPilotos temp = new AñadirPilotos();
                temp.setVisible(true);
            }
        });
        btnNewButton.setBounds(170, 424, 129, 26);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Modificar Piloto");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String id = (String) tableModel.getValueAt(selectedRow, 0);
                    String nombre = (String) tableModel.getValueAt(selectedRow, 1);
                    String equipo = (String) tableModel.getValueAt(selectedRow, 2);
                    String nacionalidad = (String) tableModel.getValueAt(selectedRow, 3);
                    String habilidad = (String) tableModel.getValueAt(selectedRow, 4);
                    String consistencia = (String) tableModel.getValueAt(selectedRow, 5);

                    // Abrir ventana de modificación
                    abrirVentanaModificacion(id, nombre, equipo, nacionalidad, habilidad, consistencia);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un piloto para modificar.");
                }
            }
        });
        btnNewButton_1.setBounds(327, 424, 129, 26);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarPilotos();
            }
        });

        ImageIcon originalIcon = new ImageIcon(VerPilotos.class.getResource("/image/recargar.png"));

        Image scaledImage = originalIcon.getImage().getScaledInstance(52, 51, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        btnNewButton_2.setIcon(scaledIcon);
        btnNewButton_2.setSelectedIcon(scaledIcon);
        btnNewButton_2.setBounds(552, 11, 52, 51);
        btnNewButton_2.setText("");
        getContentPane().add(btnNewButton_2);
        
        JLabel lblNewLabel_3_1 = new JLabel("Refrescar");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_3_1.setBounds(614, 25, 69, 31);
        getContentPane().add(lblNewLabel_3_1);
    }

    // Método para cargar todos los pilotos en la tabla
    private void cargarPilotos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String sentencia = "SELECT * FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            // Limpiar tabla
            tableModel.setRowCount(0);
            // Añadir filas a la tabla
            while (resultado.next()) {
                String Id = resultado.getString("Id");
                String nombre = resultado.getString("Nombre");
                String equipo = resultado.getString("Equipo");
                String nacionalidad = resultado.getString("Nacionalidad");
                String habilidad = resultado.getString("Habilidad");
                String consistencia = resultado.getString("Consistencia");
                tableModel.addRow(new Object[]{Id, nombre, equipo, nacionalidad, habilidad, consistencia});
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para abrir la ventana de modificación
    private void abrirVentanaModificacion(String id, String nombre, String equipo, String nacionalidad, String habilidad, String consistencia) {
        JDialog dialog = new JDialog(this, "Modificar Piloto", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(0, 0, 800, 500);
        dialog.setLocationRelativeTo(this);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        dialog.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblId.setBounds(282, 80, 39, 32);
        contentPane.add(lblId);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblNombre.setBounds(238, 123, 83, 32);
        contentPane.add(lblNombre);

        JLabel lblEdad = new JLabel("EDAD");
        lblEdad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblEdad.setBounds(238, 166, 83, 32);
        contentPane.add(lblEdad);

        JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
        lblNacionalidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblNacionalidad.setBounds(171, 209, 148, 32);
        contentPane.add(lblNacionalidad);

        JLabel lblEquipo = new JLabel("EQUIPO");
        lblEquipo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblEquipo.setBounds(234, 252, 74, 32);
        contentPane.add(lblEquipo);

        JLabel lblHabilidad = new JLabel("HABILIDAD");
        lblHabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblHabilidad.setBounds(215, 295, 106, 32);
        contentPane.add(lblHabilidad);

        JLabel lblConsistencia = new JLabel("CONSISTENCIA");
        lblConsistencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblConsistencia.setBounds(192, 381, 129, 32);
        contentPane.add(lblConsistencia);

        JLabel lblPuntos = new JLabel("PUNTOS");
        lblPuntos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPuntos.setBounds(234, 338, 83, 32);
        contentPane.add(lblPuntos);

        JLabel lblCampeonato = new JLabel("CAMPEONATO");
        lblCampeonato.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblCampeonato.setBounds(192, 424, 129, 32);
        contentPane.add(lblCampeonato);

        JTextField textId = new JTextField(id);
        textId.setColumns(10);
        textId.setBounds(329, 90, 149, 20);
        contentPane.add(textId);

        JTextField textNombre = new JTextField(nombre);
        textNombre.setColumns(10);
        textNombre.setBounds(329, 133, 149, 20);
        contentPane.add(textNombre);

        JTextField textEdad = new JTextField();
        textEdad.setColumns(10);
        textEdad.setBounds(329, 176, 149, 20);
        contentPane.add(textEdad);

        JTextField textNacionalidad = new JTextField(nacionalidad);
        textNacionalidad.setColumns(10);
        textNacionalidad.setBounds(329, 219, 149, 20);
        contentPane.add(textNacionalidad);

        JTextField textEquipo = new JTextField(equipo);
        textEquipo.setColumns(10);
        textEquipo.setBounds(329, 262, 149, 20);
        contentPane.add(textEquipo);

        JTextField textHabilidad = new JTextField(habilidad);
        textHabilidad.setColumns(10);
        textHabilidad.setBounds(331, 305, 149, 20);
        contentPane.add(textHabilidad);

        JTextField textConsistencia = new JTextField(consistencia);
        textConsistencia.setColumns(10);
        textConsistencia.setBounds(331, 391, 149, 20);
        contentPane.add(textConsistencia);

        JTextField textPuntos = new JTextField();
        textPuntos.setColumns(10);
        textPuntos.setBounds(330, 348, 148, 20);
        contentPane.add(textPuntos);

        JTextField textCampeonato = new JTextField();
        textCampeonato.setColumns(10);
        textCampeonato.setBounds(329, 434, 149, 20);
        contentPane.add(textCampeonato);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "UPDATE piloto SET Nombre='" + textNombre.getText() + "', Edad='" + textEdad.getText() + "', Nacionalidad='" + textNacionalidad.getText() +
                                      "', Equipo='" + textEquipo.getText() + "', Habilidad='" + textHabilidad.getText() + "', Consistencia='" + textConsistencia.getText() +
                                      "', Puntos='" + textPuntos.getText() + "', Campeonato='" + textCampeonato.getText() +
                                      "' WHERE Id='" + textId.getText() + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(dialog, "Piloto modificado con éxito.");
                        dialog.dispose();
                        cargarPilotos(); // Recargar tabla después de modificar
                    } else {
                        JOptionPane.showMessageDialog(dialog, "No se pudo modificar el piloto.");
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dialog, "Error al modificar el piloto.");
                }
            }
        });
        btnGuardar.setBounds(597, 228, 89, 23);
        contentPane.add(btnGuardar);

        JLabel lblNewLabel_1 = new JLabel("MODIFICAR PILOTO");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_1.setBounds(240, 11, 325, 90);
        contentPane.add(lblNewLabel_1);

        dialog.setVisible(true);
    }
}

