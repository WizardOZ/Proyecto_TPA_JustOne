package Modelos;

public class Cliente extends Usuario {
    private Carrito carrito;

    public Cliente(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
        this.carrito = new Carrito();
    }

    public Carrito getCarrito() {
        return carrito;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente: " + getNombre() + ", Email: " + getEmail());
    }
}