package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/puestos-de-trabajo")
public class PuestoDeTrabajoController {
    @Autowired
    private IPuestoDeTrabajoService puestoDeTrabajoService;

    @GetMapping
    public List<PuestoDeTrabajoDTO> obtenerPuestosDeTrabajo() {
        return puestoDeTrabajoService.obtenerPuestosDeTrabajo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuestoDeTrabajoDTO> obtenerPuestoDeTrabajo(@PathVariable Integer id) {
        PuestoDeTrabajoDTO puesto = puestoDeTrabajoService.obtenerPuestoDeTrabajo(id);
        if (puesto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(puesto);
    }

    @PostMapping
    public ResponseEntity<?> crearPuestoDeTrabajo(@RequestBody PuestoDeTrabajoDTO puesto) {
        if (puestoDeTrabajoService.existeNombrePuesto(puesto.getNombre())) {
            return ResponseEntity.badRequest().body("El nombre del puesto ya existe o es muy parecido a uno existente.");
        }
        return ResponseEntity.ok(puestoDeTrabajoService.crearPuestoDeTrabajo(puesto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPuestoDeTrabajo(@PathVariable Integer id, @RequestBody PuestoDeTrabajoDTO puesto) {
        if (puestoDeTrabajoService.existeNombrePuesto(puesto.getNombre())) {
            return ResponseEntity.badRequest().body("El nombre del puesto ya existe o es muy parecido a uno existente.");
        }
        return ResponseEntity.ok(puestoDeTrabajoService.actualizarPuestoDeTrabajo(id, puesto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPuestoDeTrabajo(@PathVariable Integer id) {
        puestoDeTrabajoService.eliminarPuestoDeTrabajo(id);
        return ResponseEntity.noContent().build();
    }
}
