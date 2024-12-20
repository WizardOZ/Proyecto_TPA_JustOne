package InterfazGrafica;
import Modelos.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

// Interfaz gráfica para Administrador
public class AdminFrame extends JFrame {

    private List<Compra> compras;

    public AdminFrame(Administrador admin, List<Compra> compras) {
        this.compras = compras;

        setTitle("Panel de Administrador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Encabezado
        JLabel header = new JLabel("Bienvenido, " + admin.getNombre(), JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(header, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton verDineroButton = new JButton("Ver Dinero Acumulado");
        JButton verEnviosButton = new JButton("Ver Envíos Pendientes");
        JButton modificarProductosButton = new JButton("Modificar Productos");

        verDineroButton.addActionListener(e -> mostrarDineroAcumulado());
        verEnviosButton.addActionListener(e -> mostrarEnviosPendientes());
        modificarProductosButton.addActionListener(e -> modificarProductos());

        buttonPanel.add(verDineroButton);
        buttonPanel.add(verEnviosButton);
        buttonPanel.add(modificarProductosButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void mostrarDineroAcumulado() {
        double total = compras.stream().mapToDouble(c -> c.getProducto().getPrecio() * c.getCantidad()).sum();
        JOptionPane.showMessageDialog(this, "Dinero acumulado: $" + total, "Dinero Acumulado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarEnviosPendientes() {
        StringBuilder envios = new StringBuilder("Envíos Pendientes:\n\n");
        for (Compra compra : compras) {
            if (!compra.isEnviada()) {
                envios.append("Cliente: ").append(compra.getClienteNombre())
                        .append(" - Producto: ").append(compra.getProducto().getNombre())
                        .append(" - Cantidad: ").append(compra.getCantidad())
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, envios.toString(), "Envíos Pendientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificarProductos() {
        JOptionPane.showMessageDialog(this, "Función para modificar productos en construcción.", "Modificar Productos", JOptionPane.INFORMATION_MESSAGE);
    }
}
