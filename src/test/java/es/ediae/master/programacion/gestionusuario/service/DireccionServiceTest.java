package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.model.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DireccionServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private DireccionRepository direccionRepository;
    @InjectMocks
    private DireccionServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ObtenerDireccionesUsuarioValido() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(usuario);
        DireccionEntity direccionEntity = new DireccionEntity();
        direccionEntity.setNombreCalle("Calle Test");
        direccionEntity.setNumeroCalle(123);
        direccionEntity.setDireccionPrincipal(false);
        direccionEntity.setUsuario(usuario);
        List<DireccionEntity> entities = Arrays.asList(direccionEntity);
        when(direccionRepository.findByUsuarioId(1)).thenReturn(entities);
        List<DireccionDTO> result = service.obtenerDirecciones(1, "nick", "pass");
        assertNotNull(result);
    }

    @Test
    public void ObtenerDireccionesUsuarioNoValido() {
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(null);
        List<DireccionDTO> result = service.obtenerDirecciones(1, "nick", "pass");
        assertNull(result);
    }

    @Test
    public void ObtenerDireccionUsuarioValido() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(usuario);
        DireccionEntity entity = new DireccionEntity();
        entity.setNombreCalle("Calle Test");
        entity.setNumeroCalle(123);
        entity.setDireccionPrincipal(false);
        entity.setUsuario(usuario);
        when(direccionRepository.findById(1)).thenReturn(Optional.of(entity));
        DireccionDTO result = service.obtenerDireccion(1, "nick", "pass");
        assertNotNull(result);
    }

    @Test
    public void ObtenerDireccionUsuarioNoValido() {
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(null);
        DireccionDTO result = service.obtenerDireccion(1, "nick", "pass");
        assertNull(result);
    }

    @Test
    public void CrearDireccionUsuarioValido() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(1);
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(usuario);
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        DireccionDTO dto = new DireccionDTO(null, "Calle Test", 123, 1, false);
        DireccionEntity entity = new DireccionEntity();
        entity.setNombreCalle("Calle Test");
        entity.setNumeroCalle(123);
        entity.setDireccionPrincipal(false);
        entity.setUsuario(usuario);
        when(direccionRepository.save(any())).thenReturn(entity);
        DireccionDTO result = service.crearDireccion(dto, "nick", "pass");
        assertNotNull(result);
    }

    @Test
    public void CrearDireccionUsuarioNoValido() {
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(null);
        DireccionDTO dto = new DireccionDTO(null, null, null, null, false);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.crearDireccion(dto, "nick", "pass"));
        assertEquals("Usuario o contraseña no válidos", ex.getMessage());
    }

    @Test
    public void ActualizarDireccionUsuarioValido() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(1);
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(usuario);
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        DireccionDTO dto = new DireccionDTO(null, "Calle Test", 123, 1, false);
        DireccionEntity entity = new DireccionEntity();
        entity.setNombreCalle("Calle Test");
        entity.setNumeroCalle(123);
        entity.setDireccionPrincipal(false);
        entity.setUsuario(usuario);
        when(direccionRepository.save(any())).thenReturn(entity);
        DireccionDTO result = service.actualizarDireccion(2, dto, "nick", "pass");
        assertNotNull(result);
    }

    @Test
    public void ActualizarDireccionUsuarioNoValido() {
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(null);
        DireccionDTO dto = new DireccionDTO(null, null, null, null, false);
        DireccionDTO result = service.actualizarDireccion(2, dto, "nick", "pass");
        assertNull(result);
    }

    @Test
    public void EliminarDireccionUsuarioValido() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(usuario);
        service.eliminarDireccion(1, "nick", "pass");
        verify(direccionRepository, times(1)).deleteById(1);
    }

    @Test
    public void EliminarDireccionUsuarioNoValido() {
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(null);
        service.eliminarDireccion(1, "nick", "pass");
        verify(direccionRepository, never()).deleteById(any());
    }
}
