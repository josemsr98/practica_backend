package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;

@Entity
public class PuestoDeTrabajoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre_puesto",nullable=false)
    private String nombre;

    public PuestoDeTrabajoEntity() {
    }

    public PuestoDeTrabajoEntity(Integer id, String nombre) {
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
    
    
}
