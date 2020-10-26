/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.model;

import oa.gnosis.turnossantuario.spring.model.enums.TipoFecha;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import oa.gnosis.turnossantuario.spring.model.pk.ConfiguracionAsistenciaDiaPK;

/**
 * Configuración de días de asistencia para una lista específica.
 * @author nesto
 */
@IdClass(ConfiguracionAsistenciaDiaPK.class)
@Entity
@Data
@Table(name="conasist_dia")
public class ConfiguracionAsistenciaDia implements Serializable{
    /**
     * El dia de la semana o del mes para el que se configura esta lista de asistencia.
     */
    @Id
    private int dia;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_fecha")
    @Id
    private TipoFecha tipoFecha;
    
    @Column(nullable = false,length = 255)
    private String nombre;
}
