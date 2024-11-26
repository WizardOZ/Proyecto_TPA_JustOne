package Juego;

import java.util.ArrayList;
import java.util.Scanner;

public class CarritoDeCompras {
    private ArrayList<Producto> productos;
    private double total;

    public CarritoDeCompras() {
        productos = new ArrayList<>();
        total = 0.0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
    }

    public double getTotal() {
        return total;
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Carrito de Compras ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Ver total del carrito");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarProductoMenu(scanner);
                    break;
                case 2:
                    eliminarProductoMenu(scanner);
                    break;
                case 3:
                    System.out.println("Total del carrito: $" + getTotal());
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    private void agregarProductoMenu(Scanner scanner) {
        System.out.print("Introduce el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la categoría del producto: ");
        String categoria = scanner.nextLine();
        System.out.print("Introduce la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Introduce el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer del scanner

        Producto producto = new Producto(nombre, categoria, precio, descripcion);
        agregarProducto(producto);
        System.out.println("Producto agregado al carrito.");
    }

    private void eliminarProductoMenu(Scanner scanner) {
        System.out.print("Introduce el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Producto productoAEliminar = buscarProductoPorNombre(nombre);

        if (productoAEliminar != null) {
            eliminarProducto(productoAEliminar);
            System.out.println("Producto eliminado del carrito.");
        } else {
            System.out.println("Producto no encontrado en el carrito.");
        }
    }
}
