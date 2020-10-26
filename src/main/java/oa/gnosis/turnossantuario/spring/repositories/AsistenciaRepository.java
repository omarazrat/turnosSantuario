/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue dise�ado para la Santa Iglesia Gn�stica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.repositories;

import oa.gnosis.turnossantuario.spring.model.Asistencia;
import oa.gnosis.turnossantuario.spring.model.pk.AsistenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nesto
 */
public interface AsistenciaRepository extends JpaRepository<Asistencia, AsistenciaPK> {

}
