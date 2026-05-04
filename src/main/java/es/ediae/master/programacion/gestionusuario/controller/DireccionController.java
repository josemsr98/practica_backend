package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private IDireccionService direccionService;

    @GetMapping("/usuario/{usuarioId}")
    public List<DireccionDTO> obtenerDirecciones(@PathVariable Integer usuarioId) {
        return direccionService.obtenerDirecciones(usuarioId);
    }
    
    
}
