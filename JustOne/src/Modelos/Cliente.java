package Modelos;

public class Cliente extends Usuario implements AccesoUsuario {
    private Carrito carrito = new Carrito();

    public Cliente(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente: " + getNombre());
    }

    public Carrito getCarrito() {
        return carrito;
    }
}