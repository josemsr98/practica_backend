package es.ediae.master.programacion.gestionusuario.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;
import java.util.ArrayList;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;

    private String nickUsuario;

    private boolean esAdmin;

    private String contrasena;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private LocalDateTime fechaHoraCreacion;

    private LocalDate fechaNacimiento;

    private LocalTime horaDesayuno;

    private Integer generoId;

    private String generoNombre;

    private Integer puestoDeTrabajoId;

    private String puestoDeTrabajoNombre;

    private List<DireccionDTO> direcciones;

    /**
     * Convierte este DTO a una entidad UsuarioEntity.
     * Nota: Solo asigna los campos simples y los IDs de las relaciones.
     * Las relaciones completas (GeneroEntity, PuestoDeTrabajoEntity, Direcciones)
     * deben ser asignadas en el servicio.
     */
    public UsuarioEntity toEntity() {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(this.id);
        entity.setNickUsuario(this.nickUsuario);
        entity.setEsAdmin(this.esAdmin);
        entity.setContrasena(this.contrasena);
        entity.setNombre(this.nombre);
        entity.setPrimerApellido(this.primerApellido);
        entity.setSegundoApellido(this.segundoApellido);
        entity.setFechaHoraCreacion(this.fechaHoraCreacion);
        entity.setFechaNacimiento(this.fechaNacimiento);
        entity.setHoraDesayuno(this.horaDesayuno);
        // Las relaciones genero, puestoDeTrabajo y direcciones deben ser asignadas en
        // el servicio usando los IDs
        return entity;
    }

    /**
     * Convierte un objeto UsuarioEntity (que representa un usuario en la base de
     * datos)
     * a un objeto UsuarioDTO (que es una versión simplificada para enviar al
     * exterior, por ejemplo, a la API).
     * 
     * ¿Por qué es útil? Así no exponemos directamente la estructura interna de la
     * base de datos y podemos controlar qué datos salen.
     * 
     * @param entity El objeto UsuarioEntity que queremos convertir.
     * @return Un nuevo UsuarioDTO con los datos copiados del entity, o null si el
     *         entity es null.
     */
    public static UsuarioDTO fromEntity(UsuarioEntity entity) {
        if (entity == null)
            return null;
        // Creamos una lista para las direcciones convertidas a DTO
        List<DireccionDTO> direccionesDTO = null;
        if (entity.getDirecciones() != null) {
            direccionesDTO = new ArrayList<>();
            // Convertimos cada DireccionEntity a DireccionDTO usando su propio método
            // fromEntity
            for (DireccionEntity dir : entity.getDirecciones()) {
                direccionesDTO.add(DireccionDTO.fromEntity(dir));
            }
        }
        // Creamos y devolvemos el DTO con todos los datos necesarios
        return new UsuarioDTO(
                entity.getId(),
                entity.getNickUsuario(),
                entity.isEsAdmin(),
                entity.getContrasena(),
                entity.getNombre(),
                entity.getPrimerApellido(),
                entity.getSegundoApellido(),
                entity.getFechaHoraCreacion(),
                entity.getFechaNacimiento(),
                entity.getHoraDesayuno(),
                entity.getGenero() != null ? entity.getGenero().getId() : null,
                entity.getGenero() != null ? entity.getGenero().getNombre() : null,
                entity.getPuestoDeTrabajo() != null ? entity.getPuestoDeTrabajo().getId() : null,
                entity.getPuestoDeTrabajo() != null ? entity.getPuestoDeTrabajo().getNombre() : null,
                direccionesDTO);
    }

    /**
     * Convierte una lista de objetos UsuarioEntity a una lista de UsuarioDTO.
     * 
     * Esto es útil cuando queremos devolver muchos usuarios a la vez (por ejemplo,
     * en un listado).
     * 
     * @param entities Lista de UsuarioEntity (usuarios de la base de datos)
     * @return Lista de UsuarioDTO (usuarios preparados para la API o la vista)
     */
    public static List<UsuarioDTO> fromEntityList(List<UsuarioEntity> entities) {
        if (entities == null)
            return null;
        List<UsuarioDTO> dtos = new ArrayList<>();
        // Convertimos cada entity de la lista usando el método fromEntity de arriba
        for (UsuarioEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }
}
