package co.edu.umanizales.asignaturas.model;

import java.util.List;

public abstract class Asignatura {

    private String codigo;
    private String nombre;
    private List<Estudiante> estudiantes;

    public Asignatura(String codigo, String nombre, List<Estudiante> estudiantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    
    public abstract boolean esVirtual();
}
