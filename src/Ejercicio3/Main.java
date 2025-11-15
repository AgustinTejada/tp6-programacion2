package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN UNIVERSITARIA");

        Universidad universidad = new Universidad("Universidad Nacional");

        // TAREA 1: Crear 3 profesores y 5 cursos
        System.out.println("=== TAREA 1: CREAR PROFESORES Y CURSOS ===\n");
        Profesor prof1 = new Profesor("PR001", "Dr. Juan Pérez", "Programación");
        Profesor prof2 = new Profesor("PR002", "Dra. María González", "Matemáticas");
        Profesor prof3 = new Profesor("PR003", "Ing. Carlos Rodríguez", "Bases de Datos");

        Curso curso1 = new Curso("C001", "Programación I");
        Curso curso2 = new Curso("C002", "Programación II");
        Curso curso3 = new Curso("C003", "Álgebra Lineal");
        Curso curso4 = new Curso("C004", "Cálculo I");
        Curso curso5 = new Curso("C005", "Base de Datos Relacionales");

        System.out.println("✓ Profesores y cursos creados exitosamente.\n");

        // TAREA 2: Agregar profesores y cursos a la universidad
        System.out.println("=== TAREA 2: AGREGAR A LA UNIVERSIDAD ===\n");
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        System.out.println();
        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);

        // TAREA 3: Asignar profesores a cursos
        System.out.println("\n=== TAREA 3: ASIGNAR PROFESORES A CURSOS ===\n");
        universidad.asignarProfesorACurso("C001", "PR001");
        universidad.asignarProfesorACurso("C002", "PR001");
        universidad.asignarProfesorACurso("C003", "PR002");
        universidad.asignarProfesorACurso("C004", "PR002");
        universidad.asignarProfesorACurso("C005", "PR003");

        // TAREA 4: Listar cursos con su profesor y profesores con sus cursos
        System.out.println("\n=== TAREA 4A: LISTAR CURSOS CON SU PROFESOR ===");
        universidad.listarCursos();

        System.out.println("\n=== TAREA 4B: LISTAR PROFESORES CON SUS CURSOS ===");
        universidad.listarProfesores();

        // TAREA 5: Cambiar el profesor de un curso
        System.out.println("\n=== TAREA 5: CAMBIAR PROFESOR DE UN CURSO ===\n");
        System.out.println("Cambiando el profesor de 'Programación II' de Dr. Juan Pérez a Ing. Carlos Rodríguez...");
        universidad.asignarProfesorACurso("C002", "PR003");
        
        System.out.println("\nVerificando sincronización:");
        Curso c2 = universidad.buscarCursoPorCodigo("C002");
        System.out.println("Curso C002 ahora tiene profesor: " + c2.getProfesor().getNombre());
        System.out.println("\nProfesores actualizados:");
        prof1.mostrarInfo();
        prof3.mostrarInfo();

        // TAREA 6: Remover un curso
        System.out.println("\n=== TAREA 6: REMOVER UN CURSO ===\n");
        System.out.println("Eliminando curso 'Cálculo I'...");
        universidad.eliminarCurso("C004");
        System.out.println("\nVerificando que se eliminó de la lista del profesor:");
        prof2.mostrarInfo();

        // TAREA 7: Remover un profesor
        System.out.println("\n=== TAREA 7: REMOVER UN PROFESOR ===\n");
        System.out.println("Eliminando al Dr. Juan Pérez...");
        universidad.eliminarProfesor("PR001");
        System.out.println("\nVerificando que sus cursos quedan sin profesor:");
        Curso c1 = universidad.buscarCursoPorCodigo("C001");
        if (c1 != null) {
            c1.mostrarInfo();
        }

        // TAREA 8: Mostrar reporte
        System.out.println("\n=== TAREA 8: REPORTE DE CURSOS POR PROFESOR ===");
        universidad.mostrarReporteCursosPorProfesor();

    }
}