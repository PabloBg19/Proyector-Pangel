package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Fia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int currentRaceIndex = -1;
    private NuevaTemporada2007 parentWindow;

    /**
     * Create the frame with a reference to the parent window.
     */
    public Fia(NuevaTemporada2007 parent) {
        this.parentWindow = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Título en la ventana principal
        JLabel lblTitulo = new JLabel("GESTIÓN DE TEMPORADA");
        lblTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblTitulo.setBounds(50, 20, 200, 30);
        contentPane.add(lblTitulo);

        // Crear la ventana de reinicio
        JFrame reiniciarFrame = new JFrame("Reiniciar Puntos y Temporada");
        reiniciarFrame.setSize(900, 600);
        reiniciarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reiniciarFrame.setLocationRelativeTo(null);

        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(null);
        reiniciarFrame.setContentPane(panelContenido);

        // Título en la ventana de reinicio
        JLabel lblGestionar = new JLabel("GESTIONAR LA TEMPORADA");
        lblGestionar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblGestionar.setBounds(171, 72, 564, 79);
        panelContenido.add(lblGestionar);

        // Botón único para reiniciar todo
        JButton btnReiniciarTodo = new JButton("REINICIAR TODO");
        btnReiniciarTodo.setBounds(350, 250, 200, 50);
        btnReiniciarTodo.setFont(new Font("Dialog", Font.BOLD, 14));
        btnReiniciarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de reiniciar la temporada y los puntos?", "Confirmar Reinicio", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                    try {
                        System.out.println("Intentando conectar a la base de datos...");
                        conexion.conectar();
                        System.out.println("Conexión exitosa.");

                        // Reiniciar puntos de pilotos
                        System.out.println("Ejecutando: UPDATE piloto SET Puntos = 0");
                        String sentenciaPilotos = "UPDATE piloto SET Puntos = 0";
                        int filasPilotos = conexion.ejecutarInsertDeleteUpdate(sentenciaPilotos);
                        System.out.println("Filas afectadas (pilotos): " + filasPilotos);

                        // Reiniciar índice de carreras para el año 2007
                        System.out.println("Ejecutando: UPDATE carreras SET indice_actual = -1 WHERE Año = 2007");
                        String sentenciaCarreras = "UPDATE carreras SET indice_actual = -1 WHERE Año = 2007";
                        int filasCarreras = conexion.ejecutarInsertDeleteUpdate(sentenciaCarreras);
                        System.out.println("Filas afectadas (carreras): " + filasCarreras);

                        conexion.desconectar();
                        System.out.println("Desconexión exitosa.");

                        currentRaceIndex = -1;

                        // Recargar el estado en la ventana principal
                        if (parentWindow != null) {
                            parentWindow.refreshSeasonState();
                        }

                        JOptionPane.showMessageDialog(null, "¡Puntos y temporada reiniciados correctamente!\n" +
                            "Filas afectadas (pilotos): " + filasPilotos + "\n" +
                            "Filas afectadas (carreras): " + filasCarreras);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al reiniciar: " + ex.getMessage());
                    }
                }
            }
        });
        panelContenido.add(btnReiniciarTodo);

        reiniciarFrame.setVisible(true);
    }


}