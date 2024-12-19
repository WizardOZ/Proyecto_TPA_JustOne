package Modelos;
import java.util.List;

// Interface ManejoCarrito
public interface ManejoCarrito {
    void agregarProducto(Producto producto);
    void eliminarProducto(int index);
    double calcularTotal();

    List<Producto> getProductos();
}