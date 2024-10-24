package co.edu.umanizales.asignaturas.model;

import java.util.List;

public class AsignaturaVirtual extends Asignatura {

    public AsignaturaVirtual(String codigo, String nombre, List<Estudiante> estudiantes) {
        super(codigo, nombre, estudiantes);
    }

    @Override
    public boolean esVirtual() {
        return true;
    }
}
