package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;

public interface IPuestoDeTrabajoService {
    public List<PuestoDeTrabajoDTO> obtenerPuestosDeTrabajo();
    public PuestoDeTrabajoDTO obtenerPuestoDeTrabajo(Integer id);
    public PuestoDeTrabajoDTO crearPuestoDeTrabajo(PuestoDeTrabajoDTO puesto);
    public PuestoDeTrabajoDTO actualizarPuestoDeTrabajo(Integer id, PuestoDeTrabajoDTO puesto);
    public void eliminarPuestoDeTrabajo(Integer id);
    public boolean existeNombrePuesto(String nombre);
}
