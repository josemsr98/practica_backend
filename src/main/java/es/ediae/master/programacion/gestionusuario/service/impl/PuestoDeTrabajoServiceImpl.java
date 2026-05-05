package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajoService;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoDeTrabajoService {

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Override
    public List<PuestoDeTrabajoDTO> obtenerPuestosDeTrabajo(String nickUsuario, String contrasena) {
        List<PuestoDeTrabajoEntity> puestoDeTrabajoEntity = puestoDeTrabajoRepository.findAll();
        return PuestoDeTrabajoDTO.fromEntityList(puestoDeTrabajoEntity);
    }
}
