package Modelos;
import java.util.ArrayList;
import java.util.List;


// La clase Tienda es un Singleton, asegurando que solo exista una instancia de la tienda en todo el programa
public class Tienda {
    private static Tienda instancia;
    private Producto producto;

    private Tienda() {
        inicializarProducto();
    }

    public static Tienda getInstancia() {
        if (instancia == null) {
            instancia = new Tienda();
        }
        return instancia;
    }

    private void inicializarProducto() {
        this.producto = new Producto("JustOne", 33.0, 1, Variacion.COLOR_ESTANDAR);
    }

    public Producto getProducto() {
        return producto;
    }

    public List<String> getVariaciones() {
        List<String> variaciones = new ArrayList<>();
        for (Variacion v : Variacion.values()) {
            variaciones.add(v.getDescripcion());
        }
        return variaciones;
    }

    public double getPrecioVariacion(String variacion) {
        if (variacion.equals(Variacion.EDICION_LIMITADA.getDescripcion())) {
            return 333.0;
        }
        return 33.0;
    }
}
