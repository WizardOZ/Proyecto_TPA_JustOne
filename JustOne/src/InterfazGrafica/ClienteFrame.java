package InterfazGrafica;
import Modelos.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ClienteFrame extends JFrame {

    private Cliente cliente;

    public ClienteFrame(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Tienda Online - Cliente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Encabezado
        JLabel header = new JLabel("Bienvenido, " + cliente.getNombre(), JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(header, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton verProductosButton = new JButton("Ver Productos");
        JButton verCarritoButton = new JButton("Ver Carrito");
        JButton verComprasPendientesButton = new JButton("Ver Compras Pendientes");

        verProductosButton.addActionListener(e -> verProductos());
        verCarritoButton.addActionListener(e -> verCarrito());
        verComprasPendientesButton.addActionListener(e -> verComprasPendientes());

        buttonPanel.add(verProductosButton);
        buttonPanel.add(verCarritoButton);
        buttonPanel.add(verComprasPendientesButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void verProductos() {
        JOptionPane.showMessageDialog(this, "Función para ver productos en construcción.", "Ver Productos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verCarrito() {
        StringBuilder carritoContenido = new StringBuilder("Contenido del Carrito:\n\n");
        int index = 0;
        for (Producto p : cliente.getCarrito().getProductos()) {
            carritoContenido.append(index++).append(") ")
                    .append(p.getNombre()).append(" - $")
                    .append(p.getPrecio()).append(" - Cantidad: ")
                    .append(p.getCantidad()).append("\n");
        }
        carritoContenido.append("\nTotal: $").append(cliente.getCarrito().calcularTotal());
        JOptionPane.showMessageDialog(this, carritoContenido.toString(), "Carrito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verComprasPendientes() {
        JOptionPane.showMessageDialog(this, "Función para ver compras pendientes en construcción.", "Compras Pendientes", JOptionPane.INFORMATION_MESSAGE);
    }
}