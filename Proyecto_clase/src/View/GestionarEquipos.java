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

public class GestionarEquipos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textEquipo; // Adjusted to match new context
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Create the frame.
     */
    public GestionarEquipos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 919, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // Center the window
        getContentPane().setLayout(null);

        // Create table model with new columns
        String[] columnNames = {"Id", "Nombre", "Motor", "Pais", "Potencia", "Aerodinamica", "Fiabilidad"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // Add table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 120, 903, 293);
        getContentPane().add(scrollPane);

        // Center the content of the cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the renderer to all columns of the table
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Load all teams at startup
        cargarEquipos();

        // Campo de texto para búsqueda por nombre
        textNombre = new JTextField();
        textNombre.setBounds(153, 82, 120, 20);
        getContentPane().add(textNombre);
        textNombre.setColumns(10);

        // Botón BUSCAR por nombre
        JButton btnNombre = new JButton("Buscar por Nombre");
        btnNombre.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM equipo WHERE Nombre LIKE '%" + textNombre.getText() + "%'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                // Clear table
                tableModel.setRowCount(0);
                // Add rows to the table
                while (resultado.next()) {
                    String Id = resultado.getString("Id");
                    String Nombre = resultado.getString("Nombre");
                    String Motor = resultado.getString("Motor");
                    String Pais = resultado.getString("Pais");
                    int Potencia = resultado.getInt("Potencia");
                    int Aerodinamica = resultado.getInt("Aerodinamica");
                    int Fiabilidad = resultado.getInt("Fiabilidad");
                    tableModel.addRow(new Object[]{Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad});
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnNombre.setBounds(283, 77, 146, 31);
        getContentPane().add(btnNombre);

        textEquipo = new JTextField();
        textEquipo.setColumns(10);
        textEquipo.setBounds(498, 82, 117, 20);
        getContentPane().add(textEquipo);

        // Botón BUSCAR por equipo (search by Nombre)
        JButton btnEquipo = new JButton("Buscar por Equipo");
        btnEquipo.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM equipo WHERE Nombre LIKE '%" + textEquipo.getText() + "%'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                // Clear table
                tableModel.setRowCount(0);
                // Add rows to the table
                while (resultado.next()) {
                    String Id = resultado.getString("Id");
                    String Nombre = resultado.getString("Nombre");
                    String Motor = resultado.getString("Motor");
                    String Pais = resultado.getString("Pais");
                    int Potencia = resultado.getInt("Potencia");
                    int Aerodinamica = resultado.getInt("Aerodinamica");
                    int Fiabilidad = resultado.getInt("Fiabilidad");
                    tableModel.addRow(new Object[]{Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad});
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnEquipo.setBounds(625, 78, 146, 31);
        getContentPane().add(btnEquipo);

        JLabel lblNewLabel_3 = new JLabel("VER EQUIPOS");
        lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_3.setBounds(316, 19, 261, 31);
        getContentPane().add(lblNewLabel_3);

        // Botón ELIMINAR EQUIPO
        JButton btnEliminar = new JButton("Eliminar Equipo");
        btnEliminar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String idEquipo = (String) tableModel.getValueAt(selectedRow, 0); // Columna Id
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "DELETE FROM equipo WHERE Id='" + idEquipo + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        tableModel.removeRow(selectedRow); // Remove row from the table
                        JOptionPane.showMessageDialog(this, "Equipo eliminado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el equipo.");
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al eliminar el equipo.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un equipo para eliminar.");
            }
        });
        btnEliminar.setBounds(579, 424, 150, 26);
        getContentPane().add(btnEliminar);

        // Detect selection in the table
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                btnEliminar.setEnabled(true);
            } else {
                btnEliminar.setEnabled(false);
            }
        });

        JButton btnNewButton = new JButton("Añadir Equipo");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnadirEquipo temp = new AnadirEquipo();
                temp.setVisible(true);
            }
        });
        btnNewButton.setBounds(202, 424, 129, 26);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Modificar Equipo");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String id = (String) tableModel.getValueAt(selectedRow, 0);
                    String nombre = (String) tableModel.getValueAt(selectedRow, 1);
                    String motor = (String) tableModel.getValueAt(selectedRow, 2);
                    String pais = (String) tableModel.getValueAt(selectedRow, 3);
                    String potencia = String.valueOf(tableModel.getValueAt(selectedRow, 4));
                    String aerodinamica = String.valueOf(tableModel.getValueAt(selectedRow, 5));
                    String fiabilidad = String.valueOf(tableModel.getValueAt(selectedRow, 6));

                    // Open modification window
                    abrirVentanaModificacion(id, nombre, motor, pais, potencia, aerodinamica, fiabilidad);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un equipo para modificar.");
                }
            }
        });
        btnNewButton_1.setBounds(394, 424, 129, 26);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarEquipos();
            }
        });

        ImageIcon originalIcon = new ImageIcon(GestionarEquipos.class.getResource("/image/recargar.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(52, 51, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        btnNewButton_2.setIcon(scaledIcon);
        btnNewButton_2.setSelectedIcon(scaledIcon);
        btnNewButton_2.setBounds(615, 15, 52, 51);
        btnNewButton_2.setText("");
        getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_3_1 = new JLabel("Refrescar");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_3_1.setBounds(677, 25, 69, 31);
        getContentPane().add(lblNewLabel_3_1);
    }

    // Method to load all teams into the table
    private void cargarEquipos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String sentencia = "SELECT * FROM equipo";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            // Clear table
            tableModel.setRowCount(0);
            // Add rows to the table
            while (resultado.next()) {
                String Id = resultado.getString("Id");
                String Nombre = resultado.getString("Nombre");
                String Motor = resultado.getString("Motor");
                String Pais = resultado.getString("Pais");
                int Potencia = resultado.getInt("Potencia");
                int Aerodinamica = resultado.getInt("Aerodinamica");
                int Fiabilidad = resultado.getInt("Fiabilidad");
                tableModel.addRow(new Object[]{Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad});
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Method to open the modification window
    private void abrirVentanaModificacion(String id, String nombre, String motor, String pais, String potencia, String aerodinamica, String fiabilidad) {
        JDialog dialog = new JDialog(this, "Modificar Equipo", true);
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

        JLabel lblMotor = new JLabel("MOTOR");
        lblMotor.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblMotor.setBounds(238, 166, 83, 32);
        contentPane.add(lblMotor);

        JLabel lblPais = new JLabel("PAIS");
        lblPais.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPais.setBounds(234, 209, 74, 32);
        contentPane.add(lblPais);

        JLabel lblPotencia = new JLabel("POTENCIA");
        lblPotencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPotencia.setBounds(450, 209, 129, 32);
        contentPane.add(lblPotencia);

        JLabel lblAerodinamica = new JLabel("AERODINAMICA");
        lblAerodinamica.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblAerodinamica.setBounds(234, 252, 129, 32);
        contentPane.add(lblAerodinamica);

        JLabel lblFiabilidad = new JLabel("FIABILIDAD");
        lblFiabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblFiabilidad.setBounds(450, 252, 129, 32);
        contentPane.add(lblFiabilidad);

        JTextField textId = new JTextField(id);
        textId.setColumns(10);
        textId.setBounds(329, 90, 149, 20);
        contentPane.add(textId);

        JTextField textNombre = new JTextField(nombre);
        textNombre.setColumns(10);
        textNombre.setBounds(329, 120, 149, 20);
        contentPane.add(textNombre);

        JTextField textMotor = new JTextField(motor);
        textMotor.setColumns(10);
        textMotor.setBounds(329, 150, 149, 20);
        contentPane.add(textMotor);

        JTextField textPais = new JTextField(pais);
        textPais.setColumns(10);
        textPais.setBounds(329, 180, 149, 20);
        contentPane.add(textPais);

        JTextField textPotencia = new JTextField(potencia);
        textPotencia.setColumns(10);
        textPotencia.setBounds(510, 180, 149, 20);
        contentPane.add(textPotencia);

        JTextField textAerodinamica = new JTextField(aerodinamica);
        textAerodinamica.setColumns(10);
        textAerodinamica.setBounds(329, 210, 149, 20);
        contentPane.add(textAerodinamica);

        JTextField textFiabilidad = new JTextField(fiabilidad);
        textFiabilidad.setColumns(10);
        textFiabilidad.setBounds(510, 210, 149, 20);
        contentPane.add(textFiabilidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "UPDATE equipo SET Nombre='" + textNombre.getText() +
                            "', Motor='" + textMotor.getText() +
                            "', Pais='" + textPais.getText() +
                            "', Potencia=" + textPotencia.getText() +
                            ", Aerodinamica=" + textAerodinamica.getText() +
                            ", Fiabilidad=" + textFiabilidad.getText() +
                            " WHERE Id='" + textId.getText() + "'";

                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(dialog, "Equipo modificado con éxito.");
                        dialog.dispose();
                        cargarEquipos(); // Reload the table
                    } else {
                        JOptionPane.showMessageDialog(dialog, "No se pudo modificar el equipo.");
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dialog, "Error al modificar el equipo.");
                }
            }
        });
        btnGuardar.setBounds(597, 228, 89, 23);
        contentPane.add(btnGuardar);

        JLabel lblNewLabel_1 = new JLabel("MODIFICAR EQUIPO");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_1.setBounds(240, 11, 325, 90);
        contentPane.add(lblNewLabel_1);

        dialog.setVisible(true);
    }
}