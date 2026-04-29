package es.ediae.master.programacion.gestionusuario.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


import java.util.List;
import java.util.ArrayList;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;


public class UsuarioDTO {
    private String nombre;
    private String primerApellido;
        /**
         * Convierte este DTO a una entidad UsuarioEntity.
         * Nota: Solo asigna los campos simples y los IDs de las relaciones.
         * Las relaciones completas (GeneroEntity, PuestoDeTrabajoEntity, Direcciones) deben ser asignadas en el servicio.
         */
        public UsuarioEntity toEntity() {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(this.id);
            entity.setNickUsuario(this.nickUsuario);
            entity.setEsAdmin(this.esAdmin);
            entity.setContrasena(this.contrasena);
            entity.setSegundoApellido(this.segundoApellido);
            entity.setFechaHoraCreacion(this.fechaHoraCreacion);
            entity.setFechaNacimiento(this.fechaNacimiento);
            entity.setHoraDesayuno(this.horaDesayuno);
            entity.setNombre(this.nombre); // Asignar nombre
            entity.setPrimerApellido(this.primerApellido); // Asignar primerApellido
            // Las relaciones genero, puestoDeTrabajo y direcciones deben ser asignadas en el servicio usando los IDs
            return entity;
        }
    private Integer id;

    private String nickUsuario;

    private boolean esAdmin;

    private String contrasena; 

    private String segundoApellido;

    private LocalDateTime fechaHoraCreacion;

    private LocalDate fechaNacimiento;

    private LocalTime horaDesayuno;

    private Integer generoId;

    private String generoNombre;

    private Integer puestoDeTrabajoId;

    private String puestoDeTrabajoNombre;

    private List<DireccionDTO> direcciones;

    public UsuarioDTO(Integer id, String nickUsuario, boolean esAdmin, String contrasena, String segundoApellido,
            LocalDateTime fechaHoraCreacion, LocalDate fechaNacimiento, LocalTime horaDesayuno, Integer generoId,
            String generoNombre, Integer puestoDeTrabajoId, String puestoDeTrabajoNombre,
            List<DireccionDTO> direcciones) {
        this.id = id;
        this.nickUsuario = nickUsuario;
        this.esAdmin = esAdmin;
        this.contrasena = contrasena;
        this.segundoApellido = segundoApellido;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.fechaNacimiento = fechaNacimiento;
        this.horaDesayuno = horaDesayuno;
        this.generoId = generoId;
        this.generoNombre = generoNombre;
        this.puestoDeTrabajoId = puestoDeTrabajoId;
        this.puestoDeTrabajoNombre = puestoDeTrabajoNombre;
        this.direcciones = direcciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Convierte un objeto UsuarioEntity (que representa un usuario en la base de datos)
     * a un objeto UsuarioDTO (que es una versión simplificada para enviar al exterior, por ejemplo, a la API).
     * 
     * ¿Por qué es útil? Así no exponemos directamente la estructura interna de la base de datos y podemos controlar qué datos salen.
     * 
     * @param entity El objeto UsuarioEntity que queremos convertir.
     * @return Un nuevo UsuarioDTO con los datos copiados del entity, o null si el entity es null.
     */
    public static UsuarioDTO fromEntity(UsuarioEntity entity) {
        if (entity == null) return null;
        // Creamos una lista para las direcciones convertidas a DTO
        List<DireccionDTO> direccionesDTO = null;
        if (entity.getDirecciones() != null) {
            direccionesDTO = new ArrayList<>();
            // Convertimos cada DireccionEntity a DireccionDTO usando su propio método fromEntity
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
            entity.getSegundoApellido(),
            entity.getFechaHoraCreacion(),
            entity.getFechaNacimiento(),
            entity.getHoraDesayuno(),
            entity.getGenero() != null ? entity.getGenero().getId() : null,
            entity.getGenero() != null ? entity.getGenero().getNombre() : null,
            entity.getPuestoDeTrabajo() != null ? entity.getPuestoDeTrabajo().getId() : null,
            entity.getPuestoDeTrabajo() != null ? entity.getPuestoDeTrabajo().getNombre() : null,
            direccionesDTO
        );
    }

    /**
     * Convierte una lista de objetos UsuarioEntity a una lista de UsuarioDTO.
     * 
     * Esto es útil cuando queremos devolver muchos usuarios a la vez (por ejemplo, en un listado).
     * 
     * @param entities Lista de UsuarioEntity (usuarios de la base de datos)
     * @return Lista de UsuarioDTO (usuarios preparados para la API o la vista)
     */
    public static List<UsuarioDTO> fromEntityList(List<UsuarioEntity> entities) {
        if (entities == null) return null;
        List<UsuarioDTO> dtos = new ArrayList<>();
        // Convertimos cada entity de la lista usando el método fromEntity de arriba
        for (UsuarioEntity entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalTime getHoraDesayuno() {
        return horaDesayuno;
    }

    public void setHoraDesayuno(LocalTime horaDesayuno) {
        this.horaDesayuno = horaDesayuno;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public String getGeneroNombre() {
        return generoNombre;
    }

    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
    }

    public Integer getPuestoDeTrabajoId() {
        return puestoDeTrabajoId;
    }

    public void setPuestoDeTrabajoId(Integer puestoDeTrabajoId) {
        this.puestoDeTrabajoId = puestoDeTrabajoId;
    }

    public String getPuestoDeTrabajoNombre() {
        return puestoDeTrabajoNombre;
    }

    public void setPuestoDeTrabajoNombre(String puestoDeTrabajoNombre) {
        this.puestoDeTrabajoNombre = puestoDeTrabajoNombre;
    }

    public List<DireccionDTO> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionDTO> direcciones) {
        this.direcciones = direcciones;
    }

   

}
