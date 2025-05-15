package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class NuevaTemporada2007 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel[] raceLabels;
    private int currentRaceIndex = -1;

    public NuevaTemporada2007() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(242, 242, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        raceLabels = new JLabel[11];
        
        JLabel lblGPPrueba = new JLabel("");
        lblGPPrueba.setBounds(0, 0, 0, 0);
        contentPane.add(lblGPPrueba);
        raceLabels[0] = lblGPPrueba;
        
        
        JLabel lblGPAustralia = new JLabel("Gran Premio de Albert Park");
        lblGPAustralia.setBounds(147, 139, 140, 14);
        contentPane.add(lblGPAustralia);
        raceLabels[1] = lblGPAustralia;

        JLabel lblRAustralia = new JLabel("R");
        lblRAustralia.setBounds(328, 139, 25, 14);
        contentPane.add(lblRAustralia);

        JLabel lblGranPremioDe = new JLabel("Gran Premio de Barein");
        lblGranPremioDe.setBounds(147, 164, 140, 14);
        contentPane.add(lblGranPremioDe);
        raceLabels[2] = lblGranPremioDe;

        JLabel lblRAustralia_1 = new JLabel("R");
        lblRAustralia_1.setBounds(328, 164, 25, 14);
        contentPane.add(lblRAustralia_1);

        JLabel lblGPAustralia_1_1 = new JLabel("Gran Premio de España");
        lblGPAustralia_1_1.setBounds(147, 189, 140, 14);
        contentPane.add(lblGPAustralia_1_1);
        raceLabels[3] = lblGPAustralia_1_1;

        JLabel lblRAustralia_1_1 = new JLabel("R");
        lblRAustralia_1_1.setBounds(328, 189, 25, 14);
        contentPane.add(lblRAustralia_1_1);

        JLabel lblGPAustralia_1_1_1 = new JLabel("Gran Premio de Mónaco");
        lblGPAustralia_1_1_1.setBounds(147, 214, 140, 14);
        contentPane.add(lblGPAustralia_1_1_1);
        raceLabels[4] = lblGPAustralia_1_1_1;

        JLabel lblRAustralia_1_1_1 = new JLabel("R");
        lblRAustralia_1_1_1.setBounds(328, 214, 25, 14);
        contentPane.add(lblRAustralia_1_1_1);

        JLabel lblGPAustralia_1_1_1_1 = new JLabel("Gran Premio de Silverstone");
        lblGPAustralia_1_1_1_1.setBounds(147, 239, 140, 14);
        contentPane.add(lblGPAustralia_1_1_1_1);
        raceLabels[5] = (lblGPAustralia_1_1_1_1);

        JLabel lblRAustralia_1_1_1_1 = new JLabel("R");
        lblRAustralia_1_1_1_1.setBounds(328, 239, 25, 14);
        contentPane.add(lblRAustralia_1_1_1_1);

        JLabel lblGranPremioDe_1 = new JLabel("Gran Premio de Monza");
        lblGranPremioDe_1.setBounds(383, 139, 140, 14);
        contentPane.add(lblGranPremioDe_1);
        raceLabels[6] = lblGranPremioDe_1;

        JLabel lblRAustralia_2 = new JLabel("R");
        lblRAustralia_2.setBounds(559, 139, 25, 14);
        contentPane.add(lblRAustralia_2);

        JLabel lblGPAustralia_2_1 = new JLabel("Gran Premio de Spa");
        lblGPAustralia_2_1.setBounds(383, 164, 140, 14);
        contentPane.add(lblGPAustralia_2_1);
        raceLabels[7] = lblGPAustralia_2_1;

        JLabel lblRAustralia_2_1 = new JLabel("R");
        lblRAustralia_2_1.setBounds(559, 164, 25, 14);
        contentPane.add(lblRAustralia_2_1);

        JLabel lblGPAustralia_2_1_1 = new JLabel("Gran Premio de Suzuka");
        lblGPAustralia_2_1_1.setBounds(383, 189, 140, 14);
        contentPane.add(lblGPAustralia_2_1_1);
        raceLabels[8] = lblGPAustralia_2_1_1;

        JLabel lblRAustralia_2_1_1 = new JLabel("R");
        lblRAustralia_2_1_1.setBounds(559, 189, 25, 14);
        contentPane.add(lblRAustralia_2_1_1);

        JLabel lblGPAustralia_2_1_1_1 = new JLabel("Gran Premio de China");
        lblGPAustralia_2_1_1_1.setBounds(383, 214, 140, 14);
        contentPane.add(lblGPAustralia_2_1_1_1);
        raceLabels[9] = lblGPAustralia_2_1_1_1;

        JLabel lblRAustralia_2_1_1_2 = new JLabel("R");
        lblRAustralia_2_1_1_2.setBounds(559, 214, 25, 14);
        contentPane.add(lblRAustralia_2_1_1_2);

        JLabel lblGPAustralia_2_1_1_2 = new JLabel("Gran Premio de Brasil");
        lblGPAustralia_2_1_1_2.setBounds(383, 239, 140, 14);
        contentPane.add(lblGPAustralia_2_1_1_2);
        raceLabels[10] = (lblGPAustralia_2_1_1_2);

        JLabel lblRAustralia_2_1_1_3 = new JLabel("R");
        lblRAustralia_2_1_1_3.setBounds(559, 239, 25, 14);
        contentPane.add(lblRAustralia_2_1_1_3);

        JButton btnNewButton = new JButton("Avanzar a Carrera");
        btnNewButton.setBounds(478, 353, 157, 51);
        btnNewButton.addActionListener(e -> advanceToNextRace());
        contentPane.add(btnNewButton);

        JButton btnVerClasificacin = new JButton("Ver Clasificación");
        btnVerClasificacin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verClasificacion temp = new verClasificacion();
                temp.setVisible(true);
            }
        });
        btnVerClasificacin.setBounds(292, 353, 157, 51);
        contentPane.add(btnVerClasificacin);

        JButton btnNewButton_1_1 = new JButton("Gestionar Temporada");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fia temp = new Fia(NuevaTemporada2007.this);
                temp.setVisible(true);
            }
        });
        btnNewButton_1_1.setBounds(105, 353, 157, 51);
        contentPane.add(btnNewButton_1_1);

        JLabel lblNewLabel = new JLabel("Temporada 2007");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel.setBounds(232, 33, 278, 56);
        contentPane.add(lblNewLabel);

        loadSeasonState();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveSeasonState();
            }
        });
    }

    private void loadSeasonState() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String query = "SELECT indice_actual FROM carreras WHERE Año = 2007 LIMIT 1";
            ResultSet result = conexion.ejecutarSelect(query);
            if (result.next()) {
                currentRaceIndex = result.getInt("indice_actual");
                System.out.println("Estado cargado: currentRaceIndex = " + currentRaceIndex);
                // Limpiar el resaltado de todas las carreras
                for (JLabel label : raceLabels) {
                    label.setOpaque(false);
                    label.setBackground(null);
                    label.setFont(new Font("Dialog", Font.PLAIN, 12));
                }
                // Resaltar la carrera actual si está dentro del rango válido
                if (currentRaceIndex >= 0 && currentRaceIndex < raceLabels.length) {
                    raceLabels[currentRaceIndex].setOpaque(true);
                    raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
                    raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));
                } else if (currentRaceIndex == -1) {
                    System.out.println("Temporada reiniciada, comenzando desde la primera carrera (Australia).");
                } else {
                    System.out.println("Índice fuera de rango o inválido: " + currentRaceIndex);
                    currentRaceIndex = -1; // Forzar reinicio si el índice es inválido
                }
            } else {
                System.out.println("No se encontró registro para Año = 2007");
                currentRaceIndex = -1;
            }
            result.close();
            conexion.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el estado de la temporada: " + e.getMessage());
            e.printStackTrace();
            currentRaceIndex = -1;
        }
    }

    private void saveSeasonState() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String updateQuery = "UPDATE carreras SET indice_actual = " + currentRaceIndex +
                               " WHERE Año = 2007";
            int rowsAffected = conexion.ejecutarInsertDeleteUpdate(updateQuery);
            System.out.println("Filas afectadas al guardar: " + rowsAffected);
            if (rowsAffected == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron filas para actualizar el estado.");
            }
            conexion.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el estado de la temporada: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void advanceToNextRace() {
        // Si la temporada está reiniciada (índice -1), comenzar desde la primera carrera (Australia, índice 0)
        if (currentRaceIndex == -1) {
            currentRaceIndex = 0;
        } else if (currentRaceIndex >= 0 && currentRaceIndex < raceLabels.length - 1) {
            currentRaceIndex++;
        } else {
            currentRaceIndex = 0; // Volver al inicio si se completa el ciclo
        }

        // Limpiar el resaltado de la carrera anterior
        if (currentRaceIndex > 0 || (currentRaceIndex == 0 && currentRaceIndex != -1)) {
            raceLabels[currentRaceIndex - 1].setOpaque(false);
            raceLabels[currentRaceIndex - 1].setBackground(null);
            raceLabels[currentRaceIndex - 1].setFont(new Font("Dialog", Font.PLAIN, 12));
        }

        // Resaltar la nueva carrera
        raceLabels[currentRaceIndex].setOpaque(true);
        raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
        raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));

        new RaceWindow(raceLabels[currentRaceIndex].getText()).setVisible(true);

        saveSeasonState();
    }

    public void refreshSeasonState() {
        loadSeasonState();
        contentPane.repaint(); // Forzar actualización gráfica
    }

    public class RaceWindow extends JFrame {

        private static final long serialVersionUID = 1L;
        private JPanel panelContenido;
        private JPanel[] puntosPilotos;
        private int[] posicionesPilotos;
        private JLabel[] etiquetasPosicion;
        private JLabel[] etiquetasPosicionEnVivo;
        private JLabel[] etiquetasNombrePiloto;
        private JLabel[] etiquetasVueltas;
        private JPanel[] filasClasificacion;
        private JPanel[] panelesColorEquipo;
        private boolean[] haTerminado;
        private ArrayList<Integer> ordenLlegada;
        private int[] vueltasCompletadas;
        private static final int X_INICIO = 250;
        private static final int X_FIN = 800;
        private static final int Y_POSICION = 100;
        private static final int TAMANO_PUNTO = 10;
        private static final int NUM_PILOTOS = 23;
        private static final int TOTAL_VUELTAS = 3;
        private JLabel lblNewLabel;
        private JLabel etiquetaVueltasCarrera;

        // Animation variables for squares and rows
        private double[] currentYSquares;
        private double[] targetYSquares;
        private double[] currentYRows;
        private double[] targetYRows;
        // Animation variables for points labels
        private double[] currentYPoints;
        private double[] targetYPoints;
        private static final int ANIMATION_DURATION = 500;
        private static final int ANIMATION_STEP_TIME = 20;
        private double animationProgress;

        private Map<String, Integer> puntosPorPiloto = new HashMap<>();

        private static final String[] PILOT_IDS = {
            "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8",
            "P9", "P10", "P11", "P12", "P13", "P14", "P15", "P16",
            "P17", "P18", "P19", "P20", "P21", "P22"
        };
        private String[] PILOTOS;
        private String[] EQUIPOS;

        private static final Color[] COLORES_EQUIPOS = {
            new Color(200, 200, 200), new Color(200, 200, 200), new Color(220, 0, 0), new Color(220, 0, 0),
            new Color(0, 153, 0), new Color(0, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 204, 0), new Color(255, 204, 0),
            new Color(255, 0, 0), new Color(255, 0, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 153, 0), new Color(255, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204), new Color(255, 140, 0)
        };
        private int[] PUNTUACIONES_RENDIMIENTO;

        public RaceWindow(String nombreCarrera) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(0, 0, 900, 600);
            panelContenido = new JPanel();
            panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);

            panelContenido.setBackground(new Color(242, 242, 242));
            setContentPane(panelContenido);
            panelContenido.setLayout(null);

            // Initialize arrays
            PILOTOS = new String[NUM_PILOTOS];
            EQUIPOS = new String[NUM_PILOTOS];
            PUNTUACIONES_RENDIMIENTO = new int[NUM_PILOTOS];

            // Load pilot and team data from database
            fetchPilotAndTeamData();

            // Calculate performance based on team and pilot metrics
            calculatePerformance();

            JLabel etiquetaTituloCarrera = new JLabel(nombreCarrera);
            etiquetaTituloCarrera.setFont(new Font("Arial", Font.BOLD, 24));
            etiquetaTituloCarrera.setBounds(369, 11, 277, 67);
            panelContenido.add(etiquetaTituloCarrera);

            JButton botonCerrar = new JButton("Cerrar");
            botonCerrar.setBounds(260, 520, 100, 30);
            botonCerrar.addActionListener(e -> dispose());
            panelContenido.add(botonCerrar);

            puntosPilotos = new JPanel[NUM_PILOTOS];
            posicionesPilotos = new int[NUM_PILOTOS];
            etiquetasPosicion = new JLabel[NUM_PILOTOS];
            etiquetasPosicionEnVivo = new JLabel[NUM_PILOTOS];
            etiquetasNombrePiloto = new JLabel[NUM_PILOTOS];
            etiquetasVueltas = new JLabel[NUM_PILOTOS];
            filasClasificacion = new JPanel[NUM_PILOTOS];
            panelesColorEquipo = new JPanel[NUM_PILOTOS];
            haTerminado = new boolean[NUM_PILOTOS];
            ordenLlegada = new ArrayList<>();
            vueltasCompletadas = new int[NUM_PILOTOS];
            Random aleatorio = new Random();

            // Initialize animation arrays
            currentYSquares = new double[NUM_PILOTOS];
            targetYSquares = new double[NUM_PILOTOS];
            currentYRows = new double[NUM_PILOTOS];
            targetYRows = new double[NUM_PILOTOS];
            currentYPoints = new double[NUM_PILOTOS];
            targetYPoints = new double[NUM_PILOTOS];
            animationProgress = 1.0;

            for (int i = 0; i < NUM_PILOTOS; i++) {
                puntosPorPiloto.put(PILOT_IDS[i], 0);
                currentYSquares[i] = Y_POSICION + (i * 20);
                targetYSquares[i] = Y_POSICION + (i * 20);
                currentYRows[i] = i * 20;
                targetYRows[i] = i * 20;
                currentYPoints[i] = Y_POSICION + (i * 20) - 5;
                targetYPoints[i] = Y_POSICION + (i * 20) - 5;
            }

            lblNewLabel = new JLabel();
            lblNewLabel.setBounds(0, 0, 0, 0);
            panelContenido.add(lblNewLabel);

            etiquetaVueltasCarrera = new JLabel("Vuelta 0/" + TOTAL_VUELTAS);
            etiquetaVueltasCarrera.setFont(new Font("Arial", Font.BOLD, 14));
            etiquetaVueltasCarrera.setForeground(Color.WHITE);
            etiquetaVueltasCarrera.setBounds(5, 70, 200, 20);
            etiquetaVueltasCarrera.setOpaque(true);
            etiquetaVueltasCarrera.setBackground(Color.BLACK);
            panelContenido.add(etiquetaVueltasCarrera);

            JPanel panelClasificacion = new JPanel();
            panelClasificacion.setBounds(5, Y_POSICION, 200, 420);
            panelClasificacion.setBackground(Color.BLACK);
            panelClasificacion.setOpaque(true);
            panelClasificacion.setLayout(null);
            panelContenido.add(panelClasificacion);

            for (int i = 0; i < NUM_PILOTOS; i++) {
                puntosPilotos[i] = new JPanel();
                puntosPilotos[i].setBounds(X_INICIO, (int)currentYSquares[i], TAMANO_PUNTO, TAMANO_PUNTO);
                puntosPilotos[i].setBackground(COLORES_EQUIPOS[i]);
                puntosPilotos[i].setOpaque(true);
                panelContenido.add(puntosPilotos[i]);
                posicionesPilotos[i] = X_INICIO;
                haTerminado[i] = false;
                vueltasCompletadas[i] = 0;

                etiquetasPosicion[i] = new JLabel("");
                etiquetasPosicion[i].setFont(new Font("Arial", Font.PLAIN, 12));
                etiquetasPosicion[i].setBounds(X_FIN + 10, (int)currentYPoints[i], 50, 20);
                panelContenido.add(etiquetasPosicion[i]);

                filasClasificacion[i] = new JPanel();
                filasClasificacion[i].setBounds(0, (int)currentYRows[i], 200, 20);
                filasClasificacion[i].setBackground(Color.BLACK);
                filasClasificacion[i].setOpaque(true);
                filasClasificacion[i].setLayout(null);
                panelClasificacion.add(filasClasificacion[i]);

                etiquetasPosicionEnVivo[i] = new JLabel(String.valueOf(i + 1));
                etiquetasPosicionEnVivo[i].setFont(new Font("Arial", Font.BOLD, 12));
                etiquetasPosicionEnVivo[i].setForeground(Color.WHITE);
                etiquetasPosicionEnVivo[i].setBounds(10, 0, 20, 20);
                filasClasificacion[i].add(etiquetasPosicionEnVivo[i]);

                etiquetasNombrePiloto[i] = new JLabel(PILOTOS[i]);
                etiquetasNombrePiloto[i].setFont(new Font("Arial", Font.BOLD, 10));
                etiquetasNombrePiloto[i].setForeground(Color.WHITE);
                etiquetasNombrePiloto[i].setBounds(40, 0, 100, 20);
                filasClasificacion[i].add(etiquetasNombrePiloto[i]);

                panelesColorEquipo[i] = new JPanel();
                panelesColorEquipo[i].setBounds(180, 2, 16, 16);
                panelesColorEquipo[i].setBackground(COLORES_EQUIPOS[i]);
                panelesColorEquipo[i].setOpaque(true);
                filasClasificacion[i].add(panelesColorEquipo[i]);

                etiquetasVueltas[i] = new JLabel("0/" + TOTAL_VUELTAS);
                etiquetasVueltas[i].setFont(new Font("Arial", Font.BOLD, 10));
                etiquetasVueltas[i].setForeground(Color.WHITE);
                etiquetasVueltas[i].setBounds(150, 0, 40, 20);
                filasClasificacion[i].add(etiquetasVueltas[i]);
            }

            JLabel lineaMeta = new JLabel("META");
            lineaMeta.setBounds(X_FIN - 20, Y_POSICION - 20, 40, 20);
            lineaMeta.setFont(new Font("Arial", Font.BOLD, 12));
            lineaMeta.setForeground(Color.RED);
            panelContenido.add(lineaMeta);

            JButton btnNewButton = new JButton("GUARDAR");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                    try {
                        conexion.conectar();
                        for (int i = 0; i < NUM_PILOTOS; i++) {
                            String idPiloto = PILOT_IDS[i];
                            int puntos = puntosPorPiloto.getOrDefault(idPiloto, 0);
                            String sentencia = "UPDATE piloto SET Puntos = Puntos + " + puntos +
                                              " WHERE Id = '" + idPiloto + "'";
                            conexion.ejecutarInsertDeleteUpdate(sentencia);
                        }
                        conexion.desconectar();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            btnNewButton.setBounds(494, 521, 109, 28);
            panelContenido.add(btnNewButton);

            panelContenido.setComponentZOrder(panelClasificacion, 0);

            Timer temporizador = new Timer(ANIMATION_STEP_TIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update pilot positions on the track (x-coordinates)
                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        if (!haTerminado[i]) {
                            int velocidadMaxima = Math.max(1, PUNTUACIONES_RENDIMIENTO[i]);
                            int velocidad = aleatorio.nextInt(velocidadMaxima) + 1;
                            posicionesPilotos[i] += velocidad;
                            if (posicionesPilotos[i] >= X_FIN) {
                                vueltasCompletadas[i]++;
                                etiquetasVueltas[i].setText(vueltasCompletadas[i] + "/" + TOTAL_VUELTAS);
                                if (vueltasCompletadas[i] < TOTAL_VUELTAS) {
                                    posicionesPilotos[i] = X_INICIO;
                                } else {
                                    posicionesPilotos[i] = X_FIN;
                                    haTerminado[i] = true;
                                    ordenLlegada.add(i);
                                }
                            }
                        }
                    }

                    // Update the overall race lap counter
                    int vueltaMaxima = Arrays.stream(vueltasCompletadas).max().getAsInt();
                    etiquetaVueltasCarrera.setText("Vuelta " + vueltaMaxima + "/" + TOTAL_VUELTAS);

                    // Sort pilots based on their current positions
                    Integer[] indices = new Integer[NUM_PILOTOS];
                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        indices[i] = i;
                    }
                    Arrays.sort(indices, (a, b) -> {
                        if (haTerminado[a] && haTerminado[b]) {
                            return Integer.compare(ordenLlegada.indexOf(a), ordenLlegada.indexOf(b));
                        } else if (haTerminado[a]) {
                            return -1;
                        } else if (haTerminado[b]) {
                            return 1;
                        }
                        if (vueltasCompletadas[a] != vueltasCompletadas[b]) {
                            return Integer.compare(vueltasCompletadas[b], vueltasCompletadas[a]);
                        }
                        return Integer.compare(posicionesPilotos[b], posicionesPilotos[a]);
                    });

                    // Update target positions for animation (squares, rows, and points)
                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        int idx = indices[i];
                        targetYSquares[idx] = Y_POSICION + (i * 20);
                        targetYRows[idx] = i * 20;
                        targetYPoints[idx] = Y_POSICION + (i * 20) - 5;
                        etiquetasPosicionEnVivo[idx].setText(String.valueOf(i + 1));
                        etiquetasNombrePiloto[idx].setText(PILOTOS[idx]);
                        panelesColorEquipo[idx].setBackground(COLORES_EQUIPOS[idx]);
                        etiquetasVueltas[idx].setText(vueltasCompletadas[idx] + "/" + TOTAL_VUELTAS);
                    }

                    // Update animation progress
                    if (animationProgress >= 1.0) {
                        animationProgress = 0.0;
                    }
                    animationProgress += (double)ANIMATION_STEP_TIME / ANIMATION_DURATION;
                    if (animationProgress > 1.0) {
                        animationProgress = 1.0;
                    }

                    // Interpolate positions for smooth animation
                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        currentYSquares[i] = currentYSquares[i] + (targetYSquares[i] - currentYSquares[i]) * animationProgress;
                        currentYRows[i] = currentYRows[i] + (targetYRows[i] - currentYRows[i]) * animationProgress;
                        currentYPoints[i] = currentYPoints[i] + (targetYPoints[i] - currentYPoints[i]) * animationProgress;
                        puntosPilotos[i].setLocation(posicionesPilotos[i], (int)currentYSquares[i]);
                        filasClasificacion[i].setBounds(0, (int)currentYRows[i], 200, 20);
                        etiquetasPosicion[i].setBounds(X_FIN + 10, (int)currentYPoints[i], 50, 20);
                    }

                    // Assign points based on final positions when race ends
                    if (ordenLlegada.size() == NUM_PILOTOS) {
                        for (int i = 0; i < NUM_PILOTOS; i++) {
                            int pilotIndex = ordenLlegada.get(i);
                            int position = i + 1;
                            int puntos = obtenerPuntosPorPosicion(position);
                            puntosPorPiloto.put(PILOT_IDS[pilotIndex], puntos);
                            etiquetasPosicion[pilotIndex].setText(position + " + " + puntos);
                        }
                    }

                    // Repaint the panel to reflect the updated positions
                    panelContenido.repaint();

                    // Stop the timer when all pilots have finished
                    if (ordenLlegada.size() == NUM_PILOTOS) {
                        ((Timer)e.getSource()).stop();
                    }
                }
            });
            temporizador.start();
        }

        private void fetchPilotAndTeamData() {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String query = "SELECT Id, Nombre, Equipo FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC";
                ResultSet result = conexion.ejecutarSelect(query);
                int index = 0;
                while (result.next() && index < NUM_PILOTOS) {
                    PILOTOS[index] = result.getString("Nombre");
                    EQUIPOS[index] = result.getString("Equipo");
                    System.out.println("Piloto cargado: " + PILOTOS[index] + ", Equipo: " + EQUIPOS[index]);
                    index++;
                }
                if (index != NUM_PILOTOS) {
                    System.out.println("No se encontraron suficientes pilotos en la base de datos.");
                    for (int i = index; i < NUM_PILOTOS; i++) {
                        PILOTOS[i] = "Piloto" + (i + 1);
                        EQUIPOS[i] = "EquipoDesconocido";
                    }
                }
                result.close();
                conexion.desconectar();
            } catch (SQLException e) {
                System.out.println("Error al cargar pilotos: " + e.getMessage());
                e.printStackTrace();
                for (int i = 0; i < NUM_PILOTOS; i++) {
                    PILOTOS[i] = "Piloto" + (i + 1);
                    EQUIPOS[i] = "EquipoDesconocido";
                }
            }
        }

        private void calculatePerformance() {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            Map<String, Double> teamPerformance = new HashMap<>();
            double[] rendimientosCrudos = new double[NUM_PILOTOS];

            try {
                conexion.conectar();
                String queryTeams = "SELECT Nombre, Potencia, Aerodinamica, Fiabilidad FROM equipo";
                ResultSet rsTeams = conexion.ejecutarSelect(queryTeams);
                while (rsTeams.next()) {
                    String nombreEquipo = rsTeams.getString("Nombre");
                    int potencia = rsTeams.getInt("Potencia");
                    int aerodinamica = rsTeams.getInt("Aerodinamica");
                    int fiabilidad = rsTeams.getInt("Fiabilidad");
                    double teamScore = (potencia + aerodinamica + fiabilidad) / 3.0;
                    teamPerformance.put(nombreEquipo, teamScore);
                    System.out.println("Team: " + nombreEquipo + ", Score: " + teamScore);
                }
                rsTeams.close();

                String queryPilots = "SELECT Id, Habilidad, Consistencia FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC";
                ResultSet rsPilots = conexion.ejecutarSelect(queryPilots);
                int index = 0;
                while (rsPilots.next() && index < NUM_PILOTOS) {
                    int habilidad = rsPilots.getInt("Habilidad");
                    int consistencia = rsPilots.getInt("Consistencia");
                    String equipo = EQUIPOS[index];
                    double teamScore = teamPerformance.getOrDefault(equipo, 500.0);
                    double pilotScore = (habilidad + consistencia) / 2.0;
                    rendimientosCrudos[index] = 0.6 * teamScore + 0.4 * pilotScore;
                    System.out.println("Piloto: " + PILOTOS[index] + ", Team: " + equipo + ", Rendimiento Crudo: " + rendimientosCrudos[index]);
                    index++;
                }
                rsPilots.close();
                conexion.desconectar();

                double minRendimiento = Arrays.stream(rendimientosCrudos).min().orElse(1.0);
                double maxRendimiento = Arrays.stream(rendimientosCrudos).max().orElse(1.0);
                double rangoOriginal = maxRendimiento - minRendimiento;
                if (rangoOriginal == 0) {
                    rangoOriginal = 1.0;
                }
                for (int i = 0; i < NUM_PILOTOS; i++) {
                    double normalized = 5 + ((rendimientosCrudos[i] - minRendimiento) * 10.0 / rangoOriginal);
                    PUNTUACIONES_RENDIMIENTO[i] = (int) Math.round(normalized);
                    System.out.println("Piloto " + i + ": Rendimiento Normalizado = " + PUNTUACIONES_RENDIMIENTO[i]);
                }
            } catch (SQLException e) {
                System.out.println("Error al calcular rendimientos: " + e.getMessage());
                e.printStackTrace();
                for (int i = 0; i < NUM_PILOTOS; i++) {
                    PUNTUACIONES_RENDIMIENTO[i] = 10;
                }
            }
        }

        private int obtenerPuntosPorPosicion(int posicion) {
            switch (posicion) {
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