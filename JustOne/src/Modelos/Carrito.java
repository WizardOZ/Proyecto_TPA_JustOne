package Modelos;
import java.util.ArrayList;
import java.util.List;


public class Carrito implements ManejoCarrito {
    private List<Producto> productos = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
        }
    }

    @Override
    public double calcularTotal() {
        return productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
    }

    public List<Producto> getProductos() {
        return productos;
    }


    public void vaciarCarrito() {
        productos.clear();
    }
}
