package Dao;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Util.ConexionMySQL;

/**
 * Clase que representa la ventana de clasificación para la temporada de Fórmula 1.
 * Muestra dos tablas: una con la clasificación de pilotos y otra con la de equipos,
 * basadas en los puntos acumulados. Permite actualizar los datos desde la base de datos.
 * 
 * @author Pangel
 * @version 1.0
 */
public class verClasificacion extends JFrame {
    private static final long serialVersionUID = 1L; // Identificador para serialización
    private JPanel contentPane; // Panel principal de la ventana
    private JTable tablePilotos; // Tabla para mostrar la clasificación de pilotos
    private JTable tableEquipos; // Tabla para mostrar la clasificación de equipos
    private DefaultTableModel tableModelPilotos; // Modelo de datos para la tabla de pilotos
    private DefaultTableModel tableModelEquipos; // Modelo de datos para la tabla de equipos

    /**
     * Constructor de la ventana de clasificación.
     * Inicializa la interfaz gráfica con tablas para pilotos y equipos, botones y etiquetas,
     * y carga los datos iniciales desde la base de datos.
     */
    public verClasificacion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al salir
        setBounds(0, 0, 800, 500); // Tamaño y posición inicial de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Borde vacío de 5 píxeles
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        getContentPane().setLayout(null); // Usar diseño absoluto (sin layout manager)

        // Tabla de pilotos - Ampliamos el ancho para mostrar nombres completos
        String[] columnNamesPilotos = {"Puntos", "Nombre", "Equipo", "Puntos"};
        tableModelPilotos = new DefaultTableModel(columnNamesPilotos, 0);
        tablePilotos = new JTable(tableModelPilotos);
        tablePilotos.setFillsViewportHeight(true);
        JScrollPane scrollPanePilotos = new JScrollPane(tablePilotos);
        scrollPanePilotos.setBounds(50, 120, 340, 293); // Ampliamos el ancho de 280 a 340
        getContentPane().add(scrollPanePilotos);

        // Configurar el renderizador para centrar todas las columnas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablePilotos.getColumnCount(); i++) {
            tablePilotos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Ajustamos el ancho de las columnas para la tabla de pilotos
        tablePilotos.getColumnModel().getColumn(0).setPreferredWidth(50);   // Puntos (posición)
        tablePilotos.getColumnModel().getColumn(1).setPreferredWidth(150);  // Nombre
        tablePilotos.getColumnModel().getColumn(2).setPreferredWidth(90);   // Equipo
        tablePilotos.getColumnModel().getColumn(3).setPreferredWidth(50);   // Puntos

        // Tabla de equipos
        String[] columnNamesEquipos = {"Puntos", "Equipo", "Puntos Totales"};
        tableModelEquipos = new DefaultTableModel(columnNamesEquipos, 0);
        tableEquipos = new JTable(tableModelEquipos);
        tableEquipos.setFillsViewportHeight(true);
        JScrollPane scrollPaneEquipos = new JScrollPane(tableEquipos);
        scrollPaneEquipos.setBounds(410, 120, 340, 293); // Ajustamos posición y ampliamos el ancho
        getContentPane().add(scrollPaneEquipos);

        // Configurar el renderizador para centrar todas las columnas de equipos
        for (int i = 0; i < tableEquipos.getColumnCount(); i++) {
            tableEquipos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Ajustamos el ancho de las columnas para la tabla de equipos
        tableEquipos.getColumnModel().getColumn(0).setPreferredWidth(50);   // Puntos (posición)
        tableEquipos.getColumnModel().getColumn(1).setPreferredWidth(140);  // Equipo
        tableEquipos.getColumnModel().getColumn(2).setPreferredWidth(100);  // Puntos Totales

        // Cargar datos iniciales
        cargarPilotos();
        cargarEquipos();

        /**
         * Botón para actualizar las tablas de pilotos y equipos.
         * Recarga los datos desde la base de datos al hacer clic.
         */
        JButton btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(350, 439, 100, 25);
        btnActualizar.setEnabled(true);
        btnActualizar.addActionListener(e -> {
            cargarPilotos();
            cargarEquipos();
        });
        getContentPane().add(btnActualizar);

        // Título de la ventana
        JLabel lblNewLabel = new JLabel("CLASIFICACIÓN");
        lblNewLabel.setBounds(238, 11, 354, 49);
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        getContentPane().add(lblNewLabel);

        // Etiqueta para la sección de pilotos
        JLabel lblPilotos = new JLabel("PILOTOS");
        lblPilotos.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
        lblPilotos.setBounds(159, 71, 123, 33);
        getContentPane().add(lblPilotos);

        // Etiqueta para la sección de equipos
        JLabel lblEquipos = new JLabel("EQUIPOS");
        lblEquipos.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
        lblEquipos.setBounds(518, 71, 123, 33);
        getContentPane().add(lblEquipos);
    }

    /**
     * Carga los datos de los pilotos desde la base de datos y los muestra en la tabla de pilotos.
     * Ordena los pilotos por puntos en orden descendente y asigna una posición según el ranking.
     * 
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    private void cargarPilotos() { // Carga los pilotos y sus equipos en la tabla
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            int posicion = 1;
            conexion.conectar();
            String sentencia = "SELECT p.Nombre, p.Equipo, p.Puntos " +
                              "FROM piloto p " +
                              "LEFT JOIN equipo e ON p.Equipo = e.Nombre " +
                              "ORDER BY p.Puntos DESC";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            tableModelPilotos.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String equipo = resultado.getString("Equipo");
                int puntos = resultado.getInt("Puntos");
                tableModelPilotos.addRow(new Object[]{posicion, nombre, equipo, puntos});
                posicion++;
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los pilotos: " + ex.getMessage());
        }
    }

    /**
     * Carga los datos de los equipos desde la base de datos y los muestra en la tabla de equipos.
     * Agrupa los puntos de los pilotos por equipo, ordena por puntos totales en orden descendente
     * y asigna una posición según el ranking.
     * 
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    private void cargarEquipos() { // Carga los equipos y sus puntos totales en la tabla
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            int posicion = 1;
            conexion.conectar();
            String sentencia = "SELECT p.Equipo, SUM(p.Puntos) as PuntosTotales " +
                              "FROM piloto p " +
                              "GROUP BY p.Equipo " +
                              "ORDER BY PuntosTotales DESC";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            tableModelEquipos.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
            while (resultado.next()) {
                String equipo = resultado.getString("Equipo");
                int puntosTotales = resultado.getInt("PuntosTotales");
                tableModelEquipos.addRow(new Object[]{posicion, equipo, puntosTotales});
                posicion++;
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los equipos: " + ex.getMessage());
        }
    }
}