
package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.model.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	/**
	 * Iniciar sesión: verifica si el usuario y contraseña son válidos.
	 */
	@GetMapping("/iniciarSesion")
	public boolean iniciarSesion(@RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.iniciarSesion(nickUsuario, contrasena);
	}

	/**
	 * Obtener todos los usuarios (incluye género y puesto de trabajo).
	 */
	@GetMapping
	public List<UsuarioDTO> obtenerUsuarios(@RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.obtenerUsuarios(nickUsuario, contrasena);
	}

	/**
	 * Obtener un usuario por su id.
	 */
	@GetMapping("/{id}")
	public UsuarioDTO obtenerUsuario(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.obtenerUsuario(id, nickUsuario, contrasena);
	}

	/**
	 * Crear un nuevo usuario.
	 */
	@PostMapping
	public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO, @RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.crearUsuario(usuarioDTO, nickUsuario, contrasena);
	}

	/**
	 * Actualizar un usuario existente.
	 */
	@PutMapping("/{id}")
	public UsuarioDTO actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO, @RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.actualizarUsuario(id, usuarioDTO, nickUsuario, contrasena);
	}

	/**
	 * Eliminar un usuario.
	 */
	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String contrasena) {
		usuarioService.eliminarUsuario(id, nickUsuario, contrasena);
	}

	/**
	 * Obtener todos los géneros disponibles.
	 */
	@GetMapping("/generos")
	public List<?> obtenerGeneros(@RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.obtenerGeneros(nickUsuario, contrasena);
	}

	/**
	 * Obtener todos los puestos de trabajo disponibles.
	 */
	@GetMapping("/puestosDeTrabajo")
	public List<?> obtenerPuestosDeTrabajo(@RequestParam String nickUsuario, @RequestParam String contrasena) {
		return usuarioService.obtenerPuestosDeTrabajo(nickUsuario, contrasena);
	}
}


