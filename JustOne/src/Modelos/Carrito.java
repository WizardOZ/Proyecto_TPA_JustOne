package Modelos;
import java.util.ArrayList;
import java.util.List;
public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (Producto p : productos) {
                System.out.println(p.getNombre() + " - " + p.getCantidad() + " unidades");
            }
        }
    }
}