package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Local {
    private ArrayList<Producto> inventario = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void ejecutarMenu() {
        while (true) {
            System.out.println("*/*/*/*/LOCAL SEBAS/*/*/*/*");
            System.out.println("\n*/*/*/* 1 Crear producto */*/*/*");
            System.out.println("*/*/*/* 2 Vender producto */*/*/*");
            System.out.println("*/*/*/* 3 Reponer stock */*/*/*");
            System.out.println("*/*/*/* 4 Aplicar descuento */*/*/*");
            System.out.println("*/*/*/* 5 Mostrar productos */*/*/*");
            System.out.println("*/*/*/* 6 Aumentar precio */*/*/*");
            System.out.println("*/*/*/* 7 Calcular valor inventario */*/*/*");
            System.out.println("*/*/*/* 8 Eliminar producto */*/*/*");
            System.out.println("*/*/*/* 9 Salir */*/*/*");
            System.out.println("*/*/*/**/*/*/**/*/*/*");
            System.out.print("*/*/*/* Seleccione: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 9)
                break;
            switch (opcion) {
                case 1: crearProducto();
                        break;
                case 2: venderProducto();
                        break;
                case 3: reponerStock();
                        break;
                case 4: aplicarDescuento();
                        break;
                case 5: mostrarProductos();
                        break;
                case 6: aumentarPrecio();
                        break;
                case 7: calcularInventario();
                        break;
                case 8: eliminarProducto();
                        break;
                default: System.out.println("No entiendo la opcion.");
            }
        }
    }
    private void crearProducto() {
        System.out.print("Código Para el producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre Producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: $ ");
        double precio = scanner.nextDouble();
        System.out.print("Agregar Existencias: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        inventario.add(new Producto(codigo, nombre, (int) precio, stock));
        System.out.println("Agregado al Stock");
    }
    private void venderProducto() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        Producto producto = buscarProducto(codigo);

        if (producto != null) {
            System.out.println("Producto: " + producto.getNombre());  // Mostrar el nombre del producto
            System.out.println("Stock disponible: " + producto.getStock());
            System.out.print("Cantidad a vender: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            producto.vender(cantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    private void reponerStock() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            System.out.print("Cantidad a añadir: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            producto.reponer(cantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    private void aplicarDescuento() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            producto.aplicarDescuento();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    private void mostrarProductos() {
        if (inventario.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto producto : inventario) {
                producto.mostrarInformacion();
                System.out.println("------------------");
            }
        }
    }
    private void aumentarPrecio() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            producto.aumentarPrecio();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    private void calcularInventario() {
        double total = 0;
        for (Producto producto : inventario) {
            total += producto.calcularValorInventario();
        }
        System.out.println("Valor total del inventario: $" + total);
    }
    private void eliminarProducto() {
        System.out.print("Código del producto: ");
        String codigo = scanner.nextLine();
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            inventario.remove(producto);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    private Producto buscarProducto(String codigo) {
        for (Producto producto : inventario) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
}