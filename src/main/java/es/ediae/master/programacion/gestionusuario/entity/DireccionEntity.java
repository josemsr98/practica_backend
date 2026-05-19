// Entidad que representa una dirección asociada a un usuario.
// Cada instancia corresponde a una fila en la tabla "direccion" de la base de datos.
// Utiliza anotaciones JPA/Hibernate para mapear atributos a columnas y relaciones SQL.
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
public class DireccionEntity {

    // Clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre de la calle (no null)
    @Column(name="nombre_calle", nullable=false)
    private String nombreCalle;

    // Número de la calle (puede ser null)
    @Column(name="numero_calle")
    private Integer numeroCalle;

    // Relación muchos-a-uno con UsuarioEntity (obligatorio)
    // Mapea la columna usuario_id como clave foránea
    @ManyToOne
    @JoinColumn(name= "usuario_id", nullable=false)
    private UsuarioEntity usuario;

    // Indica si es la dirección principal del usuario (no null)
    @Column(name="direccion_principal", nullable=false)
    private boolean direccionPrincipal;

            
   
    
    
}
