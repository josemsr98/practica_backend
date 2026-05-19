package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class PuestoDeTrabajoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre_puesto",nullable=false)
    private String nombre;

   
    
}
