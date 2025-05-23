package Dao; // Paquete donde se encuentra la clase

import javax.swing.*; // Importa todas las clases de Swing para interfaces gráficas
import javax.swing.border.EmptyBorder; // Importa EmptyBorder para márgenes en el panel
import javax.swing.table.DefaultTableCellRenderer; // Importa DefaultTableCellRenderer para centrar contenido en la tabla
import javax.swing.table.DefaultTableModel; // Importa DefaultTableModel para el modelo de la tabla

import Util.ConexionMySQL; // Importa la clase personalizada para conexión a MySQL

import java.awt.*; // Importa clases básicas de manejo de gráficos y componentes
import java.sql.ResultSet; // Importa ResultSet para manejar resultados de consultas SQL
import java.sql.SQLException; // Importa SQLException para manejar errores de base de datos
import java.awt.event.ActionListener; // Importa ActionListener para manejar eventos de acción
import java.awt.event.ActionEvent; // Importa ActionEvent para eventos de botones

public class GestionarEquipos extends JFrame {

    private static final long serialVersionUID = 1L; // ID de serialización para la clase
    private JPanel contentPane; // Panel principal que contiene los componentes
    private JTextField textNombre; // Campo de texto para búsqueda por nombre
    private JTextField textEquipo; // Campo de texto para búsqueda por equipo (aunque parece redundante con textNombre)
    private JTable table; // Tabla para mostrar los equipos
    private DefaultTableModel tableModel; // Modelo de la tabla

    /**
     * Create the frame.
     */
    public GestionarEquipos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al hacer clic en cerrar
        setBounds(0, 0, 919, 500); // Establece las dimensiones y posición inicial (x, y, ancho, alto)
        contentPane = new JPanel(); // Crea el panel principal
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Añade márgenes de 5 píxeles alrededor del panel
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setLayout(null); // Usa un layout nulo para posicionamiento manual

        // Crea el modelo de la tabla con las columnas especificadas
        String[] columnNames = {"Id", "Nombre", "Motor", "Pais", "Potencia", "Aerodinamica", "Fiabilidad"};
        tableModel = new DefaultTableModel(columnNames, 0); // Inicializa el modelo sin filas
        table = new JTable(tableModel); // Crea la tabla con el modelo
        table.setFillsViewportHeight(true); // Hace que la tabla ocupe todo el alto visible

        // Añade la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table); // Añade barras de desplazamiento
        scrollPane.setBounds(0, 120, 903, 293); // Posiciona el scrollpane (x, y, ancho, alto)
        getContentPane().add(scrollPane); // Añade el scrollpane al panel

        // Centra el contenido de las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Alineación centrada

        // Aplica el renderizador a todas las columnas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Carga todos los equipos al iniciar
        cargarEquipos();

        // Campo de texto para búsqueda por nombre
        textNombre = new JTextField();
        textNombre.setBounds(153, 82, 120, 20); // Posiciona el campo
        getContentPane().add(textNombre);
        textNombre.setColumns(10); // Establece el tamaño de las columnas

