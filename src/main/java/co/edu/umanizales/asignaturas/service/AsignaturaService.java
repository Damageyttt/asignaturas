package co.edu.umanizales.asignaturas.service;

import co.edu.umanizales.asignaturas.model.Asignatura;
import co.edu.umanizales.asignaturas.model.AsignaturaPresencial;
import co.edu.umanizales.asignaturas.model.AsignaturaVirtual;
import co.edu.umanizales.asignaturas.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignaturaService {

    private List<Asignatura> asignaturas = new ArrayList<>();

    public AsignaturaService() {
        List<Estudiante> estudiantesMatematicas = new ArrayList<>();
        estudiantesMatematicas.add(new Estudiante("Juan", "Perez"));
        estudiantesMatematicas.add(new Estudiante("Maria", "Garcia"));

        List<Estudiante> estudiantesInformatica = new ArrayList<>();
        estudiantesInformatica.add(new Estudiante("Pedro", "Gomez"));

        List<Estudiante> estudiantesQuimica = new ArrayList<>();
        estudiantesQuimica.add(new Estudiante("Laura", "Sanchez"));

        asignaturas.add(new AsignaturaPresencial("MAT101", "Matemáticas", estudiantesMatematicas));
        asignaturas.add(new AsignaturaVirtual("INF202", "Informática", estudiantesInformatica));
        asignaturas.add(new AsignaturaPresencial("QUI303", "Química", estudiantesQuimica));
    }

    public Asignatura obtenerAsignaturaPorCodigo(String codigo) {
        return asignaturas.stream()
                .filter(asignatura -> asignatura.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Estudiante> obtenerEstudiantesPorLetraEnAsignaturasPresenciales(char letra) {
        List<Estudiante> estudiantesFiltrados = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            if (!asignatura.esVirtual()) {
                for (Estudiante estudiante : asignatura.getEstudiantes()) {
                    String apellido = estudiante.getApellido().toLowerCase();
                    if (apellido.startsWith(String.valueOf(letra).toLowerCase()) ||
                        apellido.endsWith(String.valueOf(letra).toLowerCase())) {
                        estudiantesFiltrados.add(estudiante);
                    }
                }
            }
        }
        return estudiantesFiltrados;
    }
}

