package Modelos;

public class Administrador extends Usuario {
    public Administrador(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Administrador: " + getNombre() + ", Email: " + getEmail());
    }
}