        // Botón BUSCAR por nombre
        JButton btnNombre = new JButton("Buscar por Nombre");
        btnNombre.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1"); // Conexión a la base de datos
            try {
                conexion.conectar(); // Establece la conexión
                String sentencia = "SELECT * FROM equipo WHERE Nombre LIKE '%" + textNombre.getText() + "%'"; // Consulta SQL con comodín
                ResultSet resultado = conexion.ejecutarSelect(sentencia); // Ejecuta la consulta
                tableModel.setRowCount(0); // Limpia la tabla
                while (resultado.next()) { // Itera sobre los resultados
                    String Id = resultado.getString("Id");
                    String Nombre = resultado.getString("Nombre");
                    String Motor = resultado.getString("Motor");
                    String Pais = resultado.getString("Pais");
                    int Potencia = resultado.getInt("Potencia");
                    int Aerodinamica = resultado.getInt("Aerodinamica");
                    int Fiabilidad = resultado.getInt("Fiabilidad");
                    tableModel.addRow(new Object[]{Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad}); // Añade fila a la tabla
                }
                conexion.desconectar(); // Cierra la conexión
            } catch (SQLException ex) {
                ex.printStackTrace(); // Imprime el error en la consola
            }
        });
        btnNombre.setBounds(283, 77, 146, 31); // Posiciona el botón
        getContentPane().add(btnNombre); // Añade el botón al panel

        textEquipo = new JTextField();
        textEquipo.setColumns(10); // Establece el tamaño de las columnas
        textEquipo.setBounds(498, 82, 117, 20); // Posiciona el campo (parece redundante con textNombre)
        getContentPane().add(textEquipo);

        // Botón BUSCAR por equipo (search by Nombre, redundante con btnNombre)
        JButton btnEquipo = new JButton("Buscar por Equipo");
        btnEquipo.addActionListener(e -> {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String sentencia = "SELECT * FROM equipo WHERE Nombre LIKE '%" + textEquipo.getText() + "%'";
                ResultSet resultado = conexion.ejecutarSelect(sentencia);
                tableModel.setRowCount(0);
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
        lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38)); // Establece fuente y tamaño
        lblNewLabel_3.setBounds(316, 19, 261, 31); // Posiciona el título
        getContentPane().add(lblNewLabel_3);

        // Botón ELIMINAR EQUIPO
        JButton btnEliminar = new JButton("Eliminar Equipo");
        btnEliminar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow(); // Obtiene la fila seleccionada
            if (selectedRow != -1) { // Verifica que haya una fila seleccionada
                String idEquipo = (String) tableModel.getValueAt(selectedRow, 0); // Obtiene el ID del equipo
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "DELETE FROM equipo WHERE Id='" + idEquipo + "'"; // Sentencia SQL para eliminar
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia); // Ejecuta la eliminación
                    if (rowsAffected > 0) {
                        tableModel.removeRow(selectedRow); // Elimina la fila de la tabla
                        JOptionPane.showMessageDialog(this, "Equipo eliminado con éxito."); // Mensaje de éxito
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el equipo."); // Mensaje de fallo
                    }
                    conexion.desconectar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al eliminar el equipo.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un equipo para eliminar."); // Mensaje si no hay selección
            }
        });
        btnEliminar.setBounds(579, 424, 150, 26); // Posiciona el botón
        getContentPane().add(btnEliminar);

        // Detecta la selección en la tabla
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                btnEliminar.setEnabled(true); // Habilita el botón de eliminar si hay selección
            } else {
                btnEliminar.setEnabled(false); // Deshabilita el botón si no hay selección
            }
        });

        JButton btnNewButton = new JButton("Añadir Equipo");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnadirEquipo temp = new AnadirEquipo(); // Crea una nueva instancia de AnadirEquipo
                temp.setVisible(true); // Hace visible la ventana
            }
        });
        btnNewButton.setBounds(202, 424, 129, 26); // Posiciona el botón
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

                    // Abre la ventana de modificación
                    abrirVentanaModificacion(id, nombre, motor, pais, potencia, aerodinamica, fiabilidad);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un equipo para modificar."); // Mensaje si no hay selección
                }
            }
        });
        btnNewButton_1.setBounds(394, 424, 129, 26); // Posiciona el botón
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarEquipos(); // Recarga los equipos en la tabla
            }
        });

        ImageIcon originalIcon = new ImageIcon(GestionarEquipos.class.getResource("/image/recargar.png")); // Carga el ícono de recargar
        Image scaledImage = originalIcon.getImage().getScaledInstance(52, 51, Image.SCALE_SMOOTH); // Escala el ícono
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        btnNewButton_2.setIcon(scaledIcon); // Establece el ícono
        btnNewButton_2.setSelectedIcon(scaledIcon); // Establece el ícono para estado seleccionado
        btnNewButton_2.setBounds(615, 15, 52, 51); // Posiciona el botón
        btnNewButton_2.setText(""); // Elimina el texto
        getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_3_1 = new JLabel("Refrescar");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11)); // Establece fuente y tamaño
        lblNewLabel_3_1.setBounds(677, 25, 69, 31); // Posiciona la etiqueta
        getContentPane().add(lblNewLabel_3_1);

        // Botón para restablecer equipos
        JButton btnRestablecer = new JButton("Restablecer Equipos");
        btnRestablecer.addActionListener(e -> {
            restablecerEquipos(); // Llama al método para restablecer equipos
        });
        btnRestablecer.setBounds(739, 424, 150, 26); // Posiciona el botón
        getContentPane().add(btnRestablecer);
    }

    // Método para cargar todos los equipos en la tabla
    private void cargarEquipos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar(); // Establece la conexión
            String sentencia = "SELECT * FROM equipo"; // Consulta SQL para obtener todos los equipos
            ResultSet resultado = conexion.ejecutarSelect(sentencia); // Ejecuta la consulta
            tableModel.setRowCount(0); // Limpia la tabla
            while (resultado.next()) { // Itera sobre los resultados
                String Id = resultado.getString("Id");
                String Nombre = resultado.getString("Nombre");
                String Motor = resultado.getString("Motor");
                String Pais = resultado.getString("Pais");
                int Potencia = resultado.getInt("Potencia");
                int Aerodinamica = resultado.getInt("Aerodinamica");
                int Fiabilidad = resultado.getInt("Fiabilidad");
                tableModel.addRow(new Object[]{Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad}); // Añade fila a la tabla
            }
            conexion.desconectar(); // Cierra la conexión
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprime el error en la consola
        }
    }

    // Método para abrir la ventana de modificación
    private void abrirVentanaModificacion(String id, String nombre, String motor, String pais, String potencia, String aerodinamica, String fiabilidad) {
        JDialog dialog = new JDialog(this, "Modificar Equipo", true); // Crea un diálogo modal
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra el diálogo al hacer clic en cerrar
        dialog.setBounds(0, 0, 800, 500); // Establece las dimensiones y posición inicial
        dialog.setLocationRelativeTo(this); // Centra el diálogo respecto a la ventana padre
        JPanel contentPane = new JPanel(); // Crea el panel del diálogo
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Añade márgenes
        dialog.setContentPane(contentPane); // Asigna el panel como contenido del diálogo
        contentPane.setLayout(null); // Usa un layout nulo

        JLabel lbl_Id = new JLabel("ID");
        lbl_Id.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18)); // Establece fuente y estilo
        lbl_Id.setBounds(283, 105, 39, 32); // Posiciona la etiqueta
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

        JTextField textId = new JTextField(id); // Campo de texto con el ID prellenado
        textId.setBounds(345, 115, 148, 20);
        contentPane.add(textId);
        textId.setColumns(10);

        JTextField textNombreField = new JTextField(nombre); // Campo de texto con el nombre prellenado
        textNombreField.setColumns(10);
        textNombreField.setBounds(345, 155, 148, 20);
        contentPane.add(textNombreField);

        JTextField textMotor = new JTextField(motor); // Campo de texto con el motor prellenado
        textMotor.setColumns(10);
        textMotor.setBounds(345, 195, 148, 20);
        contentPane.add(textMotor);

        JTextField textPais = new JTextField(pais); // Campo de texto con el país prellenado
        textPais.setColumns(10);
        textPais.setBounds(345, 235, 148, 20);
        contentPane.add(textPais);

        JTextField textPotencia = new JTextField(potencia); // Campo de texto con la potencia prellenada
        textPotencia.setColumns(10);
        textPotencia.setBounds(345, 285, 148, 20);
        contentPane.add(textPotencia);

        JTextField textAerodinamica = new JTextField(aerodinamica); // Campo de texto con la aerodinámica prellenada
        textAerodinamica.setColumns(10);
        textAerodinamica.setBounds(345, 325, 148, 20);
        contentPane.add(textAerodinamica);

        JTextField textFiabilidad = new JTextField(fiabilidad); // Campo de texto con la fiabilidad prellenada
        textFiabilidad.setColumns(10);
        textFiabilidad.setBounds(345, 365, 148, 20);
        contentPane.add(textFiabilidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar(); // Establece la conexión
                    String sentencia = "UPDATE equipo SET Nombre='" + textNombreField.getText() +
                            "', Motor='" + textMotor.getText() +
                            "', Pais='" + textPais.getText() +
                            "', Potencia=" + textPotencia.getText() +
                            ", Aerodinamica=" + textAerodinamica.getText() +
                            ", Fiabilidad=" + textFiabilidad.getText() +
                            " WHERE Id='" + textId.getText() + "'"; // Sentencia SQL para actualizar
                    int rowsAffected = conexion.ejecutarInsertDeleteUpdate(sentencia); // Ejecuta la actualización
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(dialog, "Equipo modificado con éxito."); // Mensaje de éxito
                        dialog.dispose(); // Cierra el diálogo
                        cargarEquipos(); // Recarga la tabla
                    } else {
                        JOptionPane.showMessageDialog(dialog, "No se pudo modificar el equipo."); // Mensaje de fallo
                    }
                    conexion.desconectar(); // Cierra la conexión
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Imprime el error en la consola
                    JOptionPane.showMessageDialog(dialog, "Error al modificar el equipo."); // Muestra mensaje de error
                }
            }
        });
        btnGuardar.setBounds(597, 228, 89, 23); // Posiciona el botón
        contentPane.add(btnGuardar);

        JLabel lblNewLabel_11 = new JLabel("MODIFICAR EQUIPO");
        lblNewLabel_11.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38)); // Establece fuente y tamaño
        lblNewLabel_11.setBounds(240, 11, 425, 90); // Posiciona el título
        contentPane.add(lblNewLabel_11);

        dialog.setVisible(true); // Hace visible el diálogo
    }

    // Método para restablecer equipos a datos iniciales
    private void restablecerEquipos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar(); // Establece la conexión
            String deleteSentencia = "DELETE FROM equipo"; // Sentencia SQL para eliminar todos los equipos
            conexion.ejecutarInsertDeleteUpdate(deleteSentencia); // Ejecuta la eliminación

            // Inserta equipos iniciales
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

            for (String equipo : equipos) {
                String[] datos = equipo.split(","); // Divide la cadena en partes
                String id = datos[0];
                String nombre = datos[1];
                String motor = datos[2];
                String pais = datos[3];
                int potencia = Integer.parseInt(datos[4]);
                int aerodinamica = Integer.parseInt(datos[5]);
                int fiabilidad = Integer.parseInt(datos[6]);
                String insertSentencia = "INSERT INTO equipo (Id, Nombre, Motor, Pais, Potencia, Aerodinamica, Fiabilidad) VALUES ('" +
                        id + "', '" + nombre + "', '" + motor + "', '" + pais + "', " + potencia + ", " + aerodinamica + ", " + fiabilidad + ")"; // Sentencia SQL para insertar
                conexion.ejecutarInsertDeleteUpdate(insertSentencia); // Ejecuta la inserción
            }

            // Recarga la tabla con los datos restablecidos
            cargarEquipos();
            JOptionPane.showMessageDialog(this, "Equipos restablecidos con éxito."); // Mensaje de éxito
            conexion.desconectar(); // Cierra la conexión
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprime el error en la consola
            JOptionPane.showMessageDialog(this, "Error al restablecer los equipos."); // Muestra mensaje de error
        }
    }
}