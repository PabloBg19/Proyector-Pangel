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
        raceLabels[9] = (lblGPAustralia_2_1_1_2);

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
                Reiniciar();
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
                if (currentRaceIndex >= 0 && currentRaceIndex < raceLabels.length) {
                    raceLabels[currentRaceIndex].setOpaque(true);
                    raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
                    raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));
                }
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
            if (rowsAffected > 0) {
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron filas para actualizar el estado.");
            }
            conexion.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el estado de la temporada: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void advanceToNextRace() {
        if (currentRaceIndex >= 0 && currentRaceIndex < raceLabels.length) {
            raceLabels[currentRaceIndex].setOpaque(false);
            raceLabels[currentRaceIndex].setBackground(null);
            raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.PLAIN, 12));
        }

        currentRaceIndex = (currentRaceIndex + 1) % raceLabels.length;

        raceLabels[currentRaceIndex].setOpaque(true);
        raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
        raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));

        new RaceWindow(raceLabels[currentRaceIndex].getText()).setVisible(true);

        saveSeasonState();
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
        private JPanel[] panelesColorEquipo; // Nuevo array para los paneles de color
        private boolean[] haTerminado;
        private ArrayList<Integer> ordenLlegada;
        private int[] vueltasCompletadas;
        private static final int X_INICIO = 250;
        private static final int X_FIN = 800;
        private static final int Y_POSICION = 100;
        private static final int TAMANO_PUNTO = 10;
        private static final int NUM_PILOTOS = 20;
        private static final int TOTAL_VUELTAS = 3;
        private JLabel lblNewLabel;
        private JLabel etiquetaVueltasCarrera;

        private Map<String, Integer> puntosPorPiloto = new HashMap<>();

        private static final String[] PILOT_IDS = {
            "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8",
            "P9", "P10", "P11", "P12", "P13", "P14", "P15", "P16",
            "P17", "P18", "P19", "P20"
        };
        private String[] PILOTOS;

        private static final Color[] COLORES_EQUIPOS = {
            new Color(200, 200, 200), new Color(200, 200, 200), new Color(220, 0, 0), new Color(220, 0, 0),
            new Color(0, 153, 0), new Color(0, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 204, 0), new Color(255, 204, 0),
            new Color(255, 0, 0), new Color(255, 0, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 153, 0), new Color(255, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204)
        };
        private static final int[] PUNTUACIONES_RENDIMIENTO = {
            10, 10, 10, 9, 6, 6, 7, 7, 6, 5, 3, 3, 5, 5, 4, 4, 3, 3, 3, 3
        };

        public RaceWindow(String nombreCarrera) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(0, 0, 900, 600);
            panelContenido = new JPanel();
            panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);

            panelContenido.setBackground(new Color(242, 242, 242));
            setContentPane(panelContenido);
            panelContenido.setLayout(null);

            // Cargar nombres de pilotos desde la base de datos
            PILOTOS = new String[NUM_PILOTOS];
            ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
            try {
                conexion.conectar();
                String query = "SELECT * FROM piloto ORDER BY CAST(SUBSTRING(Id, 2) AS UNSIGNED) ASC";
                ResultSet result = conexion.ejecutarSelect(query);
                int index = 0;
                while (result.next() && index < NUM_PILOTOS) {
                    PILOTOS[index] = result.getString("Nombre");
                    index++;
                }
                result.close();
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
                PILOTOS = new String[]{"Piloto1", "Piloto2", "Piloto3", "Piloto4", "Piloto5", "Piloto6", "Piloto7", "Piloto8",
                        "Piloto9", "Piloto10", "Piloto11", "Piloto12", "Piloto13", "Piloto14", "Piloto15", "Piloto16",
                        "Piloto17", "Piloto18", "Piloto19", "Piloto20"};
            }

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
            panelesColorEquipo = new JPanel[NUM_PILOTOS]; // Inicializar el array para los colores
            haTerminado = new boolean[NUM_PILOTOS];
            ordenLlegada = new ArrayList<>();
            vueltasCompletadas = new int[NUM_PILOTOS];
            Random aleatorio = new Random();

            for (int i = 0; i < NUM_PILOTOS; i++) {
                puntosPorPiloto.put(PILOT_IDS[i], 0);
            }

            lblNewLabel = new JLabel();
            lblNewLabel.setBounds(752, 461, 46, 14);
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
                puntosPilotos[i].setBounds(X_INICIO, Y_POSICION + (i * 20), TAMANO_PUNTO, TAMANO_PUNTO);
                puntosPilotos[i].setBackground(COLORES_EQUIPOS[i]);
                puntosPilotos[i].setOpaque(true);
                panelContenido.add(puntosPilotos[i]);
                posicionesPilotos[i] = X_INICIO;
                haTerminado[i] = false;
                vueltasCompletadas[i] = 0;

                etiquetasPosicion[i] = new JLabel("");
                etiquetasPosicion[i].setFont(new Font("Arial", Font.PLAIN, 12));
                etiquetasPosicion[i].setBounds(X_FIN + 10, Y_POSICION + (i * 20) - 5, 50, 20);
                panelContenido.add(etiquetasPosicion[i]);

                filasClasificacion[i] = new JPanel();
                filasClasificacion[i].setBounds(0, i * 20, 200, 20);
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
                etiquetasNombrePiloto[i].setBounds(40, 0, 100, 20); // Reducido el ancho para dejar espacio al color
                filasClasificacion[i].add(etiquetasNombrePiloto[i]);

                // Agregar un pequeño panel con el color del equipo
                panelesColorEquipo[i] = new JPanel();
                panelesColorEquipo[i].setBounds(180, 2, 16, 16); // Posición al lado del nombre
                panelesColorEquipo[i].setBackground(COLORES_EQUIPOS[i]);
                panelesColorEquipo[i].setOpaque(true);
                filasClasificacion[i].add(panelesColorEquipo[i]);

                etiquetasVueltas[i] = new JLabel("0/" + TOTAL_VUELTAS);
                etiquetasVueltas[i].setFont(new Font("Arial", Font.BOLD, 10));
                etiquetasVueltas[i].setForeground(Color.WHITE);
                etiquetasVueltas[i].setBounds(150, 0, 40, 20); // Ajustado para dejar espacio al color
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

            Timer temporizador = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        if (!haTerminado[i]) {
                            int velocidadMaxima = PUNTUACIONES_RENDIMIENTO[i];
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
                                    int posicion = ordenLlegada.indexOf(i) + 1;
                                    int puntos = obtenerPuntosPorPosicion(posicion);
                                    puntosPorPiloto.put(PILOT_IDS[i], puntos);
                                    if (i == 0) {
                                        lblNewLabel.setText(String.valueOf(puntos));
                                    }
                                    etiquetasPosicion[i].setText(posicion + " + " + puntos);
                                }
                            }
                            puntosPilotos[i].setLocation(posicionesPilotos[i], Y_POSICION + (i * 20));
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
                        etiquetasPosicionEnVivo[idx].setText(String.valueOf(i + 1));
                        filasClasificacion[idx].setBounds(0, i * 20, 200, 20);
                        panelClasificacion.add(filasClasificacion[idx], 0);
                        etiquetasNombrePiloto[idx].setText(PILOTOS[idx]);
                        panelesColorEquipo[idx].setBackground(COLORES_EQUIPOS[idx]); // Actualizar color si el orden cambia
                        etiquetasVueltas[idx].setText(vueltasCompletadas[idx] + "/" + TOTAL_VUELTAS);
                    }

                    panelContenido.repaint();

                    if (ordenLlegada.size() == NUM_PILOTOS) {
                        ((Timer)e.getSource()).stop();
                    }
                }
            });
            temporizador.start();
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
    

    private void Reiniciar() {
        JFrame reiniciarFrame = new JFrame("Reiniciar Puntos y Temporada");
        reiniciarFrame.setSize(900, 600);
        reiniciarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reiniciarFrame.setLocationRelativeTo(null);

        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(null);
        reiniciarFrame.setContentPane(panelContenido);

        JButton btnReiniciar = new JButton("REINICIAR PUNTOS");
        btnReiniciar.setBounds(700, 500, 120, 27);
        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "UPDATE piloto SET Puntos = 0";
                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                    String sentencia1 = "UPDATE carreras SET indice_actual = -1";
                    conexion.ejecutarInsertDeleteUpdate(sentencia1);
                    JOptionPane.showMessageDialog(null, "Temporada Reiniciada");
                    currentRaceIndex = -1;
                    for (JLabel label : raceLabels) {
                        label.setOpaque(false);
                        label.setBackground(null);
                        label.setFont(new Font("Dialog", Font.PLAIN, 12));
                    }
                    conexion.desconectar();
                    JOptionPane.showMessageDialog(null, "¡Puntos reiniciados correctamente!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al reiniciar los puntos.");
                }
            }
        });
        panelContenido.add(btnReiniciar);

        JButton btnReiniciarTemporada = new JButton("Reiniciar Temporada");
        btnReiniciarTemporada.setBounds(137, 95, 136, 49);
        btnReiniciarTemporada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
                try {
                    conexion.conectar();
                    String sentencia = "UPDATE carreras SET indice_actual = -1";
                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                    conexion.desconectar();
                    JOptionPane.showMessageDialog(null, "Temporada Reiniciada");
                    currentRaceIndex = -1;
                    for (JLabel label : raceLabels) {
                        label.setOpaque(false);
                        label.setBackground(null);
                        label.setFont(new Font("Dialog", Font.PLAIN, 12));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al reiniciar la temporada.");
                }
            }
        });
        panelContenido.add(btnReiniciarTemporada);

        reiniciarFrame.setVisible(true);
    }
}