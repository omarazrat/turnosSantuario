/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Una fecha programada para reunirse.
 * @author nesto
 */
@Entity
@Table(name = "ceremonia")
@Data
public class Ceremonia implements Serializable{
    @Id
    private Integer id;
    
    /**
     * La configuraciòn que usa esta ceremonia.
     */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "config_dia",referencedColumnName = "dia"),
        @JoinColumn(name = "config_tfecha",referencedColumnName = "tipo_fecha")
    })
    private ConfiguracionAsistenciaDia configuracion;
    
    /**
     * Los miembros de la grey
     */
    @OneToMany(mappedBy = "ceremonia")
    private List<Asistencia> grey;
    /**
     * Los miembros del coro.
     */
    @OneToMany(mappedBy = "ceremonia")
    private List<Asistencia> coro;
    
    /**
     * La fecha para la cual se configura esta lista de asistencia.
     */
    @Temporal(TemporalType.DATE)
    private Date fecha;
}
