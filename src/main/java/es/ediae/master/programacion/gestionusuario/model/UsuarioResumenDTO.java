package es.ediae.master.programacion.gestionusuario.model;

import java.util.ArrayList;
import java.util.List;


import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public class UsuarioResumenDTO {
    private Integer id;
    private String nombre;
    private String genero;
    private String puestoDeTrabajo;

    public UsuarioResumenDTO() {
    }

    public UsuarioResumenDTO(Integer id, String nombre, String genero, String puestoDeTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.puestoDeTrabajo = puestoDeTrabajo;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(String puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

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
