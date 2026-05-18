package es.ediae.master.programacion.gestionusuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Integer> {
	GeneroEntity findByNombreIgnoreCase(String nombre);

	// Buscar nombres "parecidos" (por ejemplo, usando LIKE)
	List<GeneroEntity> findByNombreIgnoreCaseContaining(String nombre);
}
