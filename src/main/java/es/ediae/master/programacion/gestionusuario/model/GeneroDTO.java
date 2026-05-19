package es.ediae.master.programacion.gestionusuario.model;

import java.util.ArrayList;
import java.util.List;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GeneroDTO {
    private Integer id;
    private String nombre;

    

    public static GeneroDTO fromEntity(GeneroEntity entity) {
        if (entity == null) return null;
        return new GeneroDTO(entity.getId(), entity.getNombre());
    }

    public static List<GeneroDTO> fromEntityList(List<GeneroEntity> entities) {
        if (entities == null) return null;
        List<GeneroDTO> dtos = new ArrayList<>();
        // Convertimos cada entity de la lista usando el método fromEntity de arriba
        for (GeneroEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }
}
