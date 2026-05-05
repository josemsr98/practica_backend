package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;

public interface IDireccionService {
    

    public List<DireccionDTO> obtenerDirecciones(Integer usuarioId, String nickUsuario, String contrasena);

    public DireccionDTO obtenerDireccion (Integer id, String nickUsuario, String contrasena);

    public DireccionDTO crearDireccion(DireccionDTO direccion, String nickUsuario, String contrasena);

    public DireccionDTO actualizarDireccion(Integer id, DireccionDTO direccion, String nickUsuario, String contrasena);   

    public void eliminarDireccion(Integer id, String nickUsuario, String contrasena);
}
