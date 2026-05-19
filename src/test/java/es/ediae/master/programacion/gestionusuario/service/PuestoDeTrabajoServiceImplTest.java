package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.model.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.impl.PuestoDeTrabajoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PuestoDeTrabajoServiceImplTest {
    @Mock
    private PuestoDeTrabajoRepository repository;
    @InjectMocks
    private PuestoDeTrabajoServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ObtenerPuestosDeTrabajo() {
        List<PuestoDeTrabajoEntity> entities = Arrays.asList(new PuestoDeTrabajoEntity(1, "Dev"));
        when(repository.findAll()).thenReturn(entities);
        List<PuestoDeTrabajoDTO> result = service.obtenerPuestosDeTrabajo();
        assertEquals(1, result.size());
        assertEquals("Dev", result.get(0).getNombre());
    }

    @Test
    public void ExisteNombrePuesto() {
        when(repository.findByNombreIgnoreCase("Dev")).thenReturn(Collections.singletonList(new PuestoDeTrabajoEntity(1, "Dev")));
        assertTrue(service.existeNombrePuesto("Dev"));
        when(repository.findByNombreIgnoreCase("QA")).thenReturn(Collections.emptyList());
        when(repository.findByNombreContainingIgnoreCase("QA")).thenReturn(Collections.emptyList());
        assertFalse(service.existeNombrePuesto("QA"));
    }
}
