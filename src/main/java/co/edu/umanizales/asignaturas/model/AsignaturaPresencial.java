package co.edu.umanizales.asignaturas.model;

import java.util.List;

public class AsignaturaPresencial extends Asignatura {

    public AsignaturaPresencial(String codigo, String nombre, List<Estudiante> estudiantes) {
        super(codigo, nombre, estudiantes);
    }

    @Override
    public boolean esVirtual() {
        return false;
    }
}
