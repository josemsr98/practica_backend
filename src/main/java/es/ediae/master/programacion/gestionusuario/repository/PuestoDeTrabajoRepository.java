package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;


@Repository
public interface PuestoDeTrabajoRepository extends JpaRepository<PuestoDeTrabajoEntity, Integer> {
    
}
