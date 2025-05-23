package Dao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Util.ConexionMySQL;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
        setBounds(0, 0, 800, 550);
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
        
     // Etiqueta para mostrar el promedio de habilidad
        JLabel lblPromedioHabilidad = new JLabel("Promedio Habilidad: ");
        lblPromedioHabilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPromedioHabilidad.setBounds(70, 462, 200, 20);
        getContentPane().add(lblPromedioHabilidad);

        // Botón para calcular el promedio de habilidad, BLOQUE ANÓNIMO.
        JButton btnCalcularPromedio = new JButton("Calcular Promedio Habilidad");
        btnCalcularPromedio.setBounds(280, 461, 200, 26);
        btnCalcularPromedio.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT CalcularPromedioHabilidad() AS promedio FROM DUAL";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                if (resultado.next()) {
                    float promedio = resultado.getFloat("promedio");
                    lblPromedioHabilidad.setText("Promedio Habilidad: " + String.format("%.2f", promedio));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al calcular el promedio de habilidad.");
            }
        });
        getContentPane().add(btnCalcularPromedio);

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
        btnEliminar.setBounds(422, 424, 150, 26);
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
            AnadirPilotos temp = new AnadirPilotos();
            temp.setVisible(true);
        });
        btnNewButton.setBounds(43, 425, 146, 26);
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
        btnNewButton_1.setBounds(216, 425, 129, 26);
        getContentPane().add(btnNewButton_1);

        JButton btnRestablecer = new JButton("Restablecer Pilotos");
        btnRestablecer.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(this, 
                    "Esta acción eliminará todos los pilotos existentes y restablecerá la base de datos.\n¿Desea continuar?", 
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                restablecerPilotos();
            }
        });
        btnRestablecer.setBounds(595, 424, 150, 26);
        getContentPane().add(btnRestablecer);

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
            String sentencia = "SELECT * FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC"; //ordena los id de los pilotos: p1, p2, p3...
            																									
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
    
    private void restablecerPilotos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            
            // Primero eliminamos todos los pilotos existentes
            String eliminarPilotos = "DELETE FROM piloto";
            conexion.ejecutarInsertDeleteUpdate(eliminarPilotos);
            
            // Datos de los pilotos a insertar
            Map<String, Object[]> pilotos = new HashMap<>();
            
            // Formato: ID, Nombre, Edad, Nacionalidad, Temporada, Equipo, Habilidad, Consistencia, Puntos, Campeonato
            pilotos.put("P3", new Object[]{"Kimi Raikkonen", 28, "Finlandia", 2007, "Ferrari", 93, 93, 0, 0});
            pilotos.put("P1", new Object[]{"Fernando Alonso", 25, "España", 2007, "Mclaren", 95, 91, 0, 2});
            pilotos.put("P2", new Object[]{"Lewis Hamilton", 22, "Reino Unido", 2007, "Mclaren", 94, 93, 0, 0});
            pilotos.put("P4", new Object[]{"Felipe Massa", 25, "Brasil", 2007, "Ferrari", 92, 90, 0, 0});
            pilotos.put("P8", new Object[]{"Robert Kubica", 22, "Polonia", 2007, "BMW Sauber", 87, 86, 0, 0});
            pilotos.put("P7", new Object[]{"Nick Heidfeld", 29, "Polonia", 2007, "BMW Sauber", 88, 88, 0, 0});
            pilotos.put("P6", new Object[]{"Heikki Kovalainen", 25, "Finlandia", 2007, "Renault", 85, 83, 0, 0});
            pilotos.put("P13", new Object[]{"Sebastian Vettel", 19, "Alemania", 2007, "Red Bull", 88, 85, 0, 0});
            pilotos.put("P5", new Object[]{"Giancarlo Fisichella", 33, "Italia", 2007, "Renault", 83, 81, 0, 0});
            pilotos.put("P9", new Object[]{"Nico Rosberg", 21, "Alemania", 2007, "Williams", 84, 80, 0, 0});
            pilotos.put("P22", new Object[]{"Christijan Albers", 28, "Holanda", 2007, "Spyker", 77, 75, 0, 0});
            pilotos.put("P21", new Object[]{"Adrian Sutil", 24, "Uruguay", 2007, "Spyker", 78, 76, 0, 0});
            pilotos.put("P10", new Object[]{"Alexander Wurz", 33, "Reino Unido", 2007, "Williams", 82, 78, 0, 0});
            pilotos.put("P11", new Object[]{"Rubens Barrichello", 34, "Brasil", 2007, "Honda", 81, 81, 0, 0});
            pilotos.put("P12", new Object[]{"Jenson Button", 27, "Reino Unido", 2007, "Honda", 83, 82, 0, 0});
            pilotos.put("P14", new Object[]{"Mark Webber", 30, "Australia", 2007, "Red Bull", 82, 78, 0, 0});
            pilotos.put("P15", new Object[]{"Ralf Schumacher", 31, "Alemania", 2007, "Toyota", 81, 75, 0, 0});
            pilotos.put("P16", new Object[]{"Jarno Trulli", 32, "Italia", 2007, "Toyota", 82, 77, 0, 0});
            pilotos.put("P17", new Object[]{"Anthony Davidson", 27, "Reino Unido", 2007, "Super Aguri", 79, 74, 0, 0});
            pilotos.put("P18", new Object[]{"Takuma Sato", 30, "Japon", 2007, "Super Aguri", 82, 75, 0, 0});
            pilotos.put("P19", new Object[]{"Vitantonio Liuzzi", 25, "Italia", 2007, "Toro Rosso", 81, 73, 0, 0});
            pilotos.put("P20", new Object[]{"Scott Speed", 24, "Estados Unidos", 2007, "Toro Rosso", 79, 72, 0, 0});
            
            // Insertar cada piloto en la base de datos
            for (Map.Entry<String, Object[]> piloto : pilotos.entrySet()) {
                String id = piloto.getKey();
                Object[] datos = piloto.getValue();
                
                String sentencia = "INSERT INTO piloto (Id, Nombre, Edad, Nacionalidad, Temporada, Equipo, Habilidad, Consistencia, Puntos, Campeonato) VALUES ("
                        + "'" + id + "', "
                        + "'" + datos[0] + "', "
                        + datos[1] + ", "
                        + "'" + datos[2] + "', "
                        + datos[3] + ", "
                        + "'" + datos[4] + "', "
                        + datos[5] + ", "
                        + datos[6] + ", "
                        + datos[7] + ", "
                        + datos[8] + ")";
                
                conexion.ejecutarInsertDeleteUpdate(sentencia);
            }
            
            conexion.desconectar();
            JOptionPane.showMessageDialog(this, "Base de datos restablecida con éxito.");
            cargarPilotos(); // Recargamos la tabla con los nuevos datos
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al restablecer la base de datos: " + ex.getMessage());
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
        lblNewLabel_1.setBounds(200, 0, 425, 90); // Adjusted y to 0 and x to 200
        contentPane.add(lblNewLabel_1);

        dialog.setVisible(true);
    }
}