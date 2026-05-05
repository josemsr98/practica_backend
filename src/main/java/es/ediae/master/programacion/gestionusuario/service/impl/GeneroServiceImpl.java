package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;

@Service
public class GeneroServiceImpl implements IGeneroService {

    private final UsuarioRepository usuarioRepository;
    private final GeneroRepository generoRepository;
    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    public GeneroServiceImpl(UsuarioRepository usuarioRepository, GeneroRepository generoRepository,
            PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.generoRepository = generoRepository;
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

   @Override
    public List<GeneroDTO> obtenerGeneros(String nickUsuario, String contrasena) {
        List<GeneroEntity> generoEntity = generoRepository.findAll();
        return GeneroDTO.fromEntityList(generoEntity);
    }

}
