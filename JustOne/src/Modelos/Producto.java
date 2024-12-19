package Modelos;
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private Variacion variacion;

    public Producto(String nombre, double precio, int cantidad, Variacion variacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.variacion = variacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Variacion getVariacion() {
        return variacion;
    }

    public void setVariacion(Variacion variacion) {
        this.variacion = variacion;
    }
}
