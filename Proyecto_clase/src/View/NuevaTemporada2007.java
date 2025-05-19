package View;

// Importaciones necesarias para la interfaz gráfica, manejo de eventos, base de datos y otras utilidades
import java.awt.Color;
import java.awt.Font;
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
    // Versión serial para la serialización de la clase
    private static final long serialVersionUID = 1L;

    // Panel principal de la ventana
    private JPanel contentPane;
    // Arreglo de etiquetas para las carreras de la temporada
    private JLabel[] raceLabels;
    // Índice de la carrera actual, inicializado en -1 (sin carrera seleccionada)
    private int currentRaceIndex = -1;

    // Constructor de la clase que inicializa la ventana principal
    public NuevaTemporada2007() {
        // Configuración básica de la ventana: cierre al disponer y tamaño
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 800, 500);

        // Inicialización del panel de contenido con fondo gris claro y bordes
        contentPane = new JPanel();
        contentPane.setBackground(new Color(242, 242, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setContentPane(contentPane);
        contentPane.setLayout(null); // Layout nulo para posicionamiento manual

        // Inicialización del arreglo de etiquetas para las 11 carreras
        raceLabels = new JLabel[10];

        // Etiqueta vacía como placeholder (índice 0)

        // Etiquetas para cada Gran Premio con sus respectivas posiciones
        JLabel lblGPAustralia = new JLabel("Gran Premio de Albert Park");
        lblGPAustralia.setBounds(147, 139, 140, 14);
        contentPane.add(lblGPAustralia);
        raceLabels[0] = lblGPAustralia;

        JLabel lblRAustralia = new JLabel("R"); // Indicador de carrera
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

        // Botón para avanzar a la siguiente carrera
        JButton btnNewButton = new JButton("Avanzar a Carrera");
        btnNewButton.setBounds(478, 353, 157, 51);
        btnNewButton.addActionListener(e -> advanceToNextRace());
        contentPane.add(btnNewButton);

        // Botón para ver la clasificación
        JButton btnVerClasificacin = new JButton("Ver Clasificación");
        btnVerClasificacin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar una nueva ventana de clasificación
                verClasificacion temp = new verClasificacion();
                temp.setVisible(true);
            }
        });
        btnVerClasificacin.setBounds(292, 353, 157, 51);
        contentPane.add(btnVerClasificacin);

        // Botón para gestionar la temporada
        JButton btnNewButton_1_1 = new JButton("Gestionar Temporada");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar una nueva ventana de gestión de la FIA
                Fia temp = new Fia(NuevaTemporada2007.this);
                temp.setVisible(true);
            }
        });
        btnNewButton_1_1.setBounds(105, 353, 157, 51);
        contentPane.add(btnNewButton_1_1);

        // Título de la ventana
        JLabel lblNewLabel = new JLabel("Temporada 2007");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38));
        lblNewLabel.setBounds(205, 33, 318, 56);
        contentPane.add(lblNewLabel);

        // Etiqueta para la imagen de la FIA
        JLabel label_FIA = new JLabel("");
        label_FIA.setBounds(147, 286, 69, 62);
        contentPane.add(label_FIA);

        // Cargar y escalar la imagen de la FIA
        ImageIcon icon = new ImageIcon(MenuDeGestion.class.getResource("/image/FIA.png"));
        Image img = icon.getImage().getScaledInstance(label_FIA.getWidth(), label_FIA.getHeight(), Image.SCALE_SMOOTH);
        label_FIA.setIcon(new ImageIcon(img));

        // Etiqueta para la imagen del trofeo (clasificación)
        JLabel lblClasificacion = new JLabel("");
        lblClasificacion.setBounds(328, 286, 61, 56);
        contentPane.add(lblClasificacion);

        // Cargar y escalar la imagen del trofeo
        ImageIcon icon1 = new ImageIcon(MenuDeGestion.class.getResource("/image/Trofeo.png"));
        Image img1 = icon1.getImage().getScaledInstance(lblClasificacion.getWidth(), lblClasificacion.getHeight(), Image.SCALE_SMOOTH);
        lblClasificacion.setIcon(new ImageIcon(img1));

        // Etiqueta para la imagen de la carrera
        JLabel lblCarrera = new JLabel("New label");
        lblCarrera.setBounds(505, 294, 91, 51);
        contentPane.add(lblCarrera);

        // Cargar y escalar la imagen de la carrera
        ImageIcon icon2 = new ImageIcon(MenuDeGestion.class.getResource("/image/carrera.png"));
        Image img2 = icon2.getImage().getScaledInstance(lblCarrera.getWidth(), lblCarrera.getHeight(), Image.SCALE_SMOOTH);
        lblCarrera.setIcon(new ImageIcon(img2));

        // Cargar el estado de la temporada desde la base de datos
        loadSeasonState();

        // Listener para guardar el estado al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveSeasonState();
            }
        });
    }

    // Método para cargar el estado de la temporada desde la base de datos
    private void loadSeasonState() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "formula_1");
        try {
            conexion.conectar();
            String query = "SELECT indice_actual FROM carreras WHERE Año = 2007 LIMIT 1";
            ResultSet result = conexion.ejecutarSelect(query);
            if (result.next()) {
                currentRaceIndex = result.getInt("indice_actual");
                System.out.println("Estado cargado: currentRaceIndex = " + currentRaceIndex);
                // Restablecer el estilo de todas las etiquetas de carreras
                for (JLabel label : raceLabels) {
                    label.setOpaque(false);
                    label.setBackground(null);
                    label.setFont(new Font("Dialog", Font.PLAIN, 12));
                }
                // Resaltar la carrera actual si está dentro del rango
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

    // Método para guardar el estado de la temporada en la base de datos
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

    // Método para avanzar a la siguiente carrera
    private void advanceToNextRace() {
        if (currentRaceIndex == -1) {
            currentRaceIndex = 0; // Comenzar desde la primera carrera
        } else if (currentRaceIndex < raceLabels.length - 1) {
            currentRaceIndex++; // Avanzar a la siguiente carrera
        } else {
            currentRaceIndex = 0; // Reiniciar al inicio y mostrar al campeón
            mostrarCampeonYReiniciarPuntos();
        }

        // Restaurar el estilo de la carrera anterior
        if (currentRaceIndex > 0) {
            raceLabels[currentRaceIndex - 1].setOpaque(false);
            raceLabels[currentRaceIndex - 1].setBackground(null);
            raceLabels[currentRaceIndex - 1].setFont(new Font("Dialog", Font.PLAIN, 12));
        }

        // Resaltar la nueva carrera
        raceLabels[currentRaceIndex].setOpaque(true);
        raceLabels[currentRaceIndex].setBackground(new Color(173, 216, 230));
        raceLabels[currentRaceIndex].setFont(new Font("Dialog", Font.BOLD, 12));

        // Abrir la ventana de la nueva carrera
        new RaceWindow(raceLabels[currentRaceIndex].getText()).setVisible(true);

        // Guardar el estado actual
        saveSeasonState();
    }

    // Método para mostrar al campeón y reiniciar los puntos al final de la temporada
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

            // Reiniciar los puntos de todos los pilotos
            String resetQuery = "UPDATE piloto SET Puntos = 0";
            conexion.ejecutarInsertDeleteUpdate(resetQuery);
            System.out.println("Puntos reiniciados para la próxima temporada.");
            conexion.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al determinar el campeón o reiniciar puntos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para refrescar el estado de la temporada
    public void refreshSeasonState() {
        loadSeasonState();
        contentPane.repaint();
    }

    // Clase interna para la ventana de la carrera
    public class RaceWindow extends JFrame {
        private static final long serialVersionUID = 1L;
        private JPanel panelContenido; // Panel de contenido de la ventana de carrera
        private JPanel[] puntosPilotos; // Arreglo de paneles para representar a los pilotos
        private int[] posicionesPilotos; // Posiciones actuales de los pilotos
        private JLabel[] etiquetasPosicion; // Etiquetas para mostrar posiciones y puntos
        private JLabel[] etiquetasPosicionEnVivo; // Etiquetas para posiciones en tiempo real
        private JLabel[] etiquetasNombrePiloto; // Etiquetas con nombres de pilotos
        private JLabel[] etiquetasVueltas; // Etiquetas para mostrar vueltas completadas
        private JPanel[] filasClasificacion; // Filas de la clasificación
        private JPanel[] panelesColorEquipo; // Paneles de color por equipo
        private boolean[] haTerminado; // Indicador de si un piloto ha terminado
        private ArrayList<Integer> ordenLlegada; // Orden de llegada de los pilotos
        private int[] vueltasCompletadas; // Vueltas completadas por cada piloto
        private static final int X_INICIO = 250; // Posición inicial en X
        private static final int X_FIN = 800; // Posición final en X (meta)
        private static final int Y_POSICION = 100; // Posición inicial en Y
        private static final int TAMANO_PUNTO = 10; // Tamaño de los puntos que representan pilotos
        private static final int NUM_PILOTOS = 22; // Número total de pilotos
        private static final int TOTAL_VUELTAS = 3; // Número total de vueltas
        private JLabel lblNewLabel; // Etiqueta placeholder
        private JLabel etiquetaVueltasCarrera; // Etiqueta para mostrar la vuelta actual

        private double[] currentYSquares; // Posiciones actuales Y de los puntos
        private double[] targetYSquares; // Posiciones objetivo Y de los puntos
        private double[] currentYRows; // Posiciones actuales Y de las filas
        private double[] targetYRows; // Posiciones objetivo Y de las filas
        private double[] currentYPoints; // Posiciones actuales Y de las etiquetas
        private double[] targetYPoints; // Posiciones objetivo Y de las etiquetas
        private static final int ANIMATION_DURATION = 500; // Duración de la animación en ms
        private static final int ANIMATION_STEP_TIME = 20; // Intervalo de tiempo de la animación
        private double animationProgress; // Progreso de la animación

        private Map<String, Integer> puntosPorPiloto = new HashMap<>(); // Mapa de puntos por piloto

        // Arreglo de IDs de pilotos
        private static final String[] PILOT_IDS = {
            "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8",
            "P9", "P10", "P11", "P12", "P13", "P14", "P15", "P16",
            "P17", "P18", "P19", "P20", "P21", "P22"
        };
        private String[] PILOTOS; // Nombres de los pilotos
        private String[] EQUIPOS; // Equipos de los pilotos

        // Colores asignados a los equipos
        private static final Color[] COLORES_EQUIPOS = {
            new Color(200, 200, 200), new Color(200, 200, 200), new Color(220, 0, 0), new Color(220, 0, 0),
            new Color(0, 153, 0), new Color(0, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 204, 0), new Color(255, 204, 0),
            new Color(255, 0, 0), new Color(255, 0, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 153, 0), new Color(255, 153, 0), new Color(0, 102, 204), new Color(0, 102, 204),
            new Color(255, 140, 0), new Color(255, 140, 0)
        };
        private int[] PUNTUACIONES_RENDIMIENTO; // Puntuaciones de rendimiento de los pilotos

        // Constructor de la ventana de carrera
        public RaceWindow(String nombreCarrera) {
            // Configuración básica de la ventana
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(0, 0, 900, 600);
            panelContenido = new JPanel();
            panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);

            // Configuración del fondo y layout del panel
            panelContenido.setBackground(new Color(230, 230, 250));
            setContentPane(panelContenido);
            panelContenido.setLayout(null);

            // Inicialización de arreglos para pilotos, equipos y rendimientos
            PILOTOS = new String[NUM_PILOTOS];
            EQUIPOS = new String[NUM_PILOTOS];
            PUNTUACIONES_RENDIMIENTO = new int[NUM_PILOTOS];

            // Cargar datos de pilotos y equipos, y calcular rendimientos
            fetchPilotAndTeamData();
            calculatePerformance();

            // Etiqueta con el nombre de la carrera
            JLabel etiquetaTituloCarrera = new JLabel(nombreCarrera);
            etiquetaTituloCarrera.setFont(new Font("Arial", Font.BOLD, 24));
            etiquetaTituloCarrera.setForeground(new Color(25, 25, 112));
            etiquetaTituloCarrera.setBounds(350, 34, 500, 30);
            panelContenido.add(etiquetaTituloCarrera);

            // Botón para cerrar la ventana
            JButton botonCerrar = new JButton("Cerrar");
            botonCerrar.setBounds(300, 520, 100, 30);
            botonCerrar.setFont(new Font("Arial", Font.BOLD, 12));
            botonCerrar.setBackground(new Color(70, 130, 180));
            botonCerrar.setForeground(Color.WHITE);
            botonCerrar.addActionListener(e -> dispose());
            panelContenido.add(botonCerrar);

            // Inicialización de arreglos para la interfaz de la carrera
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

            // Inicialización de arreglos para animación
            currentYSquares = new double[NUM_PILOTOS];
            targetYSquares = new double[NUM_PILOTOS];
            currentYRows = new double[NUM_PILOTOS];
            targetYRows = new double[NUM_PILOTOS];
            currentYPoints = new double[NUM_PILOTOS];
            targetYPoints = new double[NUM_PILOTOS];
            animationProgress = 1.0;

            // Configurar posiciones iniciales para la animación
            for (int i = 0; i < NUM_PILOTOS; i++) {
                puntosPorPiloto.put(PILOT_IDS[i], 0);
                currentYSquares[i] = Y_POSICION + (i * 20);
                targetYSquares[i] = Y_POSICION + (i * 20);
                currentYRows[i] = i * 20;
                targetYRows[i] = i * 20;
                currentYPoints[i] = Y_POSICION + (i * 20) - 5;
                targetYPoints[i] = Y_POSICION + (i * 20) - 5;
            }

            // Etiquetas placeholder
            lblNewLabel = new JLabel();
            lblNewLabel.setBounds(0, 0, 0, 0);
            panelContenido.add(lblNewLabel);

            // Etiqueta para mostrar las vueltas de la carrera
            etiquetaVueltasCarrera = new JLabel("Vuelta 0/" + TOTAL_VUELTAS);
            etiquetaVueltasCarrera.setFont(new Font("Arial", Font.BOLD, 14));
            etiquetaVueltasCarrera.setForeground(Color.WHITE);
            etiquetaVueltasCarrera.setBounds(5, 70, 200, 20);
            etiquetaVueltasCarrera.setOpaque(true);
            etiquetaVueltasCarrera.setBackground(Color.BLACK);
            panelContenido.add(etiquetaVueltasCarrera);

            // Panel de clasificación
            JPanel panelClasificacion = new JPanel();
            panelClasificacion.setBounds(5, Y_POSICION, 200, 440);
            panelClasificacion.setBackground(Color.BLACK);
            panelClasificacion.setOpaque(true);
            panelClasificacion.setLayout(null);
            panelContenido.add(panelClasificacion);

            // Configuración de los elementos de la clasificación para cada piloto
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
                etiquetasNombrePiloto[i].setFont(new Font("Arial", Font.BOLD, 12));
                etiquetasNombrePiloto[i].setForeground(Color.WHITE);
                etiquetasNombrePiloto[i].setBounds(40, 2, 120, 16);
                filasClasificacion[i].add(etiquetasNombrePiloto[i]);

                panelesColorEquipo[i] = new JPanel();
                panelesColorEquipo[i].setBounds(160, 2, 16, 16);
                panelesColorEquipo[i].setBackground(COLORES_EQUIPOS[i]);
                panelesColorEquipo[i].setOpaque(true);
                filasClasificacion[i].add(panelesColorEquipo[i]);

                etiquetasVueltas[i] = new JLabel("0/" + TOTAL_VUELTAS);
                etiquetasVueltas[i].setFont(new Font("Arial", Font.BOLD, 10));
                etiquetasVueltas[i].setForeground(Color.WHITE);
                etiquetasVueltas[i].setBounds(180, 2, 20, 16);
                filasClasificacion[i].add(etiquetasVueltas[i]);
            }

            // Etiqueta de la línea de meta
            JLabel lineaMeta = new JLabel("META");
            lineaMeta.setBounds(X_FIN - 20, Y_POSICION - 20, 40, 20);
            lineaMeta.setFont(new Font("Arial", Font.BOLD, 12));
            lineaMeta.setForeground(Color.RED);
            panelContenido.add(lineaMeta);

            // Establecer el orden de los componentes (clasificación detrás)
            panelContenido.setComponentZOrder(panelClasificacion, 0);

            // Temporizador para la animación de la carrera
            Timer temporizador = new Timer(ANIMATION_STEP_TIME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Actualizar las posiciones de los pilotos
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

                    // Actualizar la etiqueta de vueltas de la carrera
                    int vueltaMaxima = Arrays.stream(vueltasCompletadas).max().getAsInt();
                    etiquetaVueltasCarrera.setText("Vuelta " + vueltaMaxima + "/" + TOTAL_VUELTAS);

                    // Ordenar los pilotos según su posición
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

                    // Actualizar las posiciones visuales de los elementos
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

                    // Manejar la progresión de la animación
                    if (animationProgress >= 1.0) {
                        animationProgress = 0.0;
                    }
                    animationProgress += (double)ANIMATION_STEP_TIME / ANIMATION_DURATION;
                    if (animationProgress > 1.0) {
                        animationProgress = 1.0;
                    }

                    // Actualizar las posiciones animadas
                    for (int i = 0; i < NUM_PILOTOS; i++) {
                        currentYSquares[i] += (targetYSquares[i] - currentYSquares[i]) * animationProgress;
                        currentYRows[i] += (targetYRows[i] - currentYRows[i]) * animationProgress;
                        currentYPoints[i] += (targetYPoints[i] - currentYPoints[i]) * animationProgress;
                        puntosPilotos[i].setLocation(posicionesPilotos[i], (int)currentYSquares[i]);
                        filasClasificacion[i].setBounds(0, (int)currentYRows[i], 200, 20);
                        etiquetasPosicion[i].setBounds(X_FIN + 10, (int)currentYPoints[i], 50, 20);
                    }

                    // Acción al terminar la carrera
                    if (ordenLlegada.size() == NUM_PILOTOS) {
                        for (int i = 0; i < NUM_PILOTOS; i++) {
                            int pilotIndex = ordenLlegada.get(i);
                            int position = i + 1;
                            int puntos = obtenerPuntosPorPosicion(position);
                            puntosPorPiloto.put(PILOT_IDS[pilotIndex], puntos);
                            etiquetasPosicion[pilotIndex].setText(position + " + " + puntos);
                        }

                        // Guardar puntos automáticamente
                        guardarPuntosAutomaticamente();

                        // Mostrar el podio
                        mostrarPodio();

                        // Agregar botón para la siguiente carrera
                        JButton btnSiguienteCarrera = new JButton("Siguiente Carrera");
                        btnSiguienteCarrera.setBounds(450, 520, 150, 30);
                        btnSiguienteCarrera.setFont(new Font("Arial", Font.BOLD, 12));
                        btnSiguienteCarrera.setBackground(new Color(70, 130, 180));
                        btnSiguienteCarrera.setForeground(Color.WHITE);
                        btnSiguienteCarrera.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                dispose(); // Cerrar la ventana actual
                                NuevaTemporada2007.this.advanceToNextRace(); // Avanzar a la siguiente carrera
                            }
                        });
                        panelContenido.add(btnSiguienteCarrera);

                        // Detener el temporizador
                        ((Timer)e.getSource()).stop();
                    }

                    // Repintar el panel para reflejar los cambios
                    panelContenido.repaint();
                }
            });
            temporizador.start(); // Iniciar la animación
        }

        // Método para guardar los puntos automáticamente en la base de datos
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

        // Método para mostrar el podio al final de la carrera
        private void mostrarPodio() {
            JFrame podioFrame = new JFrame("Podio - " + lblNewLabel.getText());
            podioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            podioFrame.setBounds(0, 0, 300, 200);
            podioFrame.setLocationRelativeTo(null);
            JPanel podioPanel = new JPanel();
            podioPanel.setLayout(null);
            podioPanel.setBackground(new Color(230, 230, 250));

            // Etiquetas para los tres primeros lugares
            JLabel lblPos1 = new JLabel("1. " + PILOTOS[ordenLlegada.get(0)]);
            lblPos1.setFont(new Font("Arial", Font.BOLD, 16));
            lblPos1.setBounds(100, 20, 200, 20);
            podioPanel.add(lblPos1);

            JLabel lblPos2 = new JLabel("2. " + PILOTOS[ordenLlegada.get(1)]);
            lblPos2.setFont(new Font("Arial", Font.BOLD, 14));
            lblPos2.setBounds(100, 60, 200, 20);
            podioPanel.add(lblPos2);

            JLabel lblPos3 = new JLabel("3. " + PILOTOS[ordenLlegada.get(2)]);
            lblPos3.setFont(new Font("Arial", Font.BOLD, 14));
            lblPos3.setBounds(100, 100, 200, 20);
            podioPanel.add(lblPos3);

            podioFrame.setContentPane(podioPanel);
            podioFrame.setVisible(true);
        }

        // Método para cargar datos de pilotos y equipos desde la base de datos
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

        // Método para calcular el rendimiento de los pilotos
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

                // Normalizar los rendimientos
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

        // Método para obtener puntos según la posición
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