package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public interface IUsuarioService {

    public boolean iniciarSesion(String nickUsuario, String contrasena);

    public List<UsuarioEntity> obtenerUsuarios();

    public UsuarioEntity obtenerUsuario (Integer id);

    public UsuarioEntity crearUsuario(UsuarioEntity usuario);

    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);

    public void eliminarUsuario(Integer id);


        
    
    
}
