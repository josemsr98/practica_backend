package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;

@Service
public class DireccionServiceImpl implements IDireccionService {

    private final UsuarioRepository usuarioRepository;
    private final GeneroRepository generoRepository;
    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;
    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(UsuarioRepository usuarioRepository, GeneroRepository generoRepository, PuestoDeTrabajoRepository puestoDeTrabajoRepository, DireccionRepository direccionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.generoRepository = generoRepository;
        this.direccionRepository = direccionRepository;
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }
    @Override
    public List<DireccionDTO> obtenerDirecciones(Integer usuarioId) {

        List<DireccionEntity> direcciones = direccionRepository.findByUsuarioId(usuarioId);
        return DireccionDTO.fromEntityList(direcciones);
    }


    @Override
    public DireccionEntity obtenerDireccion(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDireccion'");
    }

    @Override
    public DireccionEntity crearDireccion(DireccionEntity direccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearDireccion'");
    }

    @Override
    public DireccionEntity actualizarDireccion(DireccionEntity direccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarDireccion'");
    }

    @Override
    public void eliminarDireccion(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarDireccion'");
    }
    
}
