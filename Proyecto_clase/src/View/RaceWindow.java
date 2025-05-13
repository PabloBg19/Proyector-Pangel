package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
