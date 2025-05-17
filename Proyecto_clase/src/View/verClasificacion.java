package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class verClasificacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
   
	

	/**
	 * Create the frame.
	 */
	public verClasificacion() {
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(0, 0, 800, 500);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setLocationRelativeTo(null);

	        String[] columnNames = { "Nombre", "Equipo", "Puntos"};
	        tableModel = new DefaultTableModel(columnNames, 0);
	        getContentPane().setLayout(null);
	        table = new JTable(tableModel);
	        table.setFillsViewportHeight(true);

	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(70, 120, 243, 293);
	        getContentPane().add(scrollPane);

	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }

	        cargarPilotos();

	        JButton btnVerEquipo = new JButton("VER PILOTOS");
	        btnVerEquipo.setBounds(33, 439, 0, 11);
	        btnVerEquipo.setEnabled(false);
	        btnVerEquipo.addActionListener(e -> cargarPilotos());
	        getContentPane().add(btnVerEquipo);


	        
	              
	        
	        
	        JLabel lblNewLabel = new JLabel("CLASIFICACIÓN");
	        lblNewLabel.setBounds(238, 11, 354, 49);
	        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
	        getContentPane().add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("PILOTOS");
	        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
	        lblNewLabel_1.setBounds(126, 76, 123, 33);
	        getContentPane().add(lblNewLabel_1);
	    }

	    private void cargarPilotos() {  //carga los pilotos para mostrarlos en la tabla
	        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
	        try {
	            conexion.conectar();
	            String sentencia = "SELECT * FROM piloto ORDER BY Puntos DESC";
	            ResultSet resultado = conexion.ejecutarSelect(sentencia);
	            tableModel.setRowCount(0);
	            while (resultado.next()) {
	                
	                String nombre = resultado.getString("Nombre");
	                String equipo = resultado.getString("Equipo");
	                int puntos= resultado.getInt("Puntos");
	                tableModel.addRow(new Object[]{ nombre, equipo, puntos});
	            }
	            conexion.desconectar();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    private void cargarequipos() { //carga los pilotos para mostralos en la tabla
	    	ConexionMySQL conexion=new ConexionMySQL("root", " ", "formula_1");
	    	
	    	try {
				conexion.conectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	   
	    
	}


