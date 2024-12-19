package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import Modelos.*;

// Clase para la interfaz principal de la tienda
public class TiendaFrame extends JFrame {

    public TiendaFrame(Usuario usuario) {
        setTitle("Tienda Online");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Etiqueta de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido, " + usuario.getNombre(), JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Mostrar opciones dependiendo del tipo de usuario
        if (usuario instanceof Cliente) {
            mostrarOpcionesCliente(panel, (Cliente) usuario);
        } else if (usuario instanceof Administrador) {
            mostrarOpcionesAdministrador(panel);
        }

        add(panel);
        setVisible(true);
    }

    private void mostrarOpcionesCliente(JPanel panel, Cliente cliente) {
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new GridLayout(3, 1));

        JButton verProductosButton = new JButton("Ver Productos");
        JButton verCarritoButton = new JButton("Ver Carrito");
        JButton historialButton = new JButton("Ver Historial de Compras");

        opcionesPanel.add(verProductosButton);
        opcionesPanel.add(verCarritoButton);
        opcionesPanel.add(historialButton);

        panel.add(opcionesPanel, BorderLayout.CENTER);


        verCarritoButton.addActionListener(e -> {
            cliente.getCarrito().mostrarProductos();
        });


    }

    private void mostrarOpcionesAdministrador(JPanel panel) {
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new GridLayout(2, 1));

        JButton modificarProductosButton = new JButton("Modificar Productos");
        JButton verUsuariosButton = new JButton("Ver Usuarios");

        opcionesPanel.add(modificarProductosButton);
        opcionesPanel.add(verUsuariosButton);

        panel.add(opcionesPanel, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        // Crear un ejemplo de usuario cliente para probar
        Cliente cliente = new Cliente("Juan Perez", "juan@example.com", "123456789");
        cliente.getCarrito().agregarProducto(new Producto("Producto A", 10.0, 1));

        EventQueue.invokeLater(() -> new TiendaFrame(cliente));
    }
}
