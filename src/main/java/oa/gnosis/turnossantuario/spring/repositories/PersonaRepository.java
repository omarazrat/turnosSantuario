/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.repositories;

import java.util.List;
import oa.gnosis.turnossantuario.spring.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author nesto
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    List<Persona> findByNombres(String nombres);
    List<Persona> findByApellidos(String apellidos);
    @Query(value = "SELECT p FROM Persona p WHERE p.nombres=:nombres AND p.apellidos=:apellidos")
    List<Persona> findByNombresApellidos(@Param(value = "nombres") String nombres,
            @Param(value="apellidos") String apellidos);
}