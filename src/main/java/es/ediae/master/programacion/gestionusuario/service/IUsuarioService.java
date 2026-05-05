package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.model.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.model.UsuarioResumenDTO;

public interface IUsuarioService {

    public boolean iniciarSesion(String nickUsuario, String contrasena);

    public List<UsuarioResumenDTO> obtenerUsuarios(String nickUsuario, String contrasena);

    public UsuarioResumenDTO obtenerUsuario(Integer id, String nickUsuario, String contrasena);

    public UsuarioDTO crearUsuario(UsuarioDTO usuario, String nickUsuario, String contrasena);

    public UsuarioDTO actualizarUsuario(Integer id, UsuarioDTO usuario, String nickUsuario, String contrasena);

    public void eliminarUsuario(Integer id, String nickUsuario, String contrasena);

    public List<GeneroDTO> obtenerGeneros(String nickUsuario, String contrasena);

    public List<PuestoDeTrabajoDTO> obtenerPuestosDeTrabajo(String nickUsuario, String contrasena);
}
