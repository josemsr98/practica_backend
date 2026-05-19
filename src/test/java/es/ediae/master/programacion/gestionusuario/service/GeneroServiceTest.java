package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.model.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.service.impl.GeneroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GeneroServiceTest {
    @Mock
    private GeneroRepository repository;
    @InjectMocks
    private GeneroServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ObtenerGeneros() {
        GeneroEntity genero = new GeneroEntity();
        genero.setId(1);
        genero.setNombre("Masculino");
        when(repository.findAll()).thenReturn(Collections.singletonList(genero));
        List<GeneroDTO> result = service.obtenerGeneros("nick", "pass");
        assertEquals(1, result.size());
        assertEquals("Masculino", result.get(0).getNombre());
    }

    @Test
    public void ObtenerGenero() throws Exception {
        GeneroEntity genero = new GeneroEntity();
        genero.setId(1);
        genero.setNombre("Masculino");
        when(repository.findById(1)).thenReturn(Optional.of(genero));
        GeneroDTO result = service.obtenerGenero(1, "nick", "pass");
        assertNotNull(result);
        assertEquals("Masculino", result.getNombre());
    }

    @Test
    public void ObtenerGenero_noExiste() {
        when(repository.findById(1)).thenReturn(Optional.empty());
        Exception ex = assertThrows(Exception.class, () -> service.obtenerGenero(1, "nick", "pass"));
        assertEquals("Género no encontrado", ex.getMessage());
    }

    @Test
    public void CrearGenero() throws Exception {
        GeneroDTO dto = new GeneroDTO(null, "Masculino");
        when(repository.findByNombreIgnoreCase("Masculino")).thenReturn(null);
        when(repository.findByNombreIgnoreCaseContaining("Masculino")).thenReturn(Collections.emptyList());
        GeneroEntity saved = new GeneroEntity();
        saved.setId(1);
        saved.setNombre("Masculino");
        when(repository.save(any())).thenReturn(saved);
        GeneroDTO result = service.crearGenero(dto, "nick", "pass");
        assertNotNull(result);
        assertEquals("Masculino", result.getNombre());
    }

    @Test
    public void CrearGeneroNombreExistente() {
        GeneroDTO dto = new GeneroDTO(null, "Masculino");
        GeneroEntity existente = new GeneroEntity();
        existente.setId(2);
        existente.setNombre("Masculino");
        when(repository.findByNombreIgnoreCase("Masculino")).thenReturn(existente);
        Exception ex = assertThrows(Exception.class, () -> service.crearGenero(dto, "nick", "pass"));
        assertEquals("Ya existe un género con ese nombre o uno parecido", ex.getMessage());
    }

    @Test
    public void ActualizarGenero() throws Exception {
        GeneroEntity genero = new GeneroEntity();
        genero.setId(1);
        genero.setNombre("Masculino");
        when(repository.findById(1)).thenReturn(Optional.of(genero));
        when(repository.findByNombreIgnoreCaseContaining("Masculino")).thenReturn(Collections.singletonList(genero));
        when(repository.findByNombreIgnoreCase("Masculino")).thenReturn(genero);
        when(repository.save(any())).thenReturn(genero);
        GeneroDTO dto = new GeneroDTO(1, "Masculino");
        GeneroDTO result = service.actualizarGenero(1, dto, "nick", "pass");
        assertNotNull(result);
        assertEquals("Masculino", result.getNombre());
    }

    @Test
    public void ActualizarGeneroNombreExistente() {
        GeneroEntity genero = new GeneroEntity();
        genero.setId(1);
        genero.setNombre("Masculino");
        GeneroEntity otro = new GeneroEntity();
        otro.setId(2);
        otro.setNombre("Masculino");
        when(repository.findById(1)).thenReturn(Optional.of(genero));
        when(repository.findByNombreIgnoreCaseContaining("Masculino")).thenReturn(Collections.singletonList(otro));
        Exception ex = assertThrows(Exception.class, () -> service.actualizarGenero(1, new GeneroDTO(1, "Masculino"), "nick", "pass"));
        assertEquals("Ya existe un género con ese nombre o uno parecido", ex.getMessage());
    }

    @Test
    public void EliminarGenero() throws Exception {
        GeneroEntity genero = new GeneroEntity();
        genero.setId(1);
        genero.setNombre("Masculino");
        when(repository.findById(1)).thenReturn(Optional.of(genero));
        doNothing().when(repository).delete(genero);
        service.eliminarGenero(1, "nick", "pass");
        verify(repository, times(1)).delete(genero);
    }

    @Test
    public void EliminarGeneroNoExiste() {
        when(repository.findById(1)).thenReturn(Optional.empty());
        Exception ex = assertThrows(Exception.class, () -> service.eliminarGenero(1, "nick", "pass"));
        assertEquals("Género no encontrado", ex.getMessage());
    }
}
