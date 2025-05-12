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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AnadirEquipo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textId;
    private JTextField textNombre;
    private JTextField textMotor;
    private JTextField textNivelMotor;
    private JTextField textPais;
    private JTextField textPiloto_1;
    private JTextField textPiloto_2;
    private JTextField textField_Aerodinamica;
    private JTextField textField_Fiabilidad;
    private JTextField textPuntos;
    private JTextField textCampeonatos;

    /**
     * Create the frame.
     */
    public AnadirEquipo() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 531);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // centra la ventana

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbl_Id = new JLabel("ID");
        lbl_Id.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lbl_Id.setBounds(283, 50, 39, 32);
        contentPane.add(lbl_Id);
        
        JLabel lblNewLabel_1 = new JLabel("AÑADIR EQUIPOS");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel_1.setBounds(233, 0, 338, 54);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblNombre.setBounds(239, 93, 83, 32);
        contentPane.add(lblNombre);
        
        JLabel lblMotor = new JLabel("MOTOR");
        lblMotor.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblMotor.setBounds(239, 136, 83, 32);
        contentPane.add(lblMotor);
        
        JLabel lblNivelMotor = new JLabel("NIVELMOTOR");
        lblNivelMotor.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblNivelMotor.setBounds(207, 336, 129, 32);
        contentPane.add(lblNivelMotor);
        
        JLabel lblPais = new JLabel("PAIS");
        lblPais.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPais.setBounds(265, 179, 50, 32);
        contentPane.add(lblPais);
        
        JLabel lblPiloto1 = new JLabel("PILOTO 1");
        lblPiloto1.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPiloto1.setBounds(234, 210, 102, 32);
        contentPane.add(lblPiloto1);
        
        JLabel lblPiloto2 = new JLabel("PILOTO 2");
        lblPiloto2.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPiloto2.setBounds(230, 250, 106, 32);
        contentPane.add(lblPiloto2);
        
        JLabel lblAerodinamica = new JLabel("AERODINÁMICA");
        lblAerodinamica.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblAerodinamica.setBounds(180, 293, 155, 32);
        contentPane.add(lblAerodinamica);
        
        JLabel lblFiabilidad = new JLabel("FIABILIDAD");
        lblFiabilidad.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblFiabilidad.setBounds(220, 379, 102, 20);
        contentPane.add(lblFiabilidad);
        
        JLabel lblPuntos = new JLabel("PUNTOS");
        lblPuntos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblPuntos.setBounds(233, 410, 83, 32);
        contentPane.add(lblPuntos);
        
        JLabel lblCampeonatos = new JLabel("CAMPEONATOS");
        lblCampeonatos.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 18));
        lblCampeonatos.setBounds(180, 450, 148, 32);
        contentPane.add(lblCampeonatos);
        
        textId = new JTextField();
        textId.setBounds(345, 60, 148, 20);
        contentPane.add(textId);
        textId.setColumns(10);
        
        textNombre = new JTextField();
        textNombre.setColumns(10);
        textNombre.setBounds(345, 100, 148, 20);
        contentPane.add(textNombre);
        
        textMotor = new JTextField();
        textMotor.setColumns(10);
        textMotor.setBounds(345, 140, 148, 20);
        contentPane.add(textMotor);
        
        textNivelMotor = new JTextField();
        textNivelMotor.setColumns(10);
        textNivelMotor.setBounds(346, 339, 148, 20);
        contentPane.add(textNivelMotor);
        
        textPais = new JTextField();
        textPais.setColumns(10);
        textPais.setBounds(345, 180, 148, 20);
        contentPane.add(textPais);
        
        textPiloto_1 = new JTextField();
        textPiloto_1.setColumns(10);
        textPiloto_1.setBounds(345, 220, 148, 20);
        contentPane.add(textPiloto_1);
        
        textPiloto_2 = new JTextField();
        textPiloto_2.setColumns(10);
        textPiloto_2.setBounds(345, 260, 148, 20);
        contentPane.add(textPiloto_2);
        
        textField_Aerodinamica = new JTextField();
        textField_Aerodinamica.setColumns(10);
        textField_Aerodinamica.setBounds(345, 300, 148, 20);
        contentPane.add(textField_Aerodinamica);
        
        textField_Fiabilidad = new JTextField();
        textField_Fiabilidad.setColumns(10);
        textField_Fiabilidad.setBounds(345, 380, 148, 20);
        contentPane.add(textField_Fiabilidad);
        
        textPuntos = new JTextField();
        textPuntos.setColumns(10);
        textPuntos.setBounds(345, 420, 148, 20);
        contentPane.add(textPuntos);
        
        textCampeonatos = new JTextField();
        textCampeonatos.setColumns(10);
        textCampeonatos.setBounds(345, 460, 148, 20);
        contentPane.add(textCampeonatos);
        
        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion2 = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion2.conectar();
                    // Validación de campos numéricos
                    try {
                        Integer.parseInt(textNivelMotor.getText());
                        Integer.parseInt(textField_Aerodinamica.getText());
                        Integer.parseInt(textField_Fiabilidad.getText());
                        Integer.parseInt(textPuntos.getText());
                        Integer.parseInt(textCampeonatos.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(AnadirEquipo.this, "Los campos NivelMotor, Aerodinámica, Fiabilidad, Puntos y Campeonatos deben ser números válidos.");
                        return;
                    }
                    String sentencia = "INSERT INTO equipo (Id, Nombre, Motor, NivelMotor, Pais, Piloto_1, Piloto_2, Aerodinamica, Fiabilidad, Puntos, Campeonatos) VALUES (" +
                            "'" + textId.getText() + "', " +
                            "'" + textNombre.getText() + "', " +
                            "'" + textMotor.getText() + "', " +
                            textNivelMotor.getText() + ", " +
                            "'" + textPais.getText() + "', " +
                            "'" + textPiloto_1.getText() + "', " +
                            "'" + textPiloto_2.getText() + "', " +
                            textField_Aerodinamica.getText() + ", " +
                            textField_Fiabilidad.getText() + ", " +
                            textPuntos.getText() + ", " +
                            textCampeonatos.getText() + ")";
                    int rowsAffected = conexion2.ejecutarInsertDeleteUpdate(sentencia);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(AnadirEquipo.this, "Equipo añadido con éxito.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(AnadirEquipo.this, "No se pudo añadir el equipo.");
                    }
                    conexion2.desconectar();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(AnadirEquipo.this, "Error al añadir el equipo: " + e1.getMessage());
                    try {
                        conexion2.desconectar();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        btnEnviar.setBounds(596, 228, 102, 39);
        contentPane.add(btnEnviar);
    }
}