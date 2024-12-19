package InterfazGrafica;


import javax.swing.*;
import java.awt.*;
import Modelos.*;

// Clase para la interfaz principal de la tienda
public class TiendaFrame extends JFrame {

    private Cliente cliente;
    private Tienda tienda;
    private CarritoHandler carritoHandler;

    public TiendaFrame(Cliente cliente) {
        this.cliente = cliente;
        this.tienda = Tienda.getInstancia();
        this.carritoHandler = new CarritoHandler(cliente.getCarrito()); // Strategy Pattern

        setTitle("Tienda Online - JustOne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Panel principal con diseño tipo web
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Encabezado
        JLabel headerLabel = new JLabel("Bienvenido a la Tienda Online - JustOne", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        headerLabel.setOpaque(true);
        headerLabel.setBackground(new Color(0, 102, 204));
        headerLabel.setForeground(Color.WHITE);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Panel de contenido principal
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton verProductosButton = new JButton("Ver Productos");
        JButton verCarritoButton = new JButton("Ver Carrito");
        JButton eliminarProductoButton = new JButton("Eliminar Producto del Carrito");

        verProductosButton.addActionListener(e -> mostrarProductos());
        verCarritoButton.addActionListener(e -> mostrarCarrito());
        eliminarProductoButton.addActionListener(e -> eliminarProductoCarrito());

        contentPanel.add(verProductosButton);
        contentPanel.add(verCarritoButton);
        contentPanel.add(eliminarProductoButton);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Pie de página
        JLabel footerLabel = new JLabel("© 2024 Tienda Online - JustOne. Todos los derechos reservados.", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        // Añadir el panel principal a la ventana
        add(mainPanel);
        setVisible(true);
    }

    private void mostrarProductos() {
        Producto producto = tienda.getProducto();
        StringBuilder productoInfo = new StringBuilder("Producto disponible:\n");
        productoInfo.append(producto.getNombre())
                .append("\nPrecio base: $33.00\n");
        productoInfo.append("Variaciones disponibles:\n");

        for (String variacion : tienda.getVariaciones()) {
            double precio = tienda.getPrecioVariacion(variacion);
            productoInfo.append("- ").append(variacion).append(" ($").append(precio).append(")\n");
        }

        int seleccion = JOptionPane.showOptionDialog(this,
                productoInfo.toString(),
                "Ver Producto",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                tienda.getVariaciones().toArray(),
                null);

        if (seleccion >= 0) {
            String seleccionVariacion = tienda.getVariaciones().get(seleccion);
            Variacion variacionEnum = getVariacionEnumByDescripcion(seleccionVariacion);
            if (variacionEnum != null) {
                double precio = tienda.getPrecioVariacion(seleccionVariacion);
                Producto nuevoProducto = new Producto(producto.getNombre(), precio, 1, variacionEnum);
                cliente.getCarrito().agregarProducto(nuevoProducto);
                JOptionPane.showMessageDialog(this, "Producto añadido al carrito con la variación: " + seleccionVariacion);
            } else {
                JOptionPane.showMessageDialog(this, "Error: Variación seleccionada no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarCarrito() {
        carritoHandler.mostrarCarrito();
    }

    private void eliminarProductoCarrito() {
        String indiceStr = JOptionPane.showInputDialog(this, "Ingrese el índice del producto a eliminar:");
        if (indiceStr != null && !indiceStr.isEmpty()) {
            try {
                int index = Integer.parseInt(indiceStr);
                carritoHandler.eliminarProducto(index);
                JOptionPane.showMessageDialog(this, "Producto eliminado del carrito.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El índice ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(this, "El índice ingresado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Variacion getVariacionEnumByDescripcion(String descripcion) {
        for (Variacion v : Variacion.values()) {
            if (v.getDescripcion().equals(descripcion)) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Juan Perez", "juan@example.com", "123456789");
        EventQueue.invokeLater(() -> new TiendaFrame(cliente));

    }
}



