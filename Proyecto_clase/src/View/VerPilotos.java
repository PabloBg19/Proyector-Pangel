package View;

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
    private JTextField textBusquedaNombre;
    private JTextField textBusquedaEquipo;
    private JTable table;
    private DefaultTableModel tableModel;
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

    public VerPilotos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        String[] columnNames = {"Id", "Nombre", "Equipo", "Nacionalidad", "Temporada", "Habilidad", "Consistencia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 120, 652, 293);
        getContentPane().add(scrollPane);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        cargarPilotos();

        JButton btnVerEquipo = new JButton("VER PILOTOS");
        btnVerEquipo.setEnabled(false);
        btnVerEquipo.addActionListener(e -> cargarPilotos());
        btnVerEquipo.setBounds(33, 439, 0, 11);
        getContentPane().add(btnVerEquipo);

        textBusquedaNombre = new JTextField();
        textBusquedaNombre.setBounds(74, 82, 120, 20);
        getContentPane().add(textBusquedaNombre);
        textBusquedaNombre.setColumns(10);

        JButton btnNombre = new JButton("Buscar por Nombre");
        btnNombre.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM piloto WHERE Nombre='" + textBusquedaNombre.getText() + "'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                tableModel.setRowCount(0);
                while (resultado.next()) {
                    String id = resultado.getString("Id");
                    String nombre = resultado.getString("Nombre");
                    String equipo = resultado.getString("Equipo");
                    String nacionalidad = resultado.getString("Nacionalidad");
                    int temporada = resultado.getInt("Temporada");
                    int habilidad = resultado.getInt("Habilidad");
                    int consistencia = resultado.getInt("Consistencia");
                    tableModel.addRow(new Object[]{id, nombre, equipo, nacionalidad, temporada, habilidad, consistencia});
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnNombre.setBounds(237, 77, 146, 31);
        getContentPane().add(btnNombre);

        textBusquedaEquipo = new JTextField();
        textBusquedaEquipo.setColumns(10);
        textBusquedaEquipo.setBounds(444, 82, 103, 20);
        getContentPane().add(textBusquedaEquipo);

        JButton btnEquipo = new JButton("Buscar por Equipo");
        btnEquipo.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM piloto WHERE Equipo='" + textBusquedaEquipo.getText() + "'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                tableModel.setRowCount(0);
                while (resultado.next()) {
                    String id = resultado.getString("Id");
                    String nombre = resultado.getString("Nombre");
                    String equipo = resultado.getString("Equipo");
                    String nacionalidad = resultado.getString("Nacionalidad");
                    int temporada = resultado.getInt("Temporada");
                    int habilidad = resultado.getInt("Habilidad");
                    int consistencia = resultado.getInt("Consistencia");
                    tableModel.addRow(new Object[]{id, nombre, equipo, nacionalidad, temporada, habilidad, consistencia});
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

        JButton btnEliminar = new JButton("Eliminar Piloto");
        btnEliminar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String idPiloto = (String) tableModel.getValueAt(selectedRow, 0);
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "DELETE FROM piloto WHERE Id='" + idPiloto + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        tableModel.removeRow(selectedRow);
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

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                btnEliminar.setEnabled(true);
            } else {
                btnEliminar.setEnabled(false);
            }
        });

        JButton btnNewButton = new JButton("Añadir Piloto");
        btnNewButton.addActionListener(e -> {
            AñadirPilotos temp = new AñadirPilotos();
            temp.setVisible(true);
        });
        btnNewButton.setBounds(170, 424, 129, 26);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Modificar Piloto");
        btnNewButton_1.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String id = (String) tableModel.getValueAt(selectedRow, 0);
                String nombre = (String) tableModel.getValueAt(selectedRow, 1);
                String equipo = (String) tableModel.getValueAt(selectedRow, 2);
                String nacionalidad = (String) tableModel.getValueAt(selectedRow, 3);
                int temporada = (int) tableModel.getValueAt(selectedRow, 4);
                int habilidad = (int) tableModel.getValueAt(selectedRow, 5);
                int consistencia = (int) tableModel.getValueAt(selectedRow, 6);

                // Query additional fields (Edad, Puntos, Campeonato)
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "SELECT Edad, Puntos, Campeonato FROM piloto WHERE Id='" + id + "'";
                    ResultSet resultado = conexion.ejecutarSelect(sentencia);
                    if (resultado.next()) {
                        int edad = resultado.getInt("Edad");
                        int puntos = resultado.getInt("Puntos");
                        String campeonato = resultado.getString("Campeonato");
                        abrirVentanaModificacion(id, nombre, equipo, nacionalidad, temporada, habilidad, consistencia, edad, puntos, campeonato);
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al obtener datos adicionales del piloto.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un piloto para modificar.");
            }
        });
        btnNewButton_1.setBounds(327, 424, 129, 26);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.addActionListener(e -> cargarPilotos());
        ImageIcon originalIcon = new ImageIcon(VerPilotos.class.getResource("/image/recargar.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(52, 51, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        btnNewButton_2.setIcon(scaledIcon);
        btnNewButton_2.setBounds(552, 11, 52, 51);
        getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_3_1 = new JLabel("Refrescar");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_3_1.setBounds(614, 25, 69, 31);
        getContentPane().add(lblNewLabel_3_1);
    }

    private void cargarPilotos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String sentencia = "SELECT * FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            tableModel.setRowCount(0);
            while (resultado.next()) {
                String id = resultado.getString("Id");
                String nombre = resultado.getString("Nombre");
                String equipo = resultado.getString("Equipo");
                String nacionalidad = resultado.getString("Nacionalidad");
                int temporada = resultado.getInt("Temporada");
                int habilidad = resultado.getInt("Habilidad");
                int consistencia = resultado.getInt("Consistencia");
                tableModel.addRow(new Object[]{id, nombre, equipo, nacionalidad, temporada, habilidad, consistencia});
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void abrirVentanaModificacion(String id, String nombre, String equipo, String nacionalidad, int temporada, int habilidad, int consistencia, int edad, int puntos, String campeonato) {
        JDialog dialog = new JDialog(this, "Modificar Piloto", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(0, 0, 800, 500);
        dialog.setLocationRelativeTo(this);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        dialog.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID");
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

        textId = new JTextField(id);
        textId.setBounds(329, 75, 149, 20);
        textId.setEditable(false); // ID should not be editable
        contentPane.add(textId);

        textNombre = new JTextField(nombre);
        textNombre.setBounds(329, 115, 149, 20);
        contentPane.add(textNombre);

        textEdad = new JTextField(String.valueOf(edad));
        textEdad.setBounds(329, 155, 149, 20);
        contentPane.add(textEdad);

        textNacionalidad = new JTextField(nacionalidad);
        textNacionalidad.setBounds(329, 195, 149, 20);
        contentPane.add(textNacionalidad);

        textTemporada = new JTextField(String.valueOf(temporada));
        textTemporada.setBounds(329, 235, 149, 20);
        contentPane.add(textTemporada);

        textEquipo = new JTextField(equipo);
        textEquipo.setBounds(329, 275, 149, 20);
        contentPane.add(textEquipo);

        textHabilidad = new JTextField(String.valueOf(habilidad));
        textHabilidad.setBounds(329, 315, 149, 20);
        contentPane.add(textHabilidad);

        textPuntos = new JTextField(String.valueOf(puntos));
        textPuntos.setBounds(329, 355, 149, 20);
        contentPane.add(textPuntos);

        textConsistencia = new JTextField(String.valueOf(consistencia));
        textConsistencia.setBounds(329, 395, 149, 20);
        contentPane.add(textConsistencia);

        textCampeonato = new JTextField(campeonato);
        textCampeonato.setBounds(329, 435, 149, 20);
        contentPane.add(textCampeonato);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "UPDATE piloto SET " +
                        "Nombre='" + textNombre.getText() + "', " +
                        "Edad='" + textEdad.getText() + "', " +
                        "Nacionalidad='" + textNacionalidad.getText() + "', " +
                        "Temporada='" + textTemporada.getText() + "', " +
                        "Equipo='" + textEquipo.getText() + "', " +
                        "Habilidad='" + textHabilidad.getText() + "', " +
                        "Consistencia='" + textConsistencia.getText() + "', " +
                        "Puntos='" + textPuntos.getText() + "', " +
                        "Campeonato='" + textCampeonato.getText() + "' " +
                        "WHERE Id='" + textId.getText() + "'";
                int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(dialog, "Piloto modificado con éxito.");
                    dialog.dispose();
                    cargarPilotos();
                } else {
                    JOptionPane.showMessageDialog(dialog, "No se pudo modificar el piloto.");
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(dialog, "Error al modificar el piloto.");
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