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
    private JPanel[] pilotPoints; // Array para los 20 puntos (pilotos)
    private int[] pilotPositions; // Posiciones X de los pilotos
    private JLabel[] positionLabels; // Etiquetas para mostrar posición y puntos finales (a la derecha)
    private JLabel[] livePositionLabels; // Etiquetas para mostrar posición en tiempo real (a la izquierda)
    private boolean[] hasFinished; // Marca si un piloto ha cruzado la meta
    private ArrayList<Integer> finishOrder; // Orden de llegada
    private static final int START_X = 50; // Punto de inicio
    private static final int FINISH_X = 700; // Línea de meta
    private static final int Y_POSITION = 150; // Posición Y fija para los puntos
    private static final int POINT_SIZE = 10; // Tamaño de los puntos
    private static final int NUM_PILOTS = 20; // Número de pilotos

    public RaceWindow(String raceName) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // Centra la ventana

        contentPane.setBackground(new Color(242, 242, 242));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title label for the race
        JLabel lblRaceTitle = new JLabel(raceName);
        lblRaceTitle.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24));
        lblRaceTitle.setBounds(224, 29, 300, 40);
        contentPane.add(lblRaceTitle);

        // Placeholder label
        JLabel lblDetails = new JLabel("Detalles de la carrera (en desarrollo)");
        lblDetails.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblDetails.setBounds(224, 79, 300, 30);
        contentPane.add(lblDetails);

        // Close button
        JButton btnClose = new JButton("Cerrar");
        btnClose.setBounds(320, 392, 100, 30);
        btnClose.addActionListener(e -> dispose());
        contentPane.add(btnClose);

        // Inicializar puntos y etiquetas para los pilotos
        pilotPoints = new JPanel[NUM_PILOTS];
        pilotPositions = new int[NUM_PILOTS];
        positionLabels = new JLabel[NUM_PILOTS];
        livePositionLabels = new JLabel[NUM_PILOTS];
        hasFinished = new boolean[NUM_PILOTS];
        finishOrder = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < NUM_PILOTS; i++) {
            // Puntos de los pilotos
            pilotPoints[i] = new JPanel();
            pilotPoints[i].setBounds(START_X, Y_POSITION + (i * 15), POINT_SIZE, POINT_SIZE);
            pilotPoints[i].setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            pilotPoints[i].setOpaque(true);
            contentPane.add(pilotPoints[i]);
            pilotPositions[i] = START_X; // Todas las posiciones iniciales en el inicio
            hasFinished[i] = false;

            // Etiqueta para posición y puntos finales (a la derecha)
            positionLabels[i] = new JLabel("");
            positionLabels[i].setFont(new Font("Dialog", Font.PLAIN, 12));
            positionLabels[i].setBounds(FINISH_X + 10, Y_POSITION + (i * 15) - 5, 50, 20);
            contentPane.add(positionLabels[i]);

            // Etiqueta para posición en tiempo real (a la izquierda)
            livePositionLabels[i] = new JLabel(String.valueOf(i + 1)); // Posición inicial
            livePositionLabels[i].setFont(new Font("Dialog", Font.BOLD, 12));
            livePositionLabels[i].setBounds(START_X - 30, Y_POSITION + (i * 15) - 5, 20, 20);
            contentPane.add(livePositionLabels[i]);
        }

        // Línea de meta
        JLabel finishLine = new JLabel("META");
        finishLine.setBounds(FINISH_X - 20, Y_POSITION - 20, 40, 20);
        finishLine.setFont(new Font("Dialog", Font.BOLD, 12));
        finishLine.setForeground(Color.RED);
        contentPane.add(finishLine);

        // Temporizador para animar los puntos
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar posiciones de los pilotos
                for (int i = 0; i < NUM_PILOTS; i++) {
                    if (!hasFinished[i]) {
                        // Velocidad aleatoria entre 1 y 5 píxeles por tick
                        int speed = random.nextInt(5) + 1;
                        pilotPositions[i] += speed;
                        if (pilotPositions[i] < FINISH_X) {
                            pilotPoints[i].setLocation(pilotPositions[i], Y_POSITION + (i * 15));
                        } else {
                            pilotPositions[i] = FINISH_X; // Detener en la meta
                            pilotPoints[i].setLocation(pilotPositions[i], Y_POSITION + (i * 15));
                            hasFinished[i] = true;
                            finishOrder.add(i); // Registrar el orden de llegada
                            int position = finishOrder.size(); // Posición final basada en el orden de llegada
                            int points = getPointsForPosition(position);
                            // Actualizar etiqueta final a la derecha para el piloto i
                            positionLabels[i].setText(position + " + " + points);
                            // Actualizar la posición final a la izquierda para el piloto i
                            livePositionLabels[i].setText(String.valueOf(position));
                        }
                    }
                }

                // Calcular y actualizar posiciones en tiempo real (solo para los que no han terminado)
                Integer[] indices = new Integer[NUM_PILOTS];
                for (int i = 0; i < NUM_PILOTS; i++) {
                    indices[i] = i;
                }
                // Ordenar pilotos por posición X (de mayor a menor, ya que X aumenta hacia la meta)
                Arrays.sort(indices, (a, b) -> {
                    if (hasFinished[a] && hasFinished[b]) {
                        // Si ambos han terminado, mantener el orden de llegada
                        return Integer.compare(finishOrder.indexOf(a), finishOrder.indexOf(b));
                    } else if (hasFinished[a]) {
                        return 1; // Pilotos terminados al final
                    } else if (hasFinished[b]) {
                        return -1;
                    }
                    return Integer.compare(pilotPositions[b], pilotPositions[a]);
                });

                // Actualizar etiquetas de posición en tiempo real
                for (int i = 0; i < NUM_PILOTS; i++) {
                    if (!hasFinished[indices[i]]) {
                        livePositionLabels[indices[i]].setText(String.valueOf(i + 1));
                    }
                }

                contentPane.repaint(); // Actualizar la ventana

                // Detener el timer cuando todos lleguen a la meta
                if (finishOrder.size() == NUM_PILOTS) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    // Método para obtener puntos según la posición (sistema F1 2008)
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

    // Método main para probar la ventana
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RaceWindow frame = new RaceWindow("Gran Premio de Albert Park");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}