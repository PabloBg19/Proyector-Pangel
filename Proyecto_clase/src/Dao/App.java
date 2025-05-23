package Dao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase principal que representa la ventana inicial de la aplicación de gestión de Fórmula 1.
 * Muestra un menú con opciones para acceder al "Menú de Gestión" y a la "Nueva Simulación".
 * Utiliza un panel personalizado con una imagen de fondo y un diseño centrado en la pantalla.
 * 
 * @author Pangel
 * @version 1.0
 */
public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Punto de entrada de la aplicación.
     * Inicia la interfaz gráfica en el hilo de eventos de Swing para garantizar una ejecución segura.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor de la clase App.
     * Inicializa y configura la ventana principal con un panel personalizado que incluye
     * una imagen de fondo, un ícono de ventana y dos botones para navegar a otras ventanas
     * ("Menú de Gestión" y "Nueva Simulación").
     */
    public App() {
        // Establece el ícono de la ventana
        setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/image/logo_f1.png")));

        // Crea un panel personalizado con imagen de fondo
        JPanel contentPane = new JPanel() {
            private Image backgroundImage = new ImageIcon(App.class.getResource("/image/fondo.jpg")).getImage();

            /**
             * Sobrescribe el método paintComponent para dibujar la imagen de fondo.
             * Ajusta la imagen al tamaño del panel.
             * 
             * @param g El objeto Graphics usado para dibujar.
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new LineBorder(new Color(128, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1900, 1000);
        setLocationRelativeTo(null);

        /**
         * Botón para abrir el "Menú de Gestión".
         * Al hacer clic, crea y muestra una nueva ventana de la clase MenuDeGestion.
         */
        JButton btnNuevaSimulacion = new JButton("Menú de Gestión");
        btnNuevaSimulacion.setFont(new Font("Verdana Pro", Font.PLAIN, 27));
        btnNuevaSimulacion.setBackground(new Color(0, 0, 0));
        btnNuevaSimulacion.setForeground(new Color(255, 255, 255));
        btnNuevaSimulacion.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Menú de Gestión".
             * Abre una nueva ventana de la clase MenuDeGestion.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            public void actionPerformed(ActionEvent e) {
                MenuDeGestion temp = new MenuDeGestion();
                temp.setVisible(true);
            }
        });
        btnNuevaSimulacion.setBounds(827, 635, 313, 108);
        contentPane.add(btnNuevaSimulacion);

        /**
         * Botón para iniciar una "Nueva Simulación".
         * Al hacer clic, crea y muestra una nueva ventana de la clase NuevaTemporada2007.
         */
        JButton btnMenuDeGestion = new JButton("Nueva Simulación");
        btnMenuDeGestion.addActionListener(new ActionListener() {
            /**
             * Maneja el evento de clic en el botón "Nueva Simulación".
             * Abre una nueva ventana de la clase NuevaTemporada2007.
             * 
             * @param e El evento de acción generado al hacer clic en el botón.
             */
            public void actionPerformed(ActionEvent e) {
                NuevaTemporada2007 temp = new NuevaTemporada2007();
                temp.setVisible(true);
            }
        });
        btnMenuDeGestion.setForeground(new Color(255, 255, 255));
        btnMenuDeGestion.setFont(new Font("Dialog", Font.PLAIN, 27));
        btnMenuDeGestion.setBackground(new Color(0, 0, 0));
        btnMenuDeGestion.setBounds(827, 194, 313, 108);
        contentPane.add(btnMenuDeGestion);
    }
}