package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;

public interface IDireccionService {
    

    public List<DireccionDTO> obtenerDirecciones(Integer usuarioId);

    public DireccionEntity obtenerDireccion (Integer id);

    public DireccionEntity crearDireccion(DireccionEntity direccion);

    public DireccionEntity actualizarDireccion(DireccionEntity direccion);   

    public void eliminarDireccion(Integer id);
}
