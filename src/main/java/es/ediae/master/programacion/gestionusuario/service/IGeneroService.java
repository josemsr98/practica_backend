package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;

public interface IGeneroService {
    
    public List<GeneroDTO> obtenerGeneros(String nickUsuario, String contrasena);

}
