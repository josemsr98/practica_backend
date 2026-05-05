
package es.ediae.master.programacion.gestionusuario.model;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import java.util.List;
import java.util.ArrayList;
public class DireccionDTO {

    private Integer id;

    private String nombreCalle;

    private Integer numeroCalle;

    private Integer usuarioId;

    private boolean direccionPrincipal;
    public DireccionDTO(Integer id, String nombreCalle, Integer numeroCalle, Integer usuarioId,
            boolean direccionPrincipal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuarioId = usuarioId;
        this.direccionPrincipal = direccionPrincipal;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombreCalle() {
        return nombreCalle;
    }
    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }
    public Integer getNumeroCalle() {
        return numeroCalle;
    }
    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    // Conversión de Entity a DTO
    public static DireccionDTO fromEntity(DireccionEntity entity) {
        if (entity == null) return null;
        return new DireccionDTO(
            entity.getId(),
            entity.getNombreCalle(),
            entity.getNumeroCalle(),
            entity.getUsuario() != null ? entity.getUsuario().getId() : null,
            entity.isDireccionPrincipal()
        );
    }

    public static List<DireccionDTO> fromEntityList(List<DireccionEntity> entities) {
        if (entities == null) return null;
        List<DireccionDTO> dtos = new ArrayList<>();
        for (DireccionEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public boolean isDireccionPrincipal() {
        return direccionPrincipal;
    }
    public void setDireccionPrincipal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }
    // Conversión de DTO a Entity
    public DireccionEntity toEntity() {
        DireccionEntity entity = new DireccionEntity();
        
        entity.setNombreCalle(this.nombreCalle);
        entity.setNumeroCalle(this.numeroCalle);
        entity.setDireccionPrincipal(this.direccionPrincipal);
        // Nota: usuarioId requiere que se asigne un UsuarioEntity externo si es necesario
        return entity;
    }
    
    
}
