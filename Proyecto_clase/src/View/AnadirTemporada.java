package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AnadirTemporada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AnadirTemporada() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 500);//Modificar tamaño
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);//centrar ventana


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReiniciarTemporada = new JButton("Reiniciar Temporada");
		btnReiniciarTemporada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "UPDATE carreras SET indice_actual = -1";
                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                    conexion.desconectar();
                    JOptionPane.showMessageDialog(null, "Temporada Reiniciada");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al reiniciar la temporada.");
                }
            }
			}
		);
		btnReiniciarTemporada.setBounds(137, 95, 136, 49);
		contentPane.add(btnReiniciarTemporada);
	}

}
