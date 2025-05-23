package Dao; // Paquete donde se encuentra la clase

import java.awt.BorderLayout; // Importa BorderLayout para disposición de componentes (aunque no se usa directamente aquí)
import java.awt.EventQueue; // Importa EventQueue para manejar la cola de eventos de la interfaz gráfica

import javax.swing.JFrame; // Importa JFrame para crear la ventana principal
import javax.swing.JPanel; // Importa JPanel para el contenedor de componentes
import javax.swing.border.EmptyBorder; // Importa EmptyBorder para márgenes (aunque no se usa directamente aquí)
import javax.swing.JTextField; // Importa JTextField para campos de texto (aunque no se usa directamente aquí)
import javax.swing.JButton; // Importa JButton para botones
import java.awt.event.ActionListener; // Importa ActionListener para manejar eventos de acción
import java.awt.event.ActionEvent; // Importa ActionEvent para eventos de botones
import java.awt.Color; // Importa Color para personalizar colores
import java.awt.Font; // Importa Font para personalizar fuentes
import java.awt.Graphics; // Importa Graphics para dibujo personalizado
import java.awt.Image; // Importa Image para manejar imágenes

import javax.swing.ImageIcon; // Importa ImageIcon para cargar imágenes
import javax.swing.JScrollPane; // Importa JScrollPane para barras de desplazamiento (aunque no se usa directamente aquí)
import java.awt.Toolkit; // Importa Toolkit para acceder a recursos del sistema
import javax.swing.border.LineBorder; // Importa LineBorder para bordes

public class App extends JFrame {

    private static final long serialVersionUID = 1L; // ID de serialización para la clase

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { // Ejecuta la interfaz gráfica en el hilo de eventos
            public void run() {
                try {
                    App frame = new App(); // Crea una instancia de la ventana
                    frame.setVisible(true); // Hace visible la ventana
                } catch (Exception e) {
                    e.printStackTrace(); // Imprime cualquier error en la consola
                }
            }
        });
    }

    // Crea el frame
    public App() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/image/logo_f1.png"))); // Establece el ícono de la ventana

        // Crea un panel personalizado con imagen de fondo
        JPanel contentPane = new JPanel() {
            private Image backgroundImage = new ImageIcon(App.class.getResource("/image/fondo.jpg")).getImage(); // Carga la imagen de fondo

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Llama al método padre
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo
            }
        };
        contentPane.setBorder(new LineBorder(new Color(128, 0, 0))); // Establece un borde rojo oscuro
        setContentPane(contentPane); // Asigna el panel como contenido de la ventana
        contentPane.setLayout(null); // Usa un layout nulo para posicionamiento manual
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setBounds(0, 0, 1900, 1000); // Establece las dimensiones y posición inicial (x, y, ancho, alto)
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Botón "Menú de Gestión"
        JButton btnNuevaSimulacion = new JButton("Menú de Gestión");
        btnNuevaSimulacion.setIcon(null); // Sin ícono adicional
        btnNuevaSimulacion.setFont(new Font("Verdana Pro", Font.PLAIN, 27)); // Fuente y tamaño
        btnNuevaSimulacion.setBackground(new Color(0, 0, 0)); // Fondo negro
        btnNuevaSimulacion.setForeground(new Color(255, 255, 255)); // Texto blanco
        btnNuevaSimulacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuDeGestion temp = new MenuDeGestion(); // Crea una nueva instancia de MenuDeGestion
                temp.setVisible(true); // Hace visible la nueva ventana
            }
        });
        btnNuevaSimulacion.setBounds(827, 635, 313, 108); // Posiciona el botón (x, y, ancho, alto)
        getContentPane().add(btnNuevaSimulacion); // Añade el botón al panel

        // Botón "Nueva Simulación"
        JButton btnMenuDeGestion = new JButton("Nueva Simulación");
        btnMenuDeGestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NuevaTemporada2007 temp = new NuevaTemporada2007(); // Crea una nueva instancia de NuevaTemporada2007
                temp.setVisible(true); // Hace visible la nueva ventana
            }
        });
        btnMenuDeGestion.setForeground(new Color(255, 255, 255)); // Texto blanco
        btnMenuDeGestion.setFont(new Font("Dialog", Font.PLAIN, 27)); // Fuente y tamaño
        btnMenuDeGestion.setBackground(new Color(0, 0, 0)); // Fondo negro
        btnMenuDeGestion.setBounds(827, 194, 313, 108); // Posiciona el botón (x, y, ancho, alto)
        contentPane.add(btnMenuDeGestion); // Añade el botón al panel
    }
}