package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;

public interface IPuestoDeTrabajoService {

    public List<PuestoDeTrabajoDTO> obtenerPuestosDeTrabajo();
    
}
