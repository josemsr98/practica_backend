package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;

public interface IGeneroService {
    
    public List<GeneroEntity> obtenerGeneros();
}
