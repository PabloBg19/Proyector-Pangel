package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;
    private JPanel[] puntosPilotos;
    private int[] posicionesPilotos;
    private JLabel[] etiquetasPosicion;
    private JLabel[] etiquetasPosicionEnVivo;
    private JLabel[] etiquetasNombrePiloto;
    private JPanel[] filasClasificacion;
    private boolean[] haTerminado;
    private ArrayList<Integer> ordenLlegada;
    private int[] vueltasCompletadas;
    private static final int X_INICIO = 150;
    private static final int X_FIN = 700;
    private static final int Y_POSICION = 100;
    private static final int TAMANO_PUNTO = 10;
    private static final int NUM_PILOTOS = 20;
    private static final int TOTAL_VUELTAS = 1;
    private JLabel lblNewLabel;
    private Map<String, Integer> puntosPorPiloto = new HashMap<>();
    private double[] rendimientosPilotos; // Calculated based on team performance

    private static final String[] PILOTOS = {
        "Fernando Alonso", "Lewis Hamilton", "Kimi Räikkönen", "Felipe Massa",
        "Giancarlo Fisichella", "Heikki Kovalainen", "Nick Heidfeld", "Robert Kubica",
        "Nico Rosberg", "Alexander Wurz", "Rubens Barrichello", "Jenson Button",
        "David Coulthard", "Mark Webber", "Ralf Schumacher", "Jarno Trulli",
        "Anthony Davidson", "Takuma Sato", "Vitantonio Liuzzi", "Scott Speed"
    };
    private static final String[] PILOT_IDS = {
        "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8",
        "P9", "P10", "P11", "P12", "P13", "P14", "P15", "P16",
        "P17", "P18", "P19", "P20"
    };
    private static final String[] EQUIPOS = {
        "McLaren", "McLaren", "Ferrari", "Ferrari",
        "Renault", "Renault", "BMW Sauber", "BMW Sauber",
        "Williams", "Williams", "Honda", "Honda",
        "Red Bull", "Red Bull", "Toyota", "Toyota",
        "Super Aguri", "Super Aguri", "Toro Rosso", "Toro Rosso"
    };
    private static final Color[] COLORES_EQUIPOS = {
        new Color(200, 200, 200), new Color(200, 200, 200), new Color(220, 0, 0), new Color(220, 0, 0),
        new Color(0, 153, 0), new Color(0, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204),
        new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 204, 0), new Color(255, 204, 0),
        new Color(255, 0, 0), new Color(255, 0, 0), new Color(0, 102, 204), new Color(0, 102, 204),
        new Color(255, 153, 0), new Color(255, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204)
    };

    public RaceWindow(String nombreCarrera) {
        // Initialize performance array from database
        rendimientosPilotos = new double[NUM_PILOTOS];
        fetchPerformanceFromDatabase();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 900, 600);
        panelContenido = new JPanel();
        panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        panelContenido.setBackground(new Color(242, 242, 242));
        setContentPane(panelContenido);
        panelContenido.setLayout(null);

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
        filasClasificacion = new JPanel[NUM_PILOTOS];
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

        JPanel panelClasificacion = new JPanel();
        panelClasificacion.setBounds(0, 11, 140, 466);
        panelClasificacion.setBackground(new Color(20, 20, 20));
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
            filasClasificacion[i].setBounds(0, 10 + (i * 20), 140, 20);
            filasClasificacion[i].setBackground(COLORES_EQUIPOS[i]);
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
            etiquetasNombrePiloto[i].setForeground(Color.WHITE);
            etiquetasNombrePiloto[i].setBounds(40, 0, 90, 20);
            filasClasificacion[i].add(etiquetasNombrePiloto[i]);
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

        Timer temporizador = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < NUM_PILOTOS; i++) {
                    if (!haTerminado[i]) {
                        double rendimiento = rendimientosPilotos[i]; // Use calculated team performance
                        int velocidadMaxima = (int) rendimiento; // Convert to int if necessary
                        int velocidad = aleatorio.nextInt(velocidadMaxima) + 1;
                        posicionesPilotos[i] += velocidad;
                        if (posicionesPilotos[i] >= X_FIN) {
                            vueltasCompletadas[i]++;
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
                    filasClasificacion[idx].setBounds(0, 10 + (i * 20), 140, 20);
                    etiquetasNombrePiloto[idx].setText(PILOTOS[idx]);
                }

                panelContenido.repaint();

                if (ordenLlegada.size() == NUM_PILOTOS) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        temporizador.start();
    }

    private void fetchPerformanceFromDatabase() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        Map<String, Double> teamPerformance = new HashMap<>();
        try {
            conexion.conectar();
            // Fetch team performance data
            String queryTeams = "SELECT Nombre, Potencia, Aerodinamica, Fiabilidad FROM equipo";
            ResultSet rsTeams = conexion.ejecutarSelect(queryTeams);
            while (rsTeams.next()) {
                String nombreEquipo = rsTeams.getString("Nombre");
                int potencia = rsTeams.getInt("Potencia");
                int aerodinamica = rsTeams.getInt("Aerodinamica");
                int fiabilidad = rsTeams.getInt("Fiabilidad");
                // Calculate performance as average of Potencia, Aerodinamica, and Fiabilidad
                double rendimiento = (potencia + aerodinamica + fiabilidad) / 3.0;
                teamPerformance.put(nombreEquipo, rendimiento);
                System.out.println("Team: " + nombreEquipo + ", Rendimiento: " + rendimiento);
            }

            // Map pilot performance based on team
            for (int i = 0; i < NUM_PILOTOS; i++) {
                String equipo = EQUIPOS[i];
                Double rendimiento = teamPerformance.getOrDefault(equipo, 5.0); // Default value if team not found
                rendimientosPilotos[i] = rendimiento;
                System.out.println("Pilot: " + PILOTOS[i] + ", Team: " + equipo + ", Rendimiento: " + rendimiento);
            }

            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar rendimientos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // Fallback to default values
            for (int i = 0; i < NUM_PILOTOS; i++) {
                rendimientosPilotos[i] = 5.0; // Default value
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