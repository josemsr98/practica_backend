// Entidad que representa una dirección asociada a un usuario.
// Cada instancia corresponde a una fila en la tabla "direccion" de la base de datos.
// Utiliza anotaciones JPA/Hibernate para mapear atributos a columnas y relaciones SQL.
package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;

@Entity
public class DireccionEntity {

    // Clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

        // Constructor completo
        public DireccionEntity(int id, String nombreCalle, int numeroCalle, UsuarioEntity usuario,
            boolean direccionPrincipal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuario = usuario;
        this.direccionPrincipal = direccionPrincipal;
    }
    // Constructor vacío requerido por JPA/Hibernate
    public DireccionEntity() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCalle() {
        return nombreCalle;
    }
    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }
    public int getNumeroCalle() {
        return numeroCalle;
    }
    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    public boolean isDireccionPrincipal() {
        return direccionPrincipal;
    }
    public void setDireccionPrincipal(boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }
    
    
}
