package es.ediae.master.programacion.gestionusuario.model;

import java.util.ArrayList;
import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PuestoDeTrabajoDTO {
    private Integer id;
    private String nombre;

    

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
