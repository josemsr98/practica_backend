package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private IDireccionService direccionService;

    @GetMapping("/{usuarioId}")
    public List<DireccionDTO> obtenerDirecciones(@PathVariable Integer usuarioId, @RequestParam String nickUsuario, @RequestParam String contrasena) {
        return direccionService.obtenerDirecciones(usuarioId, nickUsuario, contrasena);
    }

    @GetMapping("/direccion/{id}")
    public DireccionDTO obtenerDireccion(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String contrasena) {
        return direccionService.obtenerDireccion(id, nickUsuario, contrasena);
    }

    @PostMapping("/crear")
    public DireccionDTO crearDireccion(@RequestBody DireccionDTO direccion, @RequestParam String nickUsuario, @RequestParam String contrasena) {
        return direccionService.crearDireccion(direccion, nickUsuario, contrasena);
    }

    @PutMapping("/actualizar/{id}")
    public DireccionDTO actualizarDireccion(@PathVariable Integer id, @RequestBody DireccionDTO direccion, @RequestParam String nickUsuario, @RequestParam String contrasena) {
        return direccionService.actualizarDireccion(id, direccion, nickUsuario, contrasena);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarDireccion(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String contrasena) {
        direccionService.eliminarDireccion(id, nickUsuario, contrasena);
    }

}
