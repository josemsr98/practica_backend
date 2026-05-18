package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;

public interface IGeneroService {
    

    List<GeneroDTO> obtenerGeneros(String nickUsuario, String contrasena);

    GeneroDTO obtenerGenero(Integer id, String nickUsuario, String contrasena) throws Exception;

    GeneroDTO crearGenero(GeneroDTO generoDTO, String nickUsuario, String contrasena) throws Exception;

    GeneroDTO actualizarGenero(Integer id, GeneroDTO generoDTO, String nickUsuario, String contrasena) throws Exception;

    void eliminarGenero(Integer id, String nickUsuario, String contrasena) throws Exception;

}
