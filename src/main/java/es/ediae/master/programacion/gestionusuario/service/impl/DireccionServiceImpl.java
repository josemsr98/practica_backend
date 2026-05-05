package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;

@Service
public class DireccionServiceImpl implements IDireccionService {

    private final UsuarioRepository usuarioRepository;
    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(UsuarioRepository usuarioRepository, DireccionRepository direccionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.direccionRepository = direccionRepository;
    }

    @Override
    public List<DireccionDTO> obtenerDirecciones(Integer usuarioId, String nickUsuario, String contrasena) {
        if (!usuarioValido(nickUsuario, contrasena))
            return null;
        List<DireccionEntity> direcciones = direccionRepository.findByUsuarioId(usuarioId);
        return DireccionDTO.fromEntityList(direcciones);
    }

    @Override
    public DireccionDTO obtenerDireccion(Integer id, String nickUsuario, String contrasena) {
        if (!usuarioValido(nickUsuario, contrasena))
            return null;
        DireccionEntity direccion = direccionRepository.findById(id).orElse(null);
        return DireccionDTO.fromEntity(direccion);
    }

    @Override
    public DireccionDTO crearDireccion(DireccionDTO direccion, String nickUsuario, String contrasena) {
        if (!usuarioValido(nickUsuario, contrasena))
            return null;
        DireccionEntity entity = direccion.toEntity();
        // Asignar UsuarioEntity
        if (direccion.getUsuarioId() != null) {
            UsuarioEntity usuario = usuarioRepository.findById(direccion.getUsuarioId()).orElse(null);
            entity.setUsuario(usuario);
        }
        DireccionEntity savedEntity = direccionRepository.save(entity);
        return DireccionDTO.fromEntity(savedEntity);
    }

    @Override
    public DireccionDTO actualizarDireccion(Integer id, DireccionDTO direccion, String nickUsuario, String contrasena) {
        if (!usuarioValido(nickUsuario, contrasena))
            return null;
        // Convertimos el DTO recibido a una entidad DireccionEntity
        DireccionEntity entity = direccion.toEntity();

        // Asignamos el ID de la dirección que se va a actualizar
        entity.setId(id);

        // Buscamos y asignamos el usuario correspondiente usando el usuarioId del DTO
        // Si el usuario no existe, se lanzará una excepción para evitar guardar una
        // dirección sin usuario
        if (direccion.getUsuarioId() != null) {
            UsuarioEntity usuario = usuarioRepository.findById(direccion.getUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Usuario no encontrado con id: " + direccion.getUsuarioId()));
            entity.setUsuario(usuario);
        } else {
            throw new IllegalArgumentException("El usuarioId no puede ser null al actualizar una dirección");
        }

        // Guardamos la entidad actualizada en la base de datos
        DireccionEntity updatedEntity = direccionRepository.save(entity);

        // Convertimos la entidad actualizada de vuelta a DTO y la retornamos
        return DireccionDTO.fromEntity(updatedEntity);
    }

    @Override
    public void eliminarDireccion(Integer id, String nickUsuario, String contrasena) {
        if (!usuarioValido(nickUsuario, contrasena))
            return;
        direccionRepository.deleteById(id);
    }

    // Método auxiliar para validar usuario y contraseña
    private boolean usuarioValido(String nickUsuario, String contrasena) {
        UsuarioEntity usuario = usuarioRepository.findByNickUsuario(nickUsuario);
        return usuario != null && usuario.getContrasena().equals(contrasena);
    }
}
