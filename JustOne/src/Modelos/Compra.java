package Modelos;
import java.time.LocalDateTime;


public class Compra {
    private String clienteNombre;
    private Producto producto;
    private int cantidad;
    private LocalDateTime fechaCompra;
    private boolean enviada;

    public Compra(String clienteNombre, Producto producto, int cantidad) {
        this.clienteNombre = clienteNombre;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaCompra = LocalDateTime.now();
        this.enviada = false;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public boolean isEnviada() {
        return enviada;
    }

    public void setEnviada(boolean enviada) {
        this.enviada = enviada;
    }
}
