package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.model.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.model.UsuarioResumenDTO;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final GeneroRepository generoRepository;
    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, GeneroRepository generoRepository,
            PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.generoRepository = generoRepository;
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

    @Override
    public boolean iniciarSesion(String nickUsuario, String contrasena) {
        System.out.println("[DEBUG] nickUsuario recibido: '" + nickUsuario + "'");
        System.out.println("[DEBUG] contrasena recibida: '" + contrasena + "'");
        UsuarioEntity usuario = usuarioRepository.findByNickUsuario(nickUsuario);
        if (usuario != null) {
            System.out.println("[DEBUG] nickUsuario en BD: '" + usuario.getNickUsuario() + "'");
            System.out.println("[DEBUG] contrasena en BD: '" + usuario.getContrasena() + "'");
            if (usuario.getContrasena().equals(contrasena)) {
                System.out.println("[DEBUG] Contraseña coincide. Login exitoso.");
                return true;
            } else {
                System.out.println("[DEBUG] Contraseña NO coincide.");
            }
        } else {
            System.out.println("[DEBUG] Usuario no encontrado en la base de datos.");
        }
        return false;
    }

    @Override
    public List<UsuarioResumenDTO> obtenerUsuarios(String nickUsuario, String contrasena) {
        // Aquí puedes validar nickUsuario y contrasena si lo necesitas
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return UsuarioResumenDTO.fromEntityList(usuarios);
    }

    @Override
    public UsuarioResumenDTO obtenerUsuario(Integer id, String nickUsuario, String contrasena) {
        // Aquí puedes validar nickUsuario y contrasena si lo necesitas
        UsuarioEntity usuario = usuarioRepository.findById(id).orElse(null);
        return UsuarioResumenDTO.fromEntity(usuario);
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO, String nickUsuario, String contrasena) {
                // Validar nickUsuario único
                if (usuarioRepository.findByNickUsuario(usuarioDTO.getNickUsuario()) != null) {
                    throw new RuntimeException("El nickUsuario ya existe. No se puede crear el usuario.");
                }
        // Aquí puedes validar nickUsuario y contrasena si lo necesitas
        UsuarioEntity entity = usuarioDTO.toEntity();
        // Si la fecha de creación es null, la asignamos automáticamente
        if (entity.getFechaHoraCreacion() == null) {
            entity.setFechaHoraCreacion(java.time.LocalDateTime.now());
        }
        // Asignar GeneroEntity
        if (usuarioDTO.getGeneroId() != null) {
            GeneroEntity genero = generoRepository.findById(usuarioDTO.getGeneroId())
                    .orElseThrow(() -> new RuntimeException("Género no encontrado"));
            entity.setGenero(genero);
        } else {
            throw new RuntimeException("El género es obligatorio");
        }
        // Asignar PuestoDeTrabajoEntity si viene el ID
        if (usuarioDTO.getPuestoDeTrabajoId() != null) {
            PuestoDeTrabajoEntity puesto = puestoDeTrabajoRepository.findById(usuarioDTO.getPuestoDeTrabajoId())
                    .orElseThrow(() -> new RuntimeException("Puesto de trabajo no encontrado"));
            entity.setPuestoDeTrabajo(puesto);
        } else {
            entity.setPuestoDeTrabajo(null);
        }
        UsuarioEntity saved = usuarioRepository.save(entity);
        return UsuarioDTO.fromEntity(saved);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Integer id, UsuarioDTO usuarioDTO, String nickUsuario, String contrasena) {
                // Validar nickUsuario único (excepto para el propio usuario)
                UsuarioEntity existente = usuarioRepository.findByNickUsuario(usuarioDTO.getNickUsuario());
                if (existente != null && !existente.getId().equals(id)) {
                    throw new RuntimeException("El nickUsuario ya existe. No se puede actualizar el usuario.");
                }
        // Aquí puedes validar nickUsuario y contrasena si lo necesitas
        UsuarioEntity entity = usuarioDTO.toEntity();
        entity.setId(id);

        // Asignar GeneroEntity
        if (usuarioDTO.getGeneroId() != null) {
            GeneroEntity genero = generoRepository.findById(usuarioDTO.getGeneroId())
                    .orElseThrow(() -> new RuntimeException("Género no encontrado"));
            entity.setGenero(genero);
        } else {
            throw new RuntimeException("El género es obligatorio");
        }
        // Asignar PuestoDeTrabajoEntity si viene el ID
        if (usuarioDTO.getPuestoDeTrabajoId() != null) {
            PuestoDeTrabajoEntity puesto = puestoDeTrabajoRepository.findById(usuarioDTO.getPuestoDeTrabajoId())
                    .orElseThrow(() -> new RuntimeException("Puesto de trabajo no encontrado"));
            entity.setPuestoDeTrabajo(puesto);
        } else {
            entity.setPuestoDeTrabajo(null);
        }

        UsuarioEntity saved = usuarioRepository.save(entity);
        return UsuarioDTO.fromEntity(saved);
    }

    @Override
    public void eliminarUsuario(Integer id, String nickUsuario, String contrasena) {
        // Aquí puedes validar nickUsuario y contrasena si lo necesitas
        usuarioRepository.deleteById(id);
    }

}
