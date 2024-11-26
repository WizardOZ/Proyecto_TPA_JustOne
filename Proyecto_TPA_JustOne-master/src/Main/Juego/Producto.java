package Juego;

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private String descripcion;

    // Constructor
    public Producto(String nombre, String categoria, double precio, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
    }


    public double getPrecio() {
        return precio;
    }


    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
