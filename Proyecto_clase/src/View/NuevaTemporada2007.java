package View;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

// Main window for the 2007 season
public class NuevaTemporada2007 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel[] raceLabels; // Array to store race labels
    private int currentRaceIndex = -1; // Track the current race (-1 means none selected)

    public NuevaTemporada2007() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(242, 242, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicializar array de labels carreras
        raceLabels = new JLabel[10]; // 10 Carreras en la Temporada
        // labels carreras
        JLabel lblGPAustralia = new JLabel("Gran Premio de Albert Park");
        lblGPAustralia.setBounds(147, 139, 140, 14);
        contentPane.add(lblGPAustralia);
        raceLabels[0] = lblGPAustralia;

        JLabel lblRAustralia = new JLabel("R");
        lblRAustralia.setBounds(328, 139, 25, 14);
        contentPane.add(lblRAustralia);

        JLabel lblGranPremioDe = new JLabel("Gran Premio de Barein");
        lblGranPremioDe.setBounds(147, 164, 140, 14);
        contentPane.add(lblGranPremioDe);
        raceLabels[1] = lblGranPremioDe;

        JLabel lblRAustralia_1 = new JLabel("R");
        lblRAustralia_1.setBounds(328, 164, 25, 14);
        contentPane.add(lblRAustralia_1);

        JLabel lblGPAustralia_1_1 = new JLabel("Gran Premio de España");
        lblGPAustralia_1_1.setBounds(147, 189, 140, 14);
        contentPane.add(lblGPAustralia_1_1);
        raceLabels[2] = lblGPAustralia_1_1;

        JLabel lblRAustralia_1_1 = new JLabel("R");
        lblRAustralia_1_1.setBounds(328, 189, 25, 14);
        contentPane.add(lblRAustralia_1_1);

        JLabel lblGPAustralia_1_1_1 = new JLabel("Gran Premio de Mónaco");
        lblGPAustralia_1_1_1.setBounds(147, 214, 140, 14);
        contentPane.add(lblGPAustralia_1_1_1);
        raceLabels[3] = lblGPAustralia_1_1_1;

        JLabel lblRAustralia_1_1_1 = new JLabel("R");
        lblRAustralia_1_1_1.setBounds(328, 214, 25, 14);
        contentPane.add(lblRAustralia_1_1_1);

        JLabel lblGPAustralia_1_1_1_1 = new JLabel("Gran Premio de Silverstone");
        lblGPAustralia_1_1_1_1.setBounds(147, 239, 140, 14);
        contentPane.add(lblGPAustralia_1_1_1_1);
        raceLabels[4] = lblGPAustralia_1_1_1_1;

        JLabel lblRAustralia_1_1_1_1 = new JLabel("R");
        lblRAustralia_1_1_1_1.setBounds(328, 239, 25, 14);
        contentPane.add(lblRAustralia_1_1_1_1);

        JLabel lblGranPremioDe_1 = new JLabel("Gran Premio de Monza");
        lblGranPremioDe_1.setBounds(383, 139, 140, 14);
        contentPane.add(lblGranPremioDe_1);
        raceLabels[5] = lblGranPremioDe_1;

        JLabel lblRAustralia_2 = new JLabel("R");
        lblRAustralia_2.setBounds(559, 139, 25, 14);
        contentPane.add(lblRAustralia_2);

        JLabel lblGPAustralia_2_1 = new JLabel("Gran Premio de Spa");
        lblGPAustralia_2_1.setBounds(383, 164, 140, 14);
        contentPane.add(lblGPAustralia_2_1);
        raceLabels[6] = lblGPAustralia_2_1;

        JLabel lblRAustralia_2_1 = new JLabel("R");
        lblRAustralia_2_1.setBounds(559, 164, 25, 14);
        contentPane.add(lblRAustralia_2_1);

        JLabel lblGPAustralia_2_1_1 = new JLabel("Gran Premio de Suzuka");
        lblGPAustralia_2_1_1.setBounds(383, 189, 140, 14);
        contentPane.add(lblGPAustralia_2_1_1);
        raceLabels[7] = lblGPAustralia_2_1_1;

        JLabel lblRAustralia_2_1_1 = new JLabel("R");
        lblRAustralia_2_1_1.setBounds(559, 189, 25, 14);
        contentPane.add(lblRAustralia_2_1_1);

        JLabel lblGPAustralia_2_1_1_1 = new JLabel("Gran Premio de China");
        lblGPAustralia_2_1_1_1.setBounds(383, 214, 140, 14);
        contentPane.add(lblGPAustralia_2_1_1_1);
        raceLabels[8] = lblGPAustralia_2_1_1_1;

        JLabel lblRAustralia_2_1_1_2 = new JLabel("R");
        lblRAustralia_2_1_1_2.setBounds(559, 214, 25, 14);
        contentPane.add(lblRAustralia_2_1_1_2);

        JLabel lblGPAustralia_2_1_1_2 = new JLabel("Gran Premio de Brasil");
        lblGPAustralia_2_1_1_2.setBounds(383, 239, 140, 14);
        contentPane.add(lblGPAustralia_2_1_1_2);
        raceLabels[9] = lblGPAustralia_2_1_1_2;

        JLabel lblRAustralia_2_1_1_3 = new JLabel("R");
        lblRAustralia_2_1_1_3.setBounds(559, 239, 25, 14);
        contentPane.add(lblRAustralia_2_1_1_3);

        // Buttons
        JButton btnNewButton = new JButton("Avanzar a Carrera");
        btnNewButton.setBounds(470, 353, 128, 51);
        btnNewButton.addActionListener(e -> advanceToNextRace()); 
        contentPane.add(btnNewButton);

        JButton btnVerClasificacin = new JButton("Ver Clasificación");
        btnVerClasificacin.setBounds(297, 353, 128, 51);
        contentPane.add(btnVerClasificacin);

        JButton btnNewButton_1_1 = new JButton("Penalizaciones");
        btnNewButton_1_1.setBounds(123, 353, 128, 51);
        contentPane.add(btnNewButton_1_1);

        // Title label
        JLabel lblNewLabel = new JLabel("Temporada 2007");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel.setBounds(232, 33, 278, 56);
        contentPane.add(lblNewLabel);
    }

    private void advanceToNextRace() {
        // Resetea el subrayado de la carrera
        if (currentRaceIndex >= 0 && currentRaceIndex < raceLabels.length) {
            raceLabels[currentRaceIndex].setOpaque(false);
            raceLabels[currentRaceIndex].setBackground(null);
            raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.PLAIN, 12));
        }

        // Avanza a la siguiente carrera
        currentRaceIndex = (currentRaceIndex + 1) % raceLabels.length;

        // Resalta la carrera actual
        raceLabels[currentRaceIndex].setOpaque(true);
        raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230)); // Light blue
        raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));

        // Abre una ventana nueva para cada carrera
        new RaceWindow(raceLabels[currentRaceIndex].getText()).setVisible(true);
    }

    // Ventana nueva para cada carrera
    private class RaceWindow extends JFrame {
        private static final long serialVersionUID = 1L;

        public RaceWindow(String raceName) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(0, 0, 400, 300);
            setLocationRelativeTo(null); // Center the window
            setTitle(raceName);

            JPanel contentPane = new JPanel();
            contentPane.setBackground(new Color(242, 242, 242)); // Match main window background
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            // Title label for the race
            JLabel lblRaceTitle = new JLabel(raceName);
            lblRaceTitle.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24));
            lblRaceTitle.setBounds(50, 30, 300, 40);
            contentPane.add(lblRaceTitle);

            // Placeholder label (can be expanded with race details)
            JLabel lblDetails = new JLabel("Detalles de la carrera (en desarrollo)");
            lblDetails.setFont(new Font("Dialog", Font.PLAIN, 14));
            lblDetails.setBounds(50, 80, 300, 30);
            contentPane.add(lblDetails);

            // Close button
            JButton btnClose = new JButton("Cerrar");
            btnClose.setBounds(150, 200, 100, 30);
            btnClose.addActionListener(e -> dispose());
            contentPane.add(btnClose);
        }
    }

    //Main de la Temporada 2007
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> //Pone el código en una cola para que se ejecute en el EDT (Hilo Despacho de Eventos)
        {
            try {
                NuevaTemporada2007 frame = new NuevaTemporada2007();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

