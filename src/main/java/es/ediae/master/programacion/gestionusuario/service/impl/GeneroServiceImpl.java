package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;

@Service
public class GeneroServiceImpl implements IGeneroService {

    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public List<GeneroDTO> obtenerGeneros(String nickUsuario, String contrasena) {
        List<GeneroEntity> generoEntity = generoRepository.findAll();
        return GeneroDTO.fromEntityList(generoEntity);
    }

}
