package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.model.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private GeneroRepository generoRepository;
    @Mock
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;
    @InjectMocks
    private UsuarioServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    
    private UsuarioDTO crearUsuarioDTO() {
        return new UsuarioDTO(1, "nick", false, "pass", "Nombre", "Apellido1", "Apellido2", LocalDateTime.now(),
                LocalDate.now(), LocalTime.of(8, 0), 1, "Masculino", 2, "Dev", new ArrayList<>());
    }

    @Test
    public void IniciarSesion() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(usuario);
        assertTrue(service.iniciarSesion("nick", "pass"));
    }

    @Test
    public void IniciarSesionFail() {
        when(usuarioRepository.findByNickUsuario("nick")).thenReturn(null);
        assertFalse(service.iniciarSesion("nick", "pass"));
    }

    @Test
    public void ObtenerUsuarios() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNickUsuario("nick");
        usuario.setContrasena("pass");
        when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));
        List<UsuarioDTO> result = service.obtenerUsuarios("nick", "pass");
        assertEquals(1, result.size());
    }

    @Test
    public void ObtenerUsuario() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(1);
        usuario.setNickUsuario("nick");
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        UsuarioDTO result = service.obtenerUsuario(1, "nick", "pass");
        assertNotNull(result);
    }

    @Test
    public void CrearUsuario() {
        UsuarioDTO dto = crearUsuarioDTO();
        when(usuarioRepository.findByNickUsuario(dto.getNickUsuario())).thenReturn(null);
        GeneroEntity genero = new GeneroEntity();
        genero.setId(dto.getGeneroId());
        when(generoRepository.findById(dto.getGeneroId())).thenReturn(Optional.of(genero));
        PuestoDeTrabajoEntity puesto = new PuestoDeTrabajoEntity();
        puesto.setId(dto.getPuestoDeTrabajoId());
        when(puestoDeTrabajoRepository.findById(dto.getPuestoDeTrabajoId())).thenReturn(Optional.of(puesto));
        UsuarioEntity saved = new UsuarioEntity();
        when(usuarioRepository.save(any())).thenReturn(saved);
        UsuarioDTO result = service.crearUsuario(dto, "admin", "admin");
        assertNotNull(result);
    }

    @Test
    public void CrearUsuarioNickExistente() {
        UsuarioDTO dto = crearUsuarioDTO();
        UsuarioEntity existente = new UsuarioEntity();
        existente.setId(2);
        existente.setNickUsuario(dto.getNickUsuario());
        when(usuarioRepository.findByNickUsuario(dto.getNickUsuario())).thenReturn(existente);
        assertThrows(RuntimeException.class, () -> service.crearUsuario(dto, "admin", "admin"));
    }

    @Test
    public void ActualizarUsuario() {
        UsuarioDTO dto = crearUsuarioDTO();
        UsuarioEntity existente = new UsuarioEntity();
        existente.setId(dto.getId());
        existente.setNickUsuario(dto.getNickUsuario());
        when(usuarioRepository.findByNickUsuario(dto.getNickUsuario())).thenReturn(existente);
        GeneroEntity genero = new GeneroEntity();
        genero.setId(dto.getGeneroId());
        when(generoRepository.findById(dto.getGeneroId())).thenReturn(Optional.of(genero));
        PuestoDeTrabajoEntity puesto = new PuestoDeTrabajoEntity();
        puesto.setId(dto.getPuestoDeTrabajoId());
        when(puestoDeTrabajoRepository.findById(dto.getPuestoDeTrabajoId())).thenReturn(Optional.of(puesto));
        UsuarioEntity saved = new UsuarioEntity();
        when(usuarioRepository.save(any())).thenReturn(saved);
        UsuarioDTO result = service.actualizarUsuario(dto.getId(), dto, "admin", "admin");
        assertNotNull(result);
    }

    @Test
    public void ActualizarUsuarioNickExistente() {
        UsuarioDTO dto = crearUsuarioDTO();
        UsuarioEntity existente = new UsuarioEntity();
        existente.setId(dto.getId() + 1); // Distinto id
        existente.setNickUsuario(dto.getNickUsuario());
        when(usuarioRepository.findByNickUsuario(dto.getNickUsuario())).thenReturn(existente);
        assertThrows(RuntimeException.class, () -> service.actualizarUsuario(dto.getId(), dto, "admin", "admin"));
    }

    @Test
    public void EliminarUsuario() {
        doNothing().when(usuarioRepository).deleteById(1);
        service.eliminarUsuario(1, "admin", "admin");
        verify(usuarioRepository, times(1)).deleteById(1);
    }

}
