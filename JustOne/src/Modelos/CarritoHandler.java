package Modelos;
import javax.swing.*;


// Strategy Pattern: CarritoHandler maneja diferentes operaciones en el carrito
public class CarritoHandler {
    private ManejoCarrito carrito;

    public CarritoHandler(ManejoCarrito carrito) {
        this.carrito = carrito;
    }

    public void mostrarCarrito() {
        StringBuilder carritoContenido = new StringBuilder("Productos en el carrito:\n\n");
        int index = 0;
        for (Producto p : carrito.getProductos()) {
            carritoContenido.append(index++).append(") ")
                    .append(p.getNombre())
                    .append(" (Variación: ").append(p.getVariacion().getDescripcion()).append(")")
                    .append(" - ").append(p.getCantidad()).append(" unidades - $").append(p.getPrecio() * p.getCantidad()).append("\n");
        }
        carritoContenido.append("\nTotal: $").append(carrito.calcularTotal());
        JOptionPane.showMessageDialog(null, carritoContenido.toString());
    }

    public void eliminarProducto(int index) {
        carrito.eliminarProducto(index);
    }
}
