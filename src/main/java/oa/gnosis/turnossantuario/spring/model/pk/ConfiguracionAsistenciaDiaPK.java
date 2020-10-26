/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.model.pk;

import java.io.Serializable;
import java.util.Objects;
import oa.gnosis.turnossantuario.spring.model.enums.TipoFecha;

/**
 * Clave primaria compuesta para {@link ConfiguracionAsistencia}
 * @author nesto
 */
//@Data
public class ConfiguracionAsistenciaDiaPK implements Serializable{
    private int dia;
    private TipoFecha tipoFecha;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.dia;
        hash = 23 * hash + Objects.hashCode(this.tipoFecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConfiguracionAsistenciaDiaPK other = (ConfiguracionAsistenciaDiaPK) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.tipoFecha != other.tipoFecha) {
            return false;
        }
        return true;
    }

}
