package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajoService;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoDeTrabajoService {

    
    
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;
    

    public PuestoDeTrabajoServiceImpl(PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

    @Override
    public List<PuestoDeTrabajoDTO> obtenerPuestosDeTrabajo() {
        List<PuestoDeTrabajoEntity> entities = puestoDeTrabajoRepository.findAll();
        return PuestoDeTrabajoDTO.fromEntityList(entities);
    }

    @Override
    public PuestoDeTrabajoDTO obtenerPuestoDeTrabajo(Integer id) {
        Optional<PuestoDeTrabajoEntity> entity = puestoDeTrabajoRepository.findById(id);
        return entity.map(PuestoDeTrabajoDTO::fromEntity).orElse(null);
    }

    @Override
    public PuestoDeTrabajoDTO crearPuestoDeTrabajo(PuestoDeTrabajoDTO puesto) {
        PuestoDeTrabajoEntity entity = new PuestoDeTrabajoEntity();
        entity.setNombre(puesto.getNombre());
        PuestoDeTrabajoEntity saved = puestoDeTrabajoRepository.save(entity);
        return PuestoDeTrabajoDTO.fromEntity(saved);
    }

    @Override
    public PuestoDeTrabajoDTO actualizarPuestoDeTrabajo(Integer id, PuestoDeTrabajoDTO puesto) {
        Optional<PuestoDeTrabajoEntity> optional = puestoDeTrabajoRepository.findById(id);
        if (optional.isPresent()) {
            PuestoDeTrabajoEntity entity = optional.get();
            entity.setNombre(puesto.getNombre());
            PuestoDeTrabajoEntity saved = puestoDeTrabajoRepository.save(entity);
            return PuestoDeTrabajoDTO.fromEntity(saved);
        }
        return null;
    }

    @Override
    public void eliminarPuestoDeTrabajo(Integer id) {
        puestoDeTrabajoRepository.deleteById(id);
    }

    @Override
    public boolean existeNombrePuesto(String nombre) {
        
        if (!puestoDeTrabajoRepository.findByNombreIgnoreCase(nombre).isEmpty()) {
            return true;
        }
        
        if (!puestoDeTrabajoRepository.findByNombreContainingIgnoreCase(nombre).isEmpty()) {
            return true;
        }
        return false;
    }
}
