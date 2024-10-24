package co.edu.umanizales.asignaturas.controller;

import co.edu.umanizales.asignaturas.model.Asignatura;
import co.edu.umanizales.asignaturas.model.Estudiante;
import co.edu.umanizales.asignaturas.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/{codigo}")
    public Asignatura obtenerAsignatura(@PathVariable String codigo) {
        Asignatura asignatura = asignaturaService.obtenerAsignaturaPorCodigo(codigo);
        if (asignatura == null) {
            throw new RuntimeException("Asignatura no encontrada");
        }
        return asignatura;
    }

    @GetMapping("/presenciales/estudiantes/{letra}")
    public List<Estudiante> obtenerEstudiantesPorLetra(@PathVariable char letra) {
        return asignaturaService.obtenerEstudiantesPorLetraEnAsignaturasPresenciales(letra);
    }
}
