
package es.ediae.master.programacion.gestionusuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {
	// Busca todas las direcciones asociadas a un usuario por su id
	List<DireccionEntity> findByUsuarioId(Integer usuarioId);
}
