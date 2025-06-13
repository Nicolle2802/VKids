/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nicol
 */
public class Carrito {
    private List<Producto> productos;

    // Constructor que inicializa la lista
    public Carrito() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para eliminar un producto del carrito por índice o por objeto
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

   // Método para obtener todos los productos del carrito
   public List<Producto> getProductos() {
       return productos;
   }

   // Método para limpiar el carrito
   public void limpiar() {
       productos.clear();
   }

   // Método para obtener el total del carrito
   public double calcularTotal() {
       double total = 0.0;
       for (Producto p : productos) {
           total += p.getPrecio();
       }
       return total;
   }
}