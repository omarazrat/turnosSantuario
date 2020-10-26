/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue dise�ado para la Santa Iglesia Gn�stica Universal, por Nestor Arias -nestor_arias@hotmail.com
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
 * Configura la asistencia de una �nica persona a un santuario en cierta fecha.
 * Si confirm� y va, se considera que asisti�.
 * Si confirm� y no va se considera que falt�.
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
    *true=asisti�, false=fall�
    */
    private boolean asistencia;
}
