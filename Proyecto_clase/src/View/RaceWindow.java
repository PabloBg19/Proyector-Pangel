package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.sql.SQLException;

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

    // Map to store points for each pilot using their ID
    private Map<String, Integer> puntosPorPiloto = new HashMap<>();

    // Pilotos de la tabla proporcionada (ordenado según la nueva imagen)
    private static final String[] PILOTOS = {
    	    "Fernando Alonso", "Lewis Hamilton", "Kimi Räikkönen", "Felipe Massa",
    	    "Giancarlo Fisichella", "Heikki Kovalainen", "Nick Heidfeld", "Robert Kubica",
    	    "Nico Rosberg", "Alexander Wurz", "Rubens Barrichello", "Jenson Button",
    	    "David Coulthard", "Mark Webber", "Ralf Schumacher", "Jarno Trulli",
    	    "Anthony Davidson", "Takuma Sato", "Vitantonio Liuzzi", "Scott Speed"
    	};
    	// IDs de los pilotos (P1 a P20) según la tabla
    	private static final String[] PILOT_IDS = {
    	    "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8",
    	    "P9", "P10", "P11", "P12", "P13", "P14", "P15", "P16",
    	    "P17", "P18", "P19", "P20"
    	};
    	private static final Color[] COLORES_EQUIPOS = {
    	    new Color(200, 200, 200), // McLaren (Fernando Alonso)
    	    new Color(200, 200, 200), // McLaren (Lewis Hamilton)
    	    new Color(220, 0, 0),     // Ferrari (Kimi Räikkönen)
    	    new Color(220, 0, 0),     // Ferrari (Felipe Massa)
    	    new Color(0, 153, 0),     // Renault (Giancarlo Fisichella)
    	    new Color(0, 153, 0),     // Renault (Heikki Kovalainen)
    	    new Color(0, 102, 204),   // BMW Sauber (Nick Heidfeld)
    	    new Color(0, 102, 204),   // BMW Sauber (Robert Kubica)
    	    new Color(255, 255, 255), // Williams (Nico Rosberg)
    	    new Color(255, 255, 255), // Williams (Alexander Wurz)
    	    new Color(255, 204, 0),   // Honda (Rubens Barrichello)
    	    new Color(255, 204, 0),   // Honda (Jenson Button)
    	    new Color(255, 0, 0),     // Red Bull (David Coulthard)
    	    new Color(255, 0, 0),     // Red Bull (Mark Webber)
    	    new Color(0, 102, 204),   // Toyota (Ralf Schumacher)
    	    new Color(0, 102, 204),   // Toyota (Jarno Trulli)
    	    new Color(255, 153, 0),   // Super Aguri (Anthony Davidson)
    	    new Color(255, 153, 0),   // Super Aguri (Takuma Sato)
    	    new Color(0, 102, 204),   // Toro Rosso (Vitantonio Liuzzi)
    	    new Color(0, 102, 204)    // Toro Rosso (Scott Speed)
    	};
    	private static final int[] PUNTUACIONES_RENDIMIENTO = {
    	    10, 10, 10, 9, 6, 6, 7, 7,
    	    6, 5, 3, 3, 5, 5, 4, 4,
    	    3, 3, 3, 3
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

        // Etiqueta del título
        JLabel etiquetaTituloCarrera = new JLabel(nombreCarrera);
        etiquetaTituloCarrera.setFont(new Font("Arial", Font.BOLD, 24));
        etiquetaTituloCarrera.setBounds(300, 20, 300, 40);
        panelContenido.add(etiquetaTituloCarrera);

        // Botón de cerrar
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.setBounds(400, 500, 100, 30);
        botonCerrar.addActionListener(e -> dispose());
        panelContenido.add(botonCerrar);

        // Inicializar arrays y variables
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

        // Inicializar puntos para cada piloto
        for (int i = 0; i < NUM_PILOTOS; i++) {
            puntosPorPiloto.put(PILOT_IDS[i], 0);
        }

        // Inicializar y posicionar el JLabel
        lblNewLabel = new JLabel();
        lblNewLabel.setBounds(752, 461, 46, 14);
        panelContenido.add(lblNewLabel);

        // Panel de clasificación
        JPanel panelClasificacion = new JPanel();
        panelClasificacion.setBounds(10, 80, 140, 440);
        panelClasificacion.setBackground(new Color(20, 20, 20));
        panelClasificacion.setLayout(null);
        panelContenido.add(panelClasificacion);

        // Inicializar pilotos y clasificación
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

        // Línea de meta
        JLabel lineaMeta = new JLabel("META");
        lineaMeta.setBounds(X_FIN - 20, Y_POSICION - 20, 40, 20);
        lineaMeta.setFont(new Font("Arial", Font.BOLD, 12));
        lineaMeta.setForeground(Color.RED);
        panelContenido.add(lineaMeta);

        // Botón GUARDAR
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
        btnNewButton.setBounds(576, 500, 100, 27);
        panelContenido.add(btnNewButton);

        // Temporizador para la animación
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

                // Ordenar la clasificación en tiempo real
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

                // Actualizar la clasificación visual
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RaceWindow ventana = new RaceWindow("Gran Premio 2007");
                ventana.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}