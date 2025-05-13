package View;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
    public class RaceWindow extends JFrame {

        private static final long serialVersionUID = 1L;
        private JPanel contentPane;
        private JPanel[] pilotPoints;
        private int[] pilotPositions;
        private JLabel[] positionLabels;
        private JLabel[] livePositionLabels;
        private JLabel[] driverNameLabels;
        private boolean[] hasFinished;
        private ArrayList<Integer> finishOrder;
        private int[] lapsCompleted;
        private static final int START_X = 150;
        private static final int FINISH_X = 700;
        private static final int Y_POSITION = 100;
        private static final int POINT_SIZE = 10;
        private static final int NUM_PILOTS = 20;
        private static final int TOTAL_LAPS = 3;

        // F1 2025 drivers and their team colors
        private static final String[] DRIVERS = {
            "Verstappen", "Norris", "Leclerc", "Sainz", "Hamilton", "Russell", 
            "Perez", "Alonso", "Stroll", "Ocon", "Gasly", "Albon", 
            "Tsunoda", "Ricciardo", "Bottas", "Zhou", "Magnussen", 
            "Hulkenberg", "Bearman", "Colapinto"
        };
        private static final Color[] TEAM_COLORS = {
            new Color(0, 71, 171), // Red Bull
            new Color(0, 71, 171), // Red Bull
            new Color(220, 0, 0),  // Ferrari
            new Color(220, 0, 0),  // Ferrari
            new Color(0, 229, 255),// Mercedes
            new Color(0, 229, 255),// Mercedes
            new Color(0, 71, 171), // Red Bull
            new Color(0, 138, 0),  // Aston Martin
            new Color(0, 138, 0),  // Aston Martin
            new Color(0, 102, 204),// Alpine
            new Color(0, 102, 204),// Alpine
            new Color(0, 229, 255),// Williams
            new Color(229, 0, 0),  // RB
            new Color(229, 0, 0),  // RB
            new Color(255, 0, 0),  // Sauber
            new Color(255, 0, 0),  // Sauber
            new Color(108, 118, 135),// Haas
            new Color(108, 118, 135),// Haas
            new Color(108, 118, 135),// Haas
            new Color(0, 229, 255) // Williams
        };

        public RaceWindow(String raceName) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(0, 0, 900, 600);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);

            contentPane.setBackground(new Color(242, 242, 242));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            // Title label
            JLabel lblRaceTitle = new JLabel(raceName);
            lblRaceTitle.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24));
            lblRaceTitle.setBounds(300, 20, 300, 40);
            contentPane.add(lblRaceTitle);

            // Close button
            JButton btnClose = new JButton("Cerrar");
            btnClose.setBounds(400, 500, 100, 30);
            btnClose.addActionListener(e -> dispose());
            contentPane.add(btnClose);

            // Initialize arrays
            pilotPoints = new JPanel[NUM_PILOTS];
            pilotPositions = new int[NUM_PILOTS];
            positionLabels = new JLabel[NUM_PILOTS];
            livePositionLabels = new JLabel[NUM_PILOTS];
            driverNameLabels = new JLabel[NUM_PILOTS];
            hasFinished = new boolean[NUM_PILOTS];
            finishOrder = new ArrayList<>();
            lapsCompleted = new int[NUM_PILOTS];
            Random random = new Random();

            // Leaderboard panel
            JPanel leaderboardPanel = new JPanel();
            leaderboardPanel.setBounds(10, 80, 120, 400);
            leaderboardPanel.setBackground(new Color(30, 30, 30));
            leaderboardPanel.setLayout(null);
            contentPane.add(leaderboardPanel);

            // Initialize pilots and leaderboard
            for (int i = 0; i < NUM_PILOTS; i++) {
                // Pilot points
                pilotPoints[i] = new JPanel();
                pilotPoints[i].setBounds(START_X, Y_POSITION + (i * 20), POINT_SIZE, POINT_SIZE);
                pilotPoints[i].setBackground(TEAM_COLORS[i]);
                pilotPoints[i].setOpaque(true);
                contentPane.add(pilotPoints[i]);
                pilotPositions[i] = START_X;
                hasFinished[i] = false;
                lapsCompleted[i] = 0;

                // Final position and points label (right)
                positionLabels[i] = new JLabel("");
                positionLabels[i].setFont(new Font("Dialog", Font.PLAIN, 12));
                positionLabels[i].setBounds(FINISH_X + 10, Y_POSITION + (i * 20) - 5, 50, 20);
                contentPane.add(positionLabels[i]);

                // Live position label (leaderboard)
                livePositionLabels[i] = new JLabel(String.valueOf(i + 1));
                livePositionLabels[i].setFont(new Font("Dialog", Font.BOLD, 12));
                livePositionLabels[i].setForeground(Color.WHITE);
                livePositionLabels[i].setBounds(10, 10 + (i * 20), 20, 20);
                leaderboardPanel.add(livePositionLabels[i]);

                // Driver name label (leaderboard)
                driverNameLabels[i] = new JLabel(DRIVERS[i]);
                driverNameLabels[i].setFont(new Font("Dialog", Font.BOLD, 12));
                driverNameLabels[i].setForeground(Color.WHITE);
                driverNameLabels[i].setBounds(40, 10 + (i * 20), 80, 20);
                leaderboardPanel.add(driverNameLabels[i]);
            }

            // Finish line
            JLabel finishLine = new JLabel("META");
            finishLine.setBounds(FINISH_X - 20, Y_POSITION - 20, 40, 20);
            finishLine.setFont(new Font("Dialog", Font.BOLD, 12));
            finishLine.setForeground(Color.RED);
            contentPane.add(finishLine);

            // Timer for animation
            Timer timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update pilot positions
                    for (int i = 0; i < NUM_PILOTS; i++) {
                        if (!hasFinished[i]) {
                            int speed = random.nextInt(5) + 1;
                            pilotPositions[i] += speed;
                            if (pilotPositions[i] >= FINISH_X) {
                                lapsCompleted[i]++;
                                if (lapsCompleted[i] < TOTAL_LAPS) {
                                    pilotPositions[i] = START_X; // Reset to start for next lap
                                } else {
                                    pilotPositions[i] = FINISH_X;
                                    hasFinished[i] = true;
                                    finishOrder.add(i);
                                    int position = finishOrder.size();
                                    int points = getPointsForPosition(position);
                                    positionLabels[i].setText(position + " + " + points);
                                    livePositionLabels[i].setText(String.valueOf(position));
                                }
                            }
                            pilotPoints[i].setLocation(pilotPositions[i], Y_POSITION + (i * 20));
                        }
                    }

                    // Update live positions
                    Integer[] indices = new Integer[NUM_PILOTS];
                    for (int i = 0; i < NUM_PILOTS; i++) {
                        indices[i] = i;
                    }
                    Arrays.sort(indices, (a, b) -> {
                        if (hasFinished[a] && hasFinished[b]) {
                            return Integer.compare(finishOrder.indexOf(a), finishOrder.indexOf(b));
                        } else if (hasFinished[a]) {
                            return 1;
                        } else if (hasFinished[b]) {
                            return -1;
                        }
                        if (lapsCompleted[a] != lapsCompleted[b]) {
                            return Integer.compare(lapsCompleted[b], lapsCompleted[a]);
                        }
                        return Integer.compare(pilotPositions[b], pilotPositions[a]);
                    });

                    // Update leaderboard
                    for (int i = 0; i < NUM_PILOTS; i++) {
                        livePositionLabels[indices[i]].setText(String.valueOf(i + 1));
                        livePositionLabels[indices[i]].setBounds(10, 10 + (i * 20), 20, 20);
                        driverNameLabels[indices[i]].setBounds(40, 10 + (i * 20), 80, 20);
                    }

                    contentPane.repaint();

                    // Stop timer when all pilots finish
                    if (finishOrder.size() == NUM_PILOTS) {
                        ((Timer)e.getSource()).stop();
                    }
                }
            });
            timer.start();
        }

        // Points system (F1 2008)
        private int getPointsForPosition(int position) {
            switch (position) {
                case 1: return 10;
                case 2: return 8;
                case 3: return 6;
                case 4: return 5;
                case 5: return 4;
                case 6: return 3;
                case 7: return 2;
                case 8: return 1;
                default: return 0;
            }
        }

        
        }


    
    
}

