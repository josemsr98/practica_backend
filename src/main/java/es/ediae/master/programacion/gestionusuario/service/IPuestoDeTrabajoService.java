package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

public interface IPuestoDeTrabajoService {

    public List<PuestoDeTrabajoEntity> obtenerPuestosDeTrabajo();
    
}
