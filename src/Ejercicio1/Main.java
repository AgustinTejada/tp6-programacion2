package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        System.out.println("SISTEMA DE GESTIÓN DE STOCK - EJERCICIO 1");

        // TAREA 1: Crear y agregar productos
        System.out.println("=== TAREA 1: CREAR Y AGREGAR PRODUCTOS ===\n");
        Producto p1 = new Producto("P001", "Arroz Integral", 1500.0, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("P002", "Laptop HP", 85000.0, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("P003", "Remera Nike", 2500.0, 30, CategoriaProducto.ROPA);
        Producto p4 = new Producto("P004", "Cafetera", 2000.0, 15, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("P005", "Mouse Logitech", 1200.0, 25, CategoriaProducto.ELECTRONICA);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);

        // TAREA 2: Listar todos los productos
        System.out.println("\n=== TAREA 2: LISTAR TODOS LOS PRODUCTOS ===");
        inventario.listarProductos();

        // TAREA 3: Buscar producto por ID
        System.out.println("\n=== TAREA 3: BUSCAR PRODUCTO POR ID (P002) ===");
        Producto encontrado = inventario.buscarProductoPorId("P002");
        if (encontrado != null) {
            System.out.println("Producto encontrado:");
            encontrado.mostrarInfo();
        } else {
            System.out.println("Producto no encontrado.");
        }

        // TAREA 4: Filtrar por categoría
        System.out.println("\n=== TAREA 4: FILTRAR POR CATEGORÍA (ELECTRONICA) ===");
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);

        // TAREA 5: Eliminar producto
        System.out.println("\n=== TAREA 5: ELIMINAR PRODUCTO (P003) ===");
        inventario.eliminarProducto("P003");
        System.out.println("\nProductos restantes:");
        inventario.listarProductos();

        // TAREA 6: Actualizar stock
        System.out.println("\n=== TAREA 6: ACTUALIZAR STOCK (P001 -> 100 unidades) ===");
        inventario.actualizarStock("P001", 100);

        // TAREA 7: Total de stock
        System.out.println("\n=== TAREA 7: TOTAL DE STOCK DISPONIBLE ===");
        int totalStock = inventario.obtenerTotalStock();
        System.out.println("Stock total en inventario: " + totalStock + " unidades");

        // TAREA 8: Producto con mayor stock
        System.out.println("\n=== TAREA 8: PRODUCTO CON MAYOR STOCK ===");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("El producto con mayor stock es:");
            mayorStock.mostrarInfo();
        }

        // TAREA 9: Filtrar por precio
        System.out.println("\n=== TAREA 9: FILTRAR POR RANGO DE PRECIO ($1000 - $3000) ===");
        inventario.filtrarProductosPorPrecio(1000, 3000);

        // TAREA 10: Categorías disponibles
        System.out.println("\n=== TAREA 10: CATEGORÍAS DISPONIBLES ===");
        inventario.mostrarCategoriasDisponibles();

        System.out.println("║          FIN DEL EJERCICIO 1                    ║");
    }
}