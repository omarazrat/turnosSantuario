/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import oa.gnosis.turnossantuario.spring.model.pk.AsistenciaPK;

/**
 * Configura la asistencia de una única persona a un santuario en cierta fecha.
 * Si confirmó y va, se considera que asistió.
 * Si confirmó y no va se considera que faltó.
 * @author nesto
 */
@Entity
@Data
@Table(name="persona_asistencia")
@IdClass(AsistenciaPK.class)
public class Asistencia implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "ceremonia_id")
    private Ceremonia ceremonia;
    @Id
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Id
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    /*
    *true=asistiò, false=fallò
    */
    private boolean asistencia;
}
