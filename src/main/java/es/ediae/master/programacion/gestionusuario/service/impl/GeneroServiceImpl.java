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

    @Override
    public GeneroDTO obtenerGenero(Integer id, String nickUsuario, String contrasena) throws Exception {
        GeneroEntity entity = generoRepository.findById(id)
                .orElseThrow(() -> new Exception("Género no encontrado"));
        return GeneroDTO.fromEntity(entity);
    }

    @Override
    public GeneroDTO crearGenero(GeneroDTO generoDTO, String nickUsuario, String contrasena) throws Exception {
        // Validar nombre existente o parecido
        if (generoRepository.findByNombreIgnoreCase(generoDTO.getNombre()) != null ||
            !generoRepository.findByNombreIgnoreCaseContaining(generoDTO.getNombre()).isEmpty()) {
            throw new Exception("Ya existe un género con ese nombre o uno parecido");
        }
        GeneroEntity entity = new GeneroEntity();
        entity.setNombre(generoDTO.getNombre());
        GeneroEntity saved = generoRepository.save(entity);
        return GeneroDTO.fromEntity(saved);
    }

    @Override
    public GeneroDTO actualizarGenero(Integer id, GeneroDTO generoDTO, String nickUsuario, String contrasena) throws Exception {
        GeneroEntity entity = generoRepository.findById(id)
                .orElseThrow(() -> new Exception("Género no encontrado"));
        // Validar nombre existente o parecido (excluyendo el actual)
        List<GeneroEntity> similares = generoRepository.findByNombreIgnoreCaseContaining(generoDTO.getNombre());
        for (GeneroEntity g : similares) {
            if (!g.getId().equals(id)) {
                throw new Exception("Ya existe un género con ese nombre o uno parecido");
            }
        }
        GeneroEntity existente = generoRepository.findByNombreIgnoreCase(generoDTO.getNombre());
        if (existente != null && !existente.getId().equals(id)) {
            throw new Exception("Ya existe un género con ese nombre");
        }
        entity.setNombre(generoDTO.getNombre());
        GeneroEntity saved = generoRepository.save(entity);
        return GeneroDTO.fromEntity(saved);
    }

    @Override
    public void eliminarGenero(Integer id, String nickUsuario, String contrasena) throws Exception {
        GeneroEntity entity = generoRepository.findById(id)
                .orElseThrow(() -> new Exception("Género no encontrado"));
        generoRepository.delete(entity);
    }

}
