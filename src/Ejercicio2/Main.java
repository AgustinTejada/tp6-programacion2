package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN DE BIBLIOTECA");
        
        // TAREA 1: Crear una biblioteca
        System.out.println("=== TAREA 1: CREAR BIBLIOTECA ===\n");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
        System.out.println("✓ Biblioteca creada: " + biblioteca.getNombre() + "\n");

        // TAREA 2: Crear al menos tres autores
        System.out.println("=== TAREA 2: CREAR AUTORES ===\n");
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiano");
        Autor autor2 = new Autor("A002", "Jorge Luis Borges", "Argentino");
        Autor autor3 = new Autor("A003", "Isabel Allende", "Chilena");
        System.out.println("✓ Autores creados: Gabriel García Márquez, Jorge Luis Borges, Isabel Allende\n");

        // TAREA 3: Agregar 5 libros
        System.out.println("=== TAREA 3: AGREGAR 5 LIBROS ===\n");
        biblioteca.agregarLibro("978-0307474728", "Cien años de soledad", 1967, autor1);
        biblioteca.agregarLibro("978-0142437223", "El amor en los tiempos del cólera", 1985, autor1);
        biblioteca.agregarLibro("978-0802130303", "Ficciones", 1944, autor2);
        biblioteca.agregarLibro("978-0525433449", "El Aleph", 1949, autor2);
        biblioteca.agregarLibro("978-1501117015", "La casa de los espíritus", 1982, autor3);

        // TAREA 4: Listar todos los libros
        System.out.println("\n=== TAREA 4: LISTAR TODOS LOS LIBROS ===");
        biblioteca.listarLibros();

        // TAREA 5: Buscar un libro por ISBN
        System.out.println("\n=== TAREA 5: BUSCAR LIBRO POR ISBN (978-0802130303) ===");
        Libro encontrado = biblioteca.buscarLibroPorIsbn("978-0802130303");
        if (encontrado != null) {
            System.out.println("✓ Libro encontrado:");
            encontrado.mostrarInfo();
        } else {
            System.out.println("✗ Libro no encontrado.");
        }

        // TAREA 6: Filtrar libros por año
        System.out.println("\n=== TAREA 6: FILTRAR LIBROS POR AÑO (1949) ===");
        biblioteca.filtrarLibrosPorAnio(1949);

        // TAREA 7: Eliminar un libro por ISBN
        System.out.println("\n=== TAREA 7: ELIMINAR LIBRO (978-1501117015) ===");
        biblioteca.eliminarLibro("978-1501117015");
        System.out.println("\nLibros restantes:");
        biblioteca.listarLibros();

        // TAREA 8: Mostrar cantidad total de libros
        System.out.println("\n=== TAREA 8: CANTIDAD TOTAL DE LIBROS ===");
        int total = biblioteca.obtenerCantidadLibros();
        System.out.println("Total de libros en la biblioteca: " + total);

        // TAREA 9: Listar todos los autores disponibles
        System.out.println("\n=== TAREA 9: AUTORES DISPONIBLES ===");
        biblioteca.mostrarAutoresDisponibles();

        System.out.println("FIN DEL EJERCICIO 2");
    }
}