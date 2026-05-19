
// Entidad que representa a un usuario en la aplicación.
// Cada instancia corresponde a una fila en la tabla "usuario" de la base de datos.
// Utiliza anotaciones JPA/Hibernate para mapear atributos a columnas y relaciones SQL.
package es.ediae.master.programacion.gestionusuario.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class UsuarioEntity {

    // Clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // Nombre de usuario único (no null)
    @Column (name = "nick_usuario", nullable=false)
    private String nickUsuario;

    @Column (name= "es_admin", nullable=false)
    private boolean esAdmin;

    // Contraseña del usuario (no null)
    @Column (name = "contrasena", nullable=false)
    private String contrasena;

    // Fecha y hora de creación del usuario (no null)
    @Column (name = "fecha_hora_creacion", nullable=false)
    private LocalDateTime fechaHoraCreacion;

    // Relación muchos-a-uno con la entidad Género (obligatorio)
    // Mapea la columna genero_id como clave foránea
    @ManyToOne
    @JoinColumn(name= "genero_id", nullable=false)
    private GeneroEntity genero;

    // Nombre real del usuario (no null)
    @Column (name = "nombre", nullable=false)
    private String nombre;

    // Primer apellido (no null)
    @Column (name = "primer_apellido", nullable=false)
    private String primerApellido;

    // Segundo apellido (puede ser null)
    @Column (name = "segundo_apellido")
    private String segundoApellido;

    // Fecha de nacimiento (no null)
    @Column (name = "fecha_nacimiento", nullable=false)
    private LocalDate fechaNacimiento;

    // Hora de desayuno (puede ser null)
    @Column (name = "hora_desayuno", nullable=true)
    private LocalTime horaDesayuno;

    // Relación muchos-a-uno con PuestoDeTrabajo (puede ser null)
    // Mapea la columna puesto_de_trabajo_id como clave foránea
    @ManyToOne
    @JoinColumn(name= "puesto_de_trabajo_id", nullable=true)
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    // Relación uno-a-muchos con DireccionEntity
    // Un usuario puede tener varias direcciones
    // mappedBy indica que la relación está gestionada por el campo 'usuario' en DireccionEntity
    //cascade me permite que al eliminar un usuario se eliminen sus direcciones asociadas (orphanRemoval=true)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DireccionEntity> direcciones=new ArrayList<>();

        
    
}
