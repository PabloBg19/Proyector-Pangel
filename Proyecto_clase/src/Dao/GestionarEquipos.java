package Dao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Util.ConexionMySQL;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que representa una ventana para gestionar equipos en la base de datos de Fórmula 1.
 * Permite visualizar, buscar, añadir, modificar, eliminar y restablecer equipos en una tabla.
 * 
 * @author Pangel
 * @version 1.0
 */
public class GestionarEquipos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane; // Panel principal de la ventana
    private JTextField textNombre; // Campo de texto para buscar por nombre
    private JTextField textEquipo; // Campo de texto para buscar por equipo
    private JTable table; // Tabla para mostrar los equipos
    private DefaultTableModel tableModel; // Modelo de datos de la tabla

    /**
     * Constructor de la clase GestionarEquipos.
     * Inicializa la ventana de gestión de equipos, configurando el layout, los componentes
     * (etiquetas, campos de texto, botones, tabla) y cargando los equipos desde la base de datos.
     */
    public GestionarEquipos() {
        // Configuración inicial de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 919, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setLayout(null); // Layout nulo para posicionamiento manual

        // Configuración de la tabla para mostrar los equipos
        String[] columnNames = {"Id", "Nombre", "Motor", "Pais", "Potencia", "Aerodinamica", "Fiabilidad"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // Añade la tabla a un panel con scroll
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 120, 903, 293);
        getContentPane().add(scrollPane);

        // Centra el contenido de las celdas de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Carga los equipos iniciales desde la base de datos
        cargarEquipos();

        // Campo de texto para buscar por nombre
        textNombre = new JTextField();
        textNombre.setBounds(153, 82, 120, 20);
        getContentPane().add(textNombre);
        textNombre.setColumns(10);

        /**
         * Botón para buscar equipos por nombre.
         * Realiza una consulta SQL con el texto ingresado y actualiza la tabla con los resultados.
         */
        JButton btnNombre = new JButton("Buscar por Nombre");
        btnNombre.addActionListener(e -> {
            // Conexión a la base de datos
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                // Consulta SQL para buscar equipos por nombre
                String sentencia = "SELECT * FROM equipo WHERE Nombre LIKE '%" + textNombre.getText() + "%'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                tableModel.setRowCount(0); // Limpia la tabla
                // Añade los resultados a la tabla
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
                ex.printStackTrace(); // Manejo de errores
            }
        });
        btnNombre.setBounds(283, 77, 146, 31);
        getContentPane().add(btnNombre);

        // Campo de texto para buscar por equipo
        textEquipo = new JTextField();
        textEquipo.setColumns(10);
        textEquipo.setBounds(498, 82, 117, 20);
        getContentPane().add(textEquipo);

        /**
         * Botón para buscar equipos por nombre.
         * Realiza una consulta SQL con el texto ingresado y actualiza la tabla con los resultados.
         */
        JButton btnEquipo = new JButton("Buscar por Equipo");
        btnEquipo.addActionListener(e -> {
            // Conexión a la base de datos
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                // Consulta SQL para buscar equipos por nombre
                String sentencia = "SELECT * FROM equipo WHERE Nombre LIKE '%" + textEquipo.getText() + "%'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                tableModel.setRowCount(0); // Limpia la tabla
                // Añade los resultados a la tabla
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
                ex.printStackTrace(); // Manejo de errores
            }
        });
        btnEquipo.setBounds(625, 78, 146, 31);
        getContentPane().add(btnEquipo);

        // Etiqueta del título de la ventana
        JLabel lblNewLabel_3 = new JLabel("VER EQUIPOS");
        lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_3.setBounds(316, 19, 261, 31);
        getContentPane().add(lblNewLabel_3);

        /**
         * Botón para eliminar un equipo seleccionado.
         * Elimina el equipo de la base de datos y actualiza la tabla.
         */
        JButton btnEliminar = new JButton("Eliminar Equipo");
        btnEliminar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String idEquipo = (String) tableModel.getValueAt(selectedRow, 0);
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    // Consulta SQL para eliminar el equipo
                    String sentencia = "DELETE FROM equipo WHERE Id='" + idEquipo + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        tableModel.removeRow(selectedRow); // Elimina la fila de la tabla
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

        // Habilita/desactiva el botón de eliminar según la selección en la tabla
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                btnEliminar.setEnabled(true);
            } else {
                btnEliminar.setEnabled(false);
            }
        });

        /**
         * Botón para abrir la ventana de añadir equipo.
         * Crea y muestra una nueva ventana de la clase AnadirEquipo.
         */
        JButton btnNewButton = new JButton("Añadir Equipo");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnadirEquipo temp = new AnadirEquipo(); // Abre la ventana para añadir equipo
                temp.setVisible(true);
            }
        });
        btnNewButton.setBounds(202, 424, 129, 26);
        getContentPane().add(btnNewButton);

        /**
         * Botón para abrir la ventana de modificar equipo.
         * Abre un diálogo para modificar los datos del equipo seleccionado.
         */
        JButton btnNewButton_1 = new JButton("Modificar Equipo");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtiene los datos del equipo seleccionado
                    String id = (String) tableModel.getValueAt(selectedRow, 0);
                    String nombre = (String) tableModel.getValueAt(selectedRow, 1);
                    String motor = (String) tableModel.getValueAt(selectedRow, 2);
                    String pais = (String) tableModel.getValueAt(selectedRow, 3);
                    String potencia = String.valueOf(tableModel.getValueAt(selectedRow, 4));
                    String aerodinamica = String.valueOf(tableModel.getValueAt(selectedRow, 5));
                    String fiabilidad = String.valueOf(tableModel.getValueAt(selectedRow, 6));

                    // Abre la ventana de modificación
                    abrirVentanaModificacion(id, nombre, motor, pais, potencia, aerodinamica, fiabilidad);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un equipo para modificar.");
                }
            }
        });
        btnNewButton_1.setBounds(394, 424, 129, 26);
        getContentPane().add(btnNewButton_1);

        /**
         * Botón para recargar la lista de equipos.
         * Actualiza la tabla con los datos actuales de la base de datos.
         */
        JButton btnNewButton_2 = new JButton(""); // Botón con ícono para refrescar
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarEquipos(); // Recarga los equipos desde la base de datos
            }
        });

        // Configura el ícono del botón de refrescar
        ImageIcon originalIcon = new ImageIcon(GestionarEquipos.class.getResource("/image/recargar.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(52, 51, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        btnNewButton_2.setIcon(scaledIcon);
        btnNewButton_2.setSelectedIcon(scaledIcon);
        btnNewButton_2.setBounds(615, 15, 52, 51);
        getContentPane().add(btnNewButton_2);

        // Etiqueta para el botón de refrescar
        JLabel lblNewLabel_3_1 = new JLabel("Refrescar");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_3_1.setBounds(677, 25, 69, 31);
        getContentPane().add(lblNewLabel_3_1);

        /**
         * Botón para restablecer los equipos a los datos iniciales.
         * Elimina todos los equipos actuales y los reemplaza con un conjunto predefinido.
         */
        JButton btnRestablecer = new JButton("Restablecer Equipos");
        btnRestablecer.addActionListener(e -> {
            restablecerEquipos(); // Restablece los equipos a los valores predeterminados
        });
        btnRestablecer.setBounds(739, 424, 150, 26);
        getContentPane().add(btnRestablecer);
    }

    /**
     * Carga todos los equipos desde la base de datos y los muestra en la tabla.
     * Realiza una consulta SQL para obtener todos los registros de la tabla 'equipo'
     * y actualiza el modelo de la tabla con los resultados.
     */
    private void cargarEquipos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String sentencia = "SELECT * FROM equipo";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            tableModel.setRowCount(0); // Limpia la tabla
            // Añade cada equipo a la tabla
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
            ex.printStackTrace(); // Manejo de errores
        }
    }

    /**
     * Abre un diálogo para modificar los datos de un equipo.
     * Permite editar todos los campos del equipo y guardar los cambios en la base de datos.
     * 
     * @param id          El ID del equipo.
     * @param nombre      El nombre del equipo.
     * @param motor       El motor del equipo.
     * @param pais        El país del equipo.
     * @param potencia    La potencia del equipo.
     * @param aerodinamica La aerodinámica del equipo.
     * @param fiabilidad  La fiabilidad del equipo.
     */
    private void abrirVentanaModificacion(String id, String nombre, String motor, String pais, String potencia, String aerodinamica, String fiabilidad) {
        // Crea un diálogo modal para modificar el equipo
        JDialog dialog = new JDialog(this, "Modificar Equipo", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(0, 0, 800, 500);
        dialog.setLocationRelativeTo(this);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        dialog.setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiquetas para los campos
        JLabel lbl_Id = new JLabel("ID");
        lbl_Id.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lbl_Id.setBounds(283, 105, 39, 32);
        contentPane.add(lbl_Id);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblNombre.setBounds(239, 148, 83, 32);
        contentPane.add(lblNombre);

        JLabel lblMotor = new JLabel("MOTOR");
        lblMotor.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblMotor.setBounds(239, 191, 83, 32);
        contentPane.add(lblMotor);

        JLabel lblPais = new JLabel("PAIS");
        lblPais.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPais.setBounds(265, 234, 50, 32);
        contentPane.add(lblPais);

        JLabel lblPotencia = new JLabel("POTENCIA");
        lblPotencia.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPotencia.setBounds(220, 277, 102, 32);
        contentPane.add(lblPotencia);

        JLabel lblAerodinamica = new JLabel("AERODINÁMICA");
        lblAerodinamica.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblAerodinamica.setBounds(180, 320, 155, 32);
        contentPane.add(lblAerodinamica);

        JLabel lblFiabilidad = new JLabel("FIABILIDAD");
        lblFiabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblFiabilidad.setBounds(220, 363, 102, 32);
        contentPane.add(lblFiabilidad);

        // Campos de texto con los valores actuales del equipo
        JTextField textId = new JTextField(id);
        textId.setBounds(345, 115, 148, 20);
        contentPane.add(textId);
        textId.setColumns(10);

        JTextField textNombreField = new JTextField(nombre);
        textNombreField.setColumns(10);
        textNombreField.setBounds(345, 155, 148, 20);
        contentPane.add(textNombreField);

        JTextField textMotor = new JTextField(motor);
        textMotor.setColumns(10);
        textMotor.setBounds(345, 195, 148, 20);
        contentPane.add(textMotor);

        JTextField textPais = new JTextField(pais);
        textPais.setColumns(10);
        textPais.setBounds(345, 235, 148, 20);
        contentPane.add(textPais);

        JTextField textPotencia = new JTextField(potencia);
        textPotencia.setColumns(10);
        textPotencia.setBounds(345, 285, 148, 20);
        contentPane.add(textPotencia);

        JTextField textAerodinamica = new JTextField(aerodinamica);
        textAerodinamica.setColumns(10);
        textAerodinamica.setBounds(345, 325, 148, 20);
        contentPane.add(textAerodinamica);

        JTextField textFiabilidad = new JTextField(fiabilidad);
        textFiabilidad.setColumns(10);
        textFiabilidad.setBounds(345, 365, 148, 20);
        contentPane.add(textFiabilidad);

        /**
         * Botón para guardar los cambios del equipo.
         * Actualiza los datos del equipo en la base de datos y recarga la tabla.
         */
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    // Consulta SQL para actualizar el equipo
                    String sentencia = "UPDATE equipo SET Nombre='" + textNombreField.getText() +
                            "', Motor='" + textMotor.getText() +
                            "', Pais='" + textPais.getText() +
                            "', Potencia=" + textPotencia.getText() +
                            ", Aerodinamica=" + textAerodinamica.getText() +
                            ", Fiabilidad=" + textFiabilidad.getText() +
                            " WHERE Id='" + textId.getText() + "'";
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(dialog, "Equipo modificado con éxito.");
                        dialog.dispose(); // Cierra el diálogo
                        cargarEquipos(); // Actualiza la tabla
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

        // Etiqueta del título del diálogo
        JLabel lblNewLabel_11 = new JLabel("MODIFICAR EQUIPO");
        lblNewLabel_11.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_11.setBounds(240, 11, 425, 90);
        contentPane.add(lblNewLabel_11);

        dialog.setVisible(true); // Muestra el diálogo
    }

    /**
     * Restablece los equipos en la base de datos a un conjunto predefinido de datos iniciales.
     * Elimina todos los equipos existentes y los reemplaza con una lista predeterminada.
     * 
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    private void restablecerEquipos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            // Elimina todos los equipos existentes
            String deleteSentencia = "DELETE FROM equipo";
            conexion.ejecutarInsertDeleteUpdate(deleteSentencia);

            // Lista de equipos predeterminados
            String[] equipos = {
                "E1,Mclaren,Mercedes,Reino Unido,856,743,85",
                "E10,Super Aguri,Honda,Japon,841,721,75",
                "E11,Spyker,Ferrari,Holanda,840,720,74",
                "E2,Ferrari,Ferrari,Italia,864,740,84",
                "E3,BMW Sauber,BMW,Alemania,856,735,82",
                "E4,Renault,Renault,Francia,852,734,83",
                "E5,Williams,Toyota,Reino Unido,853,728,78",
                "E6,Red Bull,Renault,Francia,848,730,76",
                "E7,Toyota,Toyota,Japon,853,725,76",
                "E8,Toro Rosso,Ferrari,Italia,845,723,81",
                "E9,Honda,Honda,Japon,841,722,76"
            };

            // Inserta cada equipo en la base de datos
            for (String equipo : equipos) {
                String[] datos = equipo.split(",");
                String id = datos[0];
                String nombre = datos[1];
                String motor = datos[2];
                String pais = datos[3];
                int potencia = Integer.parseInt(datos[4]);
                int aerodinamica = Integer.parseInt(datos[5]);
                int fiabilidad = Integer.parseInt(datos[6]);
                String insertSentencia = "INSERT INTO equipo (Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad) VALUES ('" +
                        id + "', '" + nombre + "', '" + motor + "', '" + pais + "', " + potencia + ", " + aerodinamica + ", " + fiabilidad + ")";
                conexion.ejecutarInsertDeleteUpdate(insertSentencia);
            }

            cargarEquipos(); // Actualiza la tabla
            JOptionPane.showMessageDialog(this, "Equipos restablecidos con éxito.");
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al restablecer los equipos.");
        }
    }
}