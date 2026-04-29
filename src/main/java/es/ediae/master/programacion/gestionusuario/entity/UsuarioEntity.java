
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

@Entity
public class UsuarioEntity {

    // Clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre de usuario único (no null)
    @Column (name = "nick_usuario", nullable=false)
    private String nickUsuario;

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
    @Column (name = "hora_desayuno")
    private LocalTime horaDesayuno;

    // Relación muchos-a-uno con PuestoDeTrabajo (puede ser null)
    // Mapea la columna puesto_de_trabajo_id como clave foránea
    @ManyToOne
    @JoinColumn(name= "puesto_de_trabajo_id")
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    // Relación uno-a-muchos con DireccionEntity
    // Un usuario puede tener varias direcciones
    // mappedBy indica que la relación está gestionada por el campo 'usuario' en DireccionEntity
    @OneToMany(mappedBy = "usuario")
    private List<DireccionEntity> direcciones=new ArrayList<>();

        // Constructor completo (útil para crear instancias con todos los datos)
        public UsuarioEntity(Integer id, String nickUsuario, String contrasena, LocalDateTime fechaHoraCreacion,
            GeneroEntity genero, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento,
            LocalTime horaDesayuno, PuestoDeTrabajoEntity puestoDeTrabajo) {
        this.id = id;
        this.nickUsuario = nickUsuario;
        this.contrasena = contrasena;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.genero = genero;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.horaDesayuno = horaDesayuno;
        this.puestoDeTrabajo = puestoDeTrabajo;
    }
    // Constructor vacío requerido por JPA/Hibernate
    public UsuarioEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<DireccionEntity> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionEntity> direcciones) {
        this.direcciones = direcciones;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public GeneroEntity getGenero() {
        return genero;
    }

    public void setGenero(GeneroEntity genero) {
        this.genero = genero;
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

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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

    public PuestoDeTrabajoEntity getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }
    
    

    
}
