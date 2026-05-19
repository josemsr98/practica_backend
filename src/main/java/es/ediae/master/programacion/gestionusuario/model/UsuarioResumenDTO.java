package es.ediae.master.programacion.gestionusuario.model;

import java.util.ArrayList;
import java.util.List;


import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResumenDTO {
    private Integer id;
    private String nombre;
    private String genero;
    private String puestoDeTrabajo;

   
    public static UsuarioResumenDTO fromEntity(UsuarioEntity entity) {
        if (entity == null)
            return null;
        return new UsuarioResumenDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getGenero() != null ? entity.getGenero().getNombre() : null,
                entity.getPuestoDeTrabajo() != null ? entity.getPuestoDeTrabajo().getNombre() : null);
    }

    public static List<UsuarioResumenDTO> fromEntityList(List<UsuarioEntity> entities) {
        List<UsuarioResumenDTO> dtos = new ArrayList<>();
        for (UsuarioEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }

}
