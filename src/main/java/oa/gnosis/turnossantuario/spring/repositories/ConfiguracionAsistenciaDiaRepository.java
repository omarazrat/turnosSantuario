/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.repositories;

import oa.gnosis.turnossantuario.spring.model.ConfiguracionAsistenciaDia;
import oa.gnosis.turnossantuario.spring.model.pk.ConfiguracionAsistenciaDiaPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nesto
 */
public interface ConfiguracionAsistenciaDiaRepository extends JpaRepository<ConfiguracionAsistenciaDia,ConfiguracionAsistenciaDiaPK>{
    
}
