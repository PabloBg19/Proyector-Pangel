package View;

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

public class verClasificacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tablePilotos;
    private JTable tableEquipos;
    private DefaultTableModel tableModelPilotos;
    private DefaultTableModel tableModelEquipos;

    /**
     * Create the frame.
     */
    public verClasificacion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Tabla de pilotos
        String[] columnNamesPilotos = {"Puntos", "Nombre", "Equipo", "Puntos"};
        tableModelPilotos = new DefaultTableModel(columnNamesPilotos, 0);
        tablePilotos = new JTable(tableModelPilotos);
        tablePilotos.setFillsViewportHeight(true);

        JScrollPane scrollPanePilotos = new JScrollPane(tablePilotos);
        scrollPanePilotos.setBounds(70, 120, 280, 293);
        getContentPane().add(scrollPanePilotos);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablePilotos.getColumnCount(); i++) {
            tablePilotos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Tabla de equipos
        String[] columnNamesEquipos = {"Puntos", "Equipo", "Puntos Totales"};
        tableModelEquipos = new DefaultTableModel(columnNamesEquipos, 0);
        tableEquipos = new JTable(tableModelEquipos);
        tableEquipos.setFillsViewportHeight(true);

        JScrollPane scrollPaneEquipos = new JScrollPane(tableEquipos);
        scrollPaneEquipos.setBounds(450, 120, 280, 293);
        getContentPane().add(scrollPaneEquipos);

        for (int i = 0; i < tableEquipos.getColumnCount(); i++) {
            tableEquipos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Cargar datos iniciales
        cargarPilotos();
        cargarEquipos();

        JButton btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(350, 439, 100, 25);
        btnActualizar.setEnabled(true);
        btnActualizar.addActionListener(e -> {
            cargarPilotos();
            cargarEquipos();
        });
        getContentPane().add(btnActualizar);

        JLabel lblNewLabel = new JLabel("CLASIFICACIÓN");
        lblNewLabel.setBounds(238, 11, 354, 49);
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        getContentPane().add(lblNewLabel);

        JLabel lblPilotos = new JLabel("PILOTOS");
        lblPilotos.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
        lblPilotos.setBounds(126, 76, 123, 33);
        getContentPane().add(lblPilotos);

        JLabel lblEquipos = new JLabel("EQUIPOS");
        lblEquipos.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
        lblEquipos.setBounds(506, 76, 123, 33);
        getContentPane().add(lblEquipos);
    }

    private void cargarPilotos() { // Carga los pilotos y sus equipos en la tabla
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
        	int posicion=1;
            conexion.conectar();
            String sentencia = "SELECT p.Nombre, p.Equipo, p.Puntos " +
                             "FROM piloto p " +
                             "LEFT JOIN equipo e ON p.Equipo = e.Nombre " +
                             "ORDER BY p.Puntos DESC";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            tableModelPilotos.setRowCount(0);
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

    private void cargarEquipos() { // Carga los equipos y sus puntos totales en la tabla
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
        	int posicion=1;
            conexion.conectar();
            String sentencia = "SELECT p.Equipo, SUM(p.Puntos) as PuntosTotales " +
                             "FROM piloto p " +
                             "GROUP BY p.Equipo " +
                             "ORDER BY PuntosTotales DESC";
            ResultSet resultado = conexion.ejecutarSelect(sentencia);
            tableModelEquipos.setRowCount(0);
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