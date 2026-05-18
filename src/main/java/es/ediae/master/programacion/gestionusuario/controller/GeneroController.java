package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private IGeneroService generoService;

    @GetMapping
    public List<GeneroDTO> obtenerGeneros(@RequestParam String nickUsuario, @RequestParam String contrasena) {
        return generoService.obtenerGeneros(nickUsuario, contrasena);
    }

    @GetMapping("/{id}")
    public GeneroDTO obtenerGenero(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String contrasena) throws Exception {
        return generoService.obtenerGenero(id, nickUsuario, contrasena);
    }

    @PostMapping
    public GeneroDTO crearGenero(@RequestBody GeneroDTO generoDTO, @RequestParam String nickUsuario, @RequestParam String contrasena) throws Exception {
        return generoService.crearGenero(generoDTO, nickUsuario, contrasena);
    }

    @PutMapping("/{id}")
    public GeneroDTO actualizarGenero(@PathVariable Integer id, @RequestBody GeneroDTO generoDTO, @RequestParam String nickUsuario, @RequestParam String contrasena) throws Exception {
        return generoService.actualizarGenero(id, generoDTO, nickUsuario, contrasena);
    }

    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String contrasena) throws Exception {
        generoService.eliminarGenero(id, nickUsuario, contrasena);
    }

    
}
