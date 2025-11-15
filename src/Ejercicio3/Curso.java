package Ejercicio3;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor p) {
        // Si tenía un profesor previo diferente, quitarse de su lista
        if (this.profesor != null && this.profesor != p) {
            this.profesor.getCursos().remove(this);
        }

        // Asignar el nuevo profesor
        this.profesor = p;

        // Si el nuevo profesor no es null, agregarse a su lista
        if (p != null && !p.getCursos().contains(this)) {
            p.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre() + " (" + profesor.getEspecialidad() + ")");
        } else {
            System.out.println("Profesor: Sin asignar");
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return "Curso{codigo='" + codigo + "', nombre='" + nombre + 
               "', profesor=" + (profesor != null ? profesor.getNombre() : "Sin asignar") + '}';
    }
}