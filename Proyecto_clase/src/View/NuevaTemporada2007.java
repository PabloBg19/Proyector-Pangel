package View;

// Importaciones necesarias para la interfaz gráfica, manejo de eventos, base de datos y otras utilidades
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.ImageIcon;

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

        raceLabels = new JLabel[10];

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
        raceLabels[4] = (lblGPAustralia_1_1_1_1);

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
        lblNewLabel.setBounds(205, 33, 318, 56);
        contentPane.add(lblNewLabel);

        JLabel label_FIA = new JLabel("");
        label_FIA.setBounds(147, 286, 69, 62);
        contentPane.add(label_FIA);

        ImageIcon icon = new ImageIcon(MenuDeGestion.class.getResource("/image/FIA.png"));
        Image img = icon.getImage().getScaledInstance(label_FIA.getWidth(), label_FIA.getHeight(), Image.SCALE_SMOOTH);
        label_FIA.setIcon(new ImageIcon(img));

        JLabel lblClasificacion = new JLabel("");
        lblClasificacion.setBounds(328, 286, 61, 56);
        contentPane.add(lblClasificacion);

        ImageIcon icon1 = new ImageIcon(MenuDeGestion.class.getResource("/image/Trofeo.png"));
        Image img1 = icon1.getImage().getScaledInstance(lblClasificacion.getWidth(), lblClasificacion.getHeight(), Image.SCALE_SMOOTH);
        lblClasificacion.setIcon(new ImageIcon(img1));

        JLabel lblCarrera = new JLabel("New label");
        lblCarrera.setBounds(505, 294, 91, 51);
        contentPane.add(lblCarrera);

        ImageIcon icon2 = new ImageIcon(MenuDeGestion.class.getResource("/image/carrera.png"));
        Image img2 = icon2.getImage().getScaledInstance(lblCarrera.getWidth(), lblCarrera.getHeight(), Image.SCALE_SMOOTH);
        lblCarrera.setIcon(new ImageIcon(img2));

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
            //Trigger Bases de Datos
            if (result.next()) {
                currentRaceIndex = result.getInt("indice_actual");
                System.out.println("Estado cargado: currentRaceIndex = " + currentRaceIndex);
                for (JLabel label : raceLabels) {
                    label.setOpaque(false);
                    label.setBackground(null);
                    label.setFont(new Font("Dialog", Font.PLAIN, 12));
                }
                if (currentRaceIndex >= 0 && currentRaceIndex < raceLabels.length) {
                    raceLabels[currentRaceIndex].setOpaque(true);
                    raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
                    raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));
                } else if (currentRaceIndex == -1) {
                    System.out.println("Temporada reiniciada, comenzando desde la primera carrera (Australia).");
                } else {
                    System.out.println("Índice fuera de rango o inválido: " + currentRaceIndex);
                    currentRaceIndex = -1;
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
            String updateQuery = "UPDATE carreras SET indice_actual = " + currentRaceIndex + " WHERE Año = 2007";
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
        if (currentRaceIndex == -1) {
            currentRaceIndex = 0;
        } else if (currentRaceIndex < raceLabels.length - 1) {
            currentRaceIndex++;
        } else {
            currentRaceIndex = 0;
            mostrarCampeonYReiniciarPuntos();
        }

        if (currentRaceIndex > 0) {
            raceLabels[currentRaceIndex - 1].setOpaque(false);
            raceLabels[currentRaceIndex - 1].setBackground(null);
            raceLabels[currentRaceIndex - 1].setFont(new Font("Dialog", Font.PLAIN, 12));
        }

        raceLabels[currentRaceIndex].setOpaque(true);
        raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
        raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));

        new RaceWindow(raceLabels[currentRaceIndex].getText()).setVisible(true);

        saveSeasonState();
    }

    private void mostrarCampeonYReiniciarPuntos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String query = "SELECT Nombre, Puntos FROM piloto ORDER BY Puntos DESC LIMIT 1";
            ResultSet result = conexion.ejecutarSelect(query);
            if (result.next()) {
                String campeon = result.getString("Nombre");
                int puntos = result.getInt("Puntos");
                JOptionPane.showMessageDialog(this, "¡Campeón del Mundo 2007: " + campeon + " con " + puntos + " puntos!");
            }
            result.close();

            String resetQuery = "UPDATE piloto SET Puntos = 0";
            conexion.ejecutarInsertDeleteUpdate(resetQuery);
            System.out.println("Puntos reiniciados para la próxima temporada.");
            conexion.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al determinar el campeón o reiniciar puntos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void refreshSeasonState() {
        loadSeasonState();
        contentPane.repaint();
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
        private static final int NUM_PILOTOS = 22;
        private static final int TOTAL_VUELTAS = 3;
        private JLabel lblNewLabel;
        private JLabel etiquetaVueltasCarrera;

        private double[] currentYSquares;
        private double[] targetYSquares;
        private double[] currentYRows;
        private double[] targetYRows;
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
        private int[] PUNTUACIONES_RENDIMIENTO;

        // Mapa de colores por equipo (definido manualmente según los equipos de la temporada 2007)
        private static final Map<String, Color> COLORES_POR_EQUIPO = new HashMap<>();
        static {
            COLORES_POR_EQUIPO.put("McLaren", new Color(200, 200, 200)); // Gris
            COLORES_POR_EQUIPO.put("Honda", new Color(200, 200, 200));   // Gris
            COLORES_POR_EQUIPO.put("Ferrari", new Color(220, 0, 0));     // Rojo
            COLORES_POR_EQUIPO.put("BMW Sauber", new Color(0, 153, 0));  // Verde
            COLORES_POR_EQUIPO.put("Renault", new Color(0, 102, 204));   // Azul
            COLORES_POR_EQUIPO.put("Williams", new Color(255, 255, 255)); // Blanco
            COLORES_POR_EQUIPO.put("Toyota", new Color(255, 204, 0));    // Amarillo
            COLORES_POR_EQUIPO.put("Toro Rosso", new Color(255, 0, 0));  // Rojo oscuro
            COLORES_POR_EQUIPO.put("Red Bull", new Color(0, 102, 204));  // Azul
            COLORES_POR_EQUIPO.put("Super Aguri", new Color(255, 153, 0)); // Naranja
            COLORES_POR_EQUIPO.put("Spyker", new Color(255, 140, 0));    // Naranja oscuro
        }

        public RaceWindow(String nombreCarrera) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(0, 0, 900, 600);
            panelContenido = new JPanel();
            panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);

            panelContenido.setBackground(new Color(230, 230, 250));
            setContentPane(panelContenido);
            panelContenido.setLayout(null);

            PILOTOS = new String[NUM_PILOTOS];
            EQUIPOS = new String[NUM_PILOTOS];
            PUNTUACIONES_RENDIMIENTO = new int[NUM_PILOTOS];

            fetchPilotAndTeamData();
            calculatePerformance();

            JLabel etiquetaTituloCarrera = new JLabel(nombreCarrera);
            etiquetaTituloCarrera.setFont(new Font("Arial", Font.BOLD, 24));
            etiquetaTituloCarrera.setForeground(new Color(25, 25, 112));
            etiquetaTituloCarrera.setBounds(320, 34, 500, 30);
            panelContenido.add(etiquetaTituloCarrera);

            JButton botonCerrar = new JButton("Cerrar");
            botonCerrar.setBounds(460, 520, 100, 30);
            botonCerrar.setFont(new Font("Arial", Font.BOLD, 12));
            botonCerrar.setBackground(new Color(70, 130, 180));
            botonCerrar.setForeground(Color.WHITE);
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
            panelClasificacion.setBounds(5, Y_POSICION, 200, 440);
            panelClasificacion.setBackground(Color.BLACK);
            panelClasificacion.setOpaque(true);
            panelClasificacion.setLayout(null);
            panelContenido.add(panelClasificacion);

            for (int i = 0; i < NUM_PILOTOS; i++) {
                puntosPilotos[i] = new JPanel();
                puntosPilotos[i].setBounds(X_INICIO, (int)currentYSquares[i], TAMANO_PUNTO, TAMANO_PUNTO);
                puntosPilotos[i].setBackground(getColorForTeam(EQUIPOS[i]));
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
                etiquetasNombrePiloto[i].setFont(new Font("Arial", Font.BOLD, 12));
                etiquetasPosicionEnVivo[i].setForeground(Color.WHITE);
                etiquetasNombrePiloto[i].setBounds(40, 2, 120, 16);
                filasClasificacion[i].add(etiquetasNombrePiloto[i]);

                panelesColorEquipo[i] = new JPanel();
                panelesColorEquipo[i].setBounds(160, 2, 16, 16);
                panelesColorEquipo[i].setBackground(getColorForTeam(EQUIPOS[i]));
                panelesColorEquipo[i].setOpaque(true);
                filasClasificacion[i].add(panelesColorEquipo[i]);

                etiquetasVueltas[i] = new JLabel("0/" + TOTAL_VUELTAS);
                etiquetasVueltas[i].setFont(new Font("Arial", Font.BOLD, 10));
                etiquetasVueltas[i].setForeground(Color.WHITE);
                etiquetasVueltas[i].setBounds(180, 2, 20, 16);
                filasClasificacion[i].add(etiquetasVueltas[i]);
            }

            JLabel lineaMeta = new JLabel("META");
            lineaMeta.setBounds(X_FIN - 20, Y_POSICION - 20, 40, 20);
            lineaMeta.setFont(new Font("Arial", Font.BOLD, 12));
            lineaMeta.setForeground(Color.RED);
            panelContenido.add(lineaMeta);

            panelContenido.setComponentZOrder(panelClasificacion, 0);

            Timer temporizador = new Timer(ANIMATION_STEP_TIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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

                    int vueltaMaxima = Arrays.stream(vueltasCompletadas).max().getAsInt();
                    etiquetaVueltasCarrera.setText("Vuelta " + vueltaMaxima + "/" + TOTAL_VUELTAS);

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

                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        int idx = indices[i];
                        targetYSquares[idx] = Y_POSICION + (i * 20);
                        targetYRows[idx] = i * 20;
                        targetYPoints[idx] = Y_POSICION + (i * 20) - 5;
                        etiquetasPosicionEnVivo[idx].setText(String.valueOf(i + 1));
                        etiquetasNombrePiloto[idx].setText(PILOTOS[idx]);
                        panelesColorEquipo[idx].setBackground(getColorForTeam(EQUIPOS[idx]));
                        puntosPilotos[idx].setBackground(getColorForTeam(EQUIPOS[idx]));
                        etiquetasVueltas[idx].setText(vueltasCompletadas[idx] + "/" + TOTAL_VUELTAS);
                    }

                    if (animationProgress >= 1.0) {
                        animationProgress = 0.0;
                    }
                    animationProgress += (double)ANIMATION_STEP_TIME / ANIMATION_DURATION;
                    if (animationProgress > 1.0) {
                        animationProgress = 1.0;
                    }

                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        currentYSquares[i] += (targetYSquares[i] - currentYSquares[i]) * animationProgress;
                        currentYRows[i] += (targetYRows[i] - currentYRows[i]) * animationProgress;
                        currentYPoints[i] += (targetYPoints[i] - currentYPoints[i]) * animationProgress;
                        puntosPilotos[i].setLocation(posicionesPilotos[i], (int)currentYSquares[i]);
                        filasClasificacion[i].setBounds(0, (int)currentYRows[i], 200, 20);
                        etiquetasPosicion[i].setBounds(X_FIN + 10, (int)currentYPoints[i], 50, 20);
                    }

                    if (ordenLlegada.size() == NUM_PILOTOS) {
                        for (int i = 0; i < NUM_PILOTOS; i++) {
                            int pilotIndex = ordenLlegada.get(i);
                            int position = i + 1;
                            int puntos = obtenerPuntosPorPosicion(position);
                            puntosPorPiloto.put(PILOT_IDS[pilotIndex], puntos);
                            etiquetasPosicion[pilotIndex].setText(position + " + " + puntos);
                        }

                        guardarPuntosAutomaticamente();
                        mostrarPodio();

                        ((Timer)e.getSource()).stop();
                    }

                    panelContenido.repaint();
                }
            });
            temporizador.start();
        }

        private void guardarPuntosAutomaticamente() {
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                for (int i = 0; i < NUM_PILOTOS; i++) {
                    String idPiloto = PILOT_IDS[i];
                    int puntos = puntosPorPiloto.getOrDefault(idPiloto, 0);
                    String sentencia = "UPDATE piloto SET Puntos = Puntos + " + puntos + " WHERE Id = '" + idPiloto + "'";
                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                }
                conexion.desconectar();
                System.out.println("Puntos guardados automáticamente al finalizar la carrera.");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar los puntos automáticamente: " + e.getMessage());
            }
        }

        private void mostrarPodio() {
            JFrame podioFrame = new JFrame("Podio - " + lblNewLabel.getText());
            podioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            podioFrame.setBounds(0, 0, 300, 200);
            podioFrame.setLocationRelativeTo(null);
            JPanel podioPanel = new JPanel();
            podioPanel.setLayout(null);
            podioPanel.setBackground(new Color(87, 87, 87));
            ImageIcon fondoIcon = new ImageIcon("/image/podio.jpg"); // o usa getResource("/ruta/archivo.jpg") si está en recursos
            Image fondo = fondoIcon.getImage();
            

            JLabel lblPos1 = new JLabel("1. " + PILOTOS[ordenLlegada.get(0)]);
            lblPos1.setFont(new Font("Arial", Font.BOLD, 14));
            lblPos1.setBounds(82, 25, 200, 20);
            lblPos1.setForeground(new Color(253, 176, 50));
            podioPanel.add(lblPos1);

            JLabel lblPos2 = new JLabel("2. " + PILOTOS[ordenLlegada.get(1)]);
            lblPos2.setFont(new Font("Arial", Font.BOLD, 14));
            lblPos2.setBounds(82, 65, 200, 20);
            lblPos2.setForeground(new Color(169, 169, 169));
            podioPanel.add(lblPos2);

            JLabel lblPos3 = new JLabel("3. " + PILOTOS[ordenLlegada.get(2)]);
            lblPos3.setFont(new Font("Arial", Font.BOLD, 14));
            lblPos3.setBounds(82, 105, 200, 20);
            lblPos3.setForeground(new Color(237, 129, 39));
            podioPanel.add(lblPos3);

            podioFrame.setContentPane(podioPanel);
            podioFrame.setVisible(true);
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

                String queryPilots = "SELECT Id, Habilidad, Consistencia, Equipo FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC";
                ResultSet rsPilots = conexion.ejecutarSelect(queryPilots);
                int index = 0;
                while (rsPilots.next() && index < NUM_PILOTOS) {
                    int habilidad = rsPilots.getInt("Habilidad");
                    int consistencia = rsPilots.getInt("Consistencia");
                    String equipo = rsPilots.getString("Equipo");
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

        // Método para obtener el color basado en el equipo
        private Color getColorForTeam(String team) {
            return COLORES_POR_EQUIPO.getOrDefault(team, Color.GRAY); // Color gris por defecto si el equipo no está mapeado
        }
    }
}