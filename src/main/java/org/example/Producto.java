package org.example;

public class Producto {
    private String codigo;
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String codigo, String nombre, int precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public void vender(int cantidad) {
        if (cantidad > stock) {
            System.out.println("Stock insuficiente. Disponible: " + stock);
        } else {
            stock -= cantidad;
            System.out.println("Venta realizada. Nuevo stock: " + stock);
        }
    }
    public void reponer(int cantidad) {
        stock += cantidad;
        System.out.println("Stock actualizado: " + stock);
    }
    public void aplicarDescuento() {
        precio -= precio * 0.02;
        System.out.println("Descuento aplicado. Nuevo precio: " + precio);
    }
    public void aumentarPrecio() {
        precio += precio * 0.06;
        System.out.println("Precio aumentado. Nuevo precio: " + precio);
    }
    public double calcularValorInventario() {
        return precio * stock;
    }
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock);
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getStock() {
        return stock;
    }
}