package Dao;

import java.awt.EventQueue; // Importa EventQueue para manejar la cola de eventos de la interfaz gráfica (no usado directamente)
import javax.swing.JFrame; // Importa JFrame para crear la ventana principal
import javax.swing.JPanel; // Importa JPanel para el contenedor de componentes
import javax.swing.border.EmptyBorder; // Importa EmptyBorder para márgenes en el panel
import javax.swing.JButton; // Importa JButton para botones
import javax.swing.JTextField; // Importa JTextField para campos de texto (no usado directamente)
import javax.swing.JLabel; // Importa JLabel para etiquetas de texto
import java.awt.Font; // Importa Font para personalizar fuentes
import java.awt.Image; // Importa Image para manejar imágenes
import javax.swing.ImageIcon; // Importa ImageIcon para cargar imágenes
import java.awt.event.ActionListener; // Importa ActionListener para manejar eventos de acción
import java.awt.event.ActionEvent; // Importa ActionEvent para eventos de botones
import java.awt.Color; // Importa Color para personalizar colores

/**
 * Clase que representa el menú principal de gestión para la aplicación de Fórmula 1.
 * Proporciona una interfaz gráfica con opciones para gestionar pilotos y equipos,
 * permitiendo al usuario abrir ventanas específicas para cada tipo de gestión.
 * 
 * @author Pangel
 * @version 1.0
 */
public class MenuDeGestion extends JFrame {

    private static final long serialVersionUID = 1L; // ID de serialización para la clase
    private JPanel contentPane; // Panel principal que contiene los componentes

    /**
     * Constructor de la clase MenuDeGestion.
     * Inicializa la ventana del menú de gestión, configurando el layout, el fondo,
     * los botones para gestionar pilotos y equipos, etiquetas de texto e íconos.
     */
    public MenuDeGestion() {
        // Configuración inicial de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al hacer clic en cerrar
        setBounds(0, 0, 800, 500); // Establece las dimensiones y posición inicial (x, y, ancho, alto)
        contentPane = new JPanel(); // Crea el panel principal
        contentPane.setBackground(new Color(242, 242, 242)); // Establece un fondo gris claro
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Añade márgenes de 5 píxeles alrededor del panel
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        setContentPane(contentPane); // Asigna el panel como contenido de la ventana
        contentPane.setLayout(null); // Usa un layout nulo para posicionamiento manual

        /**
         * Botón para abrir la ventana de gestión de pilotos.
         * Crea y muestra una nueva instancia de la clase VerPilotos.
         */
        JButton btnGestionarPilotos = new JButton("Gestionar Pilotos");
        btnGestionarPilotos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VerPilotos temp = new VerPilotos(); // Crea una nueva instancia de VerPilotos
                temp.setVisible(true); // Hace visible la ventana de gestión de pilotos
            }
        });
        btnGestionarPilotos.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Establece fuente y tamaño
        btnGestionarPilotos.setBounds(113, 180, 272, 54); // Posiciona el botón (x, y, ancho, alto)
        contentPane.add(btnGestionarPilotos); // Añade el botón al panel

        // Título del menú
        JLabel lblMenuGestion = new JLabel("MENÚ DE GESTIÓN");
        lblMenuGestion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 38)); // Establece fuente y tamaño
        lblMenuGestion.setBounds(200, 32, 394, 63); // Posiciona el título
        contentPane.add(lblMenuGestion); // Añade el título al panel

        /**
         * Botón para abrir la ventana de gestión de equipos.
         * Crea y muestra una nueva instancia de la clase GestionarEquipos.
         */
        JButton btnGestionarEquipos = new JButton("Gestionar Equipos");
        btnGestionarEquipos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestionarEquipos temp = new GestionarEquipos(); // Crea una nueva instancia de GestionarEquipos
                temp.setVisible(true); // Hace visible la ventana de gestión de equipos
            }
        });
        btnGestionarEquipos.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Establece fuente y tamaño
        btnGestionarEquipos.setBounds(113, 277, 272, 54); // Posiciona el botón
        contentPane.add(btnGestionarEquipos); // Añade el botón al panel

        // Etiqueta para mostrar el ícono del casco
        JLabel label_casco = new JLabel("");
        label_casco.setBounds(483, 180, 69, 54); // Posiciona la etiqueta
        contentPane.add(label_casco);

        // Carga y escala la imagen del casco de forma dinámica
        ImageIcon icon = new ImageIcon(MenuDeGestion.class.getResource("/image/Casco.png")); // Carga la imagen del casco
        Image img = icon.getImage().getScaledInstance(label_casco.getWidth(), label_casco.getHeight(), Image.SCALE_SMOOTH); // Escala la imagen al tamaño de la etiqueta
        label_casco.setIcon(new ImageIcon(img)); // Establece el ícono escalado

        // Etiqueta para mostrar el ícono del coche
        JLabel label_coche = new JLabel("");
        label_coche.setBounds(468, 269, 103, 77); // Posiciona la etiqueta
        contentPane.add(label_coche);

        // Carga y escala la imagen del coche de forma dinámica
        ImageIcon icon2 = new ImageIcon(MenuDeGestion.class.getResource("/image/Coche.png")); // Carga la imagen del coche
        Image img2 = icon2.getImage().getScaledInstance(label_coche.getWidth(), label_coche.getHeight(), Image.SCALE_SMOOTH); // Escala la imagen al tamaño de la etiqueta
        label_coche.setIcon(new ImageIcon(img2)); // Establece el ícono escalado

        // Carga la imagen del circuito (sin uso en la interfaz actual)
        ImageIcon icon3 = new ImageIcon(MenuDeGestion.class.getResource("/image/Track.png")); // Carga la imagen (sin asignar a ningún componente)
    }
}