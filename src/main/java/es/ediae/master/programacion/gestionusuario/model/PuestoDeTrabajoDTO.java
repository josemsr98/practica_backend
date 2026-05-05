package es.ediae.master.programacion.gestionusuario.model;

import java.util.ArrayList;
import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

public class PuestoDeTrabajoDTO {
    private Integer id;
    private String nombre;

    public PuestoDeTrabajoDTO() {}

    public PuestoDeTrabajoDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static PuestoDeTrabajoDTO fromEntity(PuestoDeTrabajoEntity entity) {
        if (entity==null) return null;
        return new PuestoDeTrabajoDTO(entity.getId(), entity.getNombre());
    }

    public static List<PuestoDeTrabajoDTO> fromEntityList(List<PuestoDeTrabajoEntity> entities) {
        if (entities == null) return null;
        List<PuestoDeTrabajoDTO> dtos = new ArrayList<>();
        for (PuestoDeTrabajoEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }
}
