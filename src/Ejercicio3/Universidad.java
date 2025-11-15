package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProfesor(Profesor p) {
        if (!profesores.contains(p)) {
            profesores.add(p);
            System.out.println("✓ Profesor agregado: " + p.getNombre());
        }
    }

    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            System.out.println("✓ Curso agregado: " + c.getNombre());
        }
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso == null) {
            System.out.println("✗ Error: Curso con código " + codigoCurso + " no encontrado.");
            return;
        }
        if (profesor == null) {
            System.out.println("✗ Error: Profesor con ID " + idProfesor + " no encontrado.");
            return;
        }

        curso.setProfesor(profesor);
        System.out.println("✓ Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
    }

    public void listarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        System.out.println("\n=== PROFESORES DE " + nombre + " ===");
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.println("\n=== CURSOS DE " + nombre + " ===");
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Romper la relación con el profesor si la hay
            if (curso.getProfesor() != null) {
                curso.getProfesor().eliminarCurso(curso);
            }
            cursos.remove(curso);
            System.out.println("✓ Curso eliminado: " + curso.getNombre());
            return true;
        }
        System.out.println("✗ Curso con código " + codigo + " no encontrado.");
        return false;
    }

    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Antes de remover, dejar null los cursos que dictaba
            List<Curso> cursosDelProfesor = new ArrayList<>(profesor.getCursos());
            for (Curso c : cursosDelProfesor) {
                c.setProfesor(null);
            }
            profesores.remove(profesor);
            System.out.println("✓ Profesor eliminado: " + profesor.getNombre());
            return true;
        }
        System.out.println("✗ Profesor con ID " + id + " no encontrado.");
        return false;
    }

    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\n=== REPORTE: CURSOS POR PROFESOR ===");
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + " - " + p.getCursos().size() + " curso(s)");
            if (!p.getCursos().isEmpty()) {
                for (Curso c : p.getCursos()) {
                    System.out.println("  • " + c.getNombre());
                }
            }
        }
        System.out.println("----------------------------------------");
    }
}