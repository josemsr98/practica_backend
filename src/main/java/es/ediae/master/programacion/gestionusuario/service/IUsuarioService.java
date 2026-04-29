package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.model.UsuarioDTO;

public interface IUsuarioService {

    public boolean iniciarSesion(String nickUsuario, String contrasena);

    public List<UsuarioDTO> obtenerUsuarios(String nickUsuario, String contrasena);

    public UsuarioDTO obtenerUsuario(Integer id, String nickUsuario, String contrasena);

    public UsuarioDTO crearUsuario(UsuarioDTO usuario, String nickUsuario, String contrasena);

    public UsuarioDTO actualizarUsuario(Integer id, UsuarioDTO usuario, String nickUsuario, String contrasena);

    public void eliminarUsuario(Integer id, String nickUsuario, String contrasena);

    public List<?> obtenerGeneros(String nickUsuario, String contrasena);

    public List<?> obtenerPuestosDeTrabajo(String nickUsuario, String contrasena);
}
