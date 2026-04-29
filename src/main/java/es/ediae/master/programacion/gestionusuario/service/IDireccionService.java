package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

public interface IDireccionService {
    

    public List<DireccionEntity> obtenerDirecciones(Integer usuarioId);

    public DireccionEntity obtenerDireccion (Integer id);

    public DireccionEntity crearDireccion(DireccionEntity direccion);

    public DireccionEntity actualizarDireccion(DireccionEntity direccion);   

    public void eliminarDireccion(Integer id);
}
